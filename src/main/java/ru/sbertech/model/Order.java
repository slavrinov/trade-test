package ru.sbertech.model;

/**
 * Created by Сергей on 07.07.2017.
 */
public class Order {
    // имя клиента
    private String clientName;
    // наименование операции
    private String operation;
    // Наименование акции
    private String equityName;
    //цена заявки
    private String proposition;
    // количество
    private String quantity;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getEquityName() {
        return equityName;
    }

    public void setEquityName(String equityName) {
        this.equityName = equityName;
    }

    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
