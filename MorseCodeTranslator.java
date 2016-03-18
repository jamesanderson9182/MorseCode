/**
 * My new solution to GCD Morse code challenge
 * Created by James Anderson
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;


public class MorseCodeTranslator {
    //Variables
    private static String theEncodedMessage,currentWord,currentLetter;

    private static HashMap<Character, String> morse = new HashMap<>();
    private static HashMap<String, Character> translateMap = new HashMap<>();

    private static String[] wordArray, currentLetterArray;
    private static StringBuilder stringBuilder;
    private static Scanner scanner;

    //Main method
    public static void main(String[] args) {
        //Create HashMap of the morse code values
        morse.put('A', ".-");
        morse.put('B', "-...");
        morse.put('C', "-.-.");
        morse.put('D',  "-..");
        morse.put('E',    ".");
        morse.put('F', "..-.");
        morse.put('G',  "--.");
        morse.put('H', "....");
        morse.put('I',   "..");
        morse.put('J', ".---");
        morse.put('K',   "-.");
        morse.put('L', ".-..");
        morse.put('M',   "--");
        morse.put('N',   "-.");
        morse.put('O',  "---");
        morse.put('P', ".--.");
        morse.put('Q', "--.-");
        morse.put('R', ".-.");
        morse.put('S',  "...");
        morse.put('T',   "-");
        morse.put('U',  "..-");
        morse.put('V', "...-");
        morse.put('W',  ".--");
        morse.put('X', "-..-");
        morse.put('Y', "-.--");
        morse.put('Z', "--..");
        morse.put('1', ".----");
        morse.put('2',"..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");
        morse.put('.', ".-.-.-");

        readInEncodedMessage();//reads the file into theEncodedMessage (this is a String)

        wordArray = theEncodedMessage.split(" / ");//Break the message up into an array of words based on:
        stringBuilder = new StringBuilder();
        
        translateMap = reverseAHashMap(morse);//reverse the morse code hash map

        for(int i = 0; i < wordArray.length; i++)
        {
            currentWord = wordArray[i];
            currentLetterArray = currentWord.split(" ");//Break letters of a word up by spaces
            for(int j = 0; j < currentLetterArray.length; j++)
            {
                currentLetter  = currentLetterArray[j];
               stringBuilder.append(translateMap.get(currentLetter));
            }
            stringBuilder.append(" ");//Add a space after every word
        }
        System.out.println(stringBuilder.toString());
    }

    /**
     * Reads in the text file
     * TODO make this return a String and pass in a file path
     */
    public static void readInEncodedMessage()
    {
        try
        {
            scanner = new Scanner(new FileReader("src/encodedMessage.txt"));
            theEncodedMessage = scanner.nextLine();
            scanner.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Reverses the key and string of a HashMap
     * TODO make this generic
     * @param originalHashMap
     * @param <String>
     * @param <Character>
     * @return the reversed HashMap
     */
    public static <String, Character> HashMap<String, Character> reverseAHashMap(HashMap<Character, String> originalHashMap) {
        HashMap<String, Character> reversedHashMap = new HashMap<String, Character>();
        for(HashMap.Entry<Character, String> entry : originalHashMap.entrySet())
            reversedHashMap.put(entry.getValue(), entry.getKey());
        return reversedHashMap;
    }


}

/*
Result:
IF THE PRESENCE OF ELECTRICITY CAN BE MADE VISIBLE IN ANY PART OF THE CIRCUIT,
I SEE NO REASON WHY INTELLIGENCE MAY NOT BE TRANSMITTED INSTANTANEOUSLY BY ELECTRICITY. SAMUEL MORSE.
 */