package program1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Scott Mitchell & Daniel Jirasek
 */
public class Dictionary
{
    
    private ArrayList<String> dictList = new ArrayList<String>();
    private String dictSrcName = "words.txt";
    
    public Dictionary() throws FileNotFoundException
    {
        
        File dictSrc = new File(dictSrcName);
        Scanner dictSrcScan = new Scanner(dictSrc);
        while(dictSrcScan.hasNext())
        {
            dictList.add(dictSrcScan.nextLine());
        }
        
    }
    
    public String chkWord(String word)
    {
        String foundWord = "";
        
        //this method will print out the original word and all its matches in dictList in the console
        
        return foundWord;
    }
    
}
