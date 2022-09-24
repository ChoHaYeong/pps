package cp연습_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2580{
    static int n = 9;
    static int[][] a = new int[n][n];
    static boolean[][][] c = new boolean[3][n+1][n+1]; // c[i][j][k] i=0 이면 j번째 행에 k숫자가 있는지, i=1이면 j번째 열에 k숫자가 있는지, i=2이면 j번째 미니네모에 k숫자가 있는지
    public static void main(String[] args) throws IOException{
        //파라미터로 넘기는 것 몇번째인지
        //curr == 81
        //불가능한 경우 - 없음 (스도쿠 판을 규칙대로 채울 수 없는 경우의 입력은 주어지지 않는다.고 했기 때문에)
        //1~9까지 넣어보면서 가능한지 확인하기
            //가능한지 확인한다는 것은 ? 가로, 세로, 미니 네모가 false일때 
        //가능하면 go(curr+1)

        //++++++++after
        //불가능한 경우라기보단, 확인하지 않아도 되는 경우도 있음 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                //0이 아니면 false
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] != 0) {
                    c[0][i][a[i][j]] = true;
                    c[1][j][a[i][j]] = true;
                    c[2][sqare(i, j)][a[i][j]] = true;
                }
                
            }
        }

        go(0);

    }

    static void go(int curr) {
        if(curr == 81) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) 
                    System.out.print(a[i][j] + " ") ;
                System.out.println();
            }

            return ;
        }

        int x = curr / n;
        int y = curr % n;
        if(a[x][y] != 0) go(curr+1); 
        else {
            for(int i=1; i<=9; i++){
                if(!c[0][x][i] && !c[1][y][i] && !c[2][sqare(x, y)][i]){
                    c[0][x][i] = c[1][y][i] =  c[2][sqare(x, y)][i] = true;
                    a[x][y] = i;
                    go(curr+1);
                    a[x][y] = 0;
                    c[0][x][i] = c[1][y][i] =  c[2][sqare(x, y)][i] = false;
                }
            }
        }
        

    }

    static int sqare(int x, int y) {
        return (x/3)*3+(y/3);
    }
}
