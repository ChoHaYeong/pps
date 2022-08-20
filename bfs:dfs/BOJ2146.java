
// import java.util.*;
// import java.io.*;

// public class BOJ2146 {
//     /*
//      * 두 대륙을 연결하는 가장 짧은 다리 구하기
//         1. 서로 다른 대륙임을 어떻게 구분하는가
//             서로 다른 대륙임을 나타내는 배열을 하나 만든다. 
//         2. 서로 다른 대륙임을 나타내는 배열에서 bfs를 진행. 일단 상하좌우 탐색했을 때 같은 숫자만 있으면 그냥 리턴 / 다른 숫자를 만날떄까지 탐색해가기

//      */
//     static int N, min = Integer.MAX_VALUE;
//     static int[][] map, dist;
//     static boolean[][] visited;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         N = Integer.parseInt(br.readLine());

//         map = new int[N][N];
//         dist = new int[N][N];
//         visited = new boolean[N][N];

//         for(int i=0; i<N; i++) {
//             StringTokenizer st = new StringTokenizer(br.readLine());
//             for(int j=0; j<N; j++) {
//                 map[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }

//         int idx = 1;
//         for(int i=0; i<N; i++) {
//             for(int j=0; j<N; j++) {
//                 if(map[i][j] == 1 && !visited[i][j]){
//                     makeIsland(i, j, idx);
//                     idx++;
//                 }
//             }
//         }   


//         // System.out.println();
//         // for(int i=0; i<N; i++) {
//         //     for(int j=0; j<N; j++) {
//         //         System.out.print(map[i][j] + " ");
//         //     }
//         //     System.out.println();
//         // }

//         //방문여부 초기화
//         for(int i=0; i<N; i++) {
//             for(int j=0; j<N; j++) {
//                 visited[i][j] = false;
//             }
//         }

//         //for(int k=1; k<=idx; k++) {
//             // for(int i=0; i<N; i++) {
//             //     for(int j=0; j<N; j++) {
//             //         visited[i][j] = false;
//             //         dist[i][j] = 0;
//             //     }
//             // }

//             for(int i=0; i<N; i++) {
//                 for(int j=0; j<N; j++) {
//                     if(map[i][j] != 0 ){
//                         bfs(i, j);
//                     }
//                 }
//             }

//             // System.out.println();
//             // for(int i=0; i<N; i++) {
//             //     for(int j=0; j<N; j++) {
//             //         System.out.print(dist[i][j] + " ");
//             //     }
//             //     System.out.println();
//             // }
//        // }


//         // System.out.println();
//         // for(int i=0; i<N; i++) {
//         //     for(int j=0; j<N; j++) {
//         //         System.out.print(dist[i][j] + " ");
//         //     }
//         //     System.out.println();
//         // }

//         System.out.println(min);


//     }

//     static void makeIsland(int x, int y, int idx) {
//         Queue<Position> queue = new LinkedList<>();
//         int[] dx = {-1, 0, 1, 0};
//         int[] dy = {0, -1, 0, 1};

//         queue.add(new Position(x, y));
//         visited[x][y] = true;
//         map[x][y] = idx;

//         while(!queue.isEmpty()) {
//             Position out = queue.poll();
//             for(int i=0; i<4; i++) {
//                 int nx = out.x + dx[i];
//                 int ny = out.y + dy[i];

//                 if(nx<0 || ny<0 || nx >=N || ny >=N) continue;
//                 else if(visited[nx][ny] || map[nx][ny] == 0) continue;
//                 else {
//                     queue.add(new Position(nx, ny));
//                     visited[nx][ny] = true;
//                     map[nx][ny] = idx;
//                 }
//             }
//         }
//     }

//     static void bfs(int x, int y) { //육지를 무시해야하는거 아닐까 ,, 바다인 경우만 탐색을 하다가 (거리를 구해가면서) 육지를 만났을 때, 다른 육지라면, map[nx][ny] != 0 && map[x][y] != map[nx][ny] 일 때 그 최소거리를 구하는 것.. 
//         Queue<Position> queue = new LinkedList<>();
//         int[] dx = {-1, 0, 1, 0};
//         int[] dy = {0, -1, 0, 1};

//         queue.add(new Position(x, y));
//         visited[x][y] = true;
//        // map[x][y] = idx;

//         while(!queue.isEmpty()) {
//             Position out = queue.poll();
//             //boolean isIn = true;

//             for(int i=0; i<4; i++) {
//                 int nx = out.x + dx[i];
//                 int ny = out.y + dy[i]; 

