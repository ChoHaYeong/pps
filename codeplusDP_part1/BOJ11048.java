// package codeplusDP_part1;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.StringTokenizer;

// public class BOJ11048 {
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int N = Integer.parseInt(st.nextToken());
//         int M = Integer.parseInt(st.nextToken());
//         int[][] a = new int[N+1][M+1];
//         int[][] D = new int[N+1][M+1];

//         for(int i=1; i<=N; i++) {
//             st = new StringTokenizer(br.readLine());
//             for(int j=1; j<=M; j++) {
//                 a[i][j] = Integer.parseInt(st.nextToken());
//             }
//         }

//         for(int i=1; i<=N; i++) {
//             for(int j=1; j<=M; j++) {
//                 D[i][j] = Math.max(Math.max(D[i-1][j], D[i][j-1]), D[i-1][j-1]) + a[i][j];
//             }
//         }

//         System.out.println(D[N][M]);
//         //점화식 D[i][j] = (1, 1)에서 시작해서 (i, j)에 도착했을 때 사탕 개수의 최대값
//         //방법 1. D[i][j]로 어떻게 오는지 고민
//         //정해져있음 D[i-1][j] or D[i][j-1] or D[i-1][j-1] 로부터 옴
//         //그럼 셋 중 더 큰값을 선택하면 될듯


//     }
// }


package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11048 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] a = new int[N+1][M+1];
        int[][] D = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        D[1][1] = a[1][1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(i+1 <= N) 
                    D[i+1][j] = Math.max(D[i+1][j], D[i][j] + a[i+1][j]);
                if(j+1 <= M)
                    D[i][j+1] = Math.max(D[i][j+1], D[i][j] + a[i][j+1]);
                if(i+1 <= N && j+1 <= M)
                    D[i+1][j+1] = Math.max(D[i+1][j+1], D[i][j] + a[i+1][j+1]);
            }
        }

        System.out.println(D[N][M] );
        //점화식 D[i][j] = (1, 1)에서 시작해서 (i, j)에 도착했을 때 사탕 개수의 최대값
        //방법 1. D[i][j]로 어떻게 오는지 고민
        //정해져있음 D[i-1][j] or D[i][j-1] or D[i-1][j-1] 로부터 옴
        //그럼 셋 중 더 큰값을 선택하면 될듯


    }
}
