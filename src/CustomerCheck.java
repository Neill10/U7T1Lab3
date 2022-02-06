import java.util.ArrayList;

public class CustomerCheck
{
    /** The check for a customer or group of customers
     *  Guaranteed to contain at least one MenuItem and all entries are non-null
     */
    private ArrayList<MenuItem> check;

    /* Constructor */
    public CustomerCheck(ArrayList<MenuItem> check)
    {
        this.check = check;
    }

    /** Returns the total of all MenuItem prices on the check,
     *  as described in part (a)
     */
    public double totalPrices()
    {
        double total = 0;
        for(MenuItem i : check)
        {
            total = total + i.getPrice();
        }
        return total;
    }

    /** Returns true if the restaurant’s coupon offer can be applied to this check and
     *  returns false otherwise, as described in part (b) */
    public boolean couponApplies()
    {
        if(totalPrices() < 40)
        {
            return false;
        }
        for(MenuItem i : check)
        {
            if(i.isDailySpecial())
            {
                return false;
            }
        }
        return true;
    }

    /** Calculates the final cost of this check, as described in part (c) */
    public double calculateCheck()
    {
        double cost = totalPrices();
        double finalCost = cost;
        double tip = 0;
        double discount = 0;
        int customers = 0;

        for(MenuItem i : check)
        {
            if(i.isEntree())
            {
                customers++;
            }
        }

        if(customers >= 6)
        {
            tip = cost * 0.2;
        }

        if(couponApplies())
        {
            discount = cost * .25;
        }

        return finalCost + tip - discount;
    }
}