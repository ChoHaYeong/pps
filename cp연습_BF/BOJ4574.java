package cp연습_BF;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4574{
    //스도쿠의 위치가 가능한지를 살펴보기 (근데 이제 스도쿠가 아니라 도미노의 위치가 가능한지 살펴뵈기)
    static int n = 9;
    static int[][] a= new int[n][n];
    static boolean[][][] c = new boolean[3][n+1][n+1]; //i=0 j번째 행에 k숫자가 있다. i=1 j번째 열에 k숫자가 있다 i=2 j번째 미니네모에 k숫자가 있다.
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static boolean[][] d = new boolean[n+1][n+1];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 1;
        while(true) {

            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());
                String p1 = st.nextToken();
                int r1 = (int) p1.charAt(0)-65;
                int c1 = Integer.parseInt(Character.toString(p1.charAt(1)))-1;
                a[r1][c1] = num;
                
                c[0][r1][num] = true;
                c[1][c1][num] = true;
                c[2][sqare(r1, c1)][num] = true;

                
                int num2 = Integer.parseInt(st.nextToken());
                String p2 = st.nextToken();
                int r2 = (int) p2.charAt(0)-65;
                int c2 = Integer.parseInt(Character.toString(p2.charAt(1)))-1;
                a[r2][c2] = num2;
                
                c[0][r2][num2] = true;
                c[1][c2][num2] = true;
                c[2][sqare(r2, c2)][num2] = true;
                
                d[num][num2] = d[num2][num] = true;

                
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=9; i++) {
                String p = st.nextToken();
                int r = (int) p.charAt(0)-65;
                int c = Integer.parseInt(Character.toString(p.charAt(1)))-1;
                a[r][c]= i;
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(a[i][j] != 0) {
                        c[0][i][a[i][j]] = true;
                        c[1][j][a[i][j]] = true;
                        c[2][sqare(i, j)][a[i][j]] = true;
                    }
                }
            }

            System.out.println("Puzzle " + idx);
            go(0);

            for(int i=0; i<n; i++) 
                Arrays.fill(a[i], 0);
            for(int i=0; i<=n; i++) {
                Arrays.fill(c[0][i], false);
                Arrays.fill(c[1][i], false);
                Arrays.fill(c[2][i], false);
                Arrays.fill(d[i], false);
            }
            
            idx++;


        }
        
    }

    static int sqare(int x, int y) {
        return (x/3)*3+(y/3);
    }

    static boolean go(int curr) {
        if(curr == 81) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++)
                    System.out.print(a[i][j]);
                System.out.println();
            }

            return true;
        }
        int x = curr / n;
        int y = curr % n;
        if(a[x][y] != 0) return go(curr+1);
        else {

            for(int k=0; k<2; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if(nx <0 || nx >= n || ny <0 || ny >=n) continue;
                if(a[nx][ny] != 0) continue;

                for(int i=1; i<=n; i++) {
                    for(int j=1; j<=n; j++) {

                        if(i == j) continue;
                        if(d[i][j]) continue;

                        if((!c[0][nx][j] && !c[1][ny][j] && !c[2][sqare(nx, ny)][j]) && 
                            (!c[0][x][i] && !c[1][y][i] && !c[2][sqare(x, y)][i])) {
                                c[0][nx][j] = c[1][ny][j] = c[2][sqare(nx, ny)][j] = true;
                                c[0][x][i] = c[1][y][i] = c[2][sqare(x, y)][i] = true;
                                a[x][y] = i;
                                a[nx][ny] = j;
                                d[i][j] = d[j][i] = true;
                                if(go(curr+1)) return true;
                                c[0][nx][j] = c[1][ny][j] = c[2][sqare(nx, ny)][j] = false;
                                c[0][x][i] = c[1][y][i] = c[2][sqare(x, y)][i] = false;
                                a[x][y] = 0;
                                a[nx][ny] = 0;
                                d[i][j] = d[j][i] = false;
                        }
    
                        
                    }
                }
                

            }
            
        }

        return false;
    }
}
