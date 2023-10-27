package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    static LinkedList<Node> nodes = new LinkedList<>();
    static HashMap<String, Node> hashMap = new HashMap<>();  // key : key, value: Node
    static final int CACHE_MAX_SIZE = 3;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++) {
            save(String.valueOf(i), "old value " + i);
        }
        log();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            String value = get(input);
            System.out.println("result value => " + value);
            log();
        }
    }

    private static String get(String key) {
        Node node = hashMap.get(key);
        if (node != null) {
            nodes.remove(node);
            nodes.addLast(node);
            return node.value;
        } else {
            return save(key, generateValue(key)).value;
        }
    }

    private static Node save(String key, String value) {
        Node node = new Node(key, value);

        nodes.addLast(node);
        hashMap.put(key, node);

        if(hashMap.size() > CACHE_MAX_SIZE) {
            Node removedNode = nodes.removeFirst();
            hashMap.remove(removedNode.key);
        }
        return node;
    }

    private static String generateValue(String key) {
        return "new value " + key;
    }

    private static void log() {
        System.out.println("* cache list *");
        nodes.forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        System.out.println("* hashMap *");
        hashMap.entrySet().forEach(System.out::println);
        System.out.println("----------------------------------------------------");
    }

    public static class Node {
        private String key;
        private String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
}

