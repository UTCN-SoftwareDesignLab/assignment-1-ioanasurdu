package repository.account;

import model.Account;
import model.builder.AccountBuilder;

import java.sql.*;

public class AccountRepositoryMySQL implements AccountRepository {
    private final Connection connection;

    public AccountRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Boolean createAccount(Account account, Long clientId) {
        try {
            PreparedStatement createAccountStatement = connection
                    .prepareStatement("INSERT INTO client_account values (null, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            createAccountStatement.setLong(1, clientId);
            createAccountStatement.setString(2, account.getCardNumber());
            createAccountStatement.setString(3, account.getType());
            createAccountStatement.setFloat(4, account.getAmount());
            createAccountStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateAccount(Account account, Long clientId) {
        try {
            PreparedStatement updateAccountStatement = connection
                    .prepareStatement("UPDATE client_account SET client_id=?, account_type=?,amount=? WHERE card_number=?", Statement.RETURN_GENERATED_KEYS);
            updateAccountStatement.setLong(1, clientId);
            updateAccountStatement.setString(2, account.getType());
            updateAccountStatement.setFloat(3, account.getAmount());
            updateAccountStatement.setString(4, account.getCardNumber());
            updateAccountStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteAccount(Account account) {
        try {
            PreparedStatement deleteAccountStatement = connection
                    .prepareStatement("DELETE FROM client_account WHERE card_number=?", Statement.RETURN_GENERATED_KEYS);
            deleteAccountStatement.setString(1, account.getCardNumber());
            deleteAccountStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Account getAccount(Long id) {
        try{
            PreparedStatement getAccountStatement = connection
                    .prepareStatement("SELECT * FROM client_account WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            getAccountStatement.setLong(1, id);
            ResultSet resultSet = getAccountStatement.executeQuery();
            resultSet.next();

            Long client_id = resultSet.getLong("client_id");
            String card_number = resultSet.getString("card_number");
            String type = resultSet.getString("account_type");
            Long amount = resultSet.getLong("amount");

            Account account = new AccountBuilder()
                    .setId(id)
                    .setCardNumber(card_number)
                    .setType(type)
                    .setAmount(amount)
                    .build();
            return account;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateAmount(float amount, Long id) {
        try{
            PreparedStatement updateAccountStatement = connection
                    .prepareStatement("UPDATE client_account SET amount=? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            updateAccountStatement.setFloat(1, amount);
            updateAccountStatement.setLong(2, id);
            updateAccountStatement.executeUpdate();
            return true;

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
