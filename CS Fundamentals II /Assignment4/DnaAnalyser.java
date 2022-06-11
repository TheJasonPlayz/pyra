
import java.util.Iterator;

/**
 *
 * @author User
 */
class DnaAnalyser
{

    LinkedQueue<Checker> checkers;
    LinkedQueue<String> results;// (LinkedQueue<String>) - holds all the results for only the recently searched
                                //sequence 

    public DnaAnalyser(LinkedQueue<Checker> checkers)
    {
        this.checkers = checkers;
        results=new LinkedQueue<String>();
    }

    /*
     public DnaAnalyser(LinkedQueue<Checker> checkers)
     Initializes all instance variables: checkers as specified, results as an empty LinkedQueue<String>
     */

    /*public String search(Iterator<Character> dnaSequence)
     Returns a String of the entire dnaSequence searched
     fills the results queue with all of the patterns of the types in the checkers queue that were found.
     Below describes a detailed search algorithm
     */
    public String search(Iterator<Character> dnaSequence)
    {
        String result="";
        //Initialize a Queue for active checkers.
        LinkedQueue<Checker> activeCheckers=new LinkedQueue<Checker>();
        //Clear previous DnaAnalysers’ results
        results=new LinkedQueue<String>();
        //Loop through each character from the dnaSequence (keeping track of its position)
        int pos=1;
        while(dnaSequence.hasNext())
        {
            char c=dnaSequence.next();
            //Concatenate the character into a full String of the sequence
            result+=c;
            //Add a new checker to the active checkers for each of the DnaAnalysers’ checkers using
            LinkedQueue<Checker> tempCheckers=new LinkedQueue<Checker>();
            while(!checkers.isEmpty())
            {
                Checker checker=checkers.dequeue();
                activeCheckers.enqueue(checker.cloneHere(pos));
                tempCheckers.enqueue(checker);                
            }
            checkers=tempCheckers;
            tempCheckers=new LinkedQueue<Checker>();
            while(!activeCheckers.isEmpty())
            {
                Checker checker=activeCheckers.dequeue();
                if(checker.process(c))
                {
                    //If process(c) is successful add its toString() to the results
                    results.enqueue(checker.toString());   
                    //checkers.enqueue(checker);
                }
                else if(!checker.finished())
                {
                    tempCheckers.enqueue(checker);
                }
            }
            activeCheckers=tempCheckers;
            pos++;           
                    
        }
        return result;
    }
    /*public String printAnalysis(String dnaSequence)
     Prints out the results queue followed by a formatted dnaSequence string to visually confirm the results
     */

    public String displayAnalysis(String dnaSequence)
    {
        String result="";
        LinkedQueue<String> temp=new LinkedQueue<String>();
        while(!results.isEmpty())
        {
            String checker=results.dequeue();
            result+=checker+"\n"; 
            temp.enqueue(checker);
        }
        results=temp;
        result+="....*....1....*....2....*....3....*....4....*....5\n"; 
        int length="....*....1....*....2....*....3....*....4....*....5".length();
        int count=0;
        while(dnaSequence.length()>length)
        {
            result+=dnaSequence.substring(0,length)+" "+count+"\n"; 
            dnaSequence=dnaSequence.substring(length);            
            count+=length;
            
        }
        result+=dnaSequence; 
        return result;
    }
}
