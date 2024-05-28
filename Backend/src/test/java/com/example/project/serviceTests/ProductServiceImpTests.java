package com.example.project.serviceTests;

import com.example.project.data.ProductData;
import com.example.project.service.ProductService;
import com.example.project.serviceimp.ProductServiceImp;
import com.example.project.entity.Product;
import com.example.project.enumeration.Category;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceImpTests {

    @Mock
    private ProductData data;

    private ProductService productService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        productService = new ProductServiceImp(data);
    }

    @Test
    public void testSaveProduct(){
        Product product = new Product(10, "Procesor", 24, 1799.99, Category.PROCESSOR, "img");

        productService.saveProduct(product);

        Mockito.verify(data).saveProduct(product);
    }

    @Test
    public void testSaveProducts(){
        Product product1 = new Product(10, "Procesor", 24, 1799.99, Category.PROCESSOR, "img");
        Product product2 = new Product(10, "Procesor", 24, 1799.99, Category.PROCESSOR, "img");
        List<Product> products = List.of(product1, product2);

        productService.saveProducts(products);

        Mockito.verify(data).saveProducts(products);
    }

    @Test
    public void testGetProducts(){
        productService.getProducts();

        Mockito.verify(data).getProducts();
    }

    @Test
    public void testGetProductById(){
        int id = 10;

        productService.getProductById(id);

        Mockito.verify(data).getProductById(id);
    }

    @Test
    public void testDeleteProduct(){
        int id = 10;

        productService.deleteProduct(id);

        Mockito.verify(data).deleteProduct(id);
    }

    @Test
    public void testUpdateProduct(){
        Product product = new Product(10, "Procesor", 24, 1799.99, Category.PROCESSOR, "img");
        when(data.getProductById(product.getId())).thenReturn(product);

        productService.updateProduct(product);

        Mockito.verify(data).updateProduct(product);
    }
}
