
package assignment4;

/**
 *
 * @author Nicholas
 */
public class StockMonitor extends StockCustomer implements StockObserver{
    public final double threshold;
    
    /**
     * Constructor that takes in a double amount threshold.
     * @param threshold The monitor will continue to monitor as long as the stock
     * price has not moved up or down by the threshold amount.
     */
    public StockMonitor(double threshold){
        observing = false;
        this.threshold = threshold;
    }
    
    
    /**
     * Method used to handle a price change. Monitor will remove itself from the
     * exchange if the threshold has been met.
     * @param pce A PriceChangeEvent object
     */
    @Override
    public void priceChanged(PriceChangeEvent pce){
        super.priceChanged(pce);
        if(Math.abs(pce.getCurrentPrice() - this.getInitialPrice()) >= this.threshold){
            System.out.println("Limit: " + this.threshold + 
                                " met --- Price Changes Occured: " 
                                + this.getSteps());
            pce.exchange.RemoveObserver(this);
            this.stop();
        }
    }
    
    /**
     * Method used to return a description of the monitor's status.
     * @return A string describing if the monitor is still observing or the
     * amount of prices changes that occurred before the threshold was met.
     */
    @Override
    public String toString(){
        String description;
        if(observing){
            description = "StockMonitor " + getID() + " Observing...";
            return description;
        }
        
        else{
            description = "Limit: " + this.threshold + 
                          " met --- Price Changes Occured: " + this.getSteps();
            return description;
        }
    }
}
