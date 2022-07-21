import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1926 {
    static int N, M; //N - 도화지의 세로크기 , M - 도화지의 가로크기
    static int[][] pic;
    static boolean[][] visited;
    static Queue<Position> queue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        /*
         BFS 탐색의 과정은 다음과 같다.
            > 첫번째 탐색요소에 방문표시를 하고, queue에 넣는다.
            > queue가 비어있지 않는 동안 (= queue가 빌때까지) 다음을 진행한다.
                - queue에서 첫번째 요소를 꺼낸다.
                - 해당 요소의 주변을 방문하며 다음을 진행한다.
                    * 방문하지 않았다면 방문 표시를 하고 queue에 넣는다.
                    * 이미 방문했다면, 넘어간다.

         정리된 생각에 대한 논리
            그림의 개수는 새롭게 탐색을 시작하는 횟수이다.
            가장 넓은 그림의 넓이는 queue에서 요소를 빼낸 횟수이다. (poll)
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pic = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                pic[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int count = 0;
        int c = 0;
        int max = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(visited[i][j] == false && pic[i][j] == 1) {
                    Position p = new Position(i, j);
                    visited[i][j] = true;
                    queue.add(p);
                    count++;
                }

                while(!queue.isEmpty()) {
                    Position p = queue.poll();
                    c++;
                    for(int k=0; k<4; k++) {
                        if(p.x+dx[k] <0 || p.y+dy[k] < 0 || p.x+dx[k] >= N || p.y+dy[k]>= M) continue;
                        else if(visited[p.x+dx[k]][p.y+dy[k]] || pic[p.x+dx[k]][p.y+dy[k]] == 0) continue;
                        else {
                            visited[p.x+dx[k]][p.y+dy[k]] = true;
                            queue.add(new Position(p.x+dx[k], p.y+dy[k]));
                        }
                    }
                    //주변탐색
                    //방문했다면 넘어감
                    //가로, 세로 맨끝 넘기면 넘어감
                    //그 외에(방문 안했다면) 방문표시하고 queue에 넣기 
                }


                max = Math.max(max, c);
                c = 0;
            }
        }

        System.out.println(count);
        System.out.println(max);

        
    }
    
}
