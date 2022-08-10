package codeplus_2;

import java.io.*;
import java.util.*;

public class BOJ3085 {
    static char[][] board;
    static boolean[][] visited;
    static int N;
    static int max = 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        widthMax ();
        heightMax ();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j]) 
                    bfs(i, j);
            }
        }

        System.out.println(max);
    }

    static void bfs(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Position out = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                else if(visited[nx][ny] || (board[out.x][out.y] == board[nx][ny])) continue;
                else {
                    //사탕색 교환하기
                    char temp = board[out.x][out.y] ;
                    board[out.x][out.y] = board[nx][ny];
                    board[nx][ny] = temp;

                    widthMax ();
                    heightMax ();

                    //원상복귀
                    char temp2 = board[out.x][out.y] ;
                    board[out.x][out.y] = board[nx][ny];
                    board[nx][ny] = temp2;


                }
            }
        }
    }

    static void widthMax () {
        for(int j=0; j<N; j++) {

            int count = 1;
            for(int k=0; k<N-1; k++) {
                if(board[j][k] == board[j][k+1]){

                    count++;
                    if(max < count)
                        max = count;
                }
                else
                    count=1;
            }
        }
    }

    static void heightMax () {
        for(int j=0; j<N; j++) {

            int count = 1;
            for(int k=0; k<N-1; k++) {
                if(board[k][j] == board[k+1][j]){

                    count++;
                    if(max < count)
                        max = count;
                }
                else
                    count=1;
            }
        }
    }
    
}

class Position{
    int x;
    int y;
    
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
