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
    public TextMessage(String msg)
    {
        this.msg = msg;
        this.msgWords = new ArrayList<String>();
        //all non-word characters and non-whitespace characters are removed
        this.msg = this.msg.replaceAll("[\\W][\\d]+","");
        
        String[] words = msg.split(" ");
        
       for(String elements: words)
       {
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
    
    public int getMsgWordsLength()
    {
        return msgWords.size();
    }
}
