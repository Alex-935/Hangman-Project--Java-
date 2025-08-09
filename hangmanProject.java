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
        Scanner scanner = new Scanner(System.in);

        //Variables:
        String wordSet = "";//user selects a topic the hangman word is based on
        String wordToGuess;//random word from selected set, word the user needs to correctly guess
        int option = 0;//user selects a topic the hangman word is based on
        String guess = "";//user guesses a letter in the word or enters 'word' to guess the word itself
        String wordGuess = "";//guess at the word itself
        boolean guessed = false;//has the word been guessed correctly
        String hiddenString;//has guessed letters displayed and not guessed letters hidden e.g. He__o _o_ld
        int wrongGuesses = 0;//number of incorrect user guesses
        boolean accepted = false;//used in while loops to validate inputs
        boolean change = false;//used in while loops to validate inputs
        String playAgain;//string responce to if they want to play again
        boolean toPlayAgain;//boolean for play agin

        //Topics the hangman words will be based on and list of said words
        String[] words = {"Hi", "World"};//used for testing mainly
        //Iron Maiden Songs
        String[] songsIM = {"Hallowed Be Thy Name", "The Trooper", "Run to the Hills",
                          "The Number of the Beast", "Powerslave", "Aces High", "2 Minutes to Midnight",
                          "Wasted Years", "Stranger in a Strange Land", "Caught Somewhere in Time",
                          "Wrathchild", "Killers", "Phantom of the Opera", "Prowler", "The Clansman",
                          "Seventh Son of a Seventh Son", "Can I Play With Madness", "Be Quick or Be Dead",
                          "Fear of the Dark", "The Evil That Men Do", "Different World", "For the Greater Good fo God",
                          "Doctor Doctor", "Flash of the Blade", "The Red and the Black", "Futureal"
                        };
        //Avenged Sevenfold Songs
        String[] songsA7X = {"Critical Acclaim", "Scream", "Afterlife", "Gunslinger", "A Little Piece of Heaven",
                             "Dear God", "Almost Easy", "Nightmare", "So Far Away", "Victim",
                             "Buried Alive", "Shepherd of Fire", "Hail to the King", "Coming Home",
                             "St. James", "Unholy Confessions", "Second Heartbeat", "Chapter Four",
                             "Seize the Day", "Trashed and Scattered", "M.I.A.", "Sidewinder", "Beast and the Harlot",
                             "The Stage", "Roman Sky", "Exist", "God Damn", "Not Ready to Die", "Mad Hatter", "Carry On",
                             "Welcome to the Family", "Danger Line", "Brompton Cocktail", "Lost", "Unbound (The Wild Ride)"
                            };// Bat Country is overrated so not included :)
        String[][] wordSets = {songsA7X, songsIM, words};//set of word topics
        int numOfSets = wordSets.length;//number of topics
        
        //User Menu
        System.out.print("""
                ************************
                   Welcome to Hangman
                ************************
                """);

        //do while loop allows the player to play again
        do {    
            //display's topics options
            System.out.print("""
                    The word sets available are: 
                    1. Avenged Sevenfold Songs
                    2. Iron Maiden Songs
                    """);


            //a while loop is going to be used to ensure an acceptable number is entered
            try {
                do {
                    //takes in option user choses
                    System.out.print("Enter the number of the word set you would like to use: ");
                    option = scanner.nextInt();

                    //option the user enters is returned if the option exists
                    if (option > 0 && option <= numOfSets) {
                        accepted = true;
                    }
                } while (!accepted);

            //if the user doesn't enter an integer
            } catch (Exception e) {
                System.out.println("Not a valid option");
                break;
            }
            
            //generates a random word from the set and hides the letters. Then outputs it
            wordToGuess = randWord(wordSets[option - 1]);
            hiddenString = convertRandomWord(wordToGuess);
            System.out.println("********************");
            System.out.printf("The word to guess is: %s\n", hiddenString);
            System.out.println("********************");

            do {
                //Lets the user enter a letter
                System.out.println("To guess a letter, type in your letter.");
                System.out.println("To guess a word, type 'word'.");

                accepted = false;
                while(!accepted) {

                    System.out.print("Please input your guess: ");
                    guess = scanner.nextLine().toLowerCase();

                    if (guess.equals("word")) {
                        accepted = true;
                        
                    } else if (guess.matches("[a-z]")) {
                        accepted = true;
                    } else {
                        System.out.println("That is not a valid guess");
                    }
                }


                if (guess.equals("word")) {

                    System.out.print("Please guess a word: ");
                    wordGuess = scanner.nextLine();
                    
                    if (wordGuess.toLowerCase().equals(wordToGuess.toLowerCase())) {

                        System.out.println("Conrgatulations, you guessed the word!");
                        guessed = true;
                    } else {

                        wrongGuesses += 1;
                        System.out.println("Unfortunately your guess was wrong!");
                        System.out.println(getHangman(wrongGuesses));

                        if (wrongGuesses == 10) {
                            System.out.println("Too bad! The word was: " + wordToGuess);
                            break;
                        }
                    }
                    
                } else {
                    
                    
                    change = false;
                    for (int i = 0; i < hiddenString.length(); i++) {
                        
                        
                        if (Character.toString(guess.charAt(0)).equals(Character.toString(wordToGuess.charAt(i)).toLowerCase())) {
                            
                            if (i == hiddenString.length() -1) {
                                hiddenString = hiddenString.substring(0, i) + Character.toString(wordToGuess.charAt(i));
                            } else {
                                hiddenString = hiddenString.substring(0, i) + Character.toString(wordToGuess.charAt(i)) + hiddenString.substring(i + 1);
                            }
                            
                            change = true;

                            if (hiddenString.equals(wordToGuess)) {
                                System.out.println("Conrgatulations, you guessed the word!");
                                guessed = true;
                                break;
                            }
                        }

                    }

                    if (!change) {
                        wrongGuesses += 1;
                        System.out.println("Unfortunately your guess was wrong!");
                        System.out.println(getHangman(wrongGuesses));
                    } else if (guessed == false) {
                        System.out.println(hiddenString);
                    }
                    
                    if (wrongGuesses == 10) {
                        System.out.println("Too bad! The word was: " + wordToGuess);
                        break;
                    }
                }
            } while (!guessed);

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.nextLine().toLowerCase();

            if (playAgain.equals("y")) {
                guess = "";
                wordGuess = "";
                guessed = false;
                wrongGuesses = 0;
                accepted = false;
                change = false;
                toPlayAgain = true;
            } else {
                toPlayAgain = false;
                System.out.println("Goodbye, Thank you for playing.");
            }

        } while (toPlayAgain);

    }


    //Gets a random word from the list to be the word to guess in out hangman game
    //It's a function as it will need to be called again if the player chooses to replay
    public static String randWord(String[] words) {

        Random random = new Random();

        //nextInt(words.length) will generate a random value between 0 and the 1 less than the length of list
        //that value is then used as an index in the word lists
        return words[random.nextInt(words.length)];
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

    //hangman pictures for each life lost
    public static String getHangman(int wrongGuesses) {

        switch(wrongGuesses) {

            //Pieces: L | () / || \
            case 0 -> {return "";}
            case 1 -> {return """
                
                


                ____________
                    """;}
            case 2 -> {return """
                |     
                |      
                |    
                |     
                |____________
                    """;}
            case 3 -> {return """
                ________
                |     
                |     
                |    
                |      
                |____________
                    """;}
            case 4 -> {return """
                ________
                |      |
                |      
                |     
                |      
                |____________
                    """;}
            case 5 -> {return """
                ________
                |      |
                |      ()
                |     
                |      
                |____________
                    """;}
            case 6 -> {return """
                ________
                |      |
                |      ()
                |      ||
                |      
                |____________
                    """;}
            case 7 -> {return """
                ________
                |      |
                |      ()
                |     /||
                |      
                |____________
                    """;}
            case 8 -> {return """
                ________
                |      |
                |      ()
                |     /||\\
                |      
                |____________
                    """;}
            case 9 -> {return """
                ________
                |      |
                |      ()
                |     /||\\
                |      /
                |____________
                    """;}
            case 10 -> {return """
                ________
                |      |
                |      ()
                |     /||\\
                |      /\\
                |____________
                    """;}
        }

        return "";
    }

}