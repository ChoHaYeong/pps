package cp연습_BF;

import java.io.*;
import java.util.*;

public class BOJ1339 {
    static int N, M, max = 0;
    static String[] arr;
   // static int[] d;
    static boolean[] visited = new boolean[10];
    static int[] alpha = new int[256]; //alpha[i] = j alpha[A]( = alpha[65]) i문자가 갖는 값이 j 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i=0; i<N; i++) 
            arr[i] = br.readLine();

        Set<Character> set = new HashSet<>();
        for(String a: arr){
            for(int i=0; i<a.length(); i++)
                set.add(a.charAt(i));
        }
        Character[] letters = set.toArray(new Character[set.size()]);
        M = letters.length;
        int[] d = new int[M];
        for(int i=0; i<M; i++)
            d[i] = 9-i;
        Arrays.sort(d);

        int ans = 0;
        do {
            int now  = go(letters, d);
            if (ans < now) ans = now;
        }
        while(next_permutation(d)); 
        System.out.println(ans);
    }

    static int go(Character[] letters, int[] d) {
        int sum =0;
        for(int i=0; i<M; i++)
            alpha[letters[i]] = d[i];
        
        for(String s: arr) {
            int now = 0;
            for(char x : s.toCharArray())
                now = now * 10 + alpha[x];
            sum += now;
        }
       // System.out.println(sum);
        return sum;
    }

    static boolean next_permutation(int[] a) {
        int i = a.length - 1;
        while(i > 0 && a[i-1] >= a[i]) i--;

        if(i <= 0) return false;

        int j = a.length-1;
        while(a[i-1] >= a[j]) j--;

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j= a.length-1;
        while(i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}
