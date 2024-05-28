package com.example.project.serviceTests;

import com.example.project.data.OrderData;
import com.example.project.service.OrderService;
import com.example.project.serviceimp.OrderServiceImp;
import com.example.project.entity.Order;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceImpTests {

    @Mock
    private OrderData data;

    private OrderService orderService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        orderService = new OrderServiceImp(data);
    }

    @Test
    public void testSaveOrder(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Order order = new Order(10, 10, 1799.99, calendar.getTime());

        orderService.saveOrder(order);

        Mockito.verify(data).saveOrder(order);
    }

    @Test
    public void testSaveOrders(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Order order1 = new Order(10, 10, 1799.99, calendar.getTime());
        Order order2 = new Order(11, 11, 1799.99, calendar.getTime());
        List<Order> orders = List.of(order1, order2);

        orderService.saveOrders(orders);

        Mockito.verify(data).saveOrders(orders);
    }

    @Test
    public void testGetOrders(){
        orderService.getOrders();

        Mockito.verify(data).getOrders();
    }

    @Test
    public void testGetOrderById(){
        int id = 10;

        orderService.getOrderById(id);

        Mockito.verify(data).getOrderById(id);
    }

    @Test
    public void testDeleteOrder(){
        int id = 10;

        orderService.deleteOrder(id);

        Mockito.verify(data).deleteOrder(id);
    }

    @Test
    public void testUpdateOrder(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, Calendar.OCTOBER, 10);
        Order order = new Order(10, 10, 1799.99, calendar.getTime());
        when(data.getOrderById(order.getId())).thenReturn(order);

        orderService.updateOrder(order);

        Mockito.verify(data).updateOrder(order);
    }

}

