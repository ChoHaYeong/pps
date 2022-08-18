package 바킹독_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alpha = new int[26];

        for(int i=0; i<str.length(); i++) {
          //  System.out.println(str.charAt(i));
            int idx = str.charAt(i) ;
         //   System.out.println(idx);
            alpha[idx-97]++;
        }

        for(int a: alpha)
            System.out.print(a + " ");
    }
    
}
