//Grace Gong
//251151854
#include <stdio.h>
//main function
int main(){
    //variables
    int i,sum,max,min,avg,length,j,tmp, temp;
//prompt user to enter length
    printf("Enter array length : \n");
    //get user input
    scanf("%d",&length);
    //initialize array index
    int a[length];
    //get user input for the integers in the array
    printf("Please enter your integers separated by spaces:\n");
    for(i = 0; i < length;  i++){
        scanf("%d", &a[i]);
    }
    //setting the variables sum max abd min with 0
    sum=0;
    max=a[0];
    min=a[0];
    //iterating through array and getting the max and min variables
    for(i = 0; i < length; i++){
        sum+=a[i];
        if(a[i] > max){
            max = a[i];
        }
        if(a[i] < min){
            min = a[i];
        }
    }
    //computing average
    avg=sum/length;
    //part 1
    printf("\nPart 1:");
    printf("\nYour array is: ");
    //printing each element in the array
    for(i=0;i<length-1;i++)
    {
        printf("%d,",a[i]);
    }
    printf("%d",a[length-1]);

    //size_t n = sizeof(a)/sizeof(a[i]);
    //calculate size of array like number of numbers in it
    int size = sizeof(a)/sizeof(a[0]);
    //printf("\nYour array has",n, "elements");
    printf("\nYour array has %d elements.", size);
    //size_t size = sizeof(array);
    //printf("\nThe size of the array in bytes is:", sizeof(a));

    //calculate bytes
    int arraySize = sizeof(a);
    printf("\nThe size of the array is %d bytes.\n", arraySize);
    //part 2
    printf("\nPart 2:");
    //printing array in reverse
    printf("\nThe array in reverse is ");
    for(i=length-1;i>=0;i--){
        printf("%d ",a[i]);
    }
    //part 3
    printf("\n\nPart 3:");
    //getting the min value that was previously calculated at the top
    printf("\nThe smallest value in your array is: %d\n",min);
    //part 4
    printf("\nPart 4:");
    //getting the sum value that was previously calculated
    printf("\nThe sum of all values in your array is %d\n",sum);
    //part 5
    //declaring temp variables since these will enable us to switch the first and last element
    printf("\nPart 5:");
    temp = a[0];
    a[0] = a[size-1];
    a[size-1]=temp;
    //output the array with elements switched
    printf("\nYour array with first and last element switched is: ");
    for(int i = 0; i < size; i++){
        printf("%d ",a[i]);
    }
    //part 6, array in sorted order from least to greatest
    printf("\n\nPart 6:");
    printf("\nYour array in sorted order is:");
    //iterating through array and each time the values will be stored in temp if they are greater and then eventually finish when j reaches the end
    for (i = 0; i < size; ++i)
    {
        for (j = i + 1; j < size; ++j)
        {
            if (a[i] > a[j])
            {
                tmp =  a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
    }

    for (i = 0; i < size; ++i)
        printf(" %d", a[i]);

    return 0;
}
