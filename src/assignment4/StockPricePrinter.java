
package assignment4;

/**
 *
 * @author Nicholas
 */
public class StockPricePrinter extends StockCustomer implements StockObserver{
    
    /**
     * Sole constructor that sets observing boolean to true.
     */
    public StockPricePrinter(){
        observing = true;
    }
   
    /**
     * Method used to check if the printer is observing a StockExchange object.
     * @return true if observing, false otherwise.
     */
    @Override
    public boolean isObserving(){
        return true;
    }
    
    /**
     * Method used to handle a PriceChangeEvent object.
     * @param pce PriceChangeEvent object
     */
    @Override
    public void priceChanged(PriceChangeEvent pce){
        super.priceChanged(pce);
        int steps = getSteps();
        System.out.println("Price Change " + steps);
        System.out.println("New price: " + pce.getCurrentPrice());
    }
    
    /**
     * Method used to create a description of the StockPricePrinter object.
     * @return String that describes if the StockPricePRinter is printing or not.
     */
    @Override
    public String toString(){
        String description;
        if(observing){
            description = "StockPricePrinter Printing...";
        }
        else{
            description = "StockPricePrinter Finished Printing.";
        }
        return description;
    }
}
