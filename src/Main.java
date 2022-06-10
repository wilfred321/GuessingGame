import java.util.ArrayList;

public class Main {
    public static int itemSize;
    static String randomItem;
    static String convertedItem;

    static String gameStatus;

    protected static boolean isGameOn = true;
    static int numberOfTries;
//    static Utils utility = new Utils();


    //print game instructions
    public static void printGameInstructions() {
        System.out.println("You are guessing: " + convertedItem);
        System.out.println("You have " + numberOfTries + " guesses");
        System.out.print("Enter your first guess: ");

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
        numberOfTries = (randomItem.length()) *2;
        printGameInstructions();
        //*************Get input from user and return a letter**************

        while (isGameOn) {
            //print enter anothe guess on subsequent guesses not the first guess
            if (numberOfTries != (randomItem.length()) *2)
                System.out.println("\n\n(" + numberOfTries + ") guesses remaining\nEnter another guess: ");

            String letter = GameInput.getInput();
            numberOfTries --;

            //compare the users input and the generated random item

            if (numberOfTries == 0){
                isGameOn = false;
                gameStatus = "GAME OVER!\nSorry you lost.";

            }
            else{
                String result = Utils.compareInputAndRandItem(letter, convertedItem, randomItem);
                if (Utils.isGuessComplete(result,randomItem)) {
                    gameStatus = "Congratulations. You Won!";
                   isGameOn = false;
                }
                else {
                    System.out.println(result);
                }
                //proceed to get another input
            }

        }
        //The game is over
        System.out.println(gameStatus);
        System.out.println();
        System.out.println("Game Stats");
        System.out.println("______________");
        System.out.printf("%nThe title of the movie is:  %s", randomItem);
        System.out.println("\nTotal correct guesses: "+ Utils.right_letter_count);
        System.out.println("Total incorrect guesses: " + Utils.wrong_letter_count)  ;





        }

    }

