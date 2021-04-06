
package assignment4;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Nicholas
 */
public class StockExchange {
    private double stockPrice;
    
    private boolean open = false;
    
    private final ArrayList<StockObserver> observers;
    
    private PriceChangeEvent recentPriceChange = new PriceChangeEvent(this, 0);
    
    /**
     * Public Constructor that takes in a starting price for the single stock.
     * @param price Double value representing the price of the stock.
     */
    public StockExchange(double price){
        stockPrice = price;
        observers = new ArrayList<>();
    }
    
    /**
     * Constructor that takes in a starting price for the single stock and a list of stock customers.
     * @param price Double value representing the price of the stock.
     * @param customers ArrayList of customers to be added to the stock exchange.
     */
    StockExchange(double price, ArrayList<StockObserver> customers){
        this(price);
        observers.addAll(customers);
    }
    
    
    /**
     * Method used to get the stock value.
     * @return stockPrice Double value representing the stock price.
     */
    public double getPrice(){
        return stockPrice;
    }
    
    /**
     * Method used to set the stock value.
     * @param stockPrice 
     */
    public void setPrice(double stockPrice){
        this.stockPrice = stockPrice;
    }
    
    /**
     * Method used to update the stock value every second.
     * @throws InterruptedException
     */
    public void updatePrice() throws InterruptedException{
        while(open){
            Thread.sleep(1000);
            int direction = (int) (100 * Math.random());
            if(direction < 50){
                setPrice(getPrice() - 1);
                recentPriceChange.setPriceChange(-1);
            }
            else{
                setPrice(getPrice() + 1);
                recentPriceChange.setPriceChange(1);
            }
            for(Object obs: getObs()){
                if(obs instanceof StockPricePrinter){
                    StockPricePrinter casted_obs = (StockPricePrinter) obs;
                    casted_obs.priceChanged(recentPriceChange);
                }
                else if(obs instanceof StockMonitor){
                    StockMonitor casted_obs = (StockMonitor) obs;
                    casted_obs.priceChanged(recentPriceChange);
                }
            }
            if(observers.size() <= 1){
                observers.remove(0);
                dayClose();
            }
        }
        
    }
    
    /**
     * Method used to start the simulation of price changes for the stock.
     */
    public void dayOpen(){
        open = true;
        try{
            updatePrice();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    /**
     * Method to halt the trading on this StockExchange for end of day.
     */
    public void dayClose(){
        open = false;
    }
    /**
     * Method used to get the observers array.
     * @return observers[]
     */
    public Object[] getObs(){
        return observers.toArray();
    }
    
    /**
     * Method used to get an iterator of the observer list.
     */
    public Iterator iterator(){
        return observers.iterator();
    }
    
    /**
     * Method used to add a StockObserver object.
     * @param obs StockObserver object to be added.
     */
    public void AddObserver(StockObserver obs){
        observers.add(obs);
    }
    
    /**
     * Method used to remove a StockObserver object.
     * @param obs Object that implements the StockObserver interface.
     */
    public void RemoveObserver(StockObserver obs){
        observers.remove(obs);
    }
    
    /**
     * Method used to check if the observer list is empty or not.
     * The observer list will always have a price printer the methods checks if
     * there is more than just the PricePrinter object in the array list.
     * @return boolean value.
     */
    public boolean hasMonitors(){
        return (observers.size() > 1);
    }
    
    /**
     * Method used to see if the StockExchange is open for trading.
     * @return open true if stock exchange is open, false otherwise.
     */
    public boolean isOpen(){
        return open;
    }
    
}
