package de.zettsystems;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestReporter;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Wir wollen das Konto über alle Methoden testen
class AccountTest {
    public static final long ACCOUNT_NO = 123L;
    public static final String OWNER = "Tester";
    private Account testee;

    @BeforeAll
    void setUp() {

    }

    @Order(1)
    @Test
    @DisplayName("We start with zero.")
    void checkGetter(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

    }

    @Order(2)
    @Test
    @DisplayName("We must not allow negative depositions.")
    void checkNotDepositNegativeValue(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());
    }

    @Order(3)
    @Test
    @DisplayName("We like positive depositions.")
    void checkDepositPositiveValue(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());
    }

    @Order(4)
    @Test
    @DisplayName("We do allow negative withdrawals.")
    void checkNegativeWithdraw(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());
    }

    @Order(5)
    @Test
    @DisplayName("We do allow negative fees.")
    void checkNegativeFee(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());
    }

    @Order(6)
    @Test
    @DisplayName("We do not withdraw too much.")
    void checkWithdrawTooMuch(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

    }

    @Order(7)
    @Test
    @DisplayName("We are able to calculate interest.")
    void checkInterest(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

    }

    @Order(8)
    @Test
    @DisplayName("Withdrawals up to the balance are ok.")
    void checkWithdraw(TestInfo info, TestReporter testReporter) {
        testReporter.publishEntry(info.getDisplayName());

    }

}