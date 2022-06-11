
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/*
 *application that will assist the staff to extract the client information, update
 *clients record and delete it if necessary
 */
/**
 *
 * @author Grace Gong
 * Student number 251151854
 */

    //The code starts with a class definition for the Q2 class.
public class Q2

{
    Scanner input = new Scanner(System.in);
    final int SIZE = 97;

    LinkedList<Client>[] hashTable=new LinkedList[97];
//- It has two methods, addClient() and searchClient().
    // - The addClient() method adds new clients to the hash table by calling LinkedList[] hashTable[index] = new LinkedList(); and then adding last client in that list with new Client(name, amount).
    private void addClient()
    {
        //The addClient() method takes in an input string of "name" and "amount".
        System.out.println("Enter name: ");
        String name = input.next();
        System.out.println("Enter amount: ");
        double amount = input.nextDouble();
        //It then uses the hashCode() function to find out which index is associated with that name.
        int index = name.hashCode() % SIZE;
        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<Client>();
        }
        //If it finds one, it creates a new LinkedList<> object called hashTable[index] and adds last to it.
        //Otherwise, if there is no such index, it creates a new LinkedList<> object called hashTable[index].
        for (Client client : hashTable[index]) {
            if (client.getName().equals(name)) {
                System.out.println("Client already exists");
                return;
            }
        }
        hashTable[index].addLast(new Client(name, amount));
        System.out.println("Client was added");
    }
    //- The searchClient() method takes in an input string of "name" and prints out all the clients that are found by using the getName(), getAmount(), setAmount(), remove(), or delete().
    //- The searchClient() method searches for existing clients by converting name into an integer using nextInt().
    private void searchClient()
    {
        System.out.println("Enter name: ");
        //- It takes a string input from the user and converts it to an integer using nextInt() function.
        String name = input.next();
        //It creates an array of size 97, which is used as a hash table for storing linked lists of clients.
        int index = name.hashCode() % SIZE;
        if (hashTable[index] != null) {
            for (Client client : hashTable[index]) {
                if (client.getName().equals(name)) {
                    System.out.println(client);
                    System.out.println("Enter new amount: ");
                    double amount = input.nextDouble();
                    client.setAmount(amount);
                    System.out.println("Client " + client + " was updated");
                    return;
                }
            }
        }
        System.out.println("not found");
    }

    private void deleteClient()
    {
        System.out.println("Enter name: ");
        String name = input.next();
        int index = name.hashCode() % SIZE;
        if (hashTable[index] != null) {

            for (Client client : hashTable[index]) {
                if (client.getName().equals(name)) {
                    hashTable[index].remove(client);
                    System.out.println("Client " + client + " has deleted");
                    return;
                }
            }
        }
        System.out.println("Not found!");

    }

    class Client
    {

        String name;
        double amount;

        public Client(String name, double amount)
        {
            this.name = name;
            this.amount = amount;
        }

        public String getName()
        {
            return name;
        }

        public double getAmount()
        {
            return amount;
        }

        public void setAmount(double amount)
        {
            this.amount = amount;
        }

        @Override
        public String toString()
        {
            return "Client{" + "name=" + name + ", amount=" + amount + '}';
        }

    }
//The code starts with a menu() function.
//The code is used to input a menu for the user.

    public void menu()
    {
        int option;
        //Then, there is a do-while loop which will continue to run until an option is chosen from the menu.
        do {
            //The first line in this function prints out "Please input 1 to Add client."
            System.out.println("Please input 1 to Add client");
            System.out.println("Please input 2 to Search client");
            System.out.println("Please input 3 to Delete client");
            System.out.println("Please input 4 to Exit");
            /*When the program will execute then it will first show the numbers selected for each test case. This will be the guidance for a user
        regarding input. */
            //Test cases, the cases here are examples of the user input that can be given to achieve a certain task
            //The best case would be when the users information can be found / retained. Worst case would be if the user information is not available.
            //- The code is a simple example of how to output the test cases that are given.

            System.out.println("-----Test Case 1-----");
            System.out.println("Input: 1");
            System.out.println("Enter name: Grace");
            System.out.println("Enter amount: 1");
            System.out.println("Client was added");

            System.out.println("-----Test Case 2-----");
            System.out.println("Input: 1");
            System.out.println("Enter name: Grace");
            System.out.println("Enter amount: 1");
            System.out.println("Client was added");

            System.out.println("Input: 1");
            System.out.println("Enter name: Barbie");
            System.out.println("Enter amount: 120.3");
            System.out.println("Client was added");

            System.out.println("Input: 2");
            System.out.println("Enter name: Barbie");
            System.out.println("Client{name=Barbie, amount=120.3}");
            System.out.println("Enter new amount");
            System.out.println("---Test cases finished---\n");

            System.out.println("1. Add client");
            System.out.println("2. Search client");
            System.out.println("3. Delete Client");
            System.out.println("4. Exit");
            option = input.nextInt();
            switch (option) {
                case 1:
                    addClient();
                    break;
                case 2:
                    searchClient();
                    break;
                case 3:
                    deleteClient();
                    break;

            }
        } while (option != 4);
    }
//This is the main method of the class, and it contains all the methods that are called by this class.
    public static void main(String[] args)
    {
        Q2 q2 = new Q2();
        q2.menu();
    }
}
/*
     The code does the following:
      1. - Prompts for a name and amount to be added to the account -
      2. - Checks if the input is valid, and adds it to the account if so
      3. - Prints out a message that says "Client was added"
 */