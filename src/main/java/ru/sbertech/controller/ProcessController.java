package ru.sbertech.controller;

import ru.sbertech.model.Client;
import ru.sbertech.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Сергей on 12.07.2017.
 */
public class ProcessController {

    static Logger log = Logger.getLogger(ProcessController.class.getName());


    public HashMap<String, Client> prepareAndProcess(List<String> clients, List<String> orders) {
        HashMap<String, Client> map = this.prepare(clients, orders);
        return this.process(map);
    }

    /*
    * Подготавливаем данные к процессингу
    * @param List<String> clients список клиентов
    * @param List<String> orders список заявок
    * */
    public HashMap<String, Client> prepare(List<String> clients, List<String> orders) {
        ProcessClientController pclContr = new ProcessClientController();
        // подготавливаем список клиентов
        HashMap<String, Client> clientsMap = pclContr.prepare(clients);
        ProcessOrdersController pOrdContr = new ProcessOrdersController();
        // добавляем список заявок
        return pOrdContr.prepare(orders, clientsMap);
    }

    /*
    * Обработка заявок
    * @param HashMap<ClientInfo, Client> карта клиентов с их заявками
    * */
    public HashMap<String, Client> process(HashMap<String, Client> clientsMap) {
        for (Client client : clientsMap.values()) {
            for (Order order : client.getOrderList()) {
                Integer sum = order.getProposition() * order.getQuantity();
                if (order.getOperation().equalsIgnoreCase("B")) {
                    // покупка
                    // проверяем достаточно ли денег на счету
                    log.info("Покупка акции. Клиент:" + client.getClientName());
                    log.info("Тип:" + order.getEquityName() + ", Кол-во:" + order.getQuantity());
                    log.info("Баланс:" + +client.getQuantityA() + ", " +
                            client.getQuantityB() + ", " + client.getQuantityC() + ", " + client.getQuantityD());
                    if (client.checkSum(sum)) {
                        //покупка
                        client.setBalance(client.getBalance() - sum);
                        // увеличиваем количество соответствующих акций
                        client.setQuantity(order.getEquityName(), order.getQuantity(), '+');
                        log.info("Покупка акции. Кол-во после операции:" + client.getQuantityA() + ", " +
                                client.getQuantityB() + ", " + client.getQuantityC() + ", " + client.getQuantityD());
                    } else {
                        log.warning("Недостаточно средств для покупки акции");
                    }


                } else if (order.getOperation().equalsIgnoreCase("S")) {
                    log.info("Продажа акции. Клиент:" + client.getClientName());
                    log.info("Тип:" + order.getEquityName() + ", Кол-во:" + order.getQuantity());
                    log.info("Баланс:" + +client.getQuantityA() + ", " +
                            client.getQuantityB() + ", " + client.getQuantityC() + ", " + client.getQuantityD());
                    // проверяем кол-во акций у клиента для продажи
                    if (client.checkQuantity(order.getEquityName(), order.getQuantity())) {
                        client.setQuantity(order.getEquityName(), order.getQuantity(), '-');
                        client.setBalance(client.getBalance() + sum);
                        log.info("Продажа акции. Кол-во после операции:" + client.getQuantityA() + ", " +
                                client.getQuantityB() + ", " + client.getQuantityC() + ", " + client.getQuantityD());


                    } else {
                        log.warning("Недостаточно кол-ва акций для продажи" + order.getQuantity());
                    }
                } else {
                    log.warning("Неизвестная операция:" + order.getOperation() +
                            "Доступные варианты B- покупка, S- продажа");
                }
                log.info(client.getOrderList() + " propositions processed");
            }
        }
        return clientsMap;
    }
}

