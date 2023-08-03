package code;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class zum2_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] data = {{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}};
//        int[][] data = {{1, 0, 3}, {2, 1, 3}, {3, 3, 2}, {4, 9, 1}, {5, 10, 2}};
//        int[][] data = {{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 2}};

        List<Document> documentList = Arrays.stream(data)
                .map(d -> new Document(d[0], d[1], d[2]))
                .collect(Collectors.toList());

        PriorityQueue<Document> waitDocumentQueue = new PriorityQueue<>(Document::compare);
        List<Integer> result = new ArrayList<>();

        int idx = 0;
        int nowTime = 0;
        int remainingPages = 0;

        while(result.size() != documentList.size()) {
            if(idx < documentList.size() && documentList.get(idx).requestTime == nowTime) {
                waitDocumentQueue.add(documentList.get(idx));
                idx++;
            }

            if(remainingPages == 0) {
                Document nextDocument = waitDocumentQueue.poll();
                if(nextDocument != null) {
                    result.add(nextDocument.getNum());
                    remainingPages = nextDocument.getSize();
                }
            }

            if(remainingPages > 0) {
                remainingPages--;
            }

            nowTime++;
        }

        int[] ints = result.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(ints));
    }

    public static class Document {
        private int num;
        private int requestTime;
        private int size;

        public static int compare(Document o1, Document o2) {
            if (o1.getSize() == o2.getSize()) {
                return Integer.compare(o1.getRequestTime(), o2.getRequestTime());
            } else {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(int requestTime) {
            this.requestTime = requestTime;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Document(int num, int requestTime, int size) {
            this.num = num;
            this.requestTime = requestTime;
            this.size = size;
        }
    }
}

