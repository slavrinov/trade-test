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
public class ProcessOrders {

    static Logger log  = Logger.getLogger(ProcessOrders.class.getName());

    public static void process(List<Order> ordList, HashMap<String, Client> clientsMap ) {
        for (int i = 0; i <ordList.size() ; i++) {

            Client client = clientsMap.get(ordList.get(i).getClientName());
            ordList.get(i).getEquityName();
            Integer proposition = ClientUtilities.StringtoInteger(ordList.get(i).getProposition(), " цена заявки");
            Integer quantity =ClientUtilities.StringtoInteger(ordList.get(i).getQuantity(), " кол-во акций");
            Integer sum = proposition*quantity;
            if (ordList.get(i).getOperation().equals("B")) {
                // покупка
                // проверяем достаточно ли денег на счету
                log.info("Покупка акции. Клиент:"+ ordList.get(i).getClientName());
                log.info("Тип:"+ordList.get(i).getEquityName()+", Кол-во:"+ quantity);
                log.info("Баланс:"+ + client.getQuantityA() + ", "+
                        client.getQuantityB() + ", "+client.getQuantityC()+ ", "+ client.getQuantityD());
                if (client.checkSum(sum)) {
                    //покупка
                    client.setBalance(client.getBalance() - sum);
                    // увеличиваем количество соответствующих акций
                    client.setQuantity(ordList.get(i).getEquityName(),quantity,'+');
                    clientsMap.put(client.getClientName(),client);
                    log.info("Покупка акции. Кол-во после операции:"+ client.getQuantityA() + ", "+
                            client.getQuantityB() + ", "+client.getQuantityC()+ ", "+ client.getQuantityD());
                } else {
                    log.warning("Недостаточно средств для покупки акции");
                }


            } else if (ordList.get(i).getOperation().equals("S")) {
                log.info("Продажа акции. Клиент:"+ ordList.get(i).getClientName());
                log.info("Тип:"+ordList.get(i).getEquityName()+", Кол-во:"+ quantity);
                log.info("Баланс:"+ + client.getQuantityA() + ", "+
                        client.getQuantityB() + ", "+client.getQuantityC()+ ", "+ client.getQuantityD());
                // проверяем кол-во акций у клиента для продажи
                if (client.checkQuantity(ordList.get(i).getEquityName(),quantity)) {
                    client.setQuantity(ordList.get(i).getEquityName(),quantity,'-');
                    client.setBalance(client.getBalance() + sum);
                    clientsMap.put(client.getClientName(),client);
                    log.info("Продажа акции. Кол-во после операции:"+ client.getQuantityA() + ", "+
                            client.getQuantityB() + ", "+client.getQuantityC()+ ", "+ client.getQuantityD());


                } else {
                    log.warning("Недостаточно кол-ва акций для продажи"+ordList.get(i).getQuantity());
                }
            } else {
                log.warning("Неизвестная операция:"+ordList.get(i).getOperation()+
                "Доступные варианты B- покупка, S- продажа");
            }

        }


    }
}
