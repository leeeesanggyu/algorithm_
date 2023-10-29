package code.n;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodilityTest3 {

    public static void main(String[] args) {
//        int N = 15958;
//        int N = -5859;
        int N = -5000;

        int result = remove5ToMaxNumber(N);
        System.out.println("가장 큰 수: " + result);
    }

    public static int remove5ToMaxNumber(int N) {
        String numberStr = Integer.toString(N);
        int len = numberStr.length();
        int maxNumber = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < len; i++) {
            if (numberStr.charAt(i) == '5') {
                StringBuilder tempStr = new StringBuilder(numberStr);
                tempStr.deleteCharAt(i);
                int newNumber = Integer.parseInt(tempStr.toString());
                if (newNumber > maxNumber) {
                    maxNumber = newNumber;
                    maxIndex = i;
                }
            }
        }

        if (maxIndex != -1) {
            StringBuilder maxStr = new StringBuilder(numberStr);
            maxStr.deleteCharAt(maxIndex);
            maxNumber = Integer.parseInt(maxStr.toString());
        }

        return maxNumber;
    }
}

