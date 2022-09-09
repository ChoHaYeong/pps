package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14819 {
    static int[][] arr = new int[5][10]; //i번째의 톱니바퀴의 j번째 상태
    static int[][] n_arr = new int[5][10]; //i번째의 톱니바퀴의 j번째 상태
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=1; i<5; i++) {
            String str = br.readLine();
            //System.ou.println()
            for(int j=0; j<8; j++) {
                arr[i][j+1] = Integer.parseInt(Character.toString(str.charAt(j)));
                n_arr[i][j+1] = arr[i][j+1];
            }
        }

        int N = Integer.parseInt(br.readLine()); //회전 횟수 K(1 ≤ K ≤ 100)
        for(int i=0; i<N; i++ ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken()); //방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.

            // if(dir == 1) clockDir(num);
            // else reverseClockDir(num);

            boolean isOriRotate = false;
            int[] dirs = new int[5] ;
            dirs[num] = dir;

            int n = num;
            int n_dir = dir;
            while( n>1 && arr[n][7] != arr[n-1][3]) { //같으면 멈추는것이여 n>1 && n<4 && 
                if(!isOriRotate){
                    if(dir == 1) clockDir(n);
                    else if(dir == -1) reverseClockDir(n);
                    isOriRotate = true;
                }

               // dirs[n-1] = -dirs[n];

                n_dir = -n_dir; //원래방향이 1이면 -1, 원래가 -1이면 1
                n--;
                if(n_dir == 1) clockDir(n);
                else if(n_dir == -1) reverseClockDir(n);
            }

            n = num;
            n_dir = dir;
            while(  n<4 && arr[n][3] != arr[n+1][7]) { //같으면 멈추는것이여 n>1 && n< 4 && 
                if(!isOriRotate){
                    if(dir == 1) clockDir(n);
                    else if(dir == -1) reverseClockDir(n);
                    isOriRotate = true;
                }

                n++;
                n_dir = -n_dir; //원래방향이 1이면 -1, 원래가 -1이면 1
                if(n_dir == 1) clockDir(n);
                else if(n_dir == -1) reverseClockDir(n);

                //dirs[n+1] = -dirs[n];

               // n_dir = 0 - n_dir; //원래방향이 1이면 -1, 원래가 -1이면 1
               // n++;
                
            }

            // for(int k=1; k<5; k++) {

            //     if(dirs[k] == 1) clockDir(k);
            //     else if(dirs[k] == -1) reverseClockDir(k);
            // }
            //톱니바퀴가 회전한 것이 바로 반영되는 것이 아니라,
            //한 단계에서 맞물린 톱니바퀴들이 서로 다른 극인지를 확인하고
            //마지막에 돌려주는 것

            //돌리고, 그다음 비교하고 돌리고 그다음 비교하고 이렇게 됨..

            // for(int k=1; k<5; k++) {
            //     for(int j=1; j<9; j++) {
            //         arr[k][j] = n_arr[k][j];
            //     }
            //     //System.out.println();
            // }
        }

        /* 1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
*/
       int ans = 0;
        if(arr[1][1] == 1) ans++;
        if(arr[2][1] == 1) ans += 2;
        if(arr[3][1] == 1) ans += 4;
        if(arr[4][1] == 1) ans += 8;

        System.out.println(ans);

    }

    static void clockDir(int n) {
        int start = arr[n][8];
        for(int i=8; i>1; i--){
           // System.out.println(i + " : " + arr[n][i] + " / " + (i-1) + " : " + arr[n][i-1]);
            arr[n][i] = arr[n][i-1];
        }
        arr[n][1] = start;

        // System.out.println("시계방향 " + n);
        // for(int i=1; i<9; i++)
        //     System.out.print(arr[n][i]);
        // System.out.println();
    }

    static void reverseClockDir(int n) {
        int end = arr[n][1];
        for(int i=1; i<8; i++)
            arr[n][i] = arr[n][i+1];
        arr[n][8] = end;


        // System.out.println("반시계방향 " + n);
        // for(int i=1; i<9; i++)
        //     System.out.print(arr[n][i]);
        // System.out.println();
    }
}
