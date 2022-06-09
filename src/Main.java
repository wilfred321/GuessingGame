import java.util.ArrayList;

public class Main {
    public static int itemSize;
    protected static String randomItem;
    protected static String convertedItem;


    //print game instructions
    public static void printGameInstructions() {
        System.out.println("You are guessing: " + convertedItem);

    }


    public static void main(String [] args){

        //call the read items function to read the item and print
        //them to stdout
        ArrayList <String> gameItems;
        gameItems = new ArrayList<>();

        try{
        gameItems = Utils.readItems();
        }catch (Exception exception){
            System.out.println("Could not get game items from file");
        }
//        System.out.print(gameItems.size());
//        for (String item : gameItems) {
//            System.out.println(item);
//        }

//     ******* call the method to get the random movie e*********
        randomItem =Utils.randomItem(gameItems);


       // *********convert item to understand and return underscore*************
        convertedItem = Utils.convertItemToUnderscore(randomItem);
//        System.out .println("Guess the letters to form the movie title below");
//        System.out.printf("%s%n%n",convertedItem);

        printGameInstructions();
//*************Get input from user**************
        GameInput.getInput();
        }

    }

