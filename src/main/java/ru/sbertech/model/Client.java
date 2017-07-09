package ru.sbertech.model;

/**
 * Created by Сергей on 07.07.2017.
 */
public class Client {
    private String clientName;
    private Integer balance;
    private Integer quantityA;
    private Integer quantityB;
    private Integer quantityC;
    private Integer quantityD;

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
            case "A": if (this.getQuantityA() > quantity) return true ; else return false;
            case "B": if (this.getQuantityB() > quantity) return true ; else return false;
            case "C": if (this.getQuantityC() > quantity) return true ; else return false;
            case "D": if (this.getQuantityD() > quantity) return true ; else return false;
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
