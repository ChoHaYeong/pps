package 일단풀어보기;

import java.io.*;
import java.util.*;

public class BOJ1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                if(Integer.compare(str1.length(), str2.length()) < 0 ) return -1;
                else if(Integer.compare(str1.length(), str2.length()) > 0 ) return 1;
                else {
                    if(str1.compareTo(str2) < 0) return -1;
                    else if(str1.compareTo(str2) > 0) return 1;
                    else {
                        return 0;
                    }
                }
            }
        });

        for(String l : list)
            System.out.println(l);
    }
}
