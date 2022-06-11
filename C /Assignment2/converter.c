//Name: Grace Gong
//Name of program is converter.c
//Purpose of program: A converter that converts Kilometer and Mile, Meter and Feet, Centimetre and Inch, and Celsius and Fahrenheit

//stdio. h is a header file which has the necessary information to include the input/output related functions in our program
#include <stdio.h>
//Int main(void) is used in C to restrict the function to take any arguments
int main(void)
/* The converter will start by prompting the user to enter numbers between 1-5, each number corresponding to a different conversion and measure */
{
    int ch;
    printf("Converter");
do{
    printf("\n• 1 for conversion between Kilometer and Mile");
    printf("\n• 2 for conversion between Meter and Feet");
    printf("\n• 3 for conversion between Centimetre and Inch");
    printf("\n• 4 for conversion between Celsius and Fahrenheit");
    printf("\n• 5 for quit(In case of 5, the program will terminate.");
    printf("\nEnter your choice: ");
    scanf("%d",&ch);
//the switch statement is a way to enable us to execute one code block among many alternatives.
//The expression is evaluated once and compared with the values of each case label.
    switch(ch)
//Case one involves the conversion from Kilometer to Mile and vice versa
{
    case 1:
//The output describes what the conversion is for in this particular case after the user inputted one of the matching numbers
    printf("• K for conversion from Kilometer to Mile • M for conversion from Mile to Kilometer: ");
    char convertKiloMile;
    //getting user input to decide if they want to convert from kilometer to mile
    scanf(" %c",&convertKiloMile);
    //if statement for if the user inputs 'K'
    if(convertKiloMile == 'K')
{
    //following the if statement, the prompt will ask user to enter the value they want to convert
    //this first one is for km to miles
    float kilo;
    //asking user for the input of the value they want to convert
    printf("Please provide Kilometer value which you want to convert to mile: ");
    //getting user input to convert from km to miles
    scanf("%f",&kilo);
    float kMile = kilo * 0.62137119 ;
    //print statement that will correctly output the conversion
    printf("%0.2f Kilometer is equal to %0.2f mile.\n\n",kilo,kMile);
}   //if statement for if the user inputs 'M'
    else if(convertKiloMile =='M')
{
    //this one is for miles to km
    float mile;
    //asking user for the input of the value they want to convert
    printf("Please provide mile value which you want to convert to Kilometer: ");
    //getting user input to decide if they want to convert from miles to kilometers
    scanf("%f",&mile);
    //the calculation for what a mile is equivalent to in km
    float mKilo = mile * 1.60934;
    //print statement that will correctly output the conversion
    printf("%0.2f Mile is equal to %0.2f Kilometer.\n\n",mile,mKilo);
}
    else
{
    printf("Invalid input");
}
//if the input is invalid, it will break, meaning it will terminate the loop
break;
//Case two involves the conversion from Meter to Feet and vice versa
case 2:
//The output describes what the conversion is for in this particular case after the user inputted one of the matching numbers
    printf("• M for conversion from Meter to Feet • F for conversion from Feet to Meter: ");
    char convertMeterFeet;
    //getting user input to decide if they want to convert from meters to feet
    scanf(" %c",&convertMeterFeet);

    if(convertMeterFeet=='M')
{
float meter;
    //asking user for the input of the value they want to convert
    printf("Please provide meter value which you want to convert to feet: ");
    scanf("%f",&meter);
    //the calculation for what a meter is equivalent to in feet
    float mFeet = meter * 3.2808399 ;
    //print statement that will correctly output the conversion
    printf("%0.2f Meter is equal to %0.2f Feet.\n\n",meter,mFeet);
}
    else if(convertMeterFeet=='F')
{
    float feet;
    //asking user for the input of the value they want to convert
    printf("Please provide feet value which you want to convert to meter: ");
    //getting user input to decide if they want to convert from feet to meter
    scanf("%f",&feet);
    //the calculation for what a feet is equivalent to in meter
    float fMeter = feet * 0.3048;
    //print statement that will correctly output the conversion
    printf("%0.2f feet is equal to %0.2f meter.\n\n",feet,fMeter);
}
else
{
printf("Invalid input");
}
//if the input is invalid, it will break, meaning it will terminate the loop
break;

case 3:
//The output describes what the conversion is for in this particular case after the user inputted one of the matching numbers
    printf("•C for conversion from Centimetre to Inch • I for conversion from Inch to Centimetre: ");
    char convertCentimetreInch;
    scanf(" %c",&convertCentimetreInch);
    if(convertCentimetreInch=='C')
{
    float centi;
    //asking user for the input of the value they want to convert
    printf("Please provide feet value which you want to convert to inches: ");
    scanf("%f",&centi);
    //the calculation for what a centimeter is equivalent to in inches
    float cInch = centi * 0.393701;
    //print statement that will correctly output the conversion
    printf("%0.2f centimeter is equal to %0.2f inches.\n\n",centi,cInch);
}
    else if(convertCentimetreInch=='I')
{
    float inch;
    //asking user for the input of the value they want to convert
    printf("Please provide inch value which you want to convert to centimeter: ");
    scanf("%f",&inch);
    //the calculation for what an inch is equivalent to in centimeters
    float iCenti = inch * 2.54;
    //print statement that will correctly output the conversion
    printf("%0.2f inch is equal to %0.2f centimeter.\n\n",inch,iCenti);
}
    else
{
printf("Invalid input");
}
//if the input is invalid, it will break, meaning it will terminate the loop
break;

case 4:
//The output describes what the conversion is for in this particular case after the user inputted one of the matching numbers
    printf("• C for conversion from Celsius to Fahrenheit • F for conversion from Fahrenheit to Celsius: ");
    char cCF;
    scanf(" %c",&cCF);
    if(cCF=='C')
{
    float cel;
    float cFar;
    //asking user for the input of the value they want to convert
    printf("Please provide Celsius value which you want to convert to Fahrenheit: ");
    scanf("%f",&cel);
    //the calculation for what 1 Celsius is equivalent to in Fahrenheit
    cFar = ((cel * 9.0) /(5.0)) + 32;
    //print statement that will correctly output the conversion
    printf("%0.2f Celsius is equal to %0.2f Fahrenheit.\n\n",cel,cFar);
}
    //if the user enters F
    else if(cCF=='F')
{
    float far;
    //asking user for the input of the value they want to convert
    printf("Please provide Fahrenheit value which you want to convert to Celsius: ");
    scanf("%f",&far);
    //the calculation for what 1 Fahrenheit is equivalent to in Celsius
    float fCel = ((far - 32) * 5.0)/(9.0);
    //print statement that will correctly output the conversion
    printf("%0.2f Farenheit is equal to %0.2f Celsius.\n\n",far,fCel);
}
else
{
    printf("Invalid input");
}
//if the input is invalid, it will break, meaning it will terminate the loop
break;

//case 5 is for quitting so it will simply break
case 5:

//Break Statement is a loop control statement that is used to terminate the loop
break;

}
}

while(ch!=5);
    return 0;
}
