package ru.netology.steps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.MoneyTransferPage;
import ru.netology.page.VerificationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateSteps {
    protected static LoginPage loginPage;
    protected static VerificationPage verificationPage;
    protected static DashboardPage dashboardPage;
    protected static MoneyTransferPage moneyTransferPage;

    @Пусть("пользователь залогинен с именем {string} и паролем {string}")
    public void loginUser(String login, String password) {
        loginPage = new LoginPage();
        verificationPage = loginPage.validLogin(login, password);
    }

    @И("пользователь вводит проверочный код 'из смс' {string}")
    public void setValidCode(String code) {
        dashboardPage = verificationPage.validCode(code);
        moneyTransferPage = dashboardPage.card1();
    }

    @Когда("пользователь переводит {int} рублей с карты с номером {string} на свою \"1\" карту с главной страницы")
    public void transferMoney(int amount, String cardNumber) {
        moneyTransferPage.transfer(amount, cardNumber); //"5559 0000 0000 0002"
    }

    @Тогда("баланс его \"1\" карты из списка на главной странице должен стать {int} рублей")
    public void balance(int balance) {
        int expected = dashboardPage.getCard1Balance();
        assertEquals(expected, balance);
    }
}
