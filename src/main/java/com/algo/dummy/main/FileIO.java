package com.algo.dummy.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author mkarki
 */
public class FileIO {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getMaxElementIndexes(Arrays.asList(1,2, 4, 3), Arrays.asList(2, 1, 3)));
        System.out.println("abcde".contains(String.valueOf('e')));
        List<String> li = new LinkedList<>();
        li.add("A");
        li.add("B");
        li.add("C");
        li.add("D");
        System.out.println(li);
        File f = new File("");

    }

    //Q1
    public static List<Integer> getMaxElementIndexes(List<Integer> a, List<Integer> rotate) {
        // Write your code here
        List<Integer> maxElementIndices = new LinkedList<>();
        if(a == null || rotate == null) {
            return maxElementIndices;
        }

        List<Integer> copyOfA = null;
        for(int rot : rotate){
            copyOfA = new LinkedList<>(a);
            Collections.rotate(copyOfA, -rot);
            maxElementIndices.add(getMaxIndex(copyOfA));
        }
        return maxElementIndices;
    }

    private static int getMaxIndex(List<Integer> a) {
        if(a.size() < 1) {
            throw new IllegalArgumentException("");
        }
        int maxIndex = 0;
        int temp = a.get(0);

        for(int i = 1; i < a.size(); i++) {
            if(temp < a.get(i)) {
                maxIndex = i;
                temp = a.get(i);
            }
        }
        return maxIndex;
    }
    //q3

    public static void commonSubstring(List<String> a, List<String> b) {
        // Write your code here
        int lenToBeChecked = a.size() > b.size() ? b.size() : a.size();
        for(int i = 0; i < lenToBeChecked; i++) {
            boolean matchFound = stringsHaveCommonSubstring(a.get(i), b.get(i));
            if(matchFound) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        int ref = lenToBeChecked;
        while(a.size() > ref++) {
            System.out.println("NO");
        }

        while(b.size() > ref++) {
            System.out.println("NO");
        }
    }


    static boolean stringsHaveCommonSubstring(String s1, String s2)  {
        boolean[] v=new boolean[26];
        Arrays.fill(v,false);

        for (int i = 0; i < s1.length(); i++)
            v[s1.charAt(i) - 'a'] = true;

        for (int i = 0; i < s2.length(); i++)  {
            if (v[s2.charAt(i) - 'a']) {
                return true;
            }
        }

        return false;
    }

    public static FileDetails getInputFileDetailsFromUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("What is the file that should be searched?");

        String path = input.nextLine();
        File inputFile = new File(path);
        if (inputFile.exists() == false) {
            System.out.println(path + " File Not Found");
            System.exit(1);

        } else if (inputFile.isFile() == false) {
            System.out.println(path + " is not a valid File");

        }
        System.out.println("Which word do you want to search?");
        String wordToBeSearched = input.nextLine();
        System.out.print("Is it case sensitive?");
        char caseSensitive = input.next().charAt(0);
        System.out.println(wordToBeSearched);
        System.out.println(caseSensitive);
        return new FileDetails(caseSensitive, wordToBeSearched, inputFile);
    }

    static class FileDetails {
        char caseSensitive;
        String wordToBeSearched;
        File file;

        public FileDetails(char caseSensitive, String wordToBeSearched, File file) {
            this.caseSensitive = caseSensitive;
            this.wordToBeSearched = wordToBeSearched;
            this.file = file;
        }

        public boolean isCaseSensitive() {
            return caseSensitive == 'y' || caseSensitive == 'Y';
        }

        public String getWordToBeSearched() {
            return wordToBeSearched;
        }

        public File getFile() {
            return file;
        }
    }


}
