import java.util.*;
import java.io.*;

public class BOJ16920 {
    static int N, M, P, cnt;
    static char[][] board;
    static int[] S;
    static boolean[][] visited;
    static Queue<Position> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M];
        S = new int[P+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=P; i++)
            S[i] = Integer.parseInt(st.nextToken());
        
        cnt = 0;
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == '.')
                    cnt++;

                
            }
        }

        //int k = 1;

        while(true) {

            for(int k=1; k<=P; k++) {
                for(int i=0; i<N; i++) {
                    for(int j=0; j<M; j++) {
                        if(board[i][j] - '0' == k && !visited[i][j]) {
                            queue.add(new Position(i, j));
                            visited[i][j] = true;
                        }
                    }
    
                }

                bfs(k);
            }
            // for(int i=0; i<N; i++) {
            //     for(int j=0; j<M; j++) {
            //         if(board[i][j] - '0' == k && !visited[i][j]) {
            //             queue.add(new Position(i, j));
            //             visited[i][j] = true;
            //         }
            //     }

            //     bfs(k);
            //     if(k >= P)
            //         k = 1;
            //     else
            //         k++;

            // }

            
            if(cnt == 0)
                break;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

    }

    static void bfs(int num) {
        // Queue<Position> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // queue.add(new Position(x, y));
        // visited[x][y] = true;

        while(!queue.isEmpty()) {
            Position out = queue.poll();
           // System.out.println(out.x + " , " + out.y);
            for(int i=1; i<=S[num]; i++) { //이동할 수 있는 칸
                for(int j=0; j<4; j++) {
                    int nx = out.x + dx[j]*i;
                    int ny = out.y + dy[j]*i;

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(visited[nx][ny]) continue;
                    if(board[nx][ny] == '#') continue; //벽
                    if(board[nx][ny] != '.' && (char) (num + '0') != board[nx][ny]) { // 다른 플레이어의 성일 때
                        // System.out.println(num);
                        // System.out.println(board[nx][ny] + "==================");
                        continue;
                    }

                    if((char) (num + '0') == board[nx][ny]) { //기존에 주어진 내 성 
                        queue.add(new Position(nx, ny));
                        visited[nx][ny] = true;
                    }
                    if(board[nx][ny] == '.') {
                        board[nx][ny] = (char) (num + '0');
                        cnt--;

                        System.out.println(out.x + " , " + out.y  + " => " + nx + ", "+ ny + " / 플레이어 " + num);
                        for(int k=0; k<N; k++) {
                            for(int l=0; l<M; l++) {
                                System.out.print(board[k][l]);
                            }
                            System.out.println();
                        }

                        // for(int k=0; k<N; k++) {
                        //     for(int l=0; l<M; l++) {
                        //         System.out.print(visited[k][l]);
                        //     }
                        //     System.out.println();
                        // }
                    }
                }
            }
        }
    }
    
}
