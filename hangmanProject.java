import java.util.Random;

public class hangmanProject {
    
    public static void main(String[] args) {

        /* 
        //Pick a random word from list of strings
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


        //for now I will create a list of Iron Maiden Songs to be the words to guess
        String[] words = {};//may be used instead of songs
        String[] songs = {"Hallowed Be Thy Name", "The Trooper", "Run to the Hills",
                          "The Number of the Beast", "Powerslave", "Aces High", "2 Minutes to Midnight",
                          "Wasted Years", "Stranger in a Strange Land", "Caught Somewhere in Time",
                          "Wrathchild", "Killers", "Phantom of the Opera", "Prowler", "The Clansman",
                          "Seventh Son of a Seventh Son", "Can I Play With Madness", "Be Quick or Be Dead",
                          "Fear of the Dark", "The Evil That Men Do", "Different World", "For the Greater Good fo God",
                        };

        //test output of randWord();           
        for (int i = 0; i < 10; i++) {
            System.out.println(randWord(songs));      
        }      
    }


    //Gets a random word from the list to be the word to guess in out hangman game
    //It's a function as it will need to be called again if the player chooses to replay
    public static String randWord(String[] words) {

        Random random = new Random();

        return words[random.nextInt(words.length)];
    }
}