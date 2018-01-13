package program1;

import java.util.ArrayList;

/**
 *
 * @author Scott Mitchell & Daniel Jirasek
 */
public class TextMessage
{
    //orignal message
    private String msg;
    //ArrayList containing each individual word in msg as its elements
    private ArrayList<String> msgWords;
    
    //constructor
    public TextMessage(String message)
    {
        //TODO puts argument into msg and then splits msg into its individual words and adds them to msgWords
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
    
    public int getMsgWordsLength()
    {
        return msgWords.size();
    }
}
