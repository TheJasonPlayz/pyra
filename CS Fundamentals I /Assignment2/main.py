#GraceGong
#Importing the volumes.py module for the functions to calculate area
from volumes import cube, pyr, ell
#the list that I will use to append my values of volumes and store it to be then sorted later
myList=[]
shape = (input("Please enter the shape (quit/q, cube/c, pyramid/p, ellipsoid/e): \n"))
#while statement for when the input is a valid number
shape=shape.lower()
while shape.lower() != "quit":
    #the shape variable gets the input of the measurements of each shape
    if shape.lower() == "cube" or shape.lower() == "c":
        side = float(input("Enter length of side for the cube:\n"))
        cubeVol=cube(side)
        print("The volume of a cube with side", side, "is:  %.2f"%cubeVol)
        #the values are then appended to the myList list
        myList.append(('cube', cubeVol))
#if the shape is a pyramid, the length and height are added by the user as input and then calculated with the pyrVol function and then stored into the list, myList
    elif shape.lower() == "pyramid" or shape.lower() == "p":
        length = float(input("Enter the base of the pyramid:\n"))
        height = float(input("Enter the height of the pyramid:\n"))
        pyrVol=pyr(length, height)
        print("The volume of a pyramid with base", length, "and height", height, "is:  %.2f"%pyrVol)
        myList.append(("pyramid", pyrVol))
#if the shape is an ellipsoid, the radius 1-3 are added by the user as input and then calculated with the ellVol function and then stored into the list, myList
    elif shape.lower() == "ellipsoid" or shape.lower() == "e":
        radius_1 = float(input("Enter the first radius:\n"))
        radius_2 = float(input("Enter the second radius:\n"))
        radius_3 = float(input("Enter the third radius:\n"))
        #the radius 1-3 are written inside the brackets so they can be recognized as the values that are multiplied in the volumes.py function
        ellVol = ell(radius_1, radius_2, radius_3)
        #statement describing the radius 1-3's volumes
        print("The volume of an ellipsoid with radii", radius_1,"and", radius_2,"and", radius_3, "is:  %.2f"%ellVol)
        #appending the ellipsoid volume to the list
        myList.append(("ellipsoid", ellVol))
        #if none of the options are valid ,the else statement executes and says the user has invalid input
        #if the shape inputs quit, the loop is done and it exits the inner loop and goes to read the outer loop statements.
    elif shape.lower() == "quit" or shape.lower() == "q":
        break
        #break statement will cause it to exit the inner loop and then if it has values in it they will be sorted.
    else:
        print("     -- invalid input: enter (quit/q, cube/c, pyramid/p, ellipsoid/e):")
#Above, the invalid input is used if the shape is not valid.
    shape=(input("Please enter the shape (quit/q, cube/c, pyramid/p, ellipsoid/e): \n"))
#if the quit function is entered before the other lengths are entered (so basically no valid dimensions are given) the output is given: 'Output: No shapes entered.'
if (shape.lower() == "quit" or shape.lower() == "q") and (len(myList)<=0):
    print('Output: No shapes entered.')
#if the quit function is entered after the other lengths are entered (so basically there are valid dimensions given) that means the values in the list are greater than 0 and the calculations are done
if (shape.lower() == "quit" or shape.lower() == "q") and (len(myList)>=1):
#the mylist.sort function is used to sort the lists and determine the order of the display
    myList.sort(key = lambda myList: float(myList[1]))
    print("Output: Volume of shapes entered in sorted order:")
    #loop is used to display the list items in the format from least to greatest and formatted to 2 decimal places, for every item in the list.
    for i in myList:
        print('{} {:.2f}'.format(i[0], i[1]))












