import java.util.ArrayList;
import java.util.List;
public class LabThree 
{
    public static String reverseVowels(String text) 
    {
        List<Character> vowels = List.of('a','e','i','o','u','A','E','I','O','U');
        List<Character> lettersV = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for(int i = 0; i < text.length(); i++){
            if(vowels.contains(text.charAt(i)) == true){
                lettersV.add(text.charAt(i));
                index.add(i); 
            }
        }
        int counter = 1;
        String newString = "";
        for(int i = 0; i < text.length(); i++){
            if(index.contains(i) == true){ 
                if(Character.isUpperCase(text.charAt(i)) == true){
                    newString += Character.toUpperCase(lettersV.get(index.size()-counter));
                    counter++;
                }
                else{
                    newString += Character.toLowerCase(lettersV.get(index.size()-counter));
                    counter++;
                }
            }
            else{
                newString += text.charAt(i);
            }
        }
        return newString;
    }  
}

