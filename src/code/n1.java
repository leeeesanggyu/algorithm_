package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class n1 {
    public static void main(String[] args) throws IOException {
        String message = "And now here is my secret";
        int K = 15;

        String[] splitMessage = message.split(" ");

        List<String> passMessageElements = new ArrayList<>();
        int passMessageLength = 0;

        for (String m : splitMessage) {
            if (passMessageLength + m.length() + " ...".length() > K) {
                String result = passMessageElements.stream()
                        .collect(Collectors.joining(" "));
                if (result.length() == 0) {
                    result = result + "...";
                } else {
                    result = result + " ...";
                }
                System.out.println(result);
            }

            passMessageLength += (m.length() + " ".length());
            passMessageElements.add(m);
        }
    }
}

