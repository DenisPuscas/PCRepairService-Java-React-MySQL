package com.example.project.serviceTests;

import com.example.project.data.OrderedProductData;
import com.example.project.service.OrderedProductService;
import com.example.project.serviceimp.OrderedProductServiceImp;
import com.example.project.entity.OrderedProduct;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderedProductServiceImpTests {

    @Mock
    private OrderedProductData data;

    private OrderedProductService orderedProductService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        orderedProductService = new OrderedProductServiceImp(data);
    }

    @Test
    public void testSaveOrderedProduct(){
        OrderedProduct orderedProduct = new OrderedProduct(10, 10, 10, 2);

        orderedProductService.saveOrderedProduct(orderedProduct);

        Mockito.verify(data).saveOrderedProduct(orderedProduct);
    }

    @Test
    public void testSaveOrderedProducts(){
        OrderedProduct orderedProduct1 = new OrderedProduct(10, 10, 10, 2);
        OrderedProduct orderedProduct2 = new OrderedProduct(11, 11, 11, 3);
        List<OrderedProduct> orderedProducts = List.of(orderedProduct1, orderedProduct2);

        orderedProductService.saveOrderedProducts(orderedProducts);

        Mockito.verify(data).saveOrderedProducts(orderedProducts);
    }

    @Test
    public void testGetOrderedProducts(){
        orderedProductService.getOrderedProducts();

        Mockito.verify(data).getOrderedProducts();
    }

    @Test
    public void testGetOrderedProductById(){
        int id = 10;

        orderedProductService.getOrderedProductById(id);

        Mockito.verify(data).getOrderedProductById(id);
    }

    @Test
    public void testDeleteOrderedProduct(){
        int id = 10;

        orderedProductService.deleteOrderedProduct(id);

        Mockito.verify(data).deleteOrderedProduct(id);
    }

    @Test
    public void testUpdateOrderedProduct(){
        OrderedProduct orderedProduct = new OrderedProduct(10, 10, 10, 2);
        when(data.getOrderedProductById(orderedProduct.getId())).thenReturn(orderedProduct);

        orderedProductService.updateOrderedProduct(orderedProduct);

        Mockito.verify(data).updateOrderedProduct(orderedProduct);
    }
}

