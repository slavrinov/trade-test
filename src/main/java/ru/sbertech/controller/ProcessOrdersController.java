package ru.sbertech.controller;

import ru.sbertech.model.Client;
import ru.sbertech.model.Order;
import ru.sbertech.util.ClientUtilities;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Сергей on 07.07.2017.
 */
public class ProcessOrdersController {

    static Logger log = Logger.getLogger(ProcessOrdersController.class.getName());

    /*
    * @param List<String> ordersStr список заявок в строковой форме
    * @param HashMap<ClientInfo, Client> карта клиентов с их заявками
    * @return HashMap<ClientInfo, Client> карта клиентов с их заявками
    * */
    public HashMap<String, Client> prepare(List<String> ordersStr, HashMap<String, Client> clients) {
        for (String orderStr : ordersStr) {
            try {
                String[] lineArr = orderStr.split("\t");
                Order order = new Order();
                order.setOperation(lineArr[1]);
                order.setEquityName(lineArr[2]);
                order.setProposition(ClientUtilities.stringToInteger(lineArr[3], " цена заявки"));
                order.setQuantity(ClientUtilities.stringToInteger(lineArr[4], " кол-во акций"));
                // lineArr[0] имя клиента например С1
                if (clients.get(lineArr[0]) != null) {
                    clients.get(lineArr[0]).getOrderList().add(order);
                }
            } catch (IndexOutOfBoundsException boundEx) {
                log.warning("Неверен формат входных данных файла заявок");
                boundEx.printStackTrace();
            }
        }
        return clients;
    }
}
