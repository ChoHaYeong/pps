import java.util.*;
import java.io.*;

class Mirror implements Comparable<Mirror>{
    int x, y, cnt, dir;

    Mirror(int x, int y, int cnt, int dir) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.dir = dir;
    }

    @Override
    public int compareTo(Mirror m) {6
        return this.cnt - m.cnt;
    }
}

public class BOJ6087 {
    static int W, H, endX, endY, min = Integer.MAX_VALUE;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static PriorityQueue<Mirror> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new boolean[H][W];
        dist = new int[H][W];

        boolean isIn = true;
        for(int i=0; i<H; i++) {
            String str = br.readLine();
            for(int j=0; j<W; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'C' && isIn) {
                    queue.add(new Mirror(i, j, 0, -1)); //일단 방향을 위로 보고 있다고 생각하자 ..
                    visited[i][j] = true;
                    isIn = false;
                }
                if(map[i][j] == 'C' && !isIn) {
                    endX = i;
                    endY = j;
                }
            }
        }

        bfs();
        //System.out.println(min);


    }

    static void bfs() {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while(!queue.isEmpty()) {
            Mirror out = queue.poll();
          //  System.out.println(out.x + " , " + out.y + " cnt ; " + out.cnt + " / dir: " + out.dir);

            if(out.x == endX && out.y == endY) {
				//min = Math.min(min, out.cnt);
                System.out.println(out.cnt);
				return ;
			}

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];
                int nc = out.cnt;
                int nd = out.dir;

                if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if(map[nx][ny] == '*') continue;
               // if(visited[nx][ny]) continue;
                if(nd != -1 && nd != i ) { //방향이 다를 때 거울 개수 증가
                   // System.out.println("before " + out.cnt);
                    nc ++;
                   // System.out.println("after " + nc);
                }   

               // if(dist[nx][ny] < nc) continue;
                if(!visited[nx][ny]) { //아직 방문 안했으면
                    visited[nx][ny] = true;
                    dist[nx][ny] = nc;
                    queue.add(new Mirror(nx, ny, nc, i)); //새로운 방향
                } else if(dist[nx][ny] >= nc) {
                    visited[nx][ny] = true;
                    dist[nx][ny] = nc;
                    queue.add(new Mirror(nx, ny, nc, i)); //새로운 방향
                }
            }
        }
    }
    
}
