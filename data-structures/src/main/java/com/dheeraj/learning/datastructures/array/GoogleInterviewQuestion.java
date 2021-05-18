package com.dheeraj.learning.datastructures.array;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * Given a string, find all the combinations of the string with repeated characters.
 * Also, the first character is mandatory in all the strings.
 * The size of the output strings can be anything. (This seems to be wrong. Lets try with max size of the string)
 * Minimum size of the string is 4
 */
public class GoogleInterviewQuestion {
    List<String> resStrings = new ArrayList<>();
    Set<String> resPermStrings = new HashSet<>();
    Set<String> words = new HashSet<>();
    public static void main(String[] argS) throws FileNotFoundException {
        GoogleInterviewQuestion giq = new GoogleInterviewQuestion();
        giq.loadFile();

        String input = "enabdfo";
        String mandChar = "t";
        for(int i=input.length();i>1;i--) {
            giq.getCombinations(input, i, new StringBuilder());
        }

        for(int i=0;i<giq.resStrings.size();i++) {
            String str = giq.resStrings.get(i);
            giq.resStrings.set(i,str.concat(mandChar));
        }
        //System.out.println(giq.resStrings);
        giq.findWords();
        System.out.println(giq.resStrings.size());
        System.out.println(giq.resPermStrings.size());
        System.out.println("Valid Words:");
        System.out.println(giq.resPermStrings);
    }

    public void getCombinations(String currWord, int len, StringBuilder sb) {
        if(len == sb.length()) {
            resStrings.add(sb.toString());
            return;
        }

        for(int i=0;i<currWord.length();i++) {
            sb.append(currWord.charAt(i));
            getCombinations(currWord, len, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public void findWords() {
        for(String word : resStrings) {
            List<String> list = new ArrayList<>();
            list.add(word.charAt(0) + "");
            for (int i = 1; i < word.length(); i++) {
                list = findPerms(list, word.charAt(i));
            }
            resPermStrings.addAll(list);
        }
    }

    public List<String> findPerms(List<String> list, char ch) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if(isWord(ch+str))
                res.add(ch+str);
            for(int j=1;j<str.length();j++) {
                String perm = str.substring(0,j)+ch+str.substring(j);
                if(isWord(perm))
                    res.add(perm);
            }
            if(isWord(str+ch))
                res.add(str+ch);
        }
        return res;
    }

    public void loadFile() throws FileNotFoundException {
        File file = new File("data-structures/src/main/resources/words_alpha.txt");
        System.out.println(file.getAbsolutePath());
        FileReader fr = new FileReader(file);
        Scanner sc = new Scanner(fr);
        while(sc.hasNextLine()) {
            words.add(sc.nextLine());
        }
    }

    public boolean isWord(String word) {
        return words.contains(word);
    }
}
