import java.util.Arrays;

public class Polynomial implements Comparable<Polynomial> 
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
    
    public long evaluate(int x)
    {
        int prod = 1;
        int sum = 0;
        for(int i = 0; i < coeff.length; i++){
            
            for(int j = 0; j<i; j++){
                prod*=x;
            }
            sum += coeff[i]*prod;
            prod = 1;
        }
        return sum;
    }

    public Polynomial add(Polynomial other) 
    {
        int[] x = {0};

        if(other.coeff.length == 1 && other.coeff[0] == 0){
            return new Polynomial(coeff);
        }
        else if(coeff.length == 1 && coeff[0] == 0){
            return new Polynomial(other.coeff);
        }
        else if(other.coeff.length > coeff.length){
            x = new int[other.coeff.length];
            x = adder(other.coeff, coeff);
        }
        else if(other.coeff.length < coeff.length){
            x = new int[coeff.length];
            x = adder(coeff, other.coeff);
        }
        else{
            x = new int[coeff.length];
            x = adder(coeff, other.coeff);
        }

        return new Polynomial(x); 
    }

    public int[] adder(int[] bigger, int[] smaller){
        int[] x = new int[bigger.length];
        for(int i = 0; i < smaller.length; i++){
            x[i] = smaller[i] + bigger[i];
        }
        for(int i = smaller.length; i < bigger.length; i++){
            x[i] = bigger[i];
        }
        return x;
    }
    @Override 
    public String toString()    
    {
        String poly = "";
        for(int i = coeff.length-1; i > -1; i--){
            
            if(coeff[i] == 0 && coeff.length == 1 || coeff[i] > 0 && coeff.length == 1){
                return poly += coeff[i];
            }
            else if(coeff[i] == 0){
                continue;
            }
            else if(coeff[i] < 0 && coeff.length == 1){
                return poly += "-" + coeff[i]*-1; 
            }
            if(i == coeff.length-1 && coeff[i] < 0){
                poly+= "-" + coeff[i]*-1 + "x^" + i + " "; 
            }
            else if (i == coeff.length-1 && coeff[i] > 0){
                poly+= coeff[i] + "x^" + i + " ";
            }
            else if(i == 0 && coeff[i] < 0){
                poly += "- " + coeff[i]*-1;
            }
            else if(i == 0 && coeff[i] > 0){
                poly += "+ " + coeff[i];
            }
            else if(i == 1 && coeff[i] < 0){
                poly += "- " + coeff[i]*-1 + "x ";
            }
            else if(i == 1 && coeff[i] > 0){
                poly += "+ " + coeff[i] + "x ";
            }
            else if(coeff[i] < 0){
                poly += "- " + coeff[i]*-1  + "x^" + i + " "; 
            }
            else if(coeff[i] > 0){
                poly += "+ " + coeff[i] + "x^" + i + " ";
            }
        }
        return poly;
    }
    
    public Polynomial multiply(Polynomial other) 
    {
        if(other.coeff.length == 1 && other.coeff[0] == 0){
            return new Polynomial(coeff);
        }
        else if(coeff.length == 1 && coeff[0] == 0){
            return new Polynomial(other.coeff);
        }

        int[] product = new int[coeff.length + other.coeff.length];
        if(coeff.length > other.coeff.length){
            product = mult(coeff, other.coeff);
        }
        else if(coeff.length < other.coeff.length){
            product = mult(other.coeff, coeff);
        }
        else if (coeff.length == other.coeff.length){
            product = mult(coeff, other.coeff);
        }
        return new Polynomial(product); // Modify this
    }
    public int[] mult(int[] bigger, int[] smaller){
        int[] product = new int[bigger.length + smaller.length];
        int larger = bigger.length;
        int small = smaller.length;

        for(int i = 0; i < larger; i++){
            for(int j = 0; j < small; j++){
                product[j+i] += bigger[i] * smaller[j]; 
            }
        }

        return product;
    }
    @Override public boolean equals(Object other) 
    {
        if (!(other instanceof Polynomial)){
            return false;
        }
        Polynomial p = (Polynomial) other;
        
        if(p.coeff.length != coeff.length){
            return false;
        }

        for(int i = coeff.length - 1; i > -1; i--){
            if(p.getCoefficient(i) != this.getCoefficient(i)){
                return false;
            }
        }
        return true;
    }

    public int compareTo(Polynomial other) 
    {
      
        if(this.getDegree() > other.getDegree()){
            return 1;
        }
        else if (this.getDegree() < other.getDegree()){
            return -1;
        }
        else{
            for(int i = coeff.length-1; i > -1;i--){
                if(this.getCoefficient(i) > other.getCoefficient(i)){
                    return 1;
                }
                else if(this.getCoefficient(i) < other.getCoefficient(i)){
                    return -1;
                }
            }
        }
        return 0;
    }
}