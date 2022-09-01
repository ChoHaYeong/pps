package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] ori_arr = new int[h][w];
        int[][] arr = new int[h+X][w+Y];

        for(int i = 0; i<h+X; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<w+Y; j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(i < X || j < Y) {
                    ori_arr[i][j] = arr[i][j];
                } else {
                   // System.out.println(i + " , " + j);
                    ori_arr[i][j] = arr[i][j] - ori_arr[i-X][j-Y];
                }
            }
        }

        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                System.out.print(ori_arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// 3 3 2 2
// 1 2 3 0 0
// 4 5 6 0 0
// 7 8 10 2 3
// 0 0 4 5 6
// 0 0 7 8 9