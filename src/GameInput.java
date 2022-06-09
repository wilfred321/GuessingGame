import java.util.Scanner;

public class GameInput {



    //get input for the size of the  random item times 2
    private static boolean isGetInput;
    private static String randomItem= Main.randomItem;
//    private String convertedString = Utils.convertedString;
//    String convertedItem = Utils.convertItemToUnderscore(randomItem);

    public static void getInput() {

        Scanner input = new Scanner(System.in);
        isGetInput = true;
        int numberOfTries = (randomItem.length()) *2;
        String letter = null;
        while (isGetInput) {

            System.out.println("Guess a letter: ");
            letter = input.next();

            String result = Utils.compareInputAndRandItem(letter);
//            if (result != null)
            System.out.println(result);



//                System.out.println(letter);
            numberOfTries--;
            if (numberOfTries == 0)
                isGetInput = false;

            }
            //compare letter to the movie
//            boolean result = randomItem.contains(letter);
//            if (result){
//                int index = randomItem.indexOf(letter);
//                System.out.println("Index of the letter is :"+ index );
//                break;


//            System.out.println(letter);
        System.out.println("GAME OVER");
        System.out.printf("%nThe title of the movie is %s", randomItem);



    }


    }

//    public static void setRandomItem(String randomItem) {
//        GameInput.randomItem = randomItem;
//    }
//}
