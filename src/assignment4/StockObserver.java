/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author Nicholas
 */
public interface StockObserver {
    /**
     * All stock observers must implement a priceChange method to handle when 
     * the stock's price changes.
     * @param pce PriceChangeEvent object.
     */
    void priceChanged(PriceChangeEvent pce);
    
    /**
     * Method used to check if the StockObserver is currently observing.
     * @return True if observing, false otherwise.
     */
    boolean isObserving();
    /**
     * Method implemented by StockMonitors to stop observing a stock.
     */
    void stop();
    /**
     * Method implemented by StockCustomers to signify that observing has begun.
     */
    void start();
    /**
     * Method implemented by StockCustomers to join an exchange.
     * @param exchange 
     */
    void joinExchange(StockExchange exchange);
}
