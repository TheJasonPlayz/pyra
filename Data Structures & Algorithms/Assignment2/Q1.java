/*
Write a java program that will implement the scenario when the tank is full and there are
gas stations at distances stop1, stop2, ... , stop n.
 */
import java.util.Scanner;

/**
 *
 * @author Grace Gong
 * Student Number: 251151854
 */

/*
Input Format: The first line contains an integer d. The second line contains an integer m. The third
line specifies an integer n. Finally, the last line contains integers stop1, stop2, ... , stop n.
Output Format: Assuming that the distance between the cities is d miles, a car can travel at most
m miles.
• On a full tank, and there are gas stations at distances stop1, stop2, ..., stop n
• along the way, output the minimum number of refills needed. Assume that the car starts
with a full tank. If it is not possible to reach the destination, output −1.
 */
public class Q1
{
    public static void main(String[] args)
    { /*When the program will execute then it will first show the numbers selected for each test case. This will be the guidance for a user
        regarding input. */

        //Best Case would be if the values entered are able to be calculated into the number of stops as shown in Test Case 1.
        System.out.println("-----Test Case 1-----");
        System.out.println("Please enter the distance between the cities: 950");
        System.out.println("Please enter the max distance car can run without refilling: 400");
        System.out.println("Please enter the number of stops: 4");
        System.out.println("Output:  200 375 550 750 \n");
        //Worse Case would be if the values entered are not able to be calculated into the number of stops as shown in Test Case 2.
        System.out.println("-----Test Case 2-----");
        System.out.println("Please enter the distance between the cities: 1950");
        System.out.println("Please enter the max distance car can run without refilling: 400");
        System.out.println("Please enter the number of stops: 4");
        System.out.println("Output: -1 \n");

        Scanner input = new Scanner(System.in);
        //getting user input for the distance
        System.out.println("Please enter the distance between the cities");
        int d = input.nextInt();
        System.out.println("Please enter the max distance car can run without refilling");
        int m = input.nextInt();
        //getting user input for the stops
        System.out.println("Please enter the number of stops");
        int n = input.nextInt();
        //getting user input into a stop and optimal array to be stored for calculation
        int[] stop = new int[n+2];
        int[] optimal = new int[n+2];
        int last = 0;
        stop[0]=0;
        optimal[0]=-1;
        //getting user input for the distance
        System.out.println("Please enter the distance between the stops and home city");
/*
- The code starts by declaring a variable called stop.
- The code then declares an array of integers called stop, which is initialized to the value of input.nextInt().
 - The next line declares a variable called d and initializes it to 0.
 - This is done so that the loop will not run infinitely if there are no numbers in the input field.
 - Next, the code creates an integer array called optimal with length equal to n+1 (n being the number of items in input).
 - The first item in this array is set to -1 because we don't know what our best solution yet.
  - Then, for each iteration through the loop, we check whether or not there's a better solution than what was found before by comparing it against m (the maximum number of iterations allowed).
  - If there's one, then we update our index accordingly and move on to checking out another possible solution until either all solutions have been checked out or until we reach our last index whereupon we break from this infinite loop and return back up into main() again at line 8 with "optimal[optimal.length-1]=-1".
 */
        for (int i = 1; i <= n; i++) {
            stop[i] = input.nextInt();
        }
        stop[n+1]=d;
        int stopIndex=0;
        for (int i = 1; i < stop.length; i++) {
            if(stop[i]-stop[i-1]>m)
            {
                optimal[optimal.length-1]=-1;
                break;
            }
            int index=i-1;
            int optIndex=index;
            while(index>=0)
            {
                if(stop[i]-stop[index]<=m)
                {
                    if(optimal[optIndex]>=optimal[index])
                        optIndex=index;
                }
                else
                    break;
                index--;
            }
            optimal[i]=optimal[optIndex]+1;
        }
        System.out.println(optimal[optimal.length-1]);

    }
}
/*
- The code above in summary, is a simple algorithm that iterates through the list of integers, "stop", and calculates the optimal index for the next iteration.
- The code begins by declaring an array called "optimal" which will store all of the indices that are calculated in this algorithm.
- The first line declares an integer variable called "optimal.length".
- This variable will be used to calculate how many indices are stored in the array "optimal".
 - The second line declares a variable called "stopIndex" which will be used to keep track of where we are in our loop.
  - The third line starts our loop by declaring a variable called "i" which will be used to keep track of where we are in our loop. */


