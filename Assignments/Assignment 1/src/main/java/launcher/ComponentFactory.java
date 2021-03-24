package launcher;

import controller.*;
import database.DatabaseConnectionFactory;
import repository.account.AccountRepository;
import repository.account.AccountRepositoryMySQL;
import repository.client.ClientRepository;
import repository.client.ClientRepositoryMySQL;
import repository.security.RightsRolesRepository;
import repository.security.RightsRolesRepositoryMySQL;
import repository.user.UserRepository;
import repository.user.UserRepositoryMySQL;
import service.account.AccountService;
import service.account.AccountServiceMySQL;
import service.authentication.AuthenticationService;
import service.authentication.AuthenticationServiceMySQL;
import service.client.ClientService;
import service.client.ClientServiceMySQL;
import service.user.UserService;
import service.user.UserServiceMySQL;
import view.*;

import java.sql.Connection;

public class ComponentFactory {

    private final LoginView loginView;

    private final LoginController loginController;

    private final AuthenticationService authenticationService;
    private final AdminController adminController;
    private final ClientController clientController;
    private final AccountController accountController;
    private final UsersController usersController;
    private final AdminView adminView;
    private final ClientView clientView;
    private final AccountView accountView;
    private final UsersView usersView;
    private final UserService userService;
    private final ClientService clientService;
    private final AccountService accountService;

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final RightsRolesRepository rightsRolesRepository;

    private static ComponentFactory instance;

    public static ComponentFactory instance(Boolean componentsForTests) {
        if (instance == null) {
            instance = new ComponentFactory(componentsForTests);
        }
        return instance;
    }

    private ComponentFactory(Boolean componentsForTests) {
        Connection connection = new DatabaseConnectionFactory().getConnectionWrapper(componentsForTests).getConnection();
        this.rightsRolesRepository = new RightsRolesRepositoryMySQL(connection);
        this.userRepository = new UserRepositoryMySQL(connection, rightsRolesRepository);
        this.clientRepository = new ClientRepositoryMySQL(connection);
        this.accountRepository = new AccountRepositoryMySQL(connection);
        this.authenticationService = new AuthenticationServiceMySQL(this.userRepository, this.rightsRolesRepository);

        this.loginView = new LoginView();
        this.adminView = new AdminView();
        this.clientView = new ClientView();
        this.accountView = new AccountView();
        this.usersView = new UsersView();

        this.userService = new UserServiceMySQL(userRepository, rightsRolesRepository);
        this.clientService = new ClientServiceMySQL(clientRepository);
        this.accountService = new AccountServiceMySQL(accountRepository, clientRepository);

        this.usersController = new UsersController(usersView, userService);
        this.adminController = new AdminController(adminView, userService, usersController);
        this.clientController = new ClientController(clientView, clientService);
        this.accountController = new AccountController(accountView, accountService);
        this.loginController = new LoginController(loginView, authenticationService, adminController, clientController, accountController);
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public RightsRolesRepository getRightsRolesRepository() {
        return rightsRolesRepository;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public UserService getUserService() { return userService; }

    public ClientService getClientService() { return clientService; }

    public AccountService getAccountService() { return accountService; }

    public AccountRepository getAccountRepository() { return accountRepository; }
}