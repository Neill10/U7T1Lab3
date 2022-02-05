public class MenuItem
{
    private String name;
    private double price;
    private boolean entree;
    private boolean dailySpecial;

    public MenuItem(String n, double p, boolean e, boolean d)
    {
        name = n;
        price = p;
        entree = e;
        dailySpecial = d;
    }

    /** Returns the name, as shown on the menu, of the item */
    public String getName()
    {
        return name;
    }

    /** Returns the price of the item */
    public double getPrice()
    {
        return price;
    }

    /** Returns true if the item is an entree and returns false otherwise */
    public boolean isEntree()
    {
        return entree;
    }

    /** Returns true if the item is a daily special menu item and returns false
     *  otherwise
     */
    public boolean isDailySpecial()
    {
        return dailySpecial;
    }
}