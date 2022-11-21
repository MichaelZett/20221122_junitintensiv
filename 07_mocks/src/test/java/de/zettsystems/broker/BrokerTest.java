package de.zettsystems.broker;

import de.zettsystems.broker.Broker;
import de.zettsystems.broker.Stock;
import de.zettsystems.broker.StockService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.quality.Strictness.STRICT_STUBS;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = STRICT_STUBS) //default
class BrokerTest {

    @Mock
    private StockService stockService;

    @InjectMocks
    private Broker testee;

    @Captor
    private ArgumentCaptor<Integer> quantityCaptor;

    @Captor
    private ArgumentCaptor<Stock> stockCaptor;


    @Test
    void shouldBuyStocks() {
        when(stockService.getPrice(any(Stock.class))).thenReturn(100.0D);

        testee.buyBestStock(1_000_000);

        InOrder inOrder = inOrder(stockService);
        inOrder.verify(stockService).getPrice(any(Stock.class));
        inOrder.verify(stockService).buy(stockCaptor.capture(), quantityCaptor.capture());
        verifyNoMoreInteractions(stockService);

        assertThat(quantityCaptor.getValue()).isEqualTo(10_000);
        final Stock value = stockCaptor.getValue();
        assertThat(value.getName()).isEqualTo("SAP");
    }
}