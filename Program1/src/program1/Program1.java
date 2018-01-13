package program1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Scott Mitchell & Daniel Jirasek
 * 1/13/18
 * This program takes a "text message" from the user and returns "auto-corrected" words as suggestions
 */
public class Program1
{

    public static void main(String[] args) throws FileNotFoundException
    {
        
        //instatiate scanner for keyboard input
        Scanner input = new Scanner(System.in);
        
        //prompt user for input
        System.out.print("Enter a text message. Type \"done\" to exit: ");
        String userInput = input.nextLine();
        
        //instatiate new Dictionary object
        Dictionary dict = new Dictionary();
        
        //program loop continues until user is done
        while(!userInput.equals("done"))
        {
            //instatiate new TextMessage object using user input
            TextMessage textMsg = new TextMessage(userInput);
            
            //loop checks each word using dict's methods
            for(int i = 0; i < textMsg.getMsgWordsLength(); i++)
            {
                System.out.print(textMsg.getMsgWord(i) + ": ");
                //method checks the word and prints out the results of each word
                dict.chkWord(textMsg.getMsgWord(i));
            }
            
            //prompt for next round of input
            System.out.print("\n\nEnter another text message or type \"done\" to exit: ");
            userInput = input.nextLine();
        }
    }
}
