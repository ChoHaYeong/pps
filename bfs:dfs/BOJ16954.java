import java.io.*;
import java.util.*;

public class BOJ16954 {
    static char[][] c;
    static int n = 8;
    static class Point{
        int x, y, t;
        Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    static boolean[][][] visited;
    static Queue<Point> queue = new LinkedList<>();
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, 0};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1, 0};
    static boolean flag = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        c = new char[n][n];
        visited = new boolean[n][n][9];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<n; j++) {
                c[i][j] = str.charAt(j);
            }
        }
        c[7][0] = 'o'; //욱제의 캐릭터는 가장 왼쪽 아랫 칸에 있고 'o' : 욱제의 위치를 나타냄
        queue.add(new Point(7, 0, 0));
        visited[7][0][0] = true;

        bfs();
        if(!flag) System.out.println(0);
    }

    static void bfs() {
        while(!queue.isEmpty()) {
            Point out = queue.poll();
            if(out.x == 0 && out.y == 7) {
                flag = true;
                System.out.println(1);
                return ;
            }
            //욱제가 이동
            for(int i=0; i<9; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];
                int nt = Math.min(out.t+1, 8);

                if(nx >= 0 && nx < n && ny >=0 && ny < n) {
                    if(nx-out.t >=0 && c[nx-out.t][ny] == '#') continue;
                    if(nx-(out.t+1) >=0 && c[nx-(out.t+1)][ny] == '#') continue;

                    if(!visited[nx][ny][nt]) { //다음 시간에 이동할위치에 아직 방문 안했으면
                        queue.add(new Point(nx, ny, nt));
                        visited[nx][ny][nt] = true;
                    }
                }
            }

        }
    }
}

/**
 * 
 * 욱제의 캐릭터는 가장 왼쪽 아랫 칸에 있고, 이 캐릭터는 가장 오른쪽 윗 칸으로 이동해야 한다.
 * 1초에 인접한 칸 또는 대각선 방향으로 인접한 칸으로 이동할 수 있다. 
 * 빈칸은 그대로이고 벽만 밑으로 내려감 !!
 * 
 * bfs
 * 1. 욱제가 먼저 이동
 * -> 1초동안 이동할 수 있는 방향이 최대 8군데이다.
 * 최대 8군데를 queue에 한번에 넣는건가 ?
 * 욱제의 이동가능 위치를 모두 고려해야할 것 같은데 어떡하쥐 
 * 2. 벽이 이동 아래로 (x값에 1 더하기 범위 벗어나면 그냥 없애기 )
 * 
 * 범위 벗어나면 continue;
 * 벽이면 continue;
 * 그렇지 않으면 이동 (queue에 넣기 )
 * 
 * 
 * 위치와 시간을 '같이' 고려해야함
 * 그 시간(=out.t)에 해당 위치가 벽이 아니면,
 * 그 시간+1에 해당 위치가 벽이 아니면,
 * 이동 시켜준다.
 */