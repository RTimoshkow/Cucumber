package ru.netology.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Data {

    public static VerificationCode getVerificationCode() {
        return new VerificationCode("12345");
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class CardNumber {
        protected String cardId;
        protected String dataTestId;
    }

    public static CardNumber getRegisteredCard1() {
        return new CardNumber("5559 0000 0000 0001", "92df3f1c-a033-48e6-8390-206f6b1f56c0");
    }

    public static CardNumber getRegisteredCard2() {
        return new CardNumber("5559 0000 0000 0002", "0f3f5c2a-249e-4c3d-8287-09f7a039391d");
    }

    public static CardNumber getNotRegisteredCard() {
        return new CardNumber("0000 0000 0000 0000", "from");
    }
}
