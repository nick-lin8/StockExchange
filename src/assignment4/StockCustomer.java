
package assignment4;

/**
 *
 * @author Nicholas
 */
public abstract class StockCustomer implements StockObserver {
    private static int nextID = 1000;
    private final int id;
    private int steps = 0;
    private double initialPrice;
    protected boolean observing;
 
    StockCustomer(){
        this.id = nextID++;
    }
    
    /**
     * Method used to get the initial price of the stock when observation started.
     * @return initialPrice double value representing the initial price.
     */
    public double getInitialPrice(){
        return initialPrice;
    }
    
    /**
     * Method used to get the index of the observer.
     * @return id Integer value representing the index.
     */
    public int getID(){
        return id;
    }
    
    /**
     * Method used to get the number of price changes that have been observed.
     * @return steps Integer value representing the number of price changes.
     */
    public int getSteps(){
        return steps;
    }
    
    /**
     * Method to check if the Monitor is observing or not.
     * @return true if observing, false otherwise.
     */
    @Override
    public boolean isObserving(){
        return observing;
    }
    
    /**
     * Method to set the observing field to false.
     */
    @Override
    public void stop(){
        observing = false;
    }
    
    /**
     * Method to set the observing field to true.
     */
    @Override
    public void start(){
        observing = true;
    }
    
    /**
     * Method used by StockCustomers to handle a price change event.
     * @param pce PriceChangeEvent object.
     */
    @Override
    public void priceChanged(PriceChangeEvent pce){
        steps += 1;
    }
    
    /**
     * Method used by StockCustomers to add themselves to the exchange passed as
     * an argument.
     * @param exchange The exchange the customer will join.
     */
    @Override
    public void joinExchange(StockExchange exchange){
        exchange.AddObserver(this);
        this.initialPrice = exchange.getPrice();
        observing = true;
    }
    
}
