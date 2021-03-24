package repository.client;

import model.Client;

import java.sql.*;

public class ClientRepositoryMySQL implements ClientRepository {
    private final Connection connection;

    public ClientRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Boolean addClient(Client client) {
        try {
            PreparedStatement createClientStatement = connection
                    .prepareStatement("INSERT INTO client values (null, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            createClientStatement.setString(1, client.getName());
            createClientStatement.setString(2, client.getICN());
            createClientStatement.setString(3, client.getPCN());
            createClientStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateClient(Client client) {
        try {
            PreparedStatement updateClientStatement = connection
                    .prepareStatement("UPDATE client SET name=?, identity_card_number=?, personal_numerical_code=? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            updateClientStatement.setString(1, client.getName());
            updateClientStatement.setString(2, client.getICN());
            updateClientStatement.setString(3, client.getPCN());
            updateClientStatement.setLong(4, client.getId());
            updateClientStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean viewClient(Client client) {
        try {
            PreparedStatement updateClientStatement = connection
                    .prepareStatement("SELECT * FROM client WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            updateClientStatement.setLong(1, client.getId());
            updateClientStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
