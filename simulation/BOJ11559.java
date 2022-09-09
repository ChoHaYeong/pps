package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ11559 {
    static char[][] puyo = new char[12][6];
    static boolean isPuyo = true;
    static boolean[][] visited = new boolean[12][6];
    static class Position{
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int cnt = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<12; i++) {
            String str = br.readLine();
            for(int j=0; j<6; j++) {
                puyo[i][j] = str.charAt(j);
            }
        }
        //boolean
        while(isPuyo) {
            isPuyo = false;



            recycle();

            for(int i=0; i<12; i++) {
                for(int j=0; j<6; j++) {
                    if(puyo[i][j] != '.' && !visited[i][j]) {
                        bfs(i, j);
                    }
                }
            }

            if(isPuyo) cnt++; //이것이 키포인트 !!

            resetVisited(); //얘는 반복문 내에서 bfs호출 라인 밑에 있어도 되긴하는데, 생각해보면 터지는 곳이 겹친다는 것은 (뿌요 색이 다르다는 거니까 ) 방문초기화는 여기서해도 될듯 !

        }
        System.out.println(cnt);

    }

    static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        List<Position> list = new LinkedList<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        //System.out.println(x + " , " + y);
        queue.add(new Position(x, y));
        list.add(new Position(x, y));
        visited[x][y] = true;
        char color = puyo[x][y];
        while(!queue.isEmpty()) {
            Position out = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = out.x + dx[i];
                int ny = out.y + dy[i];
                //System.out.println("nx " + nx + " , ny" + ny);
                if(nx<0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                if(visited[nx][ny] || color != puyo[nx][ny] || puyo[nx][ny] == '.') continue;
                //System.out.println("nx " + nx + " , ny" + ny);
                queue.add(new Position(nx, ny));
                list.add(new Position(nx, ny));
                visited[nx][ny] = true;
            }
        }

        if(list.size() >= 4) {
            isPuyo = true;

           // System.out.println("??????????");
            for(Position l : list){
               // System.out.println(l.x + " , " + l.y);
                puyo[l.x][l.y] = '.';
            }
        }
    }

    static void recycle() {
        for(int i=0; i<6; i++) {
            for(int j=10; j>=0; j--) {
                int tmp = j;
                while(tmp < 11 && puyo[tmp+1][i] == '.') {
                    char ch = puyo[tmp][i];
                    puyo[tmp][i] = puyo[tmp+1][i];
                    puyo[tmp+1][i] = ch;
                    tmp++;
                }
            }
        }


        // for(int i=0; i<12; i++) {
        //     for(int j=0; j<6; j++) {
        //        System.out.print(puyo[i][j]);
        //     }
        //     System.out.println();
        // }
    }

    static void resetVisited() {
        for(int i=0; i<12; i++) {
            for(int j=0; j<6; j++) {
                visited[i][j] = false;
            }
        }
    }
    
}
/*
 * 1. 같은 색 뿌요가 4개이상 상하좌우로 연결되면 같은색 뿌요 한번에 없어진다.
 *  1.1 4개이상 상하좌우로 연결되어 있는지 확인하기
 *  1.2 해당 뿌요들은 없애기 (빈칸처리하기 .)
 * 2. 뿌요들이 없어지면 위에 있던 뿌요들이 떨어진다.
 *  2.1 밑에서부터 그 다음칸이 빈칸이면 위치를 바꿈 (빈칸을 뿌요 위로 올림)
 * 1,2 가 끝나면 뿌요에 대해 방문처리 초기화하기
 * 이 모든 과정은 뿌요를 더이상 없앨 수 없을 때까지 반복
 */