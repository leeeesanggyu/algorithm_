package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 - 10026: 적록색약
 * https://www.acmicpc.net/problem/10026
 */
public class Baekjoon10026 {

    static int n;
    static String s;
    static char map[][];
    static boolean visited[][];
    static int dx[] = {-1,0,0,1};
    static int dy[] = {0,1,-1,0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i=0; i<n; i++){
            s = br.readLine();
            for (int j=0; j<n; j++){
                map[i][j] = s.charAt(j);
            }
        }

        // normal 인 경우
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        int normal_cnt = cnt;
        cnt=0;

        visited = new boolean[n+1][n+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]=='G'){
                    map[i][j] = 'R';
                }
            }
        }

        // 색약인 경우
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        int abnormal_cnt = cnt;
        System.out.println(normal_cnt + " " + abnormal_cnt);

    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        char tmp_char = map[x][y]; // R
        for(int i=0; i<4; i++){
            int new_x = x+dx[i];
            int new_y = y+dy[i];

            if (new_x<0 || new_y<0 || new_x>n || new_y>n){
                continue;
            }

            if (!visited[new_x][new_y] && map[new_x][new_y] == tmp_char){
                dfs(new_x, new_y);
            }
        }
    }
}
