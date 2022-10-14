import java.io.*;
import java.util.*;

public class BOJ16236 {
    static int N, size = 2;
    static int[][] arr, dist;
    static class Pair{
        int x, y, dist;
        Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int[] dx ={-1, 0, 1 ,0};
    static int[] dy ={0, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dist = new int[N][N];
        int x= 0, y = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9) {
                    x = i; y = j;
                    arr[i][j] = 0;
                }
            }
        }

        int ans = 0;
        int exp = 0;

        while(true) {
            Pair p = bfs(x, y);
            if(p == null) break;
            arr[p.x][p.y] = 0;
            ans += p.dist;
            exp++;
            if(exp == size) {
                size++;
                exp = 0;
            }
            x = p.x;
            y = p.y;
        }

        System.out.println(ans);


    }

    static Pair bfs(int x, int y) { 
        Queue<Pair> queue = new LinkedList<>();
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0; i<N; i++)  
            Arrays.fill(dist[i], -1);

        dist[x][y] = 0;
        queue.add(new Pair(x, y, dist[x][y]));

        while(!queue.isEmpty()) {
            Pair out = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx >=0 && nx < N && ny >= 0 && ny<N && dist[nx][ny] == -1) {
                    
                    boolean ok = false;
                    boolean eat = false;

                    if(arr[nx][ny] == 0) ok = true;
                    else if(size > arr[nx][ny]) {
                        ok = true;
                        eat = true;
                    }
                    else if(size == arr[nx][ny]) ok = true;

                    if(ok) {
                        dist[nx][ny] = dist[out.x][out.y] + 1;
                        queue.add(new Pair(nx, ny, dist[nx][ny] ));
    
                        if(eat) list.add(new Pair(nx, ny, dist[nx][ny] ));
                    }
                    
                }

                
                
            }
        }

        if(list.isEmpty()) return null;
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(Integer.compare(o1.dist, o2.dist) < 0) return -1;
                else if(Integer.compare(o1.dist, o2.dist) > 0) return 1;
                else {
                    if(Integer.compare(o1.x, o2.x) < 0) return -1;
                    else if(Integer.compare(o1.x, o2.x) > 0) return 1;
                    else {
                        if(Integer.compare(o1.y, o2.y) < 0) return -1;
                        else if(Integer.compare(o1.y, o2.y) > 0) return 1;
                        else {
                            return 0;
                        }
                    }
                }
            }
        });

        return list.get(0);
    }
}
