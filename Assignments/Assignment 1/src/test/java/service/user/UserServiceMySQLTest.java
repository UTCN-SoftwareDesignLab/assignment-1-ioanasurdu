package service.user;

import launcher.ComponentFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class UserServiceMySQLTest {
    public static final String TEST_USERNAME = "test@username.com";
    public static final String TEST_PASSWORD = "TestPassword1@";
    private static UserService userService;

    @BeforeClass
    public static void setUp() throws SQLException {

        ComponentFactory componentFactory = ComponentFactory.instance(true);
        userService = componentFactory.getUserService();
    }
    @Test
    public void createEmployee() {
        Assert.assertTrue(userService.createUser(TEST_USERNAME, TEST_PASSWORD).getResult());
    }

    @Test
    public void updateUser() {
        Assert.assertTrue(userService.updateUser(1L, TEST_USERNAME, TEST_PASSWORD).getResult());
    }

    @Test
    public void deleteUser() {
        Assert.assertTrue(userService.deleteUser(TEST_USERNAME, TEST_PASSWORD).getResult());
    }

    @Test
    public void viewUser() {
        Assert.assertNotNull(userService.viewUsers());
    }
}
