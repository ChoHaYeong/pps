package codeplus_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2529 {
    static int N ;
    static char[] relation;
    static boolean[] visited = new boolean[10];
    static int[] arr;
    static String max = "0";
    static String min = "99999999999"; //11자리 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        relation = new char[N];
        arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            relation[i] = st.nextToken().charAt(0);
        }

        dfs(0);

        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int curr) {
        if(curr == N+1) {
            String str = "";
            for(int i=0; i<arr.length-1; i++) {
                if(relation[i] == '>' && arr[i] > arr[i+1]){
                    str += Integer.toString(arr[i]);
                    if(i == arr.length-2){
                        str += Integer.toString(arr[i+1]);
                    }
                }
                else if(relation[i] == '<' && arr[i] < arr[i+1]){
                    str += Integer.toString(arr[i]);
                    if(i == arr.length-2){
                        str += Integer.toString(arr[i+1]);
                    }
                }
                else { //부등호의 순서를 맞추지 못함
                    return ;
                }
            }

            //최솟값과 최대값 업뎃하는 함수

            updateMaxMin(str);

            return ;

        } 

        for(int i=0; i<10; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[curr] = i;
                dfs(curr+1);
                visited[i] = false;
            }
        }
    }

    static void updateMaxMin(String str) {
       // long num = Long.parseLong(str);

        if(str.compareTo(max) > 0) //str이 max보다 사전적으로 뒤일경우
            max = str;
        if(str.compareTo(min) < 0)
            min = str;
    }
    
}
