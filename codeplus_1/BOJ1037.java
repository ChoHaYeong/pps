package codeplus_1;

import java.io.*;
import java.util.*;

public class BOJ1037 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        if(C == 1)
            System.out.println(arr[0] * arr[0]);
        else
            System.out.println(arr[0] * arr[arr.length-1]);

    }
    
}
