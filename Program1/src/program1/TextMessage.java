/**
 *
 * @author Scott Mitchell & Daniel Jirasek
 * 01/12/18
 * Program 1
 * Description:
 * 
 * class TextMessage uses several methods and a constructor to modify the
 * user inputted string so that it can be looked at by the dictionary class and 
 * displayed in Program 1.
 */


package program1;

//allows the use of the ArrayList class
import java.util.ArrayList;


public class TextMessage
{
    //orignal message
    private String msg;
    //ArrayList containing each individual word in msg as its elements
    private ArrayList<String> msgWords;
    
    //constructor
    public TextMessage(String msg)
    {
        this.msg = msg;
        this.msgWords = new ArrayList<String>();
        //all non-word characters and non-whitespace characters are removed
        this.msg = this.msg.replaceAll("[\\W][\\d]+","");
        
        //String array is composed using any whitespace characters present
        //to split each word in the string up
        String[] words = msg.split(" ");
        
       //for each loop adds each element to the String array words
       for(String elements: words)
       {
           //taking the current element of string array words and adding it
           //to msgWords
           elements = elements.replaceAll("[^a-zA-Z]", "");
           this.msgWords.add(elements);
       }
    }
    
    //returns the original message
    public String getMsg()
    {
        return this.msg;
    }
    
    //returns string at the specified element in msgWords
    public String getMsgWord(int element)
    {
        return msgWords.get(element);
    }
    
    //retrieving the size of the string array msgWords
    public int getMsgWordsLength()
    {
        return msgWords.size();
    }
}
