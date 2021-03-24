package model;

public class Account {
    private Long id;
    private String cardNumber;
    private String type;
    private float amount;
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() { return cardNumber; }

    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public float getAmount() { return amount; }

    public void setAmount(float amount) { this.amount = amount; }

}
