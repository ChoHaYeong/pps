import java.util.*;
import java.io.*;

public class BOJ14502 {
    static int N, M, total, max = 0;
    static int[][] map, newMap, arr;
    static boolean[][] visited, visitedBFS;
    //static Queue<Position> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        newMap = new int[N][M];
        visited = new boolean[N][M];
        //arr = new int[4][2];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0 ;
        for(int x1=0; x1<N; x1++) {
            for(int y1=0; y1<M; y1++) {
                if(map[x1][y1] != 0) continue;
                for(int x2=0; x2<N; x2++) {
                    for(int y2=0; y2<M; y2++) {
                        if(map[x2][y2] != 0) continue;
                        for(int x3=0; x3<N; x3++) {
                            for(int y3=0; y3<M; y3++) {
                                if(map[x3][y3] != 0) continue;
                                
                                if(x1 == x2 && y1 == y2) continue;
                                if(x1 == x3 && y1 == y3) continue;
                                if(x2 == x3 && y2 == y3) continue;

                                map[x1][y1] = 1;
                                map[x2][y2] = 1;
                                map[x3][y3] = 1;

                                int cur = bfs();
                                if(answer < cur) answer = cur;

                                map[x1][y1] = 0;
                                map[x2][y2] = 0;
                                map[x3][y3] = 0;
                            }
                        }
                    }
                }
            }
        }


        //dfs(0);
        System.out.println(answer);
    }
    
    // static void dfs(int curr) {
    //     if(curr == 3) { //3개의 벽을 선택함
    //         total = N * M;
    //         newMap = new int[N][M];
    //         queue = new LinkedList<>();
    //         visitedBFS = new boolean[N][M];

    //         for(int i=0; i<N; i++) {
    //             for(int j=0; j<M; j++) {
    //                 newMap[i][j] = map[i][j];
    //                 if(newMap[i][j] == 2){ //바이러스면 queue에 넣기, 안전거리개수도 감소
    //                     queue.add(new Position(i, j));
    //                     visitedBFS[i][j] = true;
    //                     total--;
    //                 } if(newMap[i][j] == 1){ //벽이 안전거리는 아니니까
    //                     total--;
    //                 }
    //             }
    //         }

    //         for(int i=0; i<curr; i++) {
    //             //System.out.println("벽 건설 좌표 (" + arr[i][0] + " , " +arr[i][1] +")");
    //             newMap[arr[i][0]][arr[i][1]] = 1;
    //             total--;
    //         }

    //         // System.out.println("벽 건설 ======================== > ");
    //         // for(int i=0; i<N; i++) {
    //         //     for(int j=0; j<M; j++) {
    //         //         System.out.print(newMap[i][j]);
    //         //     }
    //         //     System.out.println();
    //         // }
            

    //         bfs();
    //         int cnt = 0;
    //         //System.out.println("total " + total);
    //         // System.out.println();
    //         // for(int i=0; i<N; i++) {
    //         //     for(int j=0; j<M; j++) {
    //         //         System.out.print(newMap[i][j]);
    //         //     }
    //         //     System.out.println();
    //         // }

    //         // System.out.println("바이러스가 퍼진 후 ======================== > ");
    //       //  System.out.println("cnt " + cnt);
    //         max = Math.max(max, total);
    //         return ;

    //     }   

    //     for(int i=0; i<N; i++) {
    //         for(int j=0; j<M; j++) {
    //             if(!visited[i][j] && map[i][j] == 0) { //빈칸에만 벽 세울 수 있으니까 
    //                 visited[i][j] = true;
    //                 arr[curr][0] = i; // 벽을 세울 x좌표
    //                 arr[curr][1] = j; // 벽을 세울 y좌표

    //                 //System.out.println("???? 벽 건설 좌표 (" + arr[curr][0] + " , " +arr[curr][1] +")");
    //                 dfs(curr+1);
    //                 visited[i][j] = false;
    //             }
    //         }
    //     }
    // }

    static int bfs() {
        Queue<Position> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                newMap[i][j] = map[i][j];
                if(newMap[i][j] == 2)
                    queue.add(new Position(i, j));
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while(!queue.isEmpty()) {
            Position out = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(newMap[nx][ny] == 0) {

                    queue.add(new Position(nx, ny));
                    newMap[nx][ny] = 2;
                }
            }
        }
        
        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(newMap[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }
}
