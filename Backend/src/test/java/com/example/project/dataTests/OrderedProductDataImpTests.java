package com.example.project.dataTests;

import com.example.project.data.OrderedProductData;
import com.example.project.dataimp.OrderedProductDataImp;
import com.example.project.entity.OrderedProduct;
import com.example.project.repository.OrderedProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderedProductDataImpTests {

    @Mock
    private OrderedProductRepository repo;

    private OrderedProductData orderedProductData;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        orderedProductData = new OrderedProductDataImp(repo);
    }

    @Test
    public void testSaveOrderedProduct(){
        OrderedProduct orderedProduct = new OrderedProduct(10, 10, 10, 2);

        orderedProductData.saveOrderedProduct(orderedProduct);

        Mockito.verify(repo).save(orderedProduct);
    }

    @Test
    public void testSaveOrderedProducts(){
        OrderedProduct orderedProduct1 = new OrderedProduct(10, 10, 10, 2);
        OrderedProduct orderedProduct2 = new OrderedProduct(11, 11, 11, 3);
        List<OrderedProduct> orderedProducts = List.of(orderedProduct1, orderedProduct2);

        orderedProductData.saveOrderedProducts(orderedProducts);

        Mockito.verify(repo).saveAll(orderedProducts);
    }

    @Test
    public void testGetOrderedProducts(){
        orderedProductData.getOrderedProducts();

        Mockito.verify(repo).findAll();
    }

    @Test
    public void testGetOrderedProductById(){
        int id = 10;

        orderedProductData.getOrderedProductById(id);

        Mockito.verify(repo).findById(id);
    }

    @Test
    public void testDeleteOrderedProduct(){
        int id = 10;

        orderedProductData.deleteOrderedProduct(id);

        Mockito.verify(repo).deleteById(id);
    }

    @Test
    public void testUpdateOrderedProduct(){
        OrderedProduct orderedProduct = new OrderedProduct(10, 10, 10, 2);

        orderedProductData.updateOrderedProduct(orderedProduct);

        Mockito.verify(repo).save(orderedProduct);
    }
}

