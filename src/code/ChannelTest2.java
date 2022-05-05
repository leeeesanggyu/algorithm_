package code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// 틀림
public class ChannelTest2 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}));
    }

    public static int solution(int[][] L) throws Exception {
        Arrays.sort(L, (x, y) -> {
            if (x[1] != 0) return 1;
            if (y[1] != 0) return -1;
            return x[0] - y[0];
        });
        System.out.println(Arrays.deepToString(L));

        LinkedList<int[]> es = new LinkedList<>(Arrays.asList(L));
//

        int aroundL = 1;
        while(true) {
            if (aroundL == es.size()) break;
            int count = 0;

            for (int aroundLOther=0; aroundLOther<aroundL; aroundLOther++) {
                if (es.get(aroundL)[0] > es.get(aroundLOther)[0]) continue;
                count++;
            }

            if (es.get(aroundL)[1] != count) {
                es.add(es.remove(aroundL));
                continue;
            }
            aroundL++;
        }

        for(int[] ess: es)
            System.out.print(Arrays.toString(ess));

        return 1;
    }
}



