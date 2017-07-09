package ru.sbertech.file;

import ru.sbertech.model.Client;
import ru.sbertech.model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Сергей on 07.07.2017.
 */
public class ProcessFile {

    public static HashMap processClient(List<String> clients) {
        HashMap<String, Client> clientsMap = new HashMap();
        for (int i = 0; i < clients.size(); i++) {
            String[] lineArr = (clients.get(i)).split("\t");
            for (int j = 0; j < lineArr.length; j++) {
                Client client = new Client();
                client.setClientName(lineArr[0]);
                try {
                    client.setBalance(Integer.parseInt(lineArr[1]));
                    client.setQuantityA(Integer.parseInt(lineArr[2]));
                    client.setQuantityB(Integer.parseInt(lineArr[3]));
                    client.setQuantityC(Integer.parseInt(lineArr[4]));
                    client.setQuantityD(Integer.parseInt(lineArr[5]));
                    clientsMap.put(lineArr[0], client);
                }catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
            }
        }
        return clientsMap;
    }

    public static List<Order> processOrders(List<String> ordersStr) {
        List orders = new ArrayList<>();
        for (int i = 0; i < ordersStr.size(); i++) {
            String[] lineArr = (ordersStr.get(i)).split("\t");
            Order order = new Order();
            order.setClientName(lineArr[0]);
            order.setOperation(lineArr[1]);
            order.setEquityName(lineArr[2]);
            order.setProposition(lineArr[3]);
            order.setQuantity(lineArr[4]);
            orders.add(order);
        }
        return orders;
    }
}
