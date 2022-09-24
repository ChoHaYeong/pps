package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3190 {
    static int N, K, L;
    static int[][] arr; //1은 사과 2는 뱀
    static Deque<Info> deque = new ArrayDeque<>();
    static class Info{
        int x, y, time;
        Info(int x, int y, int time) {
            this.time = time;
            this.x = x;
            this.y = y;
        }
    }

    static class Rot{
        int time; char dir;
        Rot(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    //동 남 서 북
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            arr[r][c] = 1;
        }

        List<Rot> list = new ArrayList<>();
        for(int i=0; i<L; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);

            list.add(new Rot(second, dir));
        }


        int time = 0;
        deque.add(new Info(0, 0, time));
        arr[0][0] = 2;
        while(true) {

            int k = 0;
            //1초 후의 이동지를 구한다. 뱀의 머리에서 방향만큼 이동한 곳이다.
            Info out = deque.peekFirst();
            int nx = out.x + dx[k];
            int ny = out.y + dy[k];

            time++;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 2) break; //위치가 범위를 넘어가거나 뱀 자기자신이면 그만한다.

            arr[nx][ny] = 2; //이동지에 머리 위치시킨다.
            deque.addFirst(new Info(nx, ny, time)); //deque에 넣는다.

            if(arr[nx][ny] != 1) { //이동하련ㄴ 곳에 사과가 없으면
                Info p = deque.pollLast();
                arr[p.x][p.y] = 0; //꼬리가 위치한 곳은 빈칸
                arr[nx][ny] = 2;
            }

            if(list.size() >0 && time == list.get(0).time) {
                if(list.get(0).dir == 'L')
                    k = (k+3) % 4;
                if(list.get(0).dir == 'D') 
                    k = (k+1) % 4;
                
                list.remove(0);
            }
        }

        System.out.println(time);


    }
}
