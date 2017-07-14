package ru.sbertech.model;

/**
 * Created by Сергей on 07.07.2017.
 */
public class Order {

    // наименование операции
    private String operation;
    // Наименование акции
    private String equityName;
    //цена заявки
    private Integer proposition;
    // количество
    private Integer quantity;

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

    public Integer getProposition() {
        return proposition;
    }

    public void setProposition(Integer proposition) {
        this.proposition = proposition;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (!equityName.equals(order.equityName)) return false;
        if (!operation.equals(order.operation)) return false;
        if (!proposition.equals(order.proposition)) return false;
        if (!quantity.equals(order.quantity)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = operation.hashCode();
        result = 31 * result + equityName.hashCode();
        result = 31 * result + proposition.hashCode();
        result = 31 * result + quantity.hashCode();
        return result;
    }
}
