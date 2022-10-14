import java.util.*;
import java.io.*;

class Position{
    int x;
    int y;
    
    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ16946 {
    static int N, M;
    static int[][] arr, group;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static List<Integer> g = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        group = new int[N][M];
        visited = new boolean[N][M];

        

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0 && !visited[i][j]) bfs(i, j);
            }
        }

        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<M; j++) {
        //         System.out.print(group[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // int idx = 0;
        // for(int gg : g) {
        //     System.out.println(idx + "번째 group내 속한 개수 " + gg);
        //     idx++;
        // }

        boolean[] groupV = new boolean[g.size()];

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) {
                    bw.write("0");
                } else {
                   // HashSet<Integer> near = new HashSet<>();
                    int can = 1;
                    for(int k=0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx >=0 && nx<N && ny >=0 && ny <M ) {
                            if(!groupV[group[nx][ny]] && arr[nx][ny] == 0) {

                                groupV[group[nx][ny]] = true;
                               can += g.get(group[nx][ny]);
                              // near.add(g.get(group[nx][ny]));
                            }
                        }


                    }

                    // int can = 1;
                    // for(int n : near)
                    //     can += n;
                    bw.write(String.valueOf(can%10));
                    groupV = new boolean[g.size()];
                }
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        int idx = g.size();

        queue.add(new Position(x, y));
        visited[x][y] = true;
        group[x][y] = idx;
        int cnt = 1;

        while(!queue.isEmpty()) {
            Position out = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];

                if(nx >=0 && nx < N && ny>=0 && ny < M && !visited[nx][ny] && arr[nx][ny] == 0) {
                    group[nx][ny] = idx;
                    cnt++;
                    queue.add(new Position(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        g.add(cnt);

    }
}
