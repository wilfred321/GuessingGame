import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {


    private static final String FILENAME = "movies.txt";
    //define an initialize array to store the movies
//    public static String convertedString;
   static StringBuffer convertedString;
    static String convertedLetter;
    public static String [] gameItems = new String[100];
//    static String convertedString = convertItemToUnderscore(Main.randomItem);
    static String newUnderscorizedItem = Main.convertedItem;



    public static ArrayList<String> gameItemsList = new ArrayList<>();

    //FUNCTION TO READ ITEMS FROM A LIST
    public static ArrayList readItems()throws Exception{
        //Create the file object to open the file

        File file = new File(FILENAME);

        Scanner scanner = new Scanner(file);

        String line = null;
        while (scanner.hasNextLine()){
            line = scanner.nextLine();
            gameItems = line.split(" ");
            for (int i = 0; i < gameItems.length; i++)
                gameItemsList.add(gameItems[i]);
        }
        return gameItemsList;

    }


    //FUNCTION TO RANDOMLY SELECT AN ITEM FROM THE LIST

    public static String randomItem(ArrayList<String> itemsList) {
        int itemListSize = itemsList.size();
        int randomIndex = (int) (Math.random() * itemListSize);
        String item;
        item = itemsList.get(randomIndex);
        return item;
    }

        //FUNCTION TO CONVERT ALL LETTERS TO UNDERSCORE
    protected static String convertItemToUnderscore(String item){
//       String convertedLetter;
       convertedLetter = item.replaceAll("\\w","_");
       return convertedLetter;
    }

    //FUNCTION TO CONVERT ONE LETTER FROM UNDERSCORE TO LETTER
    protected static String convertItemFromUnderscore(String underscoredItem, int index,char letter){
       convertedString = new StringBuffer(underscoredItem);
       convertedString.setCharAt(index,letter);
       return convertedString.toString();

    }

    //THIS FUNCTION GETS THE STRING FROM THE USER AND COMPARE IT WITH THE RANDOMITEM
    protected static int wrong_letter_count = 0;
    protected static int right_letter_count = 0;

    public static String compareInputAndRandItem(String letter,String underscorizedItem, String randomItem){

        boolean letterIsPresent = randomItem.contains(letter);

        if (letterIsPresent){
            right_letter_count +=1;
            //convert the string to character
            char letter_c = letter.charAt(0);
            //get the index of the letter in the string
            int index = randomItem.indexOf(letter);
            //get oldest variable

            //replace the char in the converted string with the new character
//            String newUnderscorizedItem = underscorizedItem.replace(underscorizedItem.charAt(index),letter_c);
            newUnderscorizedItem = convertItemFromUnderscore(convertedLetter,index,letter_c);
            String message = "\n" + "You have guessed (" + right_letter_count + ") correct letters";
            return newUnderscorizedItem + message;
        }else{
            wrong_letter_count += 1;
            if (newUnderscorizedItem == null)
                return "\n" + "You have guessed (" + wrong_letter_count + ") wrong letters";
            else{
                return newUnderscorizedItem + "\n" + "You have guessed (" + wrong_letter_count + ") wrong letters";
            }



        }




    }

}



