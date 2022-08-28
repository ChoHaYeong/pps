package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10825 {

    static private class Study implements Comparable<Study> {
        String name;
        int kor, math, eng;

        Study(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        /*
         * 국어 점수가 감소하는 순서로
        국어 점수가 같으면 영어 점수가 증가하는 순서로
        국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
        모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
         */
        @Override
        public int compareTo(Study o) {
            if(this.kor < o.kor) return 1; //국어점수 내림차순
            else if(this.kor == o.kor) {
                if(this.eng < o.eng) return -1; //국어점수 같으면 영어점수 오름차순
                else if(this.eng == o.eng) {
                    if(this.math < o.math) return 1; //국, 영점수 같으면 수학점수 내림차순
                    else if(this.math == o.math) {
                        if(this.name.compareTo(o.name) < 0) return -1;
                        else if(this.name.compareTo(o.name) > 0) return 1;
                        else return 0;
                    }
                    else return -1;
                }
                else return 1;
            }
            else return -1;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Study[] arr = new Study[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Study(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        for(Study a: arr)
            System.out.println(a.name);
    }
}
