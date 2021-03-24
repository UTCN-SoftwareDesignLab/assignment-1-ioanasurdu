package service.client;

import launcher.ComponentFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.user.UserService;

import java.sql.SQLException;

public class ClientServiceMySQLTest {

    public static final String TEST_USERNAME = "test@username.com";
    public static final String TEST_ICN = "cj256718";
    public static final String TEST_PCN = "2980316120020";
    private static ClientService clientService;

    @BeforeClass
    public static void setUp() throws SQLException {

        ComponentFactory componentFactory = ComponentFactory.instance(true);
        clientService = componentFactory.getClientService();
    }
    @Test
    public void addClient() {
        Assert.assertTrue(clientService.addClient(TEST_USERNAME, TEST_ICN, TEST_PCN).getResult());
    }

    @Test
    public void updateClient() {
        Assert.assertTrue(clientService.updateClient(1L, TEST_USERNAME, TEST_ICN, TEST_PCN).getResult());
    }

}