//                 if(nx<0 || ny<0 || nx >=N || ny >=N) continue;
//                 if(visited[nx][ny] || map[x][y] == map[nx][ny]) continue; 
//                 //if(map[nx][ny] == 0) continue;
//                 // else if(map[x][y] == map[nx][ny]) continue;
//                 if(map[nx][ny] != 0 && map[x][y] != map[nx][ny]) { 
//                     //System.out.println(" ? " + dist[out.x][out.y] + "nx " +nx + " ny" + ny);
//                    // System.out.println("b) min : " + min + " nx : " + nx + " ny " + ny);
//                     min = Math.min(min, dist[out.x][out.y]);
//                    // System.out.println("a) min : " + min+ " nx : " + nx + " ny " + ny);
//                     return ;
//                 }
//                 //else {
//                     // if(map[out.x][out.y] != map[nx][ny])
//                     //     isIn = false;    

//                     queue.add(new Position(nx, ny));
//                     visited[nx][ny] = true;
//                     dist[nx][ny] = dist[out.x][out.y] + 1;
//                // }
//             }

//             // if(isIn)
//             //     return ;
//         }

//         //방문여부 초기화
//         for(int i=0; i<N; i++) {
//             for(int j=0; j<N; j++) {
//                 visited[i][j] = false;
//             }
//         }
//     }
// }

import java.util.*;
import java.io.*;


public class BOJ2146{
    /*
     * 두 대륙을 연결하는 가장 짧은 다리 구하기
        1. 서로 다른 대륙임을 어떻게 구분하는가
            서로 다른 대륙임을 나타내는 배열을 하나 만든다. 
        2. 서로 다른 대륙임을 나타내는 배열에서 bfs를 진행. 일단 상하좌우 탐색했을 때 같은 숫자만 있으면 그냥 리턴 / 다른 숫자를 만날떄까지 탐색해가기

     */
    static int N, min = Integer.MAX_VALUE;
    static int[][] map, dist;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dist = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && !visited[i][j]){
                    makeIsland(i, j, idx);
                    idx++;
                }
            }
        }   


        // System.out.println();
        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<N; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        //방문여부 초기화
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                visited[i][j] = false;
            }
        }

        //for(int k=1; k<=idx; k++) {
            // for(int i=0; i<N; i++) {
            //     for(int j=0; j<N; j++) {
            //         visited[i][j] = false;
            //         dist[i][j] = 0;
            //     }
            // }

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j] != 0 ){
                        bfs(i, j);
                    }
                }
            }

            // System.out.println();
            // for(int i=0; i<N; i++) {
            //     for(int j=0; j<N; j++) {
            //         System.out.print(dist[i][j] + " ");
            //     }
            //     System.out.println();
            // }
       // }


        // System.out.println();
        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<N; j++) {
        //         System.out.print(dist[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(min);


    }

    static void makeIsland(int x, int y, int idx) {
        Queue<Position> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        queue.add(new Position(x, y));
        visited[x][y] = true;
        map[x][y] = idx;

        while(!queue.isEmpty()) {
            Position out = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx<0 || ny<0 || nx >=N || ny >=N) continue;
                else if(visited[nx][ny] || map[nx][ny] == 0) continue;
                else {
                    queue.add(new Position(nx, ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = idx;
                }
            }
        }
    }

    static void bfs(int x, int y) { //육지를 무시해야하는거 아닐까 ,, 바다인 경우만 탐색을 하다가 (거리를 구해가면서) 육지를 만났을 때, 다른 육지라면, map[nx][ny] != 0 && map[x][y] != map[nx][ny] 일 때 그 최소거리를 구하는 것.. 
        Queue<Position> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        queue.add(new Position(x, y));
        visited[x][y] = true;
       // map[x][y] = idx;

        while(!queue.isEmpty()) {
            Position out = queue.poll();
            //boolean isIn = true;

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i]; 

                if(nx<0 || ny<0 || nx >=N || ny >=N) continue;
                else if(visited[nx][ny] || map[x][y] == map[nx][ny]) continue; 
                //if(map[nx][ny] == 0) continue;
                // else if(map[x][y] == map[nx][ny]) continue;
                else if(map[nx][ny] != 0 && map[x][y] != map[nx][ny]) { 
                    //System.out.println(" ? " + dist[out.x][out.y] + "nx " +nx + " ny" + ny);
                   // System.out.println("b) min : " + min + " nx : " + nx + " ny " + ny);
                    min = Math.min(min, dist[out.x][out.y]);
                    while(!queue.isEmpty()) queue.poll();
                   // System.out.println("a) min : " + min+ " nx : " + nx + " ny " + ny);
                    return ;
                }
                else {
                    // if(map[out.x][out.y] != map[nx][ny])
                    //     isIn = false;    

                    queue.add(new Position(nx, ny));
                    visited[nx][ny] = true;
                    dist[nx][ny] = dist[out.x][out.y] + 1;
                }
            }

            // if(isIn)
            //     return ;
        }
        
        //방문여부 초기화
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                visited[i][j] = false;
            }
        }
    }
}

