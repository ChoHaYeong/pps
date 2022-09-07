package simulation;

import java.io.*;
import java.util.*;

public class BOJ15683 {
    // static class Position{
    //     int x, y;
    //     Position(int x, int y) {
    //         this.x = x;
    //         this.y = y;
    //     }
    // }

    static class CCTV {
        int x, y;
        int num;
        CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    static int N, M, min = Integer.MAX_VALUE;
    static int[][] company, new_company;
    static List<CCTV> cctv = new LinkedList<>();
    static int C;
    static int[] cc ;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        company = new int[N][M];
        new_company = new int[N][M];
       // cctv = new Position[8]; //CCTV의 최대 개수는 8개를 넘지 않는다.
       // int idx = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                company[i][j] = Integer.parseInt(st.nextToken());
                new_company[i][j] =  company[i][j];
                if(company[i][j] >= 1 && company[i][j]<=5) {
                    cctv.add(new CCTV(i, j, company[i][j]));
                   // idx++;
                }
            }
        }

        C = cctv.size();
        cc = new int[C]; //cctv의 dir
        //visited = new boolean[N][M][4];

        dfs(0);
        System.out.println(min);
    }

    static void dfs(int curr) {
        if(curr == C) { //cctv개수만큼 방향골랐을 때, 
            for(int i=0; i<C; i++){ //Position c: cctv
                getSpaceSize(cctv.get(i), cc[i]); 
            }
            //cctv의 방향에 따라 사각지대 구하고 사무실 상태 원래대로

            int cnt = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(new_company[i][j] == 0)
                        cnt++;
                    new_company[i][j] =  company[i][j];
                }
            }

           
            min = Math.min(min, cnt);

            return ;
        }

            for(int j=0; j<4; j++) {
               // if(!visited[cctv.get(i).x][cctv.get(i).y][j]) {

                    //System.out.println("("+cctv.get(i).x+","+cctv.get(i).y+") => " + company[cctv.get(i).x][cctv.get(i).y]);
                   // visited[cctv.get(i).x][cctv.get(i).y][j] = true;
                    cc[curr] = j;
                    dfs(curr+1);
                   // visited[cctv.get(i).x][cctv.get(i).y][j] = false;
              //  }
            }
       // }
    }

    static void getSpaceSize(CCTV c, int dir) {
        int num = c.num;
        int x = c.x;
        int y = c.y;
       // int dir = dir;

        if(num == 1) {
            if(dir == 0) { //x, y ~ x, M-1까지
                for(int i = y+1; i<M; i++){
                    if(new_company[x][i] == 6) //벽이면 더 이상 감시 불가능
                        break; //이전에 -1로 바꾼거 돌려놓아야 함..
                    new_company[x][i] = -1; // 감시
                }
            }
            if(dir == 1) { //x, y ~ N-1, y까지
                for(int i = x+1; i<N; i++){
                    if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                        break;
                    new_company[i][y] = -1; // 감시
                }
            }
            if(dir == 2) { //x,0 ~ x, y 까지
                for(int i = y-1; i>=0; i--){
                    if(new_company[x][i] == 6) //벽이면 더 이상 감시 불가능
                        break;
                    new_company[x][i] = -1; // 감시
                }
            }
            if(dir == 3) { //0,y ~ x,y 까지
                for(int i = x-1; i>=0; i--){
                    if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                        break;
                    new_company[i][y] = -1; // 감시
                }
            }
        }

        else if(num == 2) {
            boolean flag = true;
            if(dir == 0 || dir == 2) { //x, 0 ~ x, M-1 까지
                // for(int i = 0; i<M; i++){
                //     if(new_company[x][i] == 6) //벽이면 더 이상 감시 불가능
                //         break;
                //     new_company[x][i] = -1; // 감시
                // }
                for(int i = y-1; i>=0; i--){
                    if(new_company[x][i] == 6) {//벽이면 더 이상 감시 불가능
                        //flag = false;
                        break;
                    }
                    new_company[x][i] = -1; // 감시
                }
        //        if(flag){
                    for(int i = y+1; i<M; i++){
                        if(new_company[x][i] == 6) //벽이면 더 이상 감시 불가능
                            break; //이전에 -1로 바꾼거 돌려놓아야 함..
                        new_company[x][i] = -1; // 감시
                    }
         //       }
                

            }
            if(dir == 1 || dir == 3) { //0, y ~ N-1, y까지
                
                for(int i = x-1; i>=0; i--){
                    if(new_company[i][y] == 6){ //벽이면 더 이상 감시 불가능
                      //  flag = false;
                        break;
                    }
                    new_company[i][y] = -1; // 감시
                }
        //        if(flag){
                    for(int i = x+1; i<N; i++){
                        if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                            break;
                        new_company[i][y] = -1; // 감시
                    }
          //      }
                
            }
        }

        else if(num == 3) {

            boolean flag = true;
            if(dir == 0) { //0,y ~ x, y / x,y ~ x,M-1까지  
                
                for(int i = x-1; i>=0; i--){
                    if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                        break;
                    new_company[i][y] = -1; // 감시
                }
            //    if(flag) {
                    for(int i = y+1; i<M; i++){
                        if(new_company[x][i] == 6) //벽이면 더 이상 감시 불가능
                            break;
                        new_company[x][i] = -1; // 감시
                    }
           //     }
                
            }
            if(dir == 1) { //x,y ~ x, M-1 / x,y ~ N-1, y
                for(int i = y+1; i<M; i++){
                    if(new_company[x][i] == 6){ //벽이면 더 이상 감시 불가능
                        flag = false;
                        break;
                    }
                    new_company[x][i] = -1; // 감시
                }
           //     if(flag) {
                    for(int i = x+1; i<N; i++){
                        if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                            break;
                        new_company[i][y] = -1; // 감시
                    }
          //      }
                
            }
            if(dir == 2) { //x,0 ~ x, y 까지
                for(int i = y-1; i>=0; i--){
                    if(new_company[x][i] == 6) //벽이면 더 이상 감시 불가능
                        break;
                    new_company[x][i] = -1; // 감시
                }
               // if(flag) {
                    for(int i = x+1; i<N; i++){
                        if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                            break;
                        new_company[i][y] = -1; // 감시
                    }
             //   }
                
            }
            if(dir == 3) { //0,y ~ x,y 까지
                for(int i = x-1; i>=0; i--){
                    if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                        break;
                    new_company[i][y] = -1; // 감시
                }
              //  if(flag){
                for(int i = y-1; i>=0; i--){
                    if(new_company[x][i] == 6) //벽이면 더 이상 감시 불가능
                        break;
                    new_company[x][i] = -1; // 감시
                }
              //  }
                
            }
        }

        else if(num == 4) {
            boolean flag = true;
            
            if(dir == 0) { // x,0 ~ x, M-1 / 0,y ~x,y
                for(int i = y-1; i>=0; i--){
                    if(new_company[x][i] == 6) {//벽이면 더 이상 감시 불가능
                        flag = false;
                        break;
                    }
                    new_company[x][i] = -1; // 감시
                }
              //  if(flag){
                    for(int i = y+1; i<M; i++){
                        if(new_company[x][i] == 6){ //벽이면 더 이상 감시 불가능
                            flag = false;
                            break; //이전에 -1로 바꾼거 돌려놓아야 함..
                        }
                        new_company[x][i] = -1; // 감시
                    }
               // }
               // if(flag) {
                    for(int i = x-1; i>=0; i--){
                        if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                            break;
                        new_company[i][y] = -1; // 감시
                    }
               // }
            }

            if(dir == 1) { //0,y ~ x, y / rmc ~ r, M-1
                for(int i = x-1; i>=0; i--){
                    if(new_company[i][y] == 6){ //벽이면 더 이상 감시 불가능
                        flag = false;
                        break;
                    }
                    new_company[i][y] = -1; // 감시
                }
               // if(flag){
                    for(int i = x+1; i<N; i++){
                        if(new_company[i][y] == 6) { //벽이면 더 이상 감시 불가능
                            flag = false;
                            break;
                        }
                        new_company[i][y] = -1; // 감시
                    }
              //  }
               // if(flag) {
                    for(int i = y+1; i<M; i++){
                        if(new_company[x][i] == 6){ //벽이면 더 이상 감시 불가능
                            flag = false;
                            break;
                        }
                        new_company[x][i] = -1; // 감시
                    }
                //}
            }
            if(dir == 2) { //x,0 ~ x, M-1 / x,y ~N-1,y
                for(int i = y-1; i>=0; i--){
                    if(new_company[x][i] == 6) {//벽이면 더 이상 감시 불가능
                        flag = false;
                        break;
                    }
                    new_company[x][i] = -1; // 감시
                }
              //  if(flag){
                    for(int i = y+1; i<M; i++){
                        if(new_company[x][i] == 6){ //벽이면 더 이상 감시 불가능
                            flag = false;
                            break; //이전에 -1로 바꾼거 돌려놓아야 함..
                        }
                        new_company[x][i] = -1; // 감시
                    }
             //   }
               // if(flag) {
                    for(int i = x+1; i<N; i++){
                        if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                            break;
                        new_company[i][y] = -1; // 감시
                    }
             //   }
            }
            if(dir == 3) { //0,y ~ N-1, y / x,0 ~ x, y
                for(int i = x-1; i>=0; i--){
                    if(new_company[i][y] == 6){ //벽이면 더 이상 감시 불가능
                        flag = false;
                        break;
                    }
                    new_company[i][y] = -1; // 감시
                }
               // if(flag){
                    for(int i = x+1; i<N; i++){
                        if(new_company[i][y] == 6) { //벽이면 더 이상 감시 불가능
                            flag = false;
                            break;
                        }
                        new_company[i][y] = -1; // 감시
                    }
               // }
                //if(flag){
                    for(int i = y-1; i>=0; i--){
                        if(new_company[x][i] == 6) //벽이면 더 이상 감시 불가능
                            break;
                        new_company[x][i] = -1; // 감시
                    }
               // }
            }
        }

        else if(num == 5) {

            for(int i = y+1; i<M; i++){
                if(new_company[x][i] == 6) //벽이면 더 이상 감시 불가능
                    break; //이전에 -1로 바꾼거 돌려놓아야 함..
                new_company[x][i] = -1; // 감시
            }

            for(int i = x+1; i<N; i++){
                if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                    break;
                new_company[i][y] = -1; // 감시
            }
       
            for(int i = y-1; i>=0; i--){
                if(new_company[x][i] == 6) //벽이면 더 이상 감시 불가능
                    break;
                new_company[x][i] = -1; // 감시
            }

       
            for(int i = x-1; i>=0; i--){
                if(new_company[i][y] == 6) //벽이면 더 이상 감시 불가능
                    break;
                new_company[i][y] = -1; // 감시
            }


           
        }
        
        else return ;
        // int cnt = 0;
        

        // System.out.println();
        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<M; j++) {
        //         System.out.print(new_company[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println(c.x + " , " + c.y + " dir : " +  dir + "num " + num );
        // return cnt;
    }
}


/**
7 5
0 6 6 6 6
6 0 6 4 6
6 6 1 2 6
6 0 1 6 0
6 6 0 0 6
0 6 0 6 6
3 0 6 0 0



 */