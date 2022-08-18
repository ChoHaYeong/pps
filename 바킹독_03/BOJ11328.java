package 바킹독_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11328 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            int[] alpha = new int[26];

            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();

            for(int j=0; j<str1.length(); j++) {
                alpha[str1.charAt(j) - 97]++;
            }


            String str2 = st.nextToken();

            for(int j=0; j<str2.length(); j++) {
                alpha[str2.charAt(j) - 97]--;
            }


            boolean flag = true;

            for(int a:alpha) {
                if(a != 0){
                    System.out.println("Impossible");
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.println("Possible");
            }

        }

    }
    
}
