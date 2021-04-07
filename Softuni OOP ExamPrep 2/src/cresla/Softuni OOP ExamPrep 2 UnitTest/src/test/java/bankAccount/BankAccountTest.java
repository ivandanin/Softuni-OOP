package bankAccount;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    private static BankAccount bankAccount;

    @Before
    public void setUp() {
        bankAccount = new BankAccount("Pesho", BigDecimal.valueOf(97865432.10));
    }

    @Test
    public void testConstructorWithCorrectData() {
        assertEquals(BigDecimal.valueOf(97865432.10), bankAccount.getBalance());
        assertEquals("Pesho", bankAccount.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithWrongData() {
        new BankAccount("", BigDecimal.valueOf(532094));
        assertEquals("Pesho", bankAccount.getName());
        assertEquals(BigDecimal.valueOf(97865432.10), bankAccount.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameShouldThrowExceptionWhenNameShorterThanThreeLetters() {
        new BankAccount("", BigDecimal.valueOf(532094));
        assertEquals("", bankAccount.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameShouldThrowExceptionWhenNameLongerThan25Letters() {
        new BankAccount("abcdefghijklmnopqrstuvwxyz", BigDecimal.valueOf(532094));
        assertEquals("abcdefghijklmnopqrstuvwxyz", bankAccount.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetBalanceShouldFailWhenBalanceIsSmallerThanZero() {
        new BankAccount("Pesho", BigDecimal.valueOf(-4));
        assertEquals(BigDecimal.valueOf(-4), bankAccount.getBalance());
    }
    @Test
    public void testSetBalanceWithPositiveBalance() {
        assertEquals(BigDecimal.valueOf(97865432.10), bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDepositShouldFailWhenValueIsLessThanZero() {
        bankAccount.deposit(BigDecimal.valueOf(-5));
        assertEquals(BigDecimal.valueOf(-5), bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDepositShouldFailWhenValueEqualsToZero() {
        new BankAccount("Pesho", BigDecimal.valueOf(0));
        bankAccount.deposit(BigDecimal.valueOf(0));
        assertEquals(BigDecimal.valueOf(0), bankAccount.getBalance());
    }

    @Test
    public void testDepositWithCorrectData() {
        bankAccount.deposit(BigDecimal.valueOf(5));
        assertEquals(BigDecimal.valueOf(97865437.10), bankAccount.getBalance());
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testWithdrawShouldFailWhenBalanceIsSmallerThanWithdraw() {
        bankAccount = new BankAccount("Pesho", BigDecimal.valueOf(3));
        bankAccount.withdraw(BigDecimal.valueOf(5));
        assertEquals(BigDecimal.valueOf(-2), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawShouldFailWhenWithdrawIsZero() {
        bankAccount.withdraw(BigDecimal.valueOf(0));
        assertEquals(BigDecimal.valueOf(97865432.10), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawShouldSubtractBalanceWithCorrectData() {
        BigDecimal expected = bankAccount.getBalance().subtract(BigDecimal.valueOf(5));
        assertEquals(BigDecimal.valueOf(5), bankAccount.withdraw(BigDecimal.valueOf(5)));
        assertEquals(expected, bankAccount.getBalance());
    }

    @Test
    public void testWithdrawWithCorrectData() {
        bankAccount.withdraw(BigDecimal.valueOf(5));
        assertEquals(BigDecimal.valueOf(97865427.10), bankAccount.getBalance());
    }
}