package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        

        int len_a = a.length();
        int len_b = b.length();

        a = " " + a;
        b = " " + b;

        int[][] D = new int[len_a+1][len_b+1];

        for(int i=1; i<=len_a; i++) {
            for(int j=1; j<=len_b; j++) {
                if(a.charAt(i) == b.charAt(j)) D[i][j] = D[i-1][j-1]+1;
                else D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
            }
        }

        System.out.println(D[len_a][len_b]);

    }
}
