import java.util.*;

/* 
 * SpySet<E> should be a child class of HashSet<E>.
 * SpySet keeps track of the number of times we attempt
 * to add a duplicate value. If we attempt to add a 
 * duplicate value N times, remove all elements from 
 * the SpySet.
 * 
 * The value of N should be obtained as an argument to
 * the constructor.  
 * 
 * Note the type of the SpySet, and the HashSet it 
 * extends, is E. This is what is called a generic type,
 * and can be thought of as a stand-in for any object
 * type in Java. 
 * 
 * For example, if we create a SpySet of Strings, then
 * in the code below, every occurrence of E would refer to
 * a String. 
 */


public class SpySet<E> extends HashSet<E>
{
    /*
     * Declare instance variables as needed. They should be private.
     */ 
    private int count = 0;
    private int n = 0;
    
    /* 
     * Write a constructor for SpySet that has an int parameter.
     * The argument passed into the SpySet constructor is the
     * number of times we can attempt to add a duplicate before
     * the SpySet is cleared.
     */
    public SpySet(int N) 
    {  
        n = N;
    }

    /* 
     * Override the add method inherited from HashSet. 
     * This method adds an element to the set. It returns
     * true if the element was not already present, and
     * false if it was.
     * 
     * If the number of duplicate adds reaches the limit,
     * clear the SpySet and reset the duplicate count to 0
     */
    @Override 
    public boolean add(E elem)
    {
        if(super.add(elem) == false){
            count++;
            if(n == count){
                clear();
            }
            return false;
        }
        else{
            return true;
        }

    

         // modify this
    }

    /*
     * Override the clear() method inherited from HashSet.
     * The clear method should clear the set as usual, but
     * also reset the duplicate count to zero. 
     */
    @Override 
    public void clear()
    {
        
        super.clear();
        count = 0;
    }

    /* 
     * This method returns the current duplicate count
     */
    public int getDuplicateCount ()
    {

        return count; // modify this
    }

    /* 
     * This method returns the duplicate limit
     */
    public int getDuplicateLimit ()
    {
        
        return n; // modify this    
    }

}

