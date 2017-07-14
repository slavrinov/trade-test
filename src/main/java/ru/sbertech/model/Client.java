package ru.sbertech.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 07.07.2017.
 */
public class Client {

    // Имя клиента
    private String clientName;
    // Баланс
    private Integer balance;
    // Количество акций А
    private Integer quantityA;
    // Количество акций B
    private Integer quantityB;
    // Количество акций C
    private Integer quantityC;
    // Количество акций D
    private Integer quantityD;
    // Список заявок клиента
    private List<Order> orderList = new ArrayList<>();


    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getQuantityA() {
        return quantityA;
    }

    public void setQuantityA(Integer quantityA) {
        this.quantityA = quantityA;
    }

    public Integer getQuantityB() {
        return quantityB;
    }

    public void setQuantityB(Integer quantityB) {
        this.quantityB = quantityB;
    }

    public Integer getQuantityC() {
        return quantityC;
    }

    public void setQuantityC(Integer quantityC) {
        this.quantityC = quantityC;
    }

    public Integer getQuantityD() {
        return quantityD;
    }

    public void setQuantityD(Integer quantityD) {
        this.quantityD = quantityD;
    }

    public boolean checkSum(Integer sum) {
        if (sum < this.getBalance()) return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (!balance.equals(client.balance)) return false;
        if (!clientName.equals(client.clientName)) return false;
        if (!orderList.equals(client.orderList)) return false;
        if (!quantityA.equals(client.quantityA)) return false;
        if (!quantityB.equals(client.quantityB)) return false;
        if (!quantityC.equals(client.quantityC)) return false;
        if (!quantityD.equals(client.quantityD)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientName.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + quantityA.hashCode();
        result = 31 * result + quantityB.hashCode();
        result = 31 * result + quantityC.hashCode();
        result = 31 * result + quantityD.hashCode();
        result = 31 * result + orderList.hashCode();
        return result;
    }

    public void setQuantity(String equityName, Integer number, char operator) {
        if (operator == '+') {
            switch (equityName) {
                case "A":
                    this.setQuantityA(this.getQuantityA() + number);
                    break;
                case "B":
                    this.setQuantityB(this.getQuantityB() + number);
                    break;
                case "C":
                    this.setQuantityC(this.getQuantityC() + number);
                    break;
                case "D":
                    this.setQuantityD(this.getQuantityD() + number);
                    break;
            }
        } else {
            switch (equityName) {
                case "A":
                    this.setQuantityA(this.getQuantityA() - number);
                    break;
                case "B":
                    this.setQuantityB(this.getQuantityB() - number);
                    break;
                case "C":
                    this.setQuantityC(this.getQuantityC() - number);
                    break;
                case "D":
                    this.setQuantityD(this.getQuantityD() - number);
                    break;
            }
        }
    }

    public boolean checkQuantity(String equityName, Integer quantity) {
        switch (equityName) {
            case "A":
                if (this.getQuantityA() > quantity) return true;
                else return false;
            case "B":
                if (this.getQuantityB() > quantity) return true;
                else return false;
            case "C":
                if (this.getQuantityC() > quantity) return true;
                else return false;
            case "D":
                if (this.getQuantityD() > quantity) return true;
                else return false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", balance=" + balance +
                ", quantityA=" + quantityA +
                ", quantityB=" + quantityB +
                ", quantityC=" + quantityC +
                ", quantityD=" + quantityD +
                '}';
    }
}
