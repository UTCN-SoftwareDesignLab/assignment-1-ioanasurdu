package service.account;

import launcher.ComponentFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.user.UserService;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class AccountServiceMySQLTest {
    public static final String TEST_CLIENT = "3";
    public static final String TEST_ACC1 = "5";
    public static final String TEST_ACC2 = "9";
    public static final String TEST_CARD = "1234123412341234";
    public static final String TEST_TYPE = "debit";
    public static final String TEST_AMOUNT = "400";
    private static AccountService accountService;

    @BeforeClass
    public static void setUp() throws SQLException {

        ComponentFactory componentFactory = ComponentFactory.instance(true);
        accountService = componentFactory.getAccountService();
    }

    @Test
    public void createAccount() {
        Assert.assertTrue(accountService.createAccount(Long.parseLong(TEST_CLIENT), TEST_CARD, TEST_TYPE, Float.parseFloat(TEST_AMOUNT)).getResult());
    }

    @Test
    public void updateAccount() {
        Assert.assertTrue(accountService.updateAccount(Long.parseLong(TEST_CLIENT), TEST_CARD, TEST_TYPE, Float.parseFloat(TEST_AMOUNT)).getResult());
    }

    @Test
    public void deleteAccount() {
        Assert.assertTrue(accountService.deleteAccount(TEST_CARD, TEST_TYPE, Float.parseFloat(TEST_AMOUNT)).getResult());
    }

    @Test
    public void transfer(){
        //Assert.assertNotNull(accountService.transfer(Long.parseLong(TEST_ACC1), Long.parseLong(TEST_ACC2), Float.parseFloat(TEST_AMOUNT)));
    }

    @Test
    public void processBill(){
        //Assert.assertNotNull(accountService.processBill(Long.parseLong(TEST_ACC2), Float.parseFloat(TEST_AMOUNT)));
    }

}
