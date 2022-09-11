package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ21610 {
    static int N, M, sum;
    static int[][] arr;
    static int[][] cloud; //0 : 구름이 없음 1: 구름이 있음 2: 구름이 있다가 없어짐
    static boolean[][] visited;
    static int[] d, s;
    static int[] dx = {0, -1, -1 , -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static class Position{
        int x, y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static List<Position> list = new LinkedList<>();
    static List<Position> n_list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        cloud = new int[N][N];
        visited = new boolean[N][N];

        d = new int[M];
        s = new int[M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            d[i] = Integer.parseInt(st.nextToken()); //이동 정보
            s[i] = Integer.parseInt(st.nextToken()); //이동 거리
        }

        //(N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다.

        for(int i= N-2; i<N; i++) {
            for(int j=0; j<2; j++){
               // cloud[i][j] = 1;
                list.add(new Position(i, j));
            }
        }

        for(int l = 0; l<M; l++) { //M번 이동함 

            sum = 0;
            //모든 구름이 di방향으로 si칸 이동한다 + 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
            cloudMoves(l);
            //구름이 모두 사라진다 (= list 초기화)
            // for(int i=0; i<N; i++) {
            //     for(int j=0; j<N; j++) {
            //         if(cloud[i][j] == 1)
            //             cloud[i][j] = 2;
            //     }
            // }
            list = new LinkedList<>();



            //2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 
            for(Position nl: n_list) { //n_list : 이동한 구름이 있는 곳 
                int[] x = {-1, 1, 1, -1};
                int[] y = {-1, -1, 1, 1};
                int bucket = 0;
                for(int i=0; i<4; i++){

                    int nx = nl.x + x[i];
                    int ny = nl.y + y[i];

                    
                    if(nx <0 || ny <0 || nx >=N || ny >= N) continue;
                    //물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
                    //arr[nl.x][nl.y] += arr[nx][ny];
                    if(arr[nx][ny] > 0 ) bucket++; // 물이 있는 바구니의 수 ++
                }
                arr[nl.x][nl.y] += bucket;
            }
            n_list = new LinkedList<>();

            // System.out.println("바구니에 물의 양 줄어들기 전 =========== ");
            // for(int i=0; i<N; i++) {
            //     for(int j=0; j<N; j++) {
            //         System.out.print(arr[i][j] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println("구름의 상태 =========== ");
            // for(int i=0; i<N; i++) {
            //     for(int j=0; j<N; j++) {
            //         System.out.print(cloud[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            //바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j] >=2 && !visited[i][j]){
                        arr[i][j] -= 2;
                        list.add(new Position(i, j)); //구름이 생김 
                    }
                    else visited[i][j] = false;
                    sum += arr[i][j];
                }
            }
            

            System.out.println();
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }

            // System.out.println("구름의 상태 =========== ");
            // for(int i=0; i<N; i++) {
            //     for(int j=0; j<N; j++) {
            //         System.out.print(cloud[i][j] + " ");
            //     }
            //     System.out.println();
            // }

        }

        //int sum = 0;
        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<N; j++) {
        //         sum += arr[i][j];
        //     }
        // }

        

        System.out.println(sum);
        


    }

    static void cloudMoves(int x) { //파라미터 x는 이동횟수를 나타냄 
        //비구름 생기는 자리 ... 
        //list는 구름이 담긴 배열 
        for(Position l: list) {
            //System.out.println("ori " + l.x + " , " + l.y);
            int nx = l.x + dx[d[x]-1] * s[x];

            int ny = l.y + dy[d[x]-1] * s[x];

            // 마법사 상어는 연습을 위해 1번 행과 N번 행을 연결했고, 1번 열과 N번 열도 연결했다. 
            if(nx <0 ) {
                while(nx <0) nx += N; 
                //nx %=  N;
            }
            if(nx >= N) {
                while(nx >=N) nx -= N; 
                //nx = nx % N;
            }
            if(ny < 0) {

                while(ny <0) ny += N; 
                //ny %= N;
            }

            if(ny >= N) {
                while(ny >=N) ny -= N; 
                //ny = ny % N;
            }


            //System.out.println(nx + " , " + ny);
            //if(cloud[l.x][l.y] != 2)
            //     cloud[l.x][l.y] = 0; //구름이 이동했기 때문에 원래 위치의 구름은 사라진다. 
            // cloud[nx][ny] = 1;
            visited[nx][ny] = true;

            //각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
            arr[nx][ny] ++;
            n_list.add(new Position(nx, ny));
            //물이 증가한 곳의 좌표를 저장해두기    
        }
        
    }
}

// 마법사 상어는 연습을 위해 1번 행과 N번 행을 연결했고, 1번 열과 N번 열도 연결했다. 
// 1부터 순서대로 ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 이다
// int[] dx = {0, -1, -1 , -1, 0, 1, 1, 1};
// int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};