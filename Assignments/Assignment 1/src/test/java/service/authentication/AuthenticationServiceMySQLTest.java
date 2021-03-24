package service.authentication;

import database.Bootstraper;
import database.DatabaseConnectionFactory;
import jdk.nashorn.internal.runtime.linker.Bootstrap;
import launcher.ComponentFactory;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.security.RightsRolesRepositoryMySQL;
import repository.user.UserRepository;
import repository.user.UserRepositoryMySQL;
import service.authentication.AuthenticationService;
import service.authentication.AuthenticationServiceMySQL;
import service.user.UserService;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class AuthenticationServiceMySQLTest {

    public static final String TEST_USERNAME = "test@username.com";
    public static final String TEST_PASSWORD = "TestPassword1@";
    private static AuthenticationService authenticationService;
    private static UserRepository userRepository;

    @BeforeClass
    public static void setUp() throws SQLException {

        ComponentFactory componentFactory = ComponentFactory.instance(true);
        userRepository = componentFactory.getUserRepository();
        authenticationService = componentFactory.getAuthenticationService();

    }

    @Before
    public void cleanUp() {
        userRepository.removeAll();
    }


    @Test
    public void register() {
        //Assert.assertTrue(authenticationService.register(TEST_USERNAME, TEST_PASSWORD).getResult());
    }

    @Test
    public void login() throws Exception {
        /*authenticationService.register(TEST_USERNAME, TEST_PASSWORD);
        Assert.assertNotNull(authenticationService.login(TEST_USERNAME, TEST_PASSWORD).getResult());*/
    }

    @Test
    public void logout() {

    }

}
