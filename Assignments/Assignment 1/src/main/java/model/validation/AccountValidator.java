package model.validation;

import model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountValidator {
    private static final int CN_LENGTH = 16;

    public List<String> getErrors() {
        return errors;
    }

    private final List<String> errors;

    private final Account account;

    public AccountValidator(Account account) {
        this.account = account;
        errors = new ArrayList<>();
    }

    public boolean validate() {
        validateCardNumber(account.getCardNumber());
        validateAmount(account.getAmount());
        return errors.isEmpty();
    }

    public void validateCardNumber(String card_number){
        if (card_number.length() != CN_LENGTH) {
            errors.add("Card number must contain exactly 16 digits!");
        }
    }

    public void validateAmount(float amount) {
        if(amount < 0.0)
            errors.add("Invalid amount!");
    }


}
