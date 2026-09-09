import java.util.ArrayList;

public class AccessCountArrayList<E> extends ArrayList<E> 
{

    /* This subclass should maintain one data field int count to keep 
     * track of how many times the methods get and set have been called. 
     * One counter keeps the simultaneous count for both of these methods 
     * together. You should override the inherited get and set methods so 
     * that both of these methods first increment the access counter, and 
     * only then call the superclass version of that same method, 
     * returning whatever result that superclass version returned. 
     * 
     * In addition to these overridden methods inherited from the superclass, 
     * your class should define the two new methods seen below: getAccessCount()
     * and resetCount(). 
    */
    private int counter =0;
    @Override
    public E get(int idx) 
    {
        counter++;
        
        return super.get(idx);
    }
    
    @Override
    public E set(int idx, E value) 
    {
       counter++;
        
       return super.set(idx, value);
    }
    
    public int getAccessCount() 
    {
        

        return counter;
    }

    public void resetCount()
    {
        counter = 0;

    } 

}
