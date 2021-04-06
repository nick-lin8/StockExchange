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
public class PriceChangeEvent {
    private double priceChange;

    public final StockExchange exchange;
    
    /**
     * Public constructor for the PriceChangeEvent class that links a Stock Exchange
     * and provides a price change.
     * @param exchange StockExchange object representing the stock exchange
     * @param priceChange Double value representing the amount the stock's price has changed.
     */
    public PriceChangeEvent(StockExchange exchange, double priceChange){
        this.exchange = exchange;
        this.priceChange = priceChange;
    }
    
    /**
     * Method used to get the priceChange value.
     * @return priceChange value of type double representing the price change.
     */
    public double getPriceChange(){
        return priceChange;
    }
    /**
     * Method used to set the priceChange field.
     * @param priceChange value to be stored in the priceChange field.
    */
    public void setPriceChange(double priceChange){
        this.priceChange = priceChange;
    }
    
    /**
     * Method used to get the current price of the stock.
     * @return 
     */
    public double getCurrentPrice(){
        return this.exchange.getPrice();
    }
    
}
