package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lg2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int p = 10;
        int index = 15;

        String paper = "";
        for(int i = 0; paper.length() < index; i++) {
            paper += Integer.toString(i, p);
        }

        System.out.println(Integer.parseInt(String.valueOf(paper.charAt(index-1))));
    }
}

