package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 - 8980: 택배 - greedy
 * https://www.acmicpc.net/problem/8980
 */
public class Baekjoon8980 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int villageCount = Integer.parseInt(st.nextToken());
        int truckSize = Integer.parseInt(st.nextToken());

        int deliveryInfoCount = Integer.parseInt(br.readLine());
        DeliveryInfo[] deliveryInfoList = new DeliveryInfo[deliveryInfoCount];
        for (int i=0; i<deliveryInfoCount; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int sender = Integer.parseInt(st2.nextToken());
            int receive = Integer.parseInt(st2.nextToken());
            int boxCount = Integer.parseInt(st2.nextToken());
            deliveryInfoList[i] = new DeliveryInfo(sender, receive, boxCount);
        }

        Arrays.sort(deliveryInfoList, ((o1, o2) -> o1.getReceive() == o2.getReceive() ? o1.getSender() - o2.getSender() : o1.getReceive() - o2.getReceive() ));
        for (int i=0; i<deliveryInfoCount; i++) {
            System.out.println(deliveryInfoList[i]);
        }

        // 1번 마을부터 마지막 마을까지 가면서 배송
        int[] villageList = new int[villageCount + 1];
        int max, possible, total = 0;

        for (int i = 0; i < deliveryInfoCount; i++) {
            int sender = deliveryInfoList[i].getSender();
            int receive = deliveryInfoList[i].getReceive();
            int boxCount = deliveryInfoList[i].getBoxCount();

            max = 0;
            // 지나가는 구간에 이미 실린 박스의 최댓값
            for (int j = sender; j < receive; j++) {
                max = Math.max(max, villageList[j]);
            }
            // 실을 수 있는 박스 수
            possible = Math.min(truckSize - max, boxCount);
            total += possible;
            for (int j = sender; j < receive; j++) {
                villageList[j] += possible;
            }
            System.out.println(Arrays.toString(villageList));
        }
        System.out.println("total : " + total);
        System.out.println("villageList : " + Arrays.toString(villageList));

        // 배송할 수 있는 최대 박스 수
        System.out.println(total + villageList[villageCount]);
    }

    public static class DeliveryInfo {
        private int sender;
        private int receive;
        private int boxCount;

        public DeliveryInfo(int sender, int receive, int boxCount) {
            this.sender = sender;
            this.receive = receive;
            this.boxCount = boxCount;
        }

        public int getSender() {
            return sender;
        }

        public int getReceive() {
            return receive;
        }

        public int getBoxCount() {
            return boxCount;
        }

        @Override
        public String toString() {
            return "{" +
                    "sender=" + sender +
                    ", receive=" + receive +
                    ", boxCount=" + boxCount +
                    '}';
        }
    }
}

