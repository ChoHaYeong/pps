package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2004 {
    static int n, r, cnt = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int nr = n-r;

        int ncount =0, rcount=0, nrcount= 0;

        while(n >= 5) {
            ncount += (n/5);
            n /= 5;
        }

        while(r >= 5) {
            rcount += r/5;
            r /= 5;
        }

        while(nr >= 5) {
            nrcount += nr/5;
            nr /= 5;
        }

        System.out.println(ncount-rcount-nrcount);
    }

    

    
}
