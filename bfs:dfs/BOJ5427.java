import java.util.*;
import java.io.*;

public class BOJ5427 {
    static int T, w, h;
    static char[][] building;
    static boolean[][] visited, visited2;
    static int[][] dist, fireDist;
    static Queue<Position> queue ;
    static Queue<Position> queue2 ;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            building = new char[h][w];
            //방문기록 초기화
            visited = new boolean[h][w];
            visited2 = new boolean[h][w];
            //거리 초기화
            dist = new int[h][w];
            fireDist = new int[h][w];
            //queue 초기화
            queue = new LinkedList<>();
            queue2 = new LinkedList<>();
            // for(int j=0; j<dist.length; j++) {
            //   //  Arrays.fill(dist[j], -1);
            //    // Arrays.fill(fireDist[j], -1);
            // }

            for(int j=0; j<h; j++) {
                String str = br.readLine();
                for(int k=0; k<w; k++) {
                    building[j][k] = str.charAt(k);
                    if(building[j][k] == '*') {
                        queue.add(new Position(j, k));
                        visited[j][k] = true;
                    }
                    if(building[j][k] == '@') {
                        queue2.add(new Position(j, k));
                        visited2[j][k] = true;
                    }
                }
            }

            //먼저 불이 퍼져가는 시간 구하기 
            moveFire();

            // for(int j=0; j<h; j++) {
            //     for(int k=0; k<w; k++) {
            //         System.out.print(fireDist[j][k] + " ");
            //     }
            //     System.out.println();
            // }

            escape();

          

        }

    }

    static void moveFire() {
        while(!queue.isEmpty()) {
            Position out = queue.poll();
           // fireDist[out.x][out.y] = 0;

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                else if(visited[nx][ny] || building[nx][ny] == '#') continue;
                else {
                    queue.add(new Position(nx, ny));
                    visited[nx][ny] = true;

                    if(fireDist[nx][ny] != 0)
                        fireDist[nx][ny] = Math.min(fireDist[nx][ny], fireDist[out.x][out.y] + 1);
                    else
                        fireDist[nx][ny] = fireDist[out.x][out.y] + 1;
                }
            }
        }
    }

    static void escape() { //불보다 늦게 도착할 때도 넘어가야쥐..
        boolean flag = false;

        while(!queue2.isEmpty()) {
            Position out = queue2.poll();
            //dist[out.x][out.y] = 0;

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    System.out.println(dist[out.x][out.y]+1);
                    flag = true;
                    return ;
                }
                else if(visited2[nx][ny] || building[nx][ny] == '#') continue;
               // else if(fireDist[nx][ny] == -1) continue;
               else if(fireDist[nx][ny] != 0 && fireDist[nx][ny] <= dist[out.x][out.y]+1) continue;
                else {
                    queue2.add(new Position(nx, ny));
                    visited2[nx][ny] = true;
                    dist[nx][ny] = dist[out.x][out.y] + 1;
                }
            }

        }

        if(!flag)
            System.out.println("IMPOSSIBLE");
        return ;

    }
    
}
