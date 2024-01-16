import java.util.*;

public class Bagle {
    static int NUM_DIGITS = 3;
    static int MAX_GUESSES = 10;

    public static void main(String[] args) {
        System.out.println(introducingGame());

        while (true) {
            System.out.println(tutorial());
            String secretNum = getSecretNum();
            System.out.println("I have thought up a number.");
            System.out.println(" You have " + MAX_GUESSES + " guesses to get it.");
            String clues;
            int numGuesses = 1;
            Scanner in = new Scanner(System.in);
            while (numGuesses <= MAX_GUESSES) {
                String guess = "";
                while ((guess.length() != NUM_DIGITS) || (!isNumberic(guess))) {
                    System.out.println("Write " + NUM_DIGITS + "-digit number and press Enter key.");
                    guess = in.nextLine();
                }
                clues = getClues(guess, secretNum);
                System.out.println(clues);
                numGuesses++;

                if (guess.equals(secretNum)) {
                    break;
                }
                if (numGuesses > MAX_GUESSES) {
                    System.out.println("You ran out of guesses.");
                    System.out.println("The answer was " + secretNum + ".");
                }
            }
            System.out.println("Do you want to play again? (yes or no)");
            String ans = in.nextLine();
            String upperAns = ans.toUpperCase();
            if (upperAns.contains("NO")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }

    }
    public static String introducingGame() {
        String introBagles = "Bagels, by Al Sweigart al@inventwithpython.com" + "\n" +
                "A deductive logic game where you must guess a number based on clues." + "\n" +
                "This code is available at https://nostarch.com/big-book-small-python-programming" + "\n" +
                "A version of this game is featured in the book, \"Invent Your Own" + "\n" +
                "Computer Games with Python\" https://nostarch.com/inventwithpython" + "\n" +
                "Tags: short, game, puzzle" + "\n" + "\n";

        return introBagles;
    }

    public static String tutorial() {
        String tuto = "I am thinking of a " + NUM_DIGITS + "-digit number with no repeated digits." + "\n" +
                "Try to guess what it is. Here are some clues:" + "\n" +
                "When I say:    That means:" + "\n" +
                "    Pico         One digit is correct but in the wrong position." + "\n" +
                "    Fermi        One digit is correct and in the right position." + "\n" +
                "    Bagels       No digit is correct." + "\n" + "\n" +
                "For example, if the secret number was 248 and your guess was 843, the" +
                "clues would be Fermi Pico." + "\n";
        return tuto;
    }

    public static boolean isNumberic(String str) {
        return str.chars().allMatch(Character::isDigit);
    }
    public static String getSecretNum() {
        String secretNum = "";
        Random rd = new Random();
        Set<Integer> setNum = new HashSet<>();
        int pickedNum;
        while (setNum.size() < 3) {
            pickedNum = rd.nextInt(9);
            if (!setNum.contains(pickedNum)) {
                secretNum = secretNum + pickedNum;
                setNum.add(pickedNum);
            }
        }
        return secretNum;
    }

    public static String getClues(String guess, String secretNum) {
        if (guess.equals(secretNum)) {
            return "You got it!";
        }

        ArrayList<String> clues = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (guess.charAt(i) == secretNum.charAt(i)) {
                clues.add("Fermi");
            } else if (secretNum.indexOf(guess.charAt(i)) != -1) {
                clues.add("Pico");
            }
        }
        if (clues.isEmpty()) {
            return "Bagles";
        } else {
            clues.sort(Comparator.naturalOrder());
            return String.join(", ", clues);

        }





    }
}