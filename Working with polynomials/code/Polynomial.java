import java.util.Arrays;

public class Polynomial 
{

    private final int[] coeff;
    public Polynomial(int[] coefficients) 
    {   
        int index = coefficients.length-1;
        int counter = 0;
        if(coefficients[coefficients.length-1] == 0){  
            while(coefficients[index] == 0 && index != 0){
                counter++;
                index--;
            }
            
        }
        if(counter == coefficients.length){
            index = 0;
        }
        coeff = Arrays.copyOf(coefficients, index+1); // Modify this
    }
    
    public int getDegree() 
    {
        return coeff.length-1; // Modify this
    }
    
    public int getCoefficient(int k) 
    {
       if(k > coeff.length-1 || k < 0){
        return 0;
       }
       else{
        return coeff[k]; // Modify this
       }
    }
    
}