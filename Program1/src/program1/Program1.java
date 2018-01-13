package program1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Scott Mitchell & Daniel Jirasek
 */
public class Program1 {

    public static void main(String[] args) throws FileNotFoundException {
        
        //instatiate scanner for keyboard input
        Scanner input = new Scanner(System.in);
        
        //prompt user for input
        System.out.println("Enter a text message. Type \"done\" to exit.");
        String userInput = input.nextLine();
        
        Dictionary dict = new Dictionary();
        
        while(userInput.equals("done"))
        {
            TextMessage textMsg = new TextMessage(userInput);
            
            for(int i = 0; i < textMsg.getMsgWordsLength(); i++)
            {
                dict.chkWord(textMsg.getMsgWord(i));
            }
            
            System.out.print("\n\nEnter another text message or type \"done\" to exit: ");
            userInput = input.nextLine();
        }
    }
    
}
