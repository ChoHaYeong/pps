package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while((str = br.readLine()) != null) {
          //  String str = sc.next();
            //if(str == null)  break;
            //String str = br.readLine();
            int beforeLen = str.length();
            int bigLetter = 0;
            int smallLetter = 0;
            int num = 0;
            for(int i=0; i<beforeLen; i++) {
                if(str.charAt(i) >= 48 && str.charAt(i) <=57)
                    num++;
                if(str.charAt(i) >= 65 && str.charAt(i) <=90)
                    bigLetter++;
                if(str.charAt(i) >= 97 && str.charAt(i) <=122)
                    smallLetter++;
            }
            String afterStr = str.replace(" ", "");
            int afterLen = afterStr.length();
            //System.out.println(str + " (길이 : " + beforeLen + ") => " + afterStr + " (길이 : " + afterLen + ")");
            System.out.println(smallLetter + " " + bigLetter + " " + num + " " + (beforeLen-afterLen)); 
        }
        
    }
    
}
