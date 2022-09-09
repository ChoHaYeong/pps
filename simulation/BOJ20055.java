package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20055 {
    static int N, K;
    static int[] arr;
    static int[] robot; //0: 로봇 존재 x, 1: 로봇 존재
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[2*N];
        robot = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // for(int i=0; i<2*N; i++)
        //     System.out.println(arr[i]);
        int stage = 1;
        while(true) {
            //1단계 회전하기
            rotate();
            if(robot[N-1] == 1) robot[N-1] = 0;
            //2단계 맨 앞의 로봇부터 (N-1에 가까울수록 먼저들어간 것임) 벨트가 이동한 방향으로 이동할 수 있으면 이동
            robotsMove();
            if(robot[N-1] == 1) robot[N-1] = 0;

            enterNewRobot();

            if(isExit()) break;
            else stage++;
        }

        System.out.println(stage);
        
    }

    static void rotate() { //컨베이어벨트 위의 로봇도 회전시켜주어야 함 
        int start = arr[2*N-1];
        for(int i=2*N-2; i>=0; i--) {
            arr[i+1] = arr[i];
        }
        arr[0] = start;

        for(int i=N-2; i>=0; i--) {
            robot[i+1] = robot[i];
            // if(i+1 == N-1) //로봇이 내리는 위치에 도달하면 그 즉시 내림
            //     robot[i+1] = 0; //로봇이 내렸으니 0으로 바꿔준다 
        }
        robot[0] = 0;

        // for(int a: arr)
        //     System.out.print(a);
        // System.out.println();

        // for(int r: robot)
        //     System.out.print(r);
        // System.out.println();
    }

    static void robotsMove() {
        int n = N-2;
        while(n > 0) {
            if(robot[n] == 1 && robot[n+1] == 0 && arr[n+1] >= 1) { //앞에서부터 로봇이 있을 때, 이동하고자 하는 칸에 로봇 없음 && 내구도가 1 이상임
                robot[n+1] = 1; //로봇을 옮김 
                // if(n+1 == N-1) //로봇이 내리는 위치에 도달하면 그 즉시 내림
                //     robot[n+1] = 0; //로봇이 내렸으니 0으로 바꿔준다 
                robot[n] = 0; //로봇이 ㅇㅣ동했으니 원래 있던 곳에는 없어짐
                arr[n+1]--; //내구도 1감소
            }
            n--;
        }
    }

    static void enterNewRobot() {
        if(arr[0] >= 1){ //올리는 위치에 있는 칸의 내구도가 0이 아니면
            robot[0] = 1; //올리는 위치에 로봇을 올린다.
            arr[0]--; //로봇을 올리는 위치에 올리거나 ..~ 하면 그 칸의 내구도는 즉시 1만큼 감소한다.
        }
    }

    static boolean isExit() {
        int cnt = 0;
        for(int a: arr)
            if(a == 0) cnt++; //내구도가 0이라면 증가 

        if(cnt >= K) return true; //내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다.
        else return false; //그렇지 않다면 1번으로 돌아간다.
    }
}
