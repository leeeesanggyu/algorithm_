package code;

public class YogiyoTest1 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(99664));
    }

    public static Integer solution(int num) throws Exception {
        Integer answer = 0;

        final String numString = String.valueOf(num);
        final int numLength = numString.length();

        StringBuilder sb = new StringBuilder();
        sb.append(1);

        for (int appendZeroCount=0; appendZeroCount<numLength-1; appendZeroCount++)
            sb.append(0);

        return Integer.parseInt(String.valueOf(sb));
    }
}



