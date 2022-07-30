package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {
    static int N, C;
    static int[] button;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        button = new int[N+1]; //idx 1부터 쓸거라서

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            button[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());

        for(int i=0; i<C; i++) {
            //학생 성별과 학생이 받은 수를 변수에 저장하기 
            st = new StringTokenizer(br.readLine());
            int morf = Integer.parseInt(st.nextToken()); //1이면 남학생 2이면 여학생
            int num = Integer.parseInt(st.nextToken()); //학생이 받은수 

            if(morf == 1) { //남학생인 경우 받은 수의 '배수'의 스위치 변환
                int idx = 1;
                while (num * idx <= N) {
                    if(button[num*idx] == 0)
                        button[num*idx] = 1;
                    else if(button[num*idx] == 1)
                        button[num*idx] = 0;
                    idx++;
                }

            } else if(morf == 2) { //여학생의 경우 받은 수의 대칭 앞뒤로 스위치 변환 (대칭 사이의 모든 스위치 번호 바꾸기)
                int idx = 1;
                if(button[num] == 0)
                    button[num] =1;
                else if(button[num] == 1)
                    button[num] = 0;
                
                while (num - idx > 0 && num + idx <= N && button[num-idx] == button[num+idx]) {
                    if(button[num-idx] == 0 && button[num+idx] == 0){
                        button[num-idx] =1;
                        button[num+idx] =1;
                    }
                    else if(button[num-idx] == 1 && button[num-idx] == 1){
                        button[num-idx] = 0;
                        button[num+idx] = 0;
                    }
                    idx++;
                }

            }

        }

        for(int i=1; i<=N; i++) {
            System.out.print(button[i] + " ");

            if(i%20 == 0)
                System.out.println();

        }

    }
    
}
