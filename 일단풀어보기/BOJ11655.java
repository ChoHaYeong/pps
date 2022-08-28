package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String newStr = "";

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) >= 65 && str.charAt(i)<= 90){
                char newCh = (char) (str.charAt(i) + 13);
                if(newCh > 90) newCh -= 26;
                newStr += newCh;
            }
            else if(str.charAt(i) >= 97 && str.charAt(i)<= 122) {
                char newCh = (char) (str.charAt(i) + 13);
                if(newCh > 122) newCh -= 26;
                newStr += newCh;
            }
            else 
                newStr += str.charAt(i);
        }

        System.out.println(newStr);
    }
    
}
