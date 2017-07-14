package ru.sbertech.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sbertech.model.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProcessOrdersTest {

    List<String> clients;

    List<String> orders;

    @Before
    public void before() {
        //клиенты
        clients = new ArrayList<>();
        clients.add("C1\t1000\t130\t240\t760\t320");
        clients.add("C2\t4350\t370\t120\t950\t560");
        clients.add("C3\t2760\t0\t0\t0\t0");
        clients.add("C4\t2760\t0\t0\t0\t0");

        orders = new ArrayList<>();
        orders.add("C1\ts\tC\t10\t5");
        orders.add("C2\tb\tC\t10\t5");
        orders.add("C2\tb\tC\t20\t2");
        orders.add("C3\ts\tB\t5\t4");
        orders.add("C4\tb\tB\t5\t4");
    }

    @Test
    public void testProcess() throws Exception {

        ProcessController processController = new ProcessController();
        HashMap<String, Client> clientsMap = processController.prepareAndProcess(clients, orders);
        Client client = clientsMap.get("C1");
        Assert.assertEquals(new Integer(1050),client.getBalance());
    }

    @Test
    public void testProcess2() throws Exception {

        ProcessController processController = new ProcessController();
        HashMap<String, Client> clientsMap = processController.prepareAndProcess(clients, orders);
        Client client = clientsMap.get("C2");
        Assert.assertEquals(new Integer(4260), client.getBalance());
    }

    @Test
    public void testProcess3() throws Exception {

        ProcessController processController = new ProcessController();
        HashMap<String, Client> clientsMap = processController.prepareAndProcess(clients, orders);
        Client client = clientsMap.get("C3");
        //недостаточно средств на счету
        Assert.assertEquals(new Integer(0), client.getQuantityB());
    }

    @Test
    public void testProcess4() throws Exception {

        ProcessController processController = new ProcessController();
        HashMap<String, Client> clientsMap = processController.prepareAndProcess(clients, orders);
        Client client = clientsMap.get("C4");
        Assert.assertEquals(new Integer(4), client.getQuantityB());
    }
}