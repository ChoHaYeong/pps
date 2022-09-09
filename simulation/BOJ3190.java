package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3190 {
    static int[][] arr ;
    static class Dir {
        int time;
        char dir;
        Dir(int time, char dir) {
            this.time = time;
            this.dir = dir;
        }
    }

    static class Position {
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = 1; //사과가 놓여져있음
        }
        int L = Integer.parseInt(br.readLine());
        Dir[] dir = new Dir[L];

        for(int i=0; i<L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char y = st.nextToken().charAt(0);
            dir[i] = new Dir(x, y);
        }
        Position head = new Position(0, 0); //머리의 위치
        int idx = 0;
        int time = 0;
        int curr_dir = 1; //0: 북, 1: 동, 2: 남, 3: 서
        int len = 1;
        while(idx < L) {
            while( time < dir[idx].time) {
                int nx = 0;
                int ny = 0;

                int tailx = 0;
                int taily = 0;
                System.out.println("방향 " + curr_dir + "위치 " + head.x + " , " + head.y);
                if(curr_dir == 1){
    
                    nx = head.x;
                    ny = head.y+1;

                    tailx = nx;
                    taily = ny-len;
                }
                if(curr_dir == 2){
    
                    nx = head.x+1;
                    ny = head.y;

                    tailx = nx-len;
                    taily = ny;
                }
                if(curr_dir == 3){
    
                    nx = head.x-1;
                    ny = head.y;

                    tailx = nx+len;
                    taily = ny;
                }
                if(curr_dir == 4){
    
                    nx = head.x;
                    ny = head.y-1;

                    tailx = nx;
                    taily = ny+len;
                }

                if(nx <0 || ny < 0 || nx >= N || ny >= N ) {
                    System.out.println("1 end"+ nx + " , " + ny);
                    System.out.println(time);
                    return ; //벽에 닿은 것임 
                }
                if(tailx <0 || taily < 0 || tailx >= N || taily >= N ) {

                    System.out.println("2 end" + tailx + " , " + taily);
                    System.out.println(time);
                    return ; //벽에 닿은 것임 
                }
                if(arr[nx][ny] == 2 ) {

                    System.out.println("3 end");
                    System.out.println(time);
                    return ; //자기 몸에 닿은 것임
                }
    
                arr[head.x][head.y] = 2; //현제 벰이 있는 위치
                len++;
                if(arr[nx][ny] == 1) {// 다음칸이 사과이면
                    arr[nx][ny] = 2;
                    //len++;
                } else { //사과가 아니면
                    arr[nx][ny] = 2;
                    System.out.println(nx + " , " + ny  + " 그리고 len " + len);
                    arr[tailx][taily] = 0; //몸 길이를 줄여서 꼬리가 위치한 칸 비움 (꼬리가 위치한 칸은 이게 아님 .. 으악)
                    len--;
                }
                head = new Position(nx, ny);
                time++;

                System.out.println();
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++) {
                        System.out.print(arr[i][j]) ;
                    }
                    System.out.println();
                }
            }
            //방향 회전해주어야함
            System.out.println(dir[idx].time + "초 , 방향 회전");
            //이 때 뱀도 이동해야함
            if(dir[idx].dir == 'L')
                curr_dir = (curr_dir+3)%4; //왼쪽으로 90도 회전
            if(dir[idx].dir == 'D')
                curr_dir = (curr_dir+1)%4; //오른쪽으로 90도 회전
            idx++;
        }


        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {
                System.out.print(arr[i][j]) ;
            }
            System.out.println();
        }

        System.out.println(time);
    }
}
