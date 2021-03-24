package model;

public class Client {
    private Long id;
    private String name;
    private String identity_card_number;
    private String personal_numerical_code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getICN() { return identity_card_number; }

    public void setICN(String icn) { this.identity_card_number = icn; }

    public String getPCN() { return personal_numerical_code; }

    public void setPCN(String pcn) { this.personal_numerical_code = pcn; }
}
