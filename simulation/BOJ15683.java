package simulation;

import java.io.*;
import java.util.*;

public class BOJ15683 {
    static int N, M;
    static int[][] company;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        company = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                company[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;
        int ccount = 0, ccount2 = 0;
      //  int[][] cc1 = {{N-1, 0}, {0, M-1}, {0, 0}, {0, 0}};

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(company[i][j] == 1) { // 현재 좌표 i, j
                    //company[i][j] ~ company[N-1][j]까지 확인
                    //company[i][j] ~ company[i][M-1]까지 확인
                    //company[0][j] ~ company[i][j]까지 확인
                    //company[i][0] ~ company[i][j]까지 확인
                    //같은 cctv가 꼭 같은방향일 필요도 없음 ...

                    //System.out.println(i + "," + (M-i));
                    for(int k=i+1; k<=M-1; k++) { //1번 cctv의 1번 방향
                        if(company[i][k] == 6)
                            break;
                        count++;
                    }

                    //System.out.println(j + "," + (N-1));
                    for(int k=j+1; k<=N-1; k++) {//1번 cctv의 2번 방향
                        if(company[k][j] == 6)
                            break;
                        count2++;
                    }

                    for(int k=0; k<i; k++) { //1번 cctv의 3번 방향
                        if(company[k][j] == 6)
                            break;
                        count3++;
                    }

                    for(int k=0; k<j; k++) { //1번 cctv의 4번 방향
                        if(company[i][k] == 6)
                            break;
                        count4++;
                    }

                    System.out.println(count + " " + count2 + " " + count3 + " " + count4);

                } 
                
                else if(company[i][j] == 2) {
                    for(int k=0; k<M; k++){
                        if(company[i][k] == 6)
                            break;
                        ccount++;
                    }
                    for(int k=0; k<N; k++) {
                        if(company[k][i] == 6)
                            break;
                        ccount2++;
                    }
                }

                else if(company[i][j] == 5) {
                    for(int k=0; k<M; k++){
                        if(company[i][k] == 6)
                            break;
                        ccount++;
                    }
                    for(int k=0; k<N; k++) {
                        if(company[k][i] == 6)
                            break;
                        ccount2++;
                    }
                }

                //System.out.println(count + " " + count2 + " " + count3 + " " + count4);

                count = 0;
                count2 = 0;
                count3 = 0;
                count4 = 0;





            }
        }

//        System.out.println(count + " " + count2 + " " + count3 + " " + count4);
        System.out.println(ccount + " " + ccount2 );


    }
}
