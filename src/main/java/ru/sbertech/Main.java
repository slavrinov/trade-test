package ru.sbertech;

import ru.sbertech.controller.ProcessController;
import ru.sbertech.file.ReadFile;
import ru.sbertech.model.Client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by Сергей on 07.07.2017.
 */
public class Main {

    static Logger log = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) {
        String clientsFile = "src\\main\\resources\\clients.txt";
        String ordersFile = "src\\main\\resources\\orders.txt";
        List<String> clients = ReadFile.read(clientsFile);
        List<String> orders = ReadFile.read(ordersFile);

        log.info("read clients:");
        log.info("size:" + clients.size());
        log.info("read orders:");
        log.info("size:" + orders.size());
        ProcessController processController = new ProcessController();
        HashMap<String, Client> clientsMap = processController.prepareAndProcess(clients, orders);
        // вывод из мап в строку
        String clientsStream = clientsMap.values().stream()
                .sorted((p1, p2) -> p1.getClientName().compareTo(p2.getClientName()))
                .map(p -> p.getClientName() + "\t" + p.getBalance() + "\t" +
                        p.getQuantityA() + "\t" + p.getQuantityB() + "\t" +
                        p.getQuantityC() + "\t" + p.getQuantityD())
                .collect(Collectors.joining("\n "));
        try {
            Files.write(Paths.get("src\\main\\resources\\output.txt"), clientsStream.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

