package program1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Scott Mitchell & Daniel Jirasek
 * 1/13/18
 * This class is used to store a dictionary of words for class Program1.
 * It also contains methods for checking words against that dictionary of words.
 */
public class Dictionary
{

    private ArrayList<String> dictList = new ArrayList<String>();
    private String dictSrcName = "words.txt";
    private char[][] heurKeyMap = new char[26][];
    
    //constructor opens file, fills dictList, and fills heurKeyMap
    public Dictionary() throws FileNotFoundException
    {
        //open the source file
        File dictSrc = new File(dictSrcName);
        //scanner for source file
        Scanner dictSrcScan = new Scanner(dictSrc);
        //while there's more stuff in the source file
        while (dictSrcScan.hasNext())
        {
            //add each line to dictList
            this.dictList.add(dictSrcScan.nextLine());
        }

        this.heurKeyMap = fillMap();
    }
    
    //checks if the inputted string is in dictList
    public void chkWord(String word)
    {
        //keeps track of if we found anything
        int wordsFound = 0;

        //for loop looks through each letter in word
        //i will stand in for the position of the current character in the word
        for (int i = 0; i < word.length(); i++)
        {
            //use stringbuilder to modify string with elements of heuristicKeyMap more easily
            StringBuilder strBuild = new StringBuilder(word.toLowerCase());
            //keeps track of the current letter
            char currentChar = word.charAt(i);
            
            //keeps track of where the current letter is in heurKeyMap. Initialized to -1 so that it doesn't mistakenly start at the position of 'a' in heurKeyMap which is 0
            int mapPos = -1;
            //looks through heuristicKeyMap[][] for the current letter's 0 position within it
            for (int j = 0; j < heurKeyMap.length; j++)
            {
                //if we're there save the position in mapPos
                if (currentChar == heurKeyMap[j][0])
                {
                    mapPos = j;
                }
            }

            //loop replaces current word character with one from the heurKeyMap, checks for a match in dictList, and prints if there is a match
            //j stands in for position of replacement char
            for (int j = 1; j < heurKeyMap[mapPos].length; j++)
            {
                strBuild.deleteCharAt(i);
                strBuild.insert(i, heurKeyMap[mapPos][j]);

                //if a there's a match
                if (dictList.contains(strBuild.toString()))
                {
                    //print out that match
                    System.out.print(dictList.get(dictList.indexOf(strBuild.toString())) + " ");
                    //counter keeps track of if there are any matches found probably could've put this in its own function but meh
                    wordsFound++;
                } else if (dictList.contains(capitalize(strBuild.toString())))
                {
                    System.out.print(dictList.get(dictList.indexOf(capitalize(strBuild.toString()))));
                    wordsFound++;
                }
            }
        }
        //if no matches were found in the dictionary
        if (wordsFound == 0)
        {
            //print out sadface message
            System.out.print("no matches found");
        }
    }

    //fills heurKeyMap
    private char[][] fillMap()
    {
        char[][] map =
        {
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

    //this method just capilizes its input string
    private String capitalize(String str)
    {
        //capitalize the substring containing the first element of the string and concatenating the rest of the string
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
