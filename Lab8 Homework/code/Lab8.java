import java.util.*;
import java.io.*;

public class Lab8
{
    /**
     * This method should return numerator/denominator as double.
     * That is, 1/2 should correctly return 0.5 rather than
     * truncating.
     * 
     * If the denominator is zero, throw an ArithmeticException.
     * 
     * If the numerator and denominator are both zero, throw
     * an UnsupportedOperationException.
     * 
     */
    public static double divideNumbers(int numerator, int denominator) 
    {
        if(denominator == 0 && numerator == 0){
            throw new UnsupportedOperationException();
        }
        else if(denominator == 0){
            throw new ArithmeticException();
        }
        return (double)numerator/denominator;
    }

    /**
     * This method converts a temperature from Celsius to Fahrenheit 
     * and validates the input.
     * 
     * If the String celciusTemp cannot be parsed as a number, you
     * should throw a NumberFormatException.
     * 
     * If celciusTemp is below absolute zero (-273.15°C), you should
     * throw an InvalidTemperatureException. Note that this does not 
     * exist, you should create it! Refer to the example in the slides 
     * for how this can be done.
     * 
     * The InvalidTemperatureException should be created as a static
     * nested class inside this Lab8 class.
     * 
     */

    public static double convertCelsiusToFahrenheit (String celsiusTemp)
    {
        double cel;
        try{
            cel = Double.parseDouble(celsiusTemp);
            if (cel < -273.15) {
                throw new InvalidTemperatureException("Temp is below max");
            }
            double faren = cel * 9/5 + 32;
            return faren;
        }
        catch(NumberFormatException e){
            throw new NumberFormatException();
        }
        catch(NullPointerException e){
            throw new NumberFormatException();
        }
        
       
    }

    public static class InvalidTemperatureException extends RuntimeException{
        public InvalidTemperatureException(String s) {
            super(s);
        }
    }
    /**
     * This method should open the plain text file named fname_in and 
     * return, as a String, lines first to last, inclusive.
     * 
     * If first or last are negative, or if last is less than first,
     * throw a Negative­Array­Size­Exception
     * 
     * If first is larger than the number of lines in the file, 
     * throw an Index­Out­Of­Bounds­Exception
     * 
     * if last is larger than the number of lines in the file, then
     * return a string containing lines first to the end of the file.
     * 
     * You may assume that fname_in is a file that exists.
     */
    public static String file_slice(String fname_in, int first, int last) 
    {
        try{
            BufferedReader reader = new BufferedReader((new FileReader(fname_in)));
            ArrayList<String> lines = new ArrayList<String>();
            String txt = "";

            String read = reader.readLine();
      
            while(read != null){
                lines.add(read + "\n");
                read = reader.readLine();
            }

            if(first < 0 || last < 0 || last < first){
                reader.close();
                throw new NegativeArraySizeException();
            }
            else if(first > lines.size()){
                reader.close();
                throw new IndexOutOfBoundsException();
            }
            else if(last > lines.size()){
                for(int i = first-1; i > -1; i--){
                    lines.remove(i);
                }
                for(String str : lines){
                    txt += str;
                }        
                txt = txt.substring(0,txt.length()-1);
                reader.close();
                return txt;
            }
            if(first == last){
                reader.close();
                txt = lines.get(last);
                txt = txt.substring(0, txt.length()-1);
                return txt;
            }

            for(int i = lines.size()-1; i>last; i--){
                System.out.print(lines.get(i));
                lines.remove(i);
            }

            for(int i = first-1; i > -1; i--){
                lines.remove(i);
            }
            
            for(String str : lines){
                txt += str;
            }        
            txt = txt.substring(0,txt.length()-1);
            reader.close();
            return txt;
            
          

        }
        catch(IOException e){

        }
        
        return "";
    }


    /**
     * This method should open the plain text file named fname_in and 
     * produce a new file whose name is fname_out. The output file 
     * should contain the lines from the input file in reverse order.
     * Additionally, the characters on each line should also be in
     * reverse order. 
     * 
     * Finally, the contents of the output file should also be returned
     * as a String.
     * 
     * If fname_in does not exist, return "ERROR: NO INPUT"
     * If fname_out fails to open, you should still return the 
     * reversed contents as a String as usual.
     */
    public static String rev_rev_file(String fname_in, String fname_out) 
    { 
        ArrayList<String> out = new ArrayList<String>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fname_in));
            ArrayList<String> list = new ArrayList<String>();
           

            String line = reader.readLine(); 
            
            while(line != null){
                list.add(line);
                line = reader.readLine();
            }
            reader.close();

            for(int i = 0; i < list.size(); i++){
                list.set(i,new StringBuilder(list.get(i)).reverse().toString() + "\n"); //reverses the element
            }
            for(int i = list.size()-1; i > -1; i--){
                out.add(list.get(i));
            }
            
        }
        catch(Exception e) {return "ERROR: NO INPUT";}
        
        try{
            FileWriter writer = new FileWriter(fname_out);
            
            for(int i = 0; i < out.size(); i++){
                writer.write(out.get(i));
            }
            
            writer.close();

            String text = "";

            for(String s : out){
                text += s;
            }
            text = text.substring(0,text.length()-1);
            return text;
            
        }
        catch(Exception e){
            String text = "";

            for(String s : out){
                text += s;
            }
            text = text.substring(0,text.length()-1);
            return text;
        }

        
    }
}

