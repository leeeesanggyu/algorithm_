package code;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class zum2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] data = {{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}};

        Queue<Document> waitDocumentQueue = new LinkedList<>();
        Queue<Document> processDocumentQueue = new LinkedList<>();
        ArrayList<Document> successDocumentList = new ArrayList<>();

        Arrays.stream(data)
                .forEach(d -> waitDocumentQueue.add(new Document(d[0], d[1], d[2])));

        Document firstDocument = waitDocumentQueue.poll();
        successDocumentList.add(firstDocument);
        int nowTime = firstDocument.getSize();

        while (true) {
            nowTime += successDocumentList.get(successDocumentList.size() - 1).getSize();

            while(true) {
                if (waitDocumentQueue.isEmpty()) {
                    break;
                }
                Document peekDocument = waitDocumentQueue.peek();

                if (peekDocument.getRequestTime() > nowTime) {
                    processDocumentQueue.add(waitDocumentQueue.poll());
                } else {
                    break;
                }
            }
        }

//        sortedProcessDocumentQueue(processDocumentQueue);

    }

    private static void sortedProcessDocumentQueue(Queue<Document> processDocumentQueue) {
        processDocumentQueue.stream().sorted((o1, o2) -> {
            if (o1.getSize() == o2.getSize()) {
                return Integer.compare(o1.getRequestTime(), o2.getRequestTime());
            } else {
                return Integer.compare(o2.getSize(), o1.getSize());
            }
        });
    }

    public static class Document {
        private int num;
        private int requestTime;
        private int size;

        @Override
        public String toString() {
            return "Document{" +
                    "num=" + num +
                    ", requestTime=" + requestTime +
                    ", size=" + size +
                    '}';
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

