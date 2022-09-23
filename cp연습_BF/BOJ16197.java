package cp연습_BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16197 {
    static int N, M, cnt = Integer.MAX_VALUE;
    static char[][] board;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean flag = true;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        int fx = 0, fy = 0, sx = 0, sy = 0;
        boolean first = true;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'o') {
                    if(first) {
                        fx = i; 
                        fy = j;
                        first = false;
                    } else {
                        sx = i;
                        sy = j;
                    }
                }
            }
        }
        go(fx, fy, sx, sy, 0);
        if(!flag) System.out.println(-1);
        else System.out.println(cnt);
    }

    static void go(int fx, int fy, int sx, int sy, int curr) {

        if(isBound(fx, fy) || isBound(sx, sy)) { //(isBound(fx, fy) && !isBound(sx, sy)) || (!isBound(fx, fy) && isBound(sx, sy))
            //동전 하나만 벗어남
            cnt = Math.min(cnt, curr);
            return ;
        }  
        
        if((!isBound(fx, fy) && !isBound(sx, sy))|| curr > 10) {
            System.out.println(isBound(fx, fy));
            System.out.println(isBound(sx, sy));
            System.out.println(curr);
            flag = false;
            return ;
        }

        for(int i=0; i<4; i++)  {
            int nfx = fx + dx[i];
            int nfy = fy + dy[i];
            int nsx = sx + dx[i];
            int nsy = sy + dy[i];

             

            if(isBound(nfx, nfy) && isBound(nsx, nsy)){
                if(board[nfx][nfy] == '#') {
                    nfx = fx;
                    nfy = fy;
                }
    
                if(board[nsx][nsy] == '#') {
                    nsx = sx;
                    nsy = sy;
                }
            }

            go(nfx, nfy, nsx, nsy, curr+1);

            

        }
    }

    static boolean isBound(int x, int y ) {
        if(x >=0 && x<N && y>=0 && y<M) return true;
        else return false;
    }
}
