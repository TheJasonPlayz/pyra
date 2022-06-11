import java.util.Scanner;

/* Given a value V, if we want to make a change for V cents, and we have an infinite supply
of each of coin C = C1, C2, .., Cm valued coins, what is the minimum number of coins to make the
change? If it’s not possible to make a change, print -1.
- The code is trying to find the minimum number of coins needed for a certain amount.
 */
/**
 *
 * @author Grace Gong
 * Student Number: 251151854
 */
public class Q3
{

    static int minCoins(int coins[], int amount)
    {
        // - The code starts by declaring an int variable called result and initializing it with 0
        int result = 0;
        //- It then checks if the amount is greater than 0, which means that there are coins in the list.
        if (amount > 0) {
            //- If so, it subtracts 1 from result and loops through each coin in the list until it finds one less than or equal to amount.
            result = -1;
            //- Once found, it increments variantCount by 1 and compares variantCount against -1 (the maximum value).
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= amount) {
                    int variantCount = minCoins(coins, amount - coins[i]);
                    //- If variantCount is not -1 but is greater than -1, then result will be set to variantCount + 1 instead of just being set to -1 because this would mean that there was another coin left over after finding out how many coins were needed for a certain amount.
                    if (variantCount  < result-1 && variantCount != -1 ) {
                        result = variantCount + 1;
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args)
        /*When the program will execute then it will first show the numbers selected for each test case. This will be the guidance for a user
    regarding input. */
    {
        //- The code is a simple example of how to output the test cases that are given.
       //Best case is when the coin denominations can be calculated
        System.out.println("-----Test Case 1-----");
        System.out.println("Please enter the number of coins: 3");
        System.out.println("Please enter the Coins values: {25, 10, 5}");
        System.out.println(" Please enter the value you want to get in change: 30");
        System.out.println("Output: Minimum coins required is 2\n");
        //Worst case is when the coin denominations cannot be calculated and return -1
        System.out.println("-----Test Case 2-----");
        System.out.println("Please enter the number of coins: 2");
        System.out.println("Please enter the Coins values: {25, 6}");
        System.out.println(" Please enter the value you want to get in change: 34");
        System.out.println("Output: Minimum coins required is -1\n");
        //getting user input for the number of coins
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of coins:");
        int n = input.nextInt();
        //getting user input for the coin values
        System.out.println("Please enter the Coins values:");
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = input.nextInt();
        }
        //getting user input
        System.out.println(" Please enter the value you want to get in change:");
        int V = input.nextInt();
        //printing out the result
        System.out.println("Minimum coins required is " + minCoins(coins, V));
    }
}