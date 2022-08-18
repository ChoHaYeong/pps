package 바킹독_03;

import java.io.*;
import java.util.*;

public class BOJ13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //수학여행 참가하는 학생수
        int K = Integer.parseInt(st.nextToken()); //한 방의 최대 인원수

        int[][] student = new int[2][7];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 학생의 성별
            int Y = Integer.parseInt(st.nextToken()); // 학생의 학년

            student[S][Y]++;

        }

        int count = 0;
        for(int i=0; i<2; i++) {
            for(int j=0; j<7; j++) {
                if(student[i][j] % K != 0) {
                    count += student[i][j] / K + 1;
                } else {
                    count += student[i][j] / K ;
                }

            }
        }

        System.out.println(count);
    }
    
}
