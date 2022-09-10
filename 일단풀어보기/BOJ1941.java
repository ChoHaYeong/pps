package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1941 {
    static char[][] classes;
    static char[] arr;
    static int ans = 0;
    static boolean[][] visited;
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //  StringTokenizer st = new StringTokenizer(br.readLine());
        classes = new char[5][5];
        visited = new boolean[5][5];
        arr = new char[7];

        for(int i=0; i<5; i++) {
            String str = br.readLine();
            for(int j=0; j<5; j++)
                classes[i][j] = str.charAt(j);
        }

        dfs(0);
        /**
         * 화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.

=> 일단 인접한 7명고르고 이다솜파 4명미만이면 거르기
         */

         System.out.println(ans);
    }

    static void dfs(int curr) {
        if(curr == 7) {
            int cnt = 0;
            for(char a: arr){
                System.out.print(a + " ");
                if(a == 'S')
                    cnt++;
            }
            System.out.println();

            if(cnt >= 4)
                ans++;

            return ;
        }

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++){
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    arr[curr] = classes[i][j];
                   // System.out.println(arr[curr]);
                    dfs(curr+1);
                    visited[i][j] = false;
                }
            }
        }

    }

    static boolean isNear(int x, int y) { //7명의 자리는 서로 가로나 세로로 반드시 인접
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >=0 && nx <5 && ny <5) {
              //  if(!visited[nx][ny]){
                 //   visited[nx][ny] = true;
                    return true;
                //}
                    //return true;
            }
        }

        return false;
    }
}
