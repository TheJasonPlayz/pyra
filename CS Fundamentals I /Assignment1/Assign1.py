#Grace Gong CS1026 10/7
#'Order' is where the variables for each possible food item are assigned with the price number, except for the combo orders which will be calculated from the individual items
#the items listed below correspond to the prices that were indicated in the assignment, but are shown without the $ sign for now. So Egg is $0.99, etc., all rounded to 2 decimal places
order = {
    "small breakfast": None,
    "regular breakfast": None,
    "big breakfast": None,
    "egg": 0.99,
    "bacon": 0.49,
    "sausage": 1.49,
    "hash brown": 1.19,
    "toast": 0.79,
    "coffee": 1.09,
    "tea": 0.89
}
#This is where the list will match the item with the associated price from the customer input
items = []
#this is the variable for their input
customer_input = ""

#the customer adds the items they want to put into the menu in their order, if the item is in the order options, it evaluates as valid/true, but if the item is not in the menu for order, then it will be false and show the error message associated wth it.
def customer_answer():
#the global keyword is used to modify variables or access them inside or outside of the function, which is important in this case since the order and items will be referenced.
    #glbal order is used to keep track of the various items that are avalable, and the prices match the items described.
    global order
	#glibal items is used to keep track of the items, including the combo items since the individual food items like egg, need to be added in/calculated later on.
    global items
	#global customer input is used to ensure the inut is actually valid, and this ensures that the calculations that happen later can run smoothly- also ensures that customer can exit if they entered a wrong key.
    global customer_input
    if customer_input in order :
        #statement that will be used to ensure the quantity entered is numeric.
        valid = False
        while not valid:
            try:
                quantity = int(input("Quantity: "))
                if quantity > 0:
                    valid = True
                else:
					#value error is used to indicate the error, and the message will be shown: print("Please enter a valid quantity.") This is important to ensure the quantity entered is numeric, and can be used for calculations.
                    raise ValueError
            except ValueError:
                print("Please enter a valid quantity.")
            except Exception as e:
                print("Something went wrong: " + str(e))
				#items.append is used to add the customer input into the list. This is important because the customers input needs to be saved so the total can be calculated with the input that was requested.
        for x in range(quantity):
            items.append(customer_input)
			#again, if the item is not correct then this is when the else statement will show up, below.
    else:
        print("Please enter a valid item.")
#as shown above, the if and else are used to evaluate if the quantity and the inputs from the customer are valid. Since the input has to be a valid number (such as greater than 0, since if its a negative number thats not possible) and the words have to be in the menu, this is used.

#the subtotal is calculated from the addition of the various items that constitute and form the combo. since the combos are made of the other items like the eggs, etc., we have to add those items into the list to associate the correct values for each combo.
def find_subtotal():
    global order
    global items
    #the subtotal is first started with 0, but will be calculated later below.
    subtotal = 0.00
    for item in items:
        item_total = 0.00
		#the items below are added corresponding to the combos. So for small breakfast since there are 1 egg, 1 hash brown, 2 slices of toast, 2 bacon and 1 sausage, the numbers correspond to that order and item list order.
        if item == "small breakfast":
            item_total = add_combo(1, 1, 2, 2, 1)
			#same thing here, the regular breakfast corresponds to the order. The specific quantities are inputted in the parentheses, in the order of food items listed above.
        elif item == "regular breakfast":
            item_total = add_combo(2, 1, 2, 4, 2)
			#same here, the big breakfast corresponds to the order. The specific quantities are inputted in the parentheses, in the order of food items listed above.
        elif item == "big breakfast":
            item_total = add_combo(3, 2, 4, 6, 3)
        #the else statement is done at the end once the combos are chosen, to calculate the total of the combo item
        else:
			#here the items are added to the item and formated with the price.
            item_total = order [item]
        print(item + ": " + '${:,.2f}'.format(item_total))
        subtotal += item_total
    return subtotal
#As shown above, in the lists the items are added corresponding to the quantities of the food items and are listed in the same order as the words listed at the top, starting with egg.
#The add_combo below is used with adding the totals together and starts with 0, but then gets to the total once the items are added. The words are associated with the variables for each combo item. For example. "egg" corresponds with the egg variable.
def add_combo(eggs, hash_browns, toast, bacon, sausages):
    combo_items = 0.00
    combo_items += order ["egg"] * eggs
    combo_items += order ["hash brown"] * hash_browns
    combo_items += order ["toast"] * toast
    combo_items += order ["bacon"] * bacon
    combo_items += order ["sausage"] * sausages
    return combo_items

#This is the code for the text that will be used to find the menu items, since some of it may be entered with lower or upper ase, this is used to ensure the words are all standardized and in one format (upper case is formatted into the correct case, or likewise for lowercase, all the words and spacing becomes standardized with the code) Spacing is also considered so the words are read correctly.
def format_input(text):
    text = text.lower().strip()
    words = text.split()
    text = " ".join(words)
    return text

#this is used to get the customers direct input and the print function shows the customer the options and asks them to enter what they want for the order that instance. They can choose between many options.
while customer_input != "q":
    customer_input = format_input(input("Enter item (q to terminate): small breakfast, regular breakfast, big breakfast, " +
                                    "egg, bacon, sausage, hash brown, toast, coffee, tea: "))
    #this is used to get the customer input and ensure that while they are typing, the order can still be collected. However, once the order gets to q (when the customer types it) this tells the program that the customer is finished and is ready to move on to the next step, which is for purchasing: total, etc.,
    if customer_input != "q":
		#this function is called so the customer can see the answer for their order and see the summary of what they ordered before they see the total, and can serve as clarification for the total calculation.
        customer_answer()
    #the else function is used to signal to the program that when the customer types in q, the program can start computing the totals, for the tax and then finally move to the printing stage to display the final totals.
    else:
		#this is where the variables and the totals are displayed, below.
        subtotal = find_subtotal()
        tax = subtotal * 0.13
        total = subtotal + tax
        #the print statement references the variables subtotal, tax and total, which are included in the print statement so they can be displayed. Tax is 13% as per Canada guidelines.
        print("Cost: " + '${:,.2f}'.format(subtotal))
        print("Tax: " + '${:,.2f}'.format(tax))
        print("Total: " + '${:,.2f}'.format(total))
#the formatting is done to ensure the program computes the totals to 2 decimal places and the order is in Cost, Tax and Total as indicated for the calculations.
