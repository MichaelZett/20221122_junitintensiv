package de.zettsystems.broker;

import de.zettsystems.broker.Stock;

public interface StockService {
   double getPrice(Stock stock);

   void buy(Stock stock, int quantity);
}
