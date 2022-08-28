package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();
        String C = st.nextToken();
        String D = st.nextToken();
        A = A.replace(",", "");
        B = B.replace(",", "");
        C = C.replace(",", "");
        D = D.replace(",", "");

        System.out.println(Integer.parseInt((A+B).trim()) + Integer.parseInt((C+D).trim()) );
    }
    
}
