import java.util.ArrayList;

public class Main {
    public static int itemSize;
    private static String randomItem;
    protected static String convertedItem;
    protected static boolean isGameOn = true;
    static int numberOfTries;



    //print game instructions
    public static void printGameInstructions() {
        System.out.println("You are guessing: " + convertedItem);
        System.out.print("Enter a guess: ");

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
        //*************Get input from user and return a letter**************
        numberOfTries = (randomItem.length()) *2;
        while (isGameOn) {
            //print enter anothe guess on subsequent guesses not the first guess
            if (numberOfTries != (randomItem.length()) *2)
                System.out.println("Enter another guess: ");

            String letter = GameInput.getInput();
            numberOfTries --;

            //compare the users input and the generated random item

            if (numberOfTries == 0){
                isGameOn = false;
            }
            else{
                String result = Utils.compareInputAndRandItem(letter, convertedItem, randomItem);
                System.out.println(result);
                //proceed to get another input
            }

        }
        //The game is over
        System.out.println("GAME OVER");
        System.out.println();
        System.out.println("Game Stats");
        System.out.println("______________");
        System.out.printf("%nThe title of the movie is:  %s", randomItem);
        System.out.println("\nTotal correct guesses: "+ Utils.right_letter_count);
        System.out.println("Total incorrect guesses: " + Utils.wrong_letter_count)  ;





        }

    }

