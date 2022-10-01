package code;

public class test1 {
    public static void main(String[] args) throws Exception {
        String a = "abcde";
        String b = "bcdej";

        int len = Math.min(a.length(), b.length());

        String overlapA = "";
        String overlapB = "";

        int temp = 1;
        for(int i=0; i<len; i++, temp++) {
            if(a.substring(a.length() - temp).equals(b.substring(0, temp))) {
                overlapA = a.substring(0, a.length() - i - 1) + b;
            }
        }

        temp = 1;
        for(int i=0; i<len; i++, temp++) {
            if(b.substring(b.length() - temp).equals(a.substring(0, temp))) {
                overlapB = b.substring(0, b.length() - i - 1) + a;
            }
        }

        System.out.println(overlapA);
        System.out.println(overlapB);

        final String s = overlapA.length() < overlapB.length() ? overlapA : overlapB;

        String answer = null;
        if (overlapA.length() < overlapB.length()) {
            answer = overlapA;
        } else if (overlapA.length() > overlapB.length()) {
            answer = overlapB;
        } else {
            if (overlapA.compareTo(overlapB) < 0) {
                answer = overlapA;
            } else {
                answer = overlapB;
            }
        }
        System.out.println(answer);
    }
}