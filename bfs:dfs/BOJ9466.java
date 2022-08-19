
import java.util.*;
import java.io.*;

public class BOJ9466 {
    static int n;
    static int[] student, arr;
    static boolean[] team;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        /**
         * 1. 사이클에 포함된 학생을 재방문 또는 사이클에 포함되지 않은 학생을 재방문 했을 경우는 x 는 사이클에 포함되지 않는 학생으로 분류한다. 
         (자기자신을 제외하고 재방문했을 경우 x가 사이클에 포함x?)
            2. x가 아닌 다른 방문한 학생 y를 재방문했을 경우 x는 사이클에 포함되지 않고 y는 사이클에 포함된다. 
                y에서 출발해서 y에 도달할때까지 만나는 학생들은 사이클에 포함된 학생으로 만들고 x에서 출발해서 y에 도달할 때까지 만나는 학생들은 사이클에 포함되지 않은 학생으로 만든다.
            3. x를 재방문했을 경우 x는 사이클에 포함. x에서 출발해 다시 x에 도달할떄까지 만나는 학생들을 사이클에 포함된 학생으로 만든다.
        */

        for(int i=0; i<T; i++) {
            n = Integer.parseInt(br.readLine()); //학생수
            student = new int[n+1]; //1번부터 사용할거라서 n+1개만큼 배열 선언하기
            team = new boolean[n+1]; //해당 idx의 학생이 팀을 이루었는지 알아보기 위함 (true: 팀이 됨, false: 팀 x)
            arr = new int[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1; j<=n; j++)
                student[j] = Integer.parseInt(st.nextToken());

            for(int j=1; j<=n; j++) {
                if(!team[j]){
                    System.out.println(j + " 번 학생");
                    dfs(0, j, j);
                }
            }   
            
            int count = 0;
            for(int j=1; j<=n; j++) {
                if(!team[j])
                    count++;
            }   
            System.out.println(count);


        }
    }

    static void dfs(int curr, int num, int start) {
        if(curr > 0 && start == num) {

            for(int a: arr){ 
                team[a] = true;
            }

            return ;
        }

        if(curr > n || (curr > 0 && arr[curr-1] == arr[curr])){
            return ;
        }


        // for(int a: arr){ 
        //     if(a < start && !team[a])
        //         return ;
        // }

        arr[curr] = student[num]; //학생이 선택한 학생 넣기
        dfs(curr+1, arr[curr], start);


        // 1 3 3
        //dfs(0, 1, 1)
        //arr[0] = 3, arr[1] = 3
        // 2 1 3 3
        //dfs(0, 2, 2)
        //arr[0] = 1, arr[1] = 3, arr[2] = 3

    }
    
}
