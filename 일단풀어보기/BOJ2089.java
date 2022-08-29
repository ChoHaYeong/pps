package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();

        if(num == 0){
            System.out.println(0);
            return ;
        }

        while(num != 0) {
            list.add(Math.abs( num % -2));
            num = (int) Math.ceil((double) num / -2) ;
           // System.out.println(num);
        }

        for(int i=list.size()-1; i>=0; i--) 
           
                System.out.print(list.get(i));
    }

    

}
