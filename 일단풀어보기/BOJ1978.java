package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i=0; i<N; i++) {
            boolean flag = true;
            int num = Integer.parseInt(st.nextToken());
            //1은 소수가 아님 skip
            if(num == 1) continue;
            if(num == 2) { //2는 소수임
                cnt++;
            }
            else {
                for(int j=2; j<num; j++) { //3 이상의 숫자 중, 1과 자기 자신을 제외하고 나누어지는 것이 있으면 소수가 아님 
                    if(num % j == 0){
                        flag = false;
                        break;
                    }
                }

                if(flag)
                    cnt++;
            }

        }

        System.out.println(cnt);
    }   
}
