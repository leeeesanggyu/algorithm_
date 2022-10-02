package code;

public class test3_Ex {
    static public int answer = Integer.MIN_VALUE;
    static public int[][] board = new int[][]{
            {1, -7, -2, 1, -1},
            {2, 3, 0, -1, -2},
            {1, -1, 6, -1, -2},
            {-1, 1, -2, 0, 4},
            {-10, 5, -3, -1, 1}
    };

//    static public int[][] board = new int[][]{
//            {1, -5},
//            {2, 0}
//    };

    static int x_wall = board[0].length - 1;
    static int y_wall = board.length - 1;

    public static void main(String[] args) throws Exception {
        dfs(0, 0, board[0][0]);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int score) {
        System.out.println("x : " + x + " y : " + y + " score :" + score);
        if (x == x_wall && y == y_wall) {
            System.out.println("score : " + score);
            if (score > answer) answer = score;
        }

        if (x < x_wall) {   // right
            if (board[x + 1][y] == 0 && score < 0) {
                dfs(x + 1, y, score * -1);
            } else {
                dfs(x + 1, y, score + board[x + 1][y]);
            }
        }

        if (y < y_wall) {   // down
            if (board[x][y + 1] == 0 && score < 0) {
                dfs(x, y + 1, score * -1);
            } else {
                dfs(x, y + 1, score + board[x][y + 1]);
            }
        }

    }

}