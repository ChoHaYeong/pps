package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[Math.max(n, m)+1];

        for(int i=1; i<= Math.max(n, m); i++)
            parent[i] = i;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(command == 0) union(x, y);
            if(command == 1) {
                if(findParent(x, y)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x < y) 
            parent[y] = x;
        else if(y > x)
            parent[x] = y;
    }

    static int find(int x) {
       // System.out.println(x + " " + parent[x]);
        if(x == parent[x])
            return x;
        else 
            return parent[x] = find(parent[x]);
    }

    static boolean findParent(int x, int y) {
        x = find(x);
        y = find(y);

        if(x == y) return true;
        else return false;
    }
}
