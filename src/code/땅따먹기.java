package code;

public class 땅따먹기 {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new int[][]{
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        }));
    }

    private static int solution(int[][] board) {
        for(int i=1; i< board.length; i++) {
            board[i][0] += Math.max(board[i-1][0], Math.max(board[i-1][1], board[i-1][2]));
            board[i][1] += Math.max(board[i-1][1], Math.max(board[i-1][2], board[i-1][3]));
            board[i][2] += Math.max(board[i-1][0], Math.max(board[i-1][2], board[i-1][3]));
            board[i][3] += Math.max(board[i-1][0], Math.max(board[i-1][1], board[i-1][3]));
        }
        return Math.max(board[board.length -1][3], Math.max(board[board.length - 1][2], Math.max(board[board.length - 1][0], board[board.length - 1][1])));
    }
}

