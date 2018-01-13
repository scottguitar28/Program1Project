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
    private char[][] heurKeyMap = new char[26][];
    
    public Dictionary() throws FileNotFoundException
    {
        
        File dictSrc = new File(dictSrcName);
        Scanner dictSrcScan = new Scanner(dictSrc);
        while(dictSrcScan.hasNext())
        {
            dictList.add(dictSrcScan.nextLine());
        }
        
        this.heurKeyMap = fillMap();
        
        
    }
    
    public void chkWord(String word)
    {
        String foundWord = "";
        //keeps track of if we found anything
        int wordsFound = 0;
        
        //for loop looks through each letter in word
        //i will stand in for the position of the current character in the word
        for(int i = 0; i < word.length(); i++)
        {
            //use stringbuilder to modify string with elements of heuristicKeyMap more easily
            StringBuilder strBuild = new StringBuilder(word.toLowerCase());
            //keeps track of the current letter
            char currentChar = word.charAt(i);
            
            int mapPos = -1;
            //looks through heuristicKeyMap[][] for the current letter's 0 position within it
            for(int j = 0; j < heurKeyMap.length; j++)
            {
                //if we're there save the position in mapPos
                if(currentChar == heurKeyMap[j][0])
                {
                    mapPos = j;
                }
            }
            
            //loop replaces current word character with one from the heurKeyMap, checks for a match in dictList, and prints if there is a match
            //j stands in for replacement char
            for(int j = 1; j < heurKeyMap[mapPos].length; j++)
            {
                strBuild.deleteCharAt(i);
                strBuild.insert(i, heurKeyMap[mapPos][j]);
                
                //if a there's a match
                if(dictList.contains(strBuild.toString()))
                {
                    //print out that match
                    System.out.print(dictList.get(dictList.indexOf(strBuild.toString())) + " ");
                    //counter keeps track of if there are any matches found probably could've put this in its own function but meh
                    wordsFound++;
                } else if(dictList.contains(capitalize(strBuild.toString())))
                {
                    System.out.print(dictList.get(dictList.indexOf(capitalize(strBuild.toString()))));
                    wordsFound++;
                }
            } 
        }
        //if no matches were found in the dictionary
            if(wordsFound == 0)
            {
                //print out message
                System.out.print("no matches found");
            }
    }
    
    //fills heurKeyMap
    private char[][] fillMap()
    {
        char[][] map = {
            {'a', 's'},
            {'b', 'v', 'n'},
            {'c', 'x', 'v'},
            {'d', 's', 'f'},
            {'e', 'w', 'r'},
            {'f', 'd', 'g'}, 
            {'g', 'f', 'h'},
            {'h', 'g', 'j'},
            {'i', 'u', 'o'},
            {'j', 'h', 'k'},
            {'k', 'j', 'l'},
            {'l', 'k'},
            {'m', 'n'},
            {'n', 'm'},
            {'o', 'i', 'p'},
            {'p', 'o'},
            {'q', 'w'},
            {'r', 'e', 't'},
            {'s', 'a', 'd'},
            {'t', 'r', 'y'},
            {'u', 'y', 'i'},
            {'v', 'c', 'b'},
            {'w', 'q', 'e'},
            {'x', 'z', 'c'},
            {'y', 't', 'u'},
            {'z', 'x'}
        };
        return map;
    }
    
    private String capitalize(String str)
    {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
