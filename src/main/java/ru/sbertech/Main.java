package ru.sbertech;

import ru.sbertech.controller.ProcessOrders;
import ru.sbertech.file.ProcessFile;
import ru.sbertech.file.ReadFile;
import ru.sbertech.model.Client;
import ru.sbertech.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Сергей on 07.07.2017.
 */
public class Main {

    static Logger log  = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        String clientsFile = "src\\main\\resources\\clients.txt";
        String ordersFile = "src\\main\\resources\\orders2.txt";
        List<String> clients = ReadFile.read(clientsFile);
        List<String> orders = ReadFile.read(ordersFile);

        log.info("read clients:");
        log.info("size:"+clients.size());
        log.info("read orders:");
        log.info("size:"+orders.size());
        HashMap<String, Client>  clientsMap =
               ProcessFile.processClient(clients);
        List<Order> ordList
                = ProcessFile.processOrders(orders);
        log.info("clients map:"+clientsMap.size());
        ProcessOrders.process(ordList,clientsMap );
        log.info( ordList.size() +" propositions processed" );
        for (Client client : clientsMap.values()) {
            log.info("client balance:" + client.toString());
        }

    }
}

