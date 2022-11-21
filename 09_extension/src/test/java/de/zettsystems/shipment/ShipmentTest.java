package de.zettsystems.shipment;

import de.zettsystems.common.Time;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShipmentTest {

    @Test
    void sendShipmentNow() throws InterruptedException {
        Shipment testee = new Shipment("Playstation");

        testee.sendShipment();

        Thread.sleep(1000L);

        testee.arrive();

        assertThat(testee.getDuration()).isCloseTo(Duration.ofMillis(1000L), Duration.ofMillis(25L));
    }

    @Test
    void sendShipmentWithTime() throws InterruptedException {
        Shipment testee = new Shipment("Playstation");

        Time.useMockTime(LocalDateTime.of(2021,10,31,12,15), ZoneId.of("Europe/Berlin"));
        testee.sendShipment();

        Time.useMockTime(LocalDateTime.of(2021,11,26,12,15), ZoneId.of("Europe/Berlin"));

        testee.arrive();

        assertThat(testee.getDuration()).isEqualTo(Duration.ofDays(26L));
    }
}