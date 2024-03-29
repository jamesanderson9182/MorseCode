/**
 * My new solution to GCD Morse code challenge
 * Created by James Anderson
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class MorseCodeTranslator
    {
    private static String theEncodedMessage, currentWord;
    private static final HashMap<Character, String> morse = new HashMap<>();
    private static HashMap<String, Character> translateMap = new HashMap<>();
    private static String[] wordArray, currentLetterArray;
    private static StringBuilder stringBuilder;
    private static Scanner scanner;

    public static void main(String[] args)
        {
        //Create HashMap of the morse code values
        morse.put('A', ".-");
        morse.put('B', "-...");
        morse.put('C', "-.-.");
        morse.put('D', "-..");
        morse.put('E', ".");
        morse.put('F', "..-.");
        morse.put('G', "--.");
        morse.put('H', "....");
        morse.put('I', "..");
        morse.put('J', ".---");
        morse.put('K', "-.");
        morse.put('L', ".-..");
        morse.put('M', "--");
        morse.put('N', "-.");
        morse.put('O', "---");
        morse.put('P', ".--.");
        morse.put('Q', "--.-");
        morse.put('R', ".-.");
        morse.put('S', "...");
        morse.put('T', "-");
        morse.put('U', "..-");
        morse.put('V', "...-");
        morse.put('W', ".--");
        morse.put('X', "-..-");
        morse.put('Y', "-.--");
        morse.put('Z', "--..");
        morse.put('1', ".----");
        morse.put('2', "..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");
        morse.put('.', ".-.-.-");
        morse.put(',', "--..--");

        /*read the file into theEncodedMessage (this is a String)*/
        theEncodedMessage = readInEncodedMessage("src/encodedMessage.txt");

        /*Break the message up into an array of words based on: space forward-slash space*/
        wordArray = theEncodedMessage.split(" / ");

        translateMap = reverseAHashMap(morse);//reverse the morse code hash map
        /*Set up string builder that will build the translated String character by character */
        stringBuilder = new StringBuilder();

        /*Loop to go through each letter in the sequence*/
        for (String aWordArray : wordArray)
            {
            currentWord = aWordArray;//First word
            currentLetterArray = currentWord.split(" ");//Break letters of word at i by spaces
            for (String aCurrentLetterArray : currentLetterArray)
                {
                stringBuilder.append(translateMap.get(aCurrentLetterArray));//Did this in one line
                }
            stringBuilder.append(" ");//Add a space after every word
            }
        System.out.println(stringBuilder.toString());//Print out the final String
        scanner.close();//Close the scanner object that was created when readInEncodedMessage was called
        }

    /**
     * @param filePath as a String
     * @return the text file as a String
     */
    public static String readInEncodedMessage(String filePath)
        {
        try
            {
            scanner = new Scanner(new FileReader(filePath));//Create the scanner object that points to the file path
            } catch (FileNotFoundException e)
            {
            e.printStackTrace();
            }
        return theEncodedMessage = scanner.nextLine();//Scanner reads the next line of text and stores it in theEncodedMessage
        }

    /**
     * Reverses the key and value of a HashMap
     * TODO make this generic
     *
     * @param originalHashMap that you want reversed
     * @param <String>        the key
     * @param <Character>     the value
     * @return the reversed HashMap
     */
    public static <String, Character> HashMap<String, Character> reverseAHashMap(HashMap<Character, String> originalHashMap)
        {
        HashMap<String, Character> reversedHashMap = new HashMap<>();//the new hash map
        for (HashMap.Entry<Character, String> entry : originalHashMap.entrySet())//enhanced for loop
            reversedHashMap.put(entry.getValue(), entry.getKey());//assign the value to the key and vice versa
        return reversedHashMap;
        }
    }
/*
Result:
IF THE PRESENCE OF ELECTRICITY CAN BE MADE VISIBLE IN ANY PART OF THE CIRCUIT,
I SEE NO REASON WHY INTELLIGENCE MAY NOT BE TRANSMITTED INSTANTANEOUSLY BY ELECTRICITY. SAMUEL MORSE.
 */