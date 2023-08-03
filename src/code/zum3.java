package code;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class zum3 {
    public static void main(String[] args) throws NumberFormatException, IOException {
//        int[] histogram = {2, 2, 2, 3};
        int[] histogram = {6, 5, 7, 3, 4, 2};

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < histogram.length - 1; i++) {
            for(int j = i+1; j < histogram.length; j++) {
                int h = Integer.min(histogram[i], histogram[j]);
                int w = j - i - 1;
                int area = w * h;
                max = Integer.max(area, max);
            }
        }

        System.out.println(max);
    }
}

