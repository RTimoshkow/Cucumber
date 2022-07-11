package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.Data;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    protected SelenideElement loginField = $("[data-test-id=login] input");
    protected SelenideElement passwordField = $("[data-test-id=password] input");
    protected SelenideElement button = $("[data-test-id=action-login]");

    public VerificationPage validLogin(String login, String password) {
        open("http://localhost:9999");
        loginField.setValue(login);
        passwordField.setValue(password);
        button.click();
        return new VerificationPage();
    }
}
