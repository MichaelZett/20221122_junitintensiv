package de.zettsystems.shipment;

import de.zettsystems.common.FreezeTimeExtension;
import de.zettsystems.shipment.Shipment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(FreezeTimeExtension.class)
class UseFreezeTimeTest {

    @Test
    void testFreezeTime() throws InterruptedException {
        Shipment testee = new Shipment("Playstation");

        testee.sendShipment();

        Thread.sleep(3000L);

        testee.arrive();

        System.out.println(testee.getDuration().getSeconds() + " Sekunden");
    }

}