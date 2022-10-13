package codeplusDP_part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9252 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        

        int len_a = a.length();
        int len_b = b.length();

        a = " " + a;
        b = " " + b;

        int[][] D = new int[len_a+1][len_b+1];
        int[][] V = new int[len_a+1][len_b+1];

        for(int i=1; i<=len_a; i++) {
            for(int j=1; j<=len_b; j++) {
                if(a.charAt(i) == b.charAt(j)) {
                    D[i][j] = D[i-1][j-1]+1;
                    V[i][j] = 1;
                }
                else {
                    if(D[i-1][j] < D[i][j-1]) {
                        D[i][j] = D[i][j-1];
                        V[i][j] = 2;
                    }
                    if(D[i-1][j] > D[i][j-1]) {
                        D[i][j] = D[i-1][j];
                        V[i][j] = 3;
                    }
                }
            }
        }

        System.out.println(D[len_a][len_b]);
        String ans = "";
        while(len_a >0 && len_b > 0 ){
            if(V[len_a][len_b] == 1) {
                ans += a.charAt(len_a);
                len_a--; len_b--;
            }
            if(V[len_a][len_b] == 2) {
                len_b--;
            }
            if(V[len_a][len_b] == 3) {
                len_a--;
            }
            
        }
        System.out.println(new StringBuilder(ans).reverse().toString());



       // System.out.println(D[len_a][len_b]);

    }
}
