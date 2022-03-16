package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

//s번째 주문취소한 번호는 몇번인가
public class 주문취소번호 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution1(new int[]{2, 4, 5, 6, 7, 8, 10}, 3));
        System.out.println(solution2(new int[]{2, 4, 5, 6, 7, 8, 10}, 3));
    }

    // cancel order 다구함
    private static Integer solution1(int[] orders, int s) {
        final int lastOrder = orders[orders.length - 1];
        ArrayList<Integer> cancelOrders = new ArrayList<>();

        for (int i=1; i<=lastOrder; i++) {   //1~7
            boolean check = false;

            for (int j=0; j<orders.length; j++) {  //0~3
                if(i == orders[j])
                    check = true;
            }
            if(!check) {
                cancelOrders.add(i);
            }
        }
        System.out.println("cancel orders : " + cancelOrders);
        return cancelOrders.get(s-1);
    }

    // hash set 사용
    private static Integer solution2(int[] orders, int s) {
        int temp = 0;
        final int lastOrder = orders[orders.length - 1];
        Set<Integer> setOrder = Arrays.stream(orders).boxed().collect(Collectors.toSet());
        System.out.println("set : " + setOrder);

        for(int i=1; i<lastOrder; i++) {
            if(!setOrder.contains(i)) {
                temp++;
            }
            if(temp == s) {
                return i;
            }
        }
        return null;
    }
}