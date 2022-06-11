//Name: Grace Gong

//Description: designing and implementing a database of all sporting events which will be used throughout the Olympics.

//stdio. h is a header file which has the necessary information to include the input/output related functions in our program.
#include<stdio.h>
//The stdlib.h header defines four variable types, several macros, and various functions for performing general functions.
#include<stdlib.h>
//To accomplish this task, each sporting event will be stored as a structure

struct event
{
    int code;
    char name[50];
    int count;
    char gender;
}
//Program will then use an array of structures to represent up to 100 possible events.

event[100];
//The eventCode below is a function that takes in an event number and returns the corresponding information.
int check(int code,int eventnum)
//The eventCode is entered by the user, so it needs to be checked for validity before proceeding with anything else.
    //Each event eventCode must be unique. Only integers 0-99 are acceptable
    //Athlete/Team/Competitor count (eg. 10, 11, 12, 13, 14, etc.)
    //Only integers 10-99 are acceptable
{
    int i;
    if(code<0||code>99)
    {
        printf("Invalid code entered.\n");
        return 0;
    }
    while( i<=eventnum)
    {
        if(event[i].code==code)
        {
            printf("Event with code %d already exist\n",code);
            return 0;
        }
        i++;
    }

}
//If the number is less than 10 or greater than 99, tell the user the error and return to the beginning
int checkcount(int count)
{
    if(count<10||count>99)
    {
        printf("Invalid number of player\n");
        return 0;
    }
}
//The code attempts to check if the gender entered by the user is valid.
//Gender (eg. "Men's", "Women's", and "Mixed" represented in your database as 'M', 'W', and 'X' respectively)
//Only the characters M, W, and X are acceptable
int checkgender(char gender)
{
     //If statement that ensures only 'M', 'W', and 'X' are inputted

    if(gender!='M'&&gender=='F'&&gender=='X')
    {
         //if 'M', 'W', and 'X' are not inputted, then there will be the invalid gender message
        printf("Invalid gender\n");
        return 0;
    }
}

void clear()
{
    while (getchar() != '\n');
}

int inputString(char output[], int n) {

    int i = 0;
    char input;
    scanf("\n%c", &input);
    while (input != '\n') {
        if (i < n) {
            output[i++] = input;
        }
        scanf("%c", &input);
    }
    output[i] = '\0';
    return i;

}

int main()

{

    int eventnum=-1;
    char choice;
    int code,count,i,flag;
    char gender;
    //The Logo / Header
    printf("*************************\n");
    printf("* 2211 Winter Olympics! *\n");
    printf("*************************\n");
    while(1)
    {
        printf("Enter operation code:");
        scanf("%c",&choice);
        clear();
 //The switch statement checks the inputted character
        //Your program should continuously prompt the user for one of five possible commands: i, s, u, p, q,
        //switch statement is an alternate to if-else-if ladder statement which allows us to execute multiple operations for the different possibles values of a single variable called switch variable.
        switch(choice)
        {
             //Insert a new event (using command i)
            case 'i':

                if(eventnum==99)
                {
                    printf("Input limit reached\n");
                    break;
                }
                printf("Enter the event code:");
                scanf("%d",&code);
                clear();
                if(!check(code,eventnum+1))
                    break;

 //Event name (eg. "Single's figure skating", "Pair skating", "Curling", "Ice hockey", etc.)
                //Only sports up to 50 characters in length are acceptable (including the null character - So think of this as 49+1)

                printf("Enter event name:");

                inputString(event[eventnum+1].name, 50);
                //clear();

 //Ensuring the number of competitors is valid by running through if statement and breaking if its not

                printf("Enter number of competitors:");
                scanf("%d",&count);
                clear();
                if(!checkcount(count))
                    break;


//Ensuring the gender is valid by running through if statement and breaking if its not
                printf("Enter the gender:");
                scanf("%c",&gender);
                clear();
                if(!checkgender(gender))
                    break;


                eventnum++;
                event[eventnum].code=code;
                event[eventnum].count=count;
                event[eventnum].gender=gender;
                break;
  //Search for an event in the database and print it out (using command s)
                //Prompt the user for the event code
            case 's':

                i=0;flag=0;
                printf("Enter event code:");
                scanf("%d",&code);
                clear();
                while(event[i].code!=code)
                {
                    i++;

                }
                  // if there are no events with that particular code, then it prints out "Event with code not found."
                if(event[i].code==code)
                    flag++;
                if(flag==0)
                {
                    printf("Event with code %d not found.\n",code);
                }
                printf("EVENT CODE\t\tEVENT NAME\t\t\tCOMPETITORS\t\tGENDER\n");
                printf("%6d\t%15s\t%18d\t\t%7c\n",event[i].code,event[i].name,event[i].count,event[i].gender);

                break;
 //Update an event in the database (using command u)
            case 'u':

                i=0;flag=0;
                printf("Enter event code:");
                scanf("%d",&code);
                clear();
                while(event[i].code!=code)
                {
                    i++;

                }
                if(event[i].code==code)
                    flag++;
                if(flag==0)
                {
                    printf("Event with code %d not found.\n",code);
                }
                printf("Enter event name:");

                inputString(event[eventnum+1].name, 50);
                //clear();
   //Prompt the user for the number of competitors in this event

                printf("Enter Number of competitors:");
                scanf("%d",&count);
                clear();

                if(!checkcount(count))
                    break;


                printf("Enter gender:");
                scanf("%c",&gender);
                clear();


                if(!checkgender(gender))
                    break;
                event[i].count=count;
                event[i].gender=gender;
                break;

 //Print the entire list of events (using command p)
                //Print out a table listing all the events in your database with all the attributes:
                //Event Code
                //Event Name
                //Competitors
                //Gender

            case 'p':
                i=0;
                printf("EVENT CODE\t\tEVENT NAME\t\t\tCOMPETITORS\t\tGENDER\n");
                while(i<=eventnum)
                {

                    printf("%6d\t%15s\t%18d\t\t%7c\n",event[i].code,event[i].name,event[i].count,event[i].gender);
                    i++;
                }
                break;

//Quit the program (using command q)
                //All data is lost when quitting the program. We do not need to maintain the data across multiple runs.
            case 'q':
                exit(0);

            default:
                printf("Invalid input!\n");
        }

    }
    return 0;
}

