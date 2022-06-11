
/**
 *
 * @author User
 */
public class PalindromeChecker implements Checker
{
    final int seqLength;
    int repeatNumber;
    int position;
    boolean fail;// (boolean) - holds whether the processed sequence so far could not be palindrome
    String patternSoFar;// (String) - holds the accumulated chars so far given to this checker
    StackADT<Character> previous;// (StackADT<Character>) -
    /*
     public PalindromeChecker(int seqLength)
     Initializes all instance variables: seqLength as specified, position as 0, fail as false, patternSofar as “”, and previous as an empty stack

     */

    public PalindromeChecker(int seqLength)
    {
        this.seqLength = seqLength;
        this.position = 0;
        previous=new ArrayStack<Character>() ;
        patternSoFar="";
        fail=false;
    }
    /*private PalindromeChecker(int seqLength, int position)
     Same as above but position is specified. This constructor is only used in the cloneHere method.
     */

    private PalindromeChecker(int seqLength, int position)
    {
        this.seqLength = seqLength;
        this.position = position;
        previous=new ArrayStack<Character>();
        fail=false;
    }
    /*public boolean process(char c)
     If the palindrome has an even length
     For the first half of the characters, add them to the stack.
     For the second half of the characters, see if they match the expected characters on the stack,
    if not, set the instance variable, fail, to true.
     If the palindrome has an odd length do the same as the even except skip over the middle character in terms of the stack
     Return true if current length of the patternSoFar is the seqLength and fail is false (meaning: it found
     a palindrome of the sought after length), otherwise return false.
     */

    public boolean process(char c)
    {
        patternSoFar+=c;
        if(fail)
            return false;
        if(seqLength%2==0)
        {        
            if(patternSoFar.length()-1<seqLength/2)
                previous.push(c);
            else
            {
                if(previous.peek()!=c)
                {
                    fail=true;
                    patternSoFar="";                    
                }                
                previous.pop();
            }   
        }
        else
        {
            if(patternSoFar.length()-1<seqLength/2)
                previous.push(c);           
            else if(patternSoFar.length()-1>seqLength/2)                
            {
                if(previous.peek()!=c)
                {
                    fail=true;
                    patternSoFar="";
                }                
                previous.pop();
            }   
        }        
        return patternSoFar.length()==seqLength ;
    }
    /*public boolean finished()
     Return fail
     */

    public boolean finished()
    {
        return  fail;
    }
    /*public Checker cloneHere(int pos)
     Return a new PalindromeChecker with pos
     */

    public Checker cloneHere(int pos)
    {
        PalindromeChecker result=new PalindromeChecker(seqLength,pos);
        result.patternSoFar="";
        /*ArrayStack<Character> temp=new ArrayStack<Character>();
        while(!previous.isEmpty())
        {
            result.previous.push(previous.peek());
            temp.push(previous.pop());            
        }
        previous=temp;        */
        return result;
    }
    /*public String toString()
     Return a String representation of this checker see DnaTest.java for details

     */

    public String toString()
    {
        
        return "Palindrome("+seqLength+") - "+position+"{"+patternSoFar+"}";
    }

}
