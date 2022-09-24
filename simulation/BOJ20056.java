package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20056 {
    static int N, M ,K; //, weight, speed, total_weight = 0;
    static class FireBall{
        int r,c,m,s,d;
        FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static class Position{
        int x, y ;
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static Queue<FireBall> queue = new LinkedList<>();
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0 ,-1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1}; 

    // static Map<int[], Integer> map = new HashMap<>();
    // static List<FireBall> list = new LinkedList<>();

    // static int[][] arr;

    static ArrayList<FireBall>[][] arr;
    static List<FireBall> list = new LinkedList<>();

    static boolean isSame = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                arr[i][j] = new ArrayList<FireBall>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            //arr[r][c].add(new FireBall(r, c, m, s, d));
            list.add(new FireBall(r, c, m, s, d));
            //arr[r-1][c-1] = 1;
        }

        for(int i=0; i<K; i++){

            //모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다
            move();
            //이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
            fireBallMagic();

           // System.out.println("??");
        }

        int ans = 0;

        for(FireBall l: list)
            ans += l.m;

        System.out.println(ans);


    }

    static void move() {
        for(FireBall out : list) {
            //FireBall out =  l;
            int nx = out.r + out.s * dx[out.d];
            int ny = out.c + out.s * dy[out.d];
           
            System.out.println("1. " + nx + " , " + ny);
            if(nx < 0) { while(nx < 0) nx +=N;};
            if(ny < 0) {while(ny < 0) ny +=N; };
            if(nx >= N) {while(nx >= N) nx -=N; };
            if(ny >= N) {while(ny >= N) ny -=N; };

            arr[nx][ny].add(new FireBall(nx, ny, out.m, out.s, out.d));
        }
    }

    static void fireBallMagic() {

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++) {

                if(arr[i][j].size() == 1)//{
                    arr[i][j].clear();
                if(arr[i][j].size() < 2)//{
                    continue;
                
                Set<Integer> set = new HashSet<>(); 

                int weight = 0, speed = 0;
                boolean odd = arr[i][j].get(0).d % 2 == 1 ? true : false,
                 even = arr[i][j].get(0).d % 2 == 0 ? true : false;
                for(FireBall l : arr[i][j]) {
                    weight += l.m;
                    speed += l.s;
                    //방향이 홀수이거나 짝수인지 확인해보아야함
                    even = even && l.d % 2 == 0 ? true : false;
                    odd = odd && l.d % 2 == 1 ? true : false;
                    // if(l.d % 2 != 0) 
                    //     even = false;
                    //     //set.add(1);
                    // if(l.d % 2 == 0) 
                    //     odd = false;
                    //     //set.add(0);
                    list.remove(l);
                }
               // if(set.size() == 1) isSame = true; //합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수인 경우 (0, 2, 4, 6)
                //else if(set.size() == 2) isSame = false; //그렇지 않은 경우
            // System.out.println(" weight " + weight);
                int newWeight = weight / 5;
                int size = arr[i][j].size();
                arr[i][j].clear();

               // System.out.println(newWeight + " , " + newSpeed);
               // arr[i][j].clear();

                if(newWeight == 0)
                    continue;

                
                int newSpeed = speed /size;

                if(odd || even){
                    for(int k=0; k<8; k+=2)
                        list.add(new FireBall(i, j, newWeight, newSpeed, k));
                } else {
                    for(int k=1; k<8; k+=2)
                        list.add(new FireBall(i, j, newWeight, newSpeed, k));
                }



                //     arr[i][j] = 0;
                // }
            }
        }

        // for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++) {
        //         arr[i][j] = 0 ;
        //     }
        // }
    }

    
}
