package ru.sbertech.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sbertech.file.ProcessFile;
import ru.sbertech.model.Client;
import ru.sbertech.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProcessOrdersTest {


    List<Order> ordList;

    HashMap<String, Client> clientsMap;
    @Before
    public void before() {
        //клиенты
        List<String> clients = new ArrayList<>();
        clients.add("C1\t1000\t130\t240\t760\t320");
        clients.add("C2\t4350\t370\t120\t950\t560");
        clients.add("C3\t2760\t0\t0\t0\t0");
        clientsMap =
                ProcessFile.processClient(clients);
        ordList = new ArrayList<>();
        Order order = new Order();
        order.setClientName("C1");
        order.setQuantity("5");
        order.setProposition("10");
        order.setEquityName("C");
        order.setOperation("B");
        ordList.add(order);

        Order order2 = new Order();
        order2.setClientName("C2");
        order2.setQuantity("5");
        order2.setProposition("10");
        order2.setEquityName("C");
        order2.setOperation("B");
        ordList.add(order2);

        Order order3 = new Order();
        order3.setClientName("C3");
        order3.setQuantity("5");
        order3.setProposition("10");
        order3.setEquityName("C");
        order3.setOperation("S");
        ordList.add(order3);
    }

    @Test
    public void testProcess() throws Exception {
        //заявки
        ordList = new ArrayList<>();
        Order order = new Order();
        order.setClientName("C1");
        order.setQuantity("5");
        order.setProposition("10");
        order.setEquityName("C");
        order.setOperation("S");
        ordList.add(order);
        ProcessOrders.process(ordList,clientsMap);
        Client client = clientsMap.get("C1");
        Assert.assertEquals(new Integer(1050),client.getBalance());
    }

    @Test
    public void testProcess2() throws Exception {

        ProcessOrders.process(ordList,clientsMap);
        Client client = clientsMap.get("C2");
        Assert.assertEquals(new Integer(4300),client.getBalance());
    }

    @Test
    public void testProcess3() throws Exception {

        ProcessOrders.process(ordList,clientsMap);
        Client client = clientsMap.get("C3");
        //недостаточно средств на счету
        Assert.assertEquals(new Integer(0),client.getQuantityC());
    }
}