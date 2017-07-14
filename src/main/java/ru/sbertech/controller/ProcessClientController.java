package ru.sbertech.controller;

import ru.sbertech.model.Client;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Сергей on 12.07.2017.
 */
public class ProcessClientController {


    static Logger log = Logger.getLogger(ProcessClientController.class.getName());

    /*
    * @param List<String> clients список клиентов
    * @return HashMap<ClientInfo, Client> карта клиентов с их заявками
    * */
    public HashMap<String, Client> prepare(List<String> clients) {
        HashMap<String, Client> clientsMap = new HashMap();
        for (String clientStr : clients) {
            String[] lineArr = clientStr.split("\t");
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
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                } catch (IndexOutOfBoundsException boundEx) {
                    log.warning("Неверен формат входных данных файла клиентов");
                    boundEx.printStackTrace();
                }
            }
        }
        return clientsMap;
    }
}
