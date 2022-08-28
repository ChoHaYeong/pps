package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] alpha = new int[26]; //a : 97
        Arrays.fill(alpha, -1);
        for(int i=0; i<str.length(); i++) {
            if(str.indexOf(str.charAt(i)) != -1) {
                alpha[str.charAt(i)-97] = str.indexOf(str.charAt(i));
            } 
        }

        for(int a : alpha)
            System.out.print(a + " ");
    }
    
}
