import java.util.Random;
import java.util.Scanner;

public class hangmanProject {

    //static Scanner scanner = new Scanner(System.in);//takes user input
    
    public static void main(String[] args) {

        /* 
        //Pick a random word from list of strings
        //Allow the user to pick a word list
        //display hidden version of word
        //ask user for input - case insensitive
        //check input against word
            - fill in any correct letters
            - add to gallows if no matches
        //Draw in gallows

        // if incorrect guesses = num
            - agame over
            - reveal word
        
        // play again?
        */

        //Variables:
        String wordSet;//user selects a topic the hangman word is based on
        String wordToGuess;//random word from set
        String guess;//user's guess
        String hiddenString;//has guessed letters displayed and not guessed letters hidden

        //for now I will create a list of Iron Maiden Songs to be the words to guess
        String[] words = {"H@ll0wed B3 th! n$m.", "World"};//may be used instead of songs
        String[] songsIM = {"Hallowed Be Thy Name", "The Trooper", "Run to the Hills",
                          "The Number of the Beast", "Powerslave", "Aces High", "2 Minutes to Midnight",
                          "Wasted Years", "Stranger in a Strange Land", "Caught Somewhere in Time",
                          "Wrathchild", "Killers", "Phantom of the Opera", "Prowler", "The Clansman",
                          "Seventh Son of a Seventh Son", "Can I Play With Madness", "Be Quick or Be Dead",
                          "Fear of the Dark", "The Evil That Men Do", "Different World", "For the Greater Good fo God",
                          "Doctor Doctor", "Flash of the Blade", "The Red and the Black", "Futureal"
                        };
        String[] songsA7X = {"Critical Acclaim", "Scream", "Afterlife", "Gunslinger", "A Little Piece of Heaven",
                             "Dear God", "Almost Easy", "Nightmare", "So Far Away", "Victim",
                             "Buried Alive", "Shepherd of Fire", "Hail to the King", "Coming Home",
                             "St. James", "Unholy Confessions", "Second Heartbeat", "Chapter Four",
                             "Seize the Day", "Trashed and Scattered", "M.I.A.", "Sidewinder", "Beast and the Harlot",
                             "The Stage", "Roman Sky", "Exist", "God Damn", "Not Ready to Die", "Mad Hatter", "Carry On",
                             "Welcome to the Family", "Danger Line", "Brompton Cocktail", "Lost", "Unbound (The Wild Ride)"
                            };// Bat Country is overrated
        String[][] wordSets = {songsIM, songsA7X};
        
        //User Menu
        System.out.print("""
                ************************
                   Welcome to Hangman
                ************************
                """);
        
        /*
          wordToGuess - our random word from our set
          randWord() - generates a random word from a list of words
          wordSets[] - is our set of word sets
          setOfWords - gets the number of the set the user wants to generate the word from
                - (wordSets.length): is so we can check the users selection doesn' exceed 
                                     the number of word sets available
                - (-1): is because the options start counting from one while the index counts from 0
                        The user will enter the option which is one more than the sets index

        //The user inputs which word set they want their word to be from, 
        //we then generate a random word from that set.*/
        wordToGuess = randWord(wordSets[setOfWords(wordSets.length) - 1]);
        hiddenString = convertRandomWord(wordToGuess);

        System.out.println(wordToGuess);
        System.out.println(hiddenString);


        //Testing
        ///*
        for (int i = 0; i < 20; i++) {

            wordToGuess = randWord(wordSets[i%2]);
            System.out.println(wordToGuess);
            System.out.println(convertRandomWord(wordToGuess));
        }
        //*/
    }


    //Gets a random word from the list to be the word to guess in out hangman game
    //It's a function as it will need to be called again if the player chooses to replay
    public static String randWord(String[] words) {

        Random random = new Random();

        //nextInt(words.length) will generate a random value between 0 and the 1 less than the length of list
        //that value is then used as an index in the word lists
        return words[random.nextInt(words.length)];
    }


    //Take an input from the user asking which word set they want to use
    //use switch to select and return a question set
    public static int setOfWords(int numOfSets) {

        //display set options
        System.out.print("""
                The word sets available are: 
                  1. Avenged Sevenfold Songs
                  2. Iron Maiden Songs
                """);

        //a while loop is going to be used to ensure an acceptable number is entered
        String wordSet = "";//word set the user has chosen
            
        //ensures the user enters an integer
        try(Scanner scanner = new Scanner(System.in)) {

            //takes in option user choses
            System.out.print("Enter the number of the word set you would like to use: ");
            int option = scanner.nextInt();
  
            //option the user enters is returned if the option exists
            if (option > 0 && option <= numOfSets) {
              return option;
            }
        //if the user doesn't enter an integer
        } catch (Exception e) {}
        
        //returns 0 if option is invalid
        System.out.println("That is not an option, please try again.");
        return 0;
    }

    //converts random word to a ____ format
    public static String convertRandomWord(String wordToGuess) {

        //empty string to put the word into as it is being converted
        String guessedStatus = "";

        //for each letter in our word to guess:
        for (int i = 0; i < wordToGuess.length(); i++) {

            //one letter at a time, changes each char into a string so .matches() can be used
            String letter = Character.toString(wordToGuess.charAt(i));

            //if the letter is in the alphabet,  replace it with _. Symbols are unaffected.
            if (letter.matches("[a-zA-Z]")) {
                guessedStatus += "_";
            } else {
                guessedStatus += letter;
            }
        }

        //return hidden string
        return guessedStatus;
    }
    
}