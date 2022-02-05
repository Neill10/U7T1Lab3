import java.util.ArrayList;
import java.util.Arrays;

public class CheckTester
{
    public static int passedTests = 0;
    public static int failedTests = 0;
    public static ArrayList<MenuItem> testItems = new ArrayList<MenuItem>();

    public static void main(String[] args)
    {
        System.out.println("--------- TEST totalPrices (part a) ---------");
        // TESTS #1-8
        testTotal(1, 10.50, 1);
        testTotal(2, 15.25, 2);
        testTotal(3, 19.15, 3);
        testTotal(4, 28.40, 4);
        testTotal(5, 30.65, 5);
        testTotal(6, 41.15, 6);
        testTotal(7, 53.95, 6);
        testTotal(8, 67.20, 6);

        System.out.println("------- TEST couponApplies (part b) -------");

        // TESTS #9-12
        testCoupon(9, false);
        testCoupon(10, false);
        testCoupon(11, false);
        testCoupon(12, true);

        System.out.println("------- TEST calculateCheck (part c) -------");

        // TESTS #13-16: these tests reflect the four situations in the FRQ table
        testCalculate(13, 95);
        testCalculate(14, 37.50);
        testCalculate(15, 96);
        testCalculate(16, 40);

        System.out.println("--------------------------------------------------");
        System.out.println("TOTAL PASSED TESTS: " + passedTests + " out of 16");
        System.out.println("TOTAL FAILED TESTS: " + failedTests + " out of 16");
    }

    public static void testTotal(int numItems, double expected, int testNo)
    {
        setItems(numItems);

        CustomerCheck check = new CustomerCheck(testItems);

        double actual = check.totalPrices();

        System.out.print("TEST #" + testNo + " -- ");
        if (actual == expected)
        {
            System.out.println("PASS");
            passedTests++;
        }
        else
        {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expected);
        System.out.println("   Actual: " + actual);
    }

    public static void setItems(int numItems)
    {
        testItems.clear();

        ArrayList<MenuItem> allItems = new ArrayList<MenuItem>();
        MenuItem item0 = new MenuItem("burger", 10.50, true, false);
        MenuItem item1 = new MenuItem("fries", 4.75, false, false);
        MenuItem item2 = new MenuItem("apple pie", 3.90, false, true);
        MenuItem item3 = new MenuItem("salad", 9.25, true, true);
        MenuItem item4 = new MenuItem("iced tea", 2.25, false, false);
        MenuItem item5 = new MenuItem("steak", 10.50, false, true);
        MenuItem item6 = new MenuItem("pizza", 12.80, true, false);
        MenuItem item7 = new MenuItem("chef's special", 13.25, true, true);

        allItems.add(item0);
        allItems.add(item1);
        allItems.add(item2);
        allItems.add(item3);
        allItems.add(item4);
        allItems.add(item5);
        allItems.add(item6);
        allItems.add(item7);

        for (int i = 0; i < numItems; i++)
        {
            testItems.add(allItems.get(i));
        }
    }

    public static void testCoupon(int testNo, boolean expected)
    {
        ArrayList<MenuItem> allItems = new ArrayList<MenuItem>();

        if (testNo == 9) // coupon does NOT apply
        {
            MenuItem item0 = new MenuItem("test", 10, true, false);
            MenuItem item1 = new MenuItem("test", 10, false, false);
            MenuItem item2 = new MenuItem("test", 10, true, false);
            MenuItem item3 = new MenuItem("test", 9, false, false);
            allItems.add(item0);
            allItems.add(item1);
            allItems.add(item2);
            allItems.add(item3);
        }
        if (testNo == 10) // coupon does NOT apply
        {
            MenuItem item0 = new MenuItem("test", 10, true, false);
            MenuItem item1 = new MenuItem("test", 10, false, false);
            MenuItem item2 = new MenuItem("test", 10, true, true);
            MenuItem item3 = new MenuItem("test", 15, false, false);
            allItems.add(item0);
            allItems.add(item1);
            allItems.add(item2);
            allItems.add(item3);
        }
        if (testNo == 11) // coupon does NOT apply
        {
            MenuItem item0 = new MenuItem("test", 10, true, false);
            MenuItem item1 = new MenuItem("test", 10, false, false);
            MenuItem item2 = new MenuItem("test", 10, true, true);
            MenuItem item3 = new MenuItem("test", 9, false, false);
            allItems.add(item0);
            allItems.add(item1);
            allItems.add(item2);
            allItems.add(item3);
        }
        if (testNo == 12) // coupon DOES apply
        {
            MenuItem item0 = new MenuItem("test", 10, true, false);
            MenuItem item1 = new MenuItem("test", 10, false, false);
            MenuItem item2 = new MenuItem("test", 10, true, false);
            MenuItem item3 = new MenuItem("test", 15, false, false);
            allItems.add(item0);
            allItems.add(item1);
            allItems.add(item2);
            allItems.add(item3);
        }

        CustomerCheck check = new CustomerCheck(allItems);

        boolean actual = check.couponApplies();

        System.out.print("TEST #" + testNo + " -- ");
        if (actual == expected)
        {
            System.out.println("PASS");
            passedTests++;
        }
        else
        {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expected);
        System.out.println("   Actual: " + actual);
    }

    public static void testCalculate(int testNo, double expected)
    {
        ArrayList<MenuItem> allItems = new ArrayList<MenuItem>();

        if (testNo == 13) // reflects first row of example calculations in FRQ
        {
            MenuItem item0 = new MenuItem("test", 10, true, false);
            MenuItem item1 = new MenuItem("test", 10, true, false);
            MenuItem item2 = new MenuItem("test", 10, false, false);
            MenuItem item3 = new MenuItem("test", 10, true, false);
            MenuItem item4 = new MenuItem("test", 10, true, false);
            MenuItem item5 = new MenuItem("test", 10, true, false);
            MenuItem item6 = new MenuItem("test", 10, true, false);
            MenuItem item7 = new MenuItem("test", 10, true, false);
            MenuItem item8 = new MenuItem("test", 10, false, false);
            MenuItem item9 = new MenuItem("test", 10, true, false);
            allItems.add(item0);
            allItems.add(item1);
            allItems.add(item2);
            allItems.add(item3);
            allItems.add(item4);
            allItems.add(item5);
            allItems.add(item6);
            allItems.add(item7);
            allItems.add(item8);
            allItems.add(item9);
        }
        if (testNo == 14)
        {
            MenuItem item0 = new MenuItem("test", 10, true, false);
            MenuItem item1 = new MenuItem("test", 10, true, false);
            MenuItem item2 = new MenuItem("test", 10, true, false);
            MenuItem item3 = new MenuItem("test", 10, true, false);
            MenuItem item4 = new MenuItem("test", 10, true, false);
            allItems.add(item0);
            allItems.add(item1);
            allItems.add(item2);
            allItems.add(item3);
            allItems.add(item4);
        }
        if (testNo == 15)
        {
            MenuItem item0 = new MenuItem("test", 10, true, false);
            MenuItem item1 = new MenuItem("test", 10, true, false);
            MenuItem item2 = new MenuItem("test", 10, false, false);
            MenuItem item3 = new MenuItem("test", 10, true, true);
            MenuItem item4 = new MenuItem("test", 10, true, false);
            MenuItem item5 = new MenuItem("test", 10, false, false);
            MenuItem item6 = new MenuItem("test", 10, true, false);
            MenuItem item7 = new MenuItem("test", 10, true, false);
            allItems.add(item0);
            allItems.add(item1);
            allItems.add(item2);
            allItems.add(item3);
            allItems.add(item4);
            allItems.add(item5);
            allItems.add(item6);
            allItems.add(item7);
        }
        if (testNo == 16)
        {
            MenuItem item0 = new MenuItem("test", 10, true, false);
            MenuItem item1 = new MenuItem("test", 10, true, true);
            MenuItem item2 = new MenuItem("test", 10, false, false);
            MenuItem item3 = new MenuItem("test", 10, false, false);
            allItems.add(item0);
            allItems.add(item1);
            allItems.add(item2);
            allItems.add(item3);
        }

        CustomerCheck check = new CustomerCheck(allItems);

        double actual = check.calculateCheck();

        System.out.print("TEST #" + testNo + " -- ");
        if (actual == expected)
        {
            System.out.println("PASS");
            passedTests++;
        }
        else
        {
            System.out.println("*****FAIL*****");
            failedTests++;
        }
        System.out.println(" Expected: " + expected);
        System.out.println("   Actual: " + actual);
    }
}