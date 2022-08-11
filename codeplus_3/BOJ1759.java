package codeplus_3;

import java.io.*;
import java.util.*;

public class BOJ1759 {
    static int L, C;
    static char[] ch;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ch = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            ch[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(ch);
        dfs(0, "");
    }
    

    static void dfs(int curr, String pwd) {
        if(curr == L) {
            //모음 최소 1개인지, 자음 최소 2개인지 확인하기

            if(isOkay(pwd))
                System.out.println(pwd);
            return ;
        }
        for(int i=0; i<C; i++) {
            if(!visited[i] && (curr == 0 || (curr > 0 && pwd.charAt(pwd.length()-1) < ch[i]))) { // 중복허용 안함
                visited[i] = true;
                dfs(curr+1, pwd + ch[i]);
                visited[i] = false;
            }
        }
    }

    static boolean isOkay(String str) {
        
        boolean flag = false;
        if(str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u"))
            flag =  true;

        int count = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) != 'a' && str.charAt(i) != 'e' && str.charAt(i) != 'i' && str.charAt(i) != 'o' && str.charAt(i) != 'u')
                count++;
        }

        if(flag && count >= 2) {
            return true;
        }

        return false;
    }
}
