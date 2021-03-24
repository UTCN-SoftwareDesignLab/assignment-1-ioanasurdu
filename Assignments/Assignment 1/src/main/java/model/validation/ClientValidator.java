package model.validation;

import model.Client;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientValidator {
    private static final int ICN_LENGTH = 8;
    private static final int PCN_LENGTH = 13;

    public List<String> getErrors() {
        return errors;
    }

    private final List<String> errors;

    private final Client client;

    public ClientValidator(Client client) {
        this.client = client;
        errors = new ArrayList<>();
    }

    public boolean validate() {
        validateICN(client.getICN());
        validatePCN(client.getPCN());
        return errors.isEmpty();
    }

    private void validateICN(String icn) {
        if (icn.length() != ICN_LENGTH) {
            errors.add("ICN must contain exactly 8 characters!");
        }
        if (!containsDigit(icn)) {
            errors.add("ICN must contain digits!");
        }
    }

    private void validatePCN(String pcn) {
        if (pcn.length() != PCN_LENGTH) {
            errors.add("PCN must contain exactly 13 digits!");
        }
    }

    private boolean containsDigit(String s) {
        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    return true;
                }
            }
        }
        return false;
    }
}
