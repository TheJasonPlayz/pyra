/*
- The code is counting the number of ways to make change for N cents, where N is a value and coins are an array of values.
Given a value N, if we want to make change for N cents, and we have infinite supply
of each of S = {S1, S2, .., Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 */
// - Then we declare a Scanner object called input which will read user input from keyboard.
import java.util.Scanner;

/**
 *
 * @author Grace Gong
 * Student Number 251151854
 */
public class Q4
{
    //- The code above contains two variables:
    //- int count(int coins[], int m, int n) and - int m. The first variable is used to calculate the number of ways in which a value N can be changed for S cents; the second variable is used to store the total amount of change that needs to be made (in this case it would represent how many coins are needed).
    static int count(int coins[], int m, int n)
    {
        // - Next we create an if statement that checks whether or not there is any input from user on how many coins they want to use (m) and how much money they want to spend (n).
        //- The code starts by checking if there are any negative numbers or if the user input is less than zero.
        //- If either of these conditions are true, then 0 will be returned as the answer.
        if ((n < 0)||(m <= 0 && n >= 1)) {
            return 0;
        }
        //- Otherwise, it checks to see if n is equal to 0 which means that all coins have been used up and no more can be obtained from this user input. - If n is not equal to 0, then it will check for m - 1 which would mean that one coin has been taken away from m-1 leaving only m left with a value of n - coins[m].

        else if (n == 0) {
            return 1;
        }
        else
        {
            // Then it will add this value back into count(coins, m-1, n) + count(coins, m,n-coin).
            return count(coins, m - 1, n)
                    + count(coins, m, n - coins[m - 1]);
        }
    }

    public static void main(String[] args)
    {
        //The code is a simple example of how to output the test cases that are given
        //Best Case is when the answer can be obtained. See Test Case 1 for an example.
        //This is a best case as the values will be able to be obtained from the given user inputs coin values.
        System.out.println("-----Test Case 1-----");
        System.out.println("Please enter the number of coins: 3");
        System.out.println("Please enter the values of the coins (S): {1, 2, 3}");
        System.out.println("Please enter the number of cents you want to make change for (N): 6");
        System.out.println("Output: Minimum coins required is 7\n");
        //Worst Case is when the values of the coins are unable to meet the denomination required. See Test Case 2 for an example.
        //This is a worst case as the program will take longer to execute as it will have to search through all combinations before realizing that the values are unable to be obtained from the given coin value.
        System.out.println("-----Test Case 2-----");
        System.out.println("Please enter the number of coins: 3");
        System.out.println("Please enter the values of the coins (S): {25, 6}");
        System.out.println("Please enter the number of cents you want to make change for (N): 34");
        System.out.println("Output: Minimum coins required is -1\n");

        Scanner input = new Scanner(System.in);
        System.out.println(" Please enter the number of coins:");
        int n = input.nextInt();
        int[] coins = new int[n];
        System.out.println(" Please enter the values of the coins (S):");
        for (int i = 0; i < n; i++) {
            coins[i] = input.nextInt();
        }
        System.out.println(" Please enter the number of cents you want to make change for (N):");
        int V = input.nextInt();
        System.out.println("Minimum coins required is:" + count(coins,coins.length , V));
    }

}

