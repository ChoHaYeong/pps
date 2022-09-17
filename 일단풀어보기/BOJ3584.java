package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3584 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    static boolean[] rootCheck;
    static int[] depth, parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            rootCheck = new boolean[N+1];
            depth = new int[N+1];
            parent = new int[N+1];
            list = new ArrayList<ArrayList<Integer>>();
            Arrays.fill(rootCheck, true);

            for(int j=0; j<=N; j++)
                list.add(new ArrayList<>());
            
            for(int j=0; j<N-1; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                list.get(to).add(from);
                list.get(from).add(to);
                rootCheck[from] = false;
            }
            int rootIdx = 0;
            for(int j=1; j<=N; j++){
                if(rootCheck[j]){
                    rootIdx = j;
                    break;
                }
            }

            //System.out.println("rootIdx" + rootIdx);
            dfs(rootIdx, 1, rootIdx);
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a, b));


        }
    }

    static void dfs(int root, int curr, int p) {
        depth[root] = curr;
        parent[root] = p;

        for(int l : list.get(root)) {
            if(l != p)
                dfs(l, curr+1, root);
        }
    }

    static int lca(int a, int b) {
        int depthA = depth[a];
        int depthB = depth[b];

        while(depthA < depthB) {
            depthB--;
            b = parent[b]  ;
        }

        while(depthA > depthB) {
            depthA--;
            a = parent[a]  ;
        }

        while(a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}


/**
 * 노드 연결 데이터를 입력 받아 저장한다.
루트노드를 선별하는 방식은 자식 노드는 check를 해준다. 그리고 입력이 끝난 후에 check가 되지 않은 노드가 루트노드이다.
저장된 노드 데이터를 root노드부터 DFS 탐색하여 노드의 부모 노드와 높이의 값을 저장한다. depth[], parents[]
두 a,b 노드의 최소 공통 조상을 구해준다.
두 노드의 높이(depth)를 맞춰준다.  ah--; or bh--;
높이가 일치되었으면 부모노드가 일치할 때 까지 부모노드를 탐색한 후 일치하게 되면 출력한다. while(a!=b) a = parents[a]; b = parents[b];
 
 */