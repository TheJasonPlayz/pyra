//Name: Grace Gong
//Student Number: 251151854
//Name of program is intToEnglish.c
//Purpose of program: A program that enables the user to convert a number word into the worded version of the word with values up to 999

//The stdlib.h header defines four variable types, several macros, and various functions for performing general functions.
#include<stdlib.h>
//stdio. h is a header file which has the necessary information to include the input/output related functions in our program
#include<stdio.h>
//Int main(void) is used in C to restrict the function to take any arguments
int main(void){
    long number, div, n1;
    int flag, digit, position, tot_dig;
//Prompts user to enter a number in the numeric
    printf("\nEnter a number: ");
    //getting user input, The %ld format specifier is implemented for representing long integer values. This is implemented with printf() function for printing the long integer value stored in the variable.
    //& means the address-of, you will see that in placeholders for functions to modify the parameter variable as in C, parameter variables are passed by value, using the ampersand means to pass by reference.
    //In this case, for the variable number
    scanf("%ld", &number);

    //if number is equal to 0
    if(number == 0) {
    //print "Zero"
        printf("Zero\n");
    //exit
        exit(0);
    }

    if(number == 1) {
        printf("One\n");
        //exit
        exit(0);
    }

    if(number == 2) {
        //print "Two"
        printf("Two\n");
        //exit
        exit(0);
    }

    if(number == 3) {
        //print "Zero"
        printf("Three\n");
        //exit
        exit(0);
    }

    if(number == 4) {
        //print "Zero"
        printf("Four\n");
        //exit
        exit(0);
    }

    if(number == 5) {
        //print "Zero"
        printf("Five\n");
        //exit
        exit(0);
    }

    if(number == 6) {
        printf("Six\n");
        //exit
        exit(0);
    }

    if(number == 7) {
        printf("Seven\n");
        //exit
        exit(0);
    }

    if(number == 8) {
        printf("Eight\n");
        //exit
        exit(0);
    }

    if(number == 9) {
        printf("Nine\n");
        //exit
        exit(0);
    }
    //if number is greater than 999 remind them to only do up to 999
    if(number > 99999) {
        printf("please enter a number between 0 and 100000\n\n");
        exit(0);
    }
/*
 * The code is meant to calculate the number of digits in a given number.
 * The line of code div=1 declares an integer variable called div that will hold the value 1.
 * The next line creates a variable called n1 which will hold the value 9.
 * The while loop is meant to run until n1 becomes less than or equal to 10, and then it will divide by 10 and increment tot_dig by one.
 */

//tot_dig which keeps track of how many digits there are in total so far
    tot_dig = 0;
    //div which is our divisor (the number we divide by)
    div = 1;
    //n1 which is our result after dividing by divisor
    n1 = number;

    while ( n1 > 9 ) {
        n1 = n1 / 10;
        div = div * 10;

        tot_dig++;
    }


    tot_dig++;
    position = tot_dig;

    /* -Checking if the digits between 20-90 are given by user and if so, will be output in word format
     * -The code starts by declaring a variable called number.
     * - This is the number that will be divided by 10 to get each digit of the answer.
     * - The code then starts an infinite loop, which will continue until the user presses enter or until it reaches 0.
     * - In this loop, we use a variable called digit to store each digit of the answer in order from left to right as they are calculated.
     * - In every iteration of this loop, we calculate how many times div has been divided into number and then update our variables accordinglY
       - The code is a loop that prints out the numbers in increments of 10's (twenty to ninety)
     * */
    while ( number != 0 ) {
        digit = number / div;
        number = number % div;
        div = div / 10;
        switch(position) {
            case 2:
            case 5:
                if ( digit == 1 )
                    flag = 1;
                else {
                    flag = 0;
                    switch(digit) {
                        case 2: printf("twenty ");
                            break;
                        case 3: printf("thirty ");
                            break;
                        case 4: printf("forty ");
                            break;
                        case 5: printf("fifty ");
                            break;
                        case 6: printf("sixty ");
                            break;
                        case 7: printf("seventy ");
                            break;
                        case 8: printf("eighty ");
                            break;
                        case 9: printf("ninty ");
                    }
                }
                break;
/*
 *  Checking if the digits between 10-19 are given by user and if so, will be output in word format
 *  The code block below attempts to print out the words ten to nineteen.
 *  - The code starts by checking if the flag variable is equal to 1, which would mean that the user has entered a number in the input box and should be printed out.
 *  - If this is true, then the program will set flag to 0 and switch on digit.
 *  - The first case of digit being 0 will print "ten" and break from there. Repeats with other numbers
 *  -This also repeats again with the numbers between one to nine
 * */
            case 1:
            case 4:
                if (flag == 1) {
                    flag = 0;
                    switch(digit) {
                        case 0 : printf("ten ");
                            break;
                        case 1 : printf("eleven ");
                            break;
                        case 2 : printf("twelve ");
                            break;
                        case 3 : printf("thirteen ");
                            break;
                        case 4 : printf("fourteen ");
                            break;
                        case 5 : printf("fifteen ");
                            break;
                        case 6 : printf("sixteen ");
                            break;
                        case 7 : printf("seventeen ");
                            break;
                        case 8 : printf("eighteen ");
                            break;
                        case 9 : printf("nineteen ");
                    }
                }
                /**
                 * Checking if the digits between 1-9 are given by user and if so, will be output in word format
                 */
                else {
                    switch(digit) {
                        case 1 : printf("one ");
                            break;
                        case 2 : printf("two ");
                            break;
                        case 3 : printf("three ");
                            break;
                        case 4 : printf("four ");
                            break;
                        case 5 : printf("five ");
                            break;
                        case 6 : printf("six ");
                            break;
                        case 7 : printf("seven ");
                            break;
                        case 8 : printf("eight ");
                            break;
                        case 9 : printf("nine ");
                    }
                }
// if the number has 4 digits then it will have the word thousand (again this is not required but just in case its needed.)
                if (position == 4)
                    printf("thousand ");
                break;
//checking for if the digits 1-9 need to be output
            case 3:
                if (digit > 0) {
                    switch(digit) {
                        case 1 : printf("one ");
                            break;
                        case 2 : printf("two ");
                            break;
                        case 3 : printf("three ");
                            break;
                        case 4 : printf("four ");
                            break;
                        case 5 : printf("five ");
                            break;
                        case 6 : printf("six ");
                            break;
                        case 7 : printf("seven ");
                            break;
                        case 8 : printf("eight ");
                            break;
                        case 9 : printf("nine ");
                    }
                    printf("hundred ");
                }
                break;
        }
        position--;
    }
//for the number ten to be output in word format
    if (position == 4 && flag == 0)
        printf("thousand");
    else if (position == 4 && flag == 1)
        printf("ten thousand");

    if (position == 1 && flag == 1)
        printf("ten ");
}
