package com.example.project.dataTests;

import com.example.project.data.OrderData;
import com.example.project.dataimp.OrderDataImp;
import com.example.project.entity.Order;
import com.example.project.repository.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

@SpringBootTest
public class OrderDataImpTests {

    @Mock
    private OrderRepository repo;

    private OrderData orderData;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        orderData = new OrderDataImp(repo);
    }

    @Test
    public void testSaveOrder(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Order order = new Order(10, 10, 1799.99, calendar.getTime());

        orderData.saveOrder(order);

        Mockito.verify(repo).save(order);
    }

    @Test
    public void testSaveOrders(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Order order1 = new Order(10, 10, 1799.99, calendar.getTime());
        Order order2 = new Order(11, 11, 1799.99, calendar.getTime());
        List<Order> orders = List.of(order1, order2);

        orderData.saveOrders(orders);

        Mockito.verify(repo).saveAll(orders);
    }

    @Test
    public void testGetOrders(){
        orderData.getOrders();

        Mockito.verify(repo).findAll();
    }

    @Test
    public void testGetOrderById(){
        int id = 10;

        orderData.getOrderById(id);

        Mockito.verify(repo).findById(id);
    }

    @Test
    public void testDeleteOrder(){
        int id = 10;

        orderData.deleteOrder(id);

        Mockito.verify(repo).deleteById(id);
    }

    @Test
    public void testUpdateOrder(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Order order = new Order(10, 10, 1799.99, calendar.getTime());

        orderData.updateOrder(order);

        Mockito.verify(repo).save(order);
    }

}

