/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class RepeatChecker implements Checker
{

    final int seqLength;
    final int repeatNumber;
    final int position;    
    boolean fail;// (boolean) - holds whether the processed sequence so far could not be palindrome
    String patternSoFar;// (String) - holds the accumulated chars so far given to this checker
    QueueADT<Character> previous;// (StackADT<Character>

    /*
     public RepeatChecker(int seqLength, int repeatNumber)
     nitializes all instance variables: seqLength as specified, repeatNumber as specified, position as 0, fail as false, patternSoFar as “”, and previous as an empty queue
     */
    public RepeatChecker(int seqLength, int repeatNumber)
    {
        this.seqLength = seqLength;
        this.repeatNumber = repeatNumber;
        this.position = 0;
        previous=new LinkedQueue<Character>();
        patternSoFar="";
    }

    /*private RepeatChecker(int seqLength, int repeatNumber, int position)
     Same as above but position is specified. This constructor is only used in the cloneHere method.
     */
    
    private RepeatChecker(int seqLength, int repeatNumber, int position)
    {
        this.seqLength = seqLength;
        this.repeatNumber = repeatNumber;
        this.position = position;
        previous=new LinkedQueue<Character>();
        patternSoFar="";
    }

    /*public boolean process(char c)
    For the first seqLength of the characters, add them to the queue.
    After that see if they match the expected characters in the queue, if not, set the instance variable, fail, to true. (
    hint: after a character is matched dequeue and then enqueue)
    Return true if current length of the patternSoFar is the seqLength times repeatNumber and fail is false (meaning:
    it found the sought after pattern), otherwise return false.
     */
    public boolean process(char c)
    {
        if (fail)
            return false;
        patternSoFar+=c;        
        if(patternSoFar.length()-1<seqLength)
        {
            previous.enqueue(c);
        }
        else
        {
            if(previous.first()!=c)
            {
                fail=true;
                patternSoFar="";
            }
            previous.enqueue(previous.dequeue());
        }              
        return patternSoFar.length()==seqLength*repeatNumber;
    }
    /*public boolean finished()
    Return fail
     */

    public boolean finished()
    {
        return fail;
    }
    /*public Checker cloneHere(int pos)
     Return a new RepeatChecker with pos
     */

    public Checker cloneHere(int pos)
    {
        RepeatChecker result=new RepeatChecker(seqLength,  repeatNumber,pos);
        
        result.patternSoFar="";
        return result;
    }
    /*public String toString()
     Return a String representation of this checker see DnaTest.java for details
     e.g. Repeat 5,2  - 37{GCCATGCCAT}
     */

    public String toString()
    {
        return "Repeat("+seqLength+","+repeatNumber+") - "+position+"{"+patternSoFar+"}";
    }
}
