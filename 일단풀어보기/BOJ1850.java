package 일단풀어보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());

        long a = Math.max(x, y);
        long b = Math.min(x, y);

        long len = getGCD(a, b);

        String str = "1".repeat((int)len);

        bw.write(str);
        bw.flush();
        bw.close();


    }

    static long getGCD(long n1, long n2) {
        long n = n1 % n2;
        while(n != 0) {
            n1 = n2;
            n2 = n;
            n = n1 % n2;
        }

        return n2;
    }
}
