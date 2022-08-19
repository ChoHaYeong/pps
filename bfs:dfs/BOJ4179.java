// import java.util.*;
// import java.io.*;


// public class BOJ4179{
//     static int R, C;
//     static boolean[][] visited;
//     static char[][] maze;
//     static int[][] dist;
//     static int min = Integer.MAX_VALUE;
//     static int[][] fire;
//     static boolean flag = false;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         R = Integer.parseInt(st.nextToken());
//         C = Integer.parseInt(st.nextToken());

//         maze = new char[R][C];
//         visited = new boolean[R][C]; 
//         dist = new int[R][C];
//         fire = new int[R][C];

//         for(int i=0; i<R; i++) {
//             String str = br.readLine();
//             for(int j=0; j<C; j++) {
//                 maze[i][j] = str.charAt(j);
//             }
//         }

//         for(int i=0; i<R; i++) {
//             for(int j=0; j<C; j++) {
//                 if(maze[i][j] == 'F' && !visited[i][j]) {
//                     bfs(i, j, maze[i][j]);
//                 }
//             }
//         }

//         for(int i=0; i<R; i++) {
//             for(int j=0; j<C; j++) {
//                 visited[i][j] = false;
//             }
//             //System.out.println();
//         }



//         for(int i=0; i<R; i++) {
//             for(int j=0; j<C; j++) {
//                 if(maze[i][j] == 'J' && !visited[i][j]) {
//                     bfs(i, j, maze[i][j]);
//                 }
//             }
//         }
        
        



//         if(!flag)
//             System.out.println("IMPOSSIBLE");
//         else 
//             System.out.println(min);


//     }

//     static void bfs(int x, int y, char what) {
//         Queue<Position> queue = new LinkedList<>();
//         int[] dx = {-1, 0, 1, 0};
//         int[] dy = {0, -1, 0, 1};

//         queue.add(new Position(x, y));
//         visited[x][y] = true;

//         while(!queue.isEmpty()) {
//             Position out = queue.poll();
//             for(int i=0; i<4; i++) {
//                 int nx = out.x + dx[i];
//                 int ny = out.y + dy[i];

//                 if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
//                 else if(visited[nx][ny] || maze[nx][ny] == '#') continue;
//                 else {

//                     if(what == 'J') {
//                         dist[nx][ny] = dist[out.x][out.y] + 1;
//                         if(fire[nx][ny] != 0 && dist[nx][ny] >= fire[nx][ny]){
//                             continue;

//                         }


//                         queue.add(new Position(nx, ny));
//                         visited[nx][ny] = true;                    

//                         if(nx == R-1 || ny == C-1){
//                             flag = true;

//                             min = dist[nx][ny]+1;
//                             return ;
//                         }
//                     }

//                     if(what == 'F') {

//                         queue.add(new Position(nx, ny));
//                         visited[nx][ny] = true;  
//                         fire[nx][ny] = fire[out.x][out.y] + 1;
//                     }
                    
//                 }
//             }
             
//         }

//     }
    
// }


import java.util.*;
import java.io.*;


public class BOJ4179{
    static int R, C;
    static boolean[][] visited;
    static char[][] maze;
    static int[][] dist;
    static int min = Integer.MAX_VALUE;
    static int[][] fire;
    static boolean flag = false;
    static Queue<Position> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maze = new char[R][C];
        visited = new boolean[R][C]; 
        dist = new int[R][C];
        fire = new int[R][C];

        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                maze[i][j] = str.charAt(j);
                if(maze[i][j] == 'F') {
                    queue.add(new Position(i, j));
                    visited[i][j] = true;
                }
            }
        }
        System.out.println("queue's size " + queue.size());
        bfsF();

        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(fire[i][j] + " ");
            }

            System.out.println();
        }
        System.out.println();

        //visited 방문여부 초기화
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                visited[i][j] = false;
            }
            //System.out.println();
        }
        //queue 초기화
        queue = new LinkedList<>();

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(maze[i][j] == 'J') {
                    queue.add(new Position(i, j));
                    visited[i][j] = true;
                }
            }
        }
        
        bfsJ();


        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(dist[i][j] + " ");
            }

            System.out.println();
        }


        // if(!flag)
        //     System.out.println("IMPOSSIBLE");
        // else 
            System.out.println(min);


    }

    static void bfsF() {
      //  Queue<Position> queue = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

      // queue.add(new Position(x, y));
      //  visited[x][y] = true;


      

        while(!queue.isEmpty()) {
            Position out = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                System.out.println("nx : " + nx + " ny : " + ny);

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                else if(visited[nx][ny] || maze[nx][ny] == '#' ) continue;
                else {
                    queue.add(new Position(nx, ny));
                    visited[nx][ny] = true;  
                    fire[nx][ny] = fire[out.x][out.y] + 1;
                    System.out.println(fire[nx][ny] + " nx : " + nx + " ny : " + ny);
                }
            }
             
        }

        System.out.println("IMPOSSIBLE");

    }

    static void bfsJ() {
        //  Queue<Position> queue = new LinkedList<>();
          int[] dx = {-1, 0, 1, 0};
          int[] dy = {0, -1, 0, 1};
  
        // queue.add(new Position(x, y));
        //  visited[x][y] = true;
  
          while(!queue.isEmpty()) {
              Position out = queue.poll();
              for(int i=0; i<4; i++) {
                  int nx = out.x + dx[i];
                  int ny = out.y + dy[i];
  
                  if(nx < 0 || ny < 0 || nx >= R || ny >= C) {
                     // flag = true;
                      min = dist[out.x][out.y] + 1;
                      return ;
                  }
                  else if(visited[nx][ny] || maze[nx][ny] == '#' || maze[nx][ny] == 'F') continue;
                  else if(fire[out.x][out.y] != 0 && dist[out.x][out.y]+1 >= fire[nx][ny]) continue;
                  else {
                      queue.add(new Position(nx, ny));
                      visited[nx][ny] = true;  

                        dist[nx][ny] = dist[out.x][out.y] + 1;
                  }
              }
               
          }
  
      }
    
}

