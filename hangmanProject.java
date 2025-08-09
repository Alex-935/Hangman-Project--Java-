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

        //for now I will create a list of Iron Maiden Songs to be the words to guess
        String[] words = {};//may be used instead of songs
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

        
        //User Menu
        System.out.print("""
                ************************
                   Welcome to Hangman
                ************************
                """);
        
      
        wordSet = setOfWords();//validates the set choice from the user
        System.out.println(wordSet);//testing function output
        


    }


    //Gets a random word from the list to be the word to guess in out hangman game
    //It's a function as it will need to be called again if the player chooses to replay
    public static String randWord(String[] words) {

        Random random = new Random();

        return words[random.nextInt(words.length)];
    }


    //Take an input from the user asking which word set they want to use
    //use switch to select and return a question set
    public static String setOfWords() {

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

            System.out.print("Enter the number of the word set you would like to use:");
  
            //option the user enters is set if the option exists
            switch (scanner.nextInt()) {

                case 1 -> wordSet = "songsA7X";
                case 2 -> wordSet = "songsIM";
                default -> {
                    System.out.println("That number is not available, please try again.");
                    break;
                }
            }
        //if the user doesn't enter an integer
        } catch (Exception e) {
            System.out.println("That is not an option, please try again.");
        }
        
        //returns the song set name if valid option entered, empty string otherwise
        return wordSet;
    }

    
}