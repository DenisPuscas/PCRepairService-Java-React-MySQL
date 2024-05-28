package com.example.project.dataTests;

import com.example.project.data.ProductData;
import com.example.project.dataimp.ProductDataImp;
import com.example.project.entity.Product;
import com.example.project.enumeration.Category;
import com.example.project.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductDataImpTests {

    @Mock
    private ProductRepository repo;

    private ProductData productData;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        productData = new ProductDataImp(repo);
    }

    @Test
    public void testSaveProduct(){
        Product product = new Product(10, "Procesor", 24, 1799.99, Category.PROCESSOR, "img");

        productData.saveProduct(product);

        Mockito.verify(repo).save(product);
    }

    @Test
    public void testSaveProducts(){
        Product product1 = new Product(10, "Procesor", 24, 1799.99, Category.PROCESSOR, "img");
        Product product2 = new Product(10, "Procesor", 24, 1799.99, Category.PROCESSOR, "img");
        List<Product> products = List.of(product1, product2);

        productData.saveProducts(products);

        Mockito.verify(repo).saveAll(products);
    }

    @Test
    public void testGetProducts(){
        productData.getProducts();

        Mockito.verify(repo).findAll();
    }

    @Test
    public void testGetProductById(){
        int id = 10;

        productData.getProductById(id);

        Mockito.verify(repo).findById(id);
    }

    @Test
    public void testDeleteProduct(){
        int id = 10;

        productData.deleteProduct(id);

        Mockito.verify(repo).deleteById(id);
    }

    @Test
    public void testUpdateProduct(){
        Product product = new Product(10, "Procesor", 24, 1799.99, Category.PROCESSOR, "img");

        productData.updateProduct(product);

        Mockito.verify(repo).save(product);
    }
}
