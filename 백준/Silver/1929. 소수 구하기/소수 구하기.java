import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean flag = false;
        String [] s = bf.readLine().split(" ");
        int a = Integer.parseInt(s[0]) , b = Integer.parseInt(s[1]);
        boolean [] isNotPrime = new boolean[1000005]; // 1 소수, 0 기본, -1 소수아님
        for(int i=2;i<=Math.sqrt(b);i++){
            if(isNotPrime[i]) continue;
            for(int j=i*i;j<=1000000;j+=i){
                isNotPrime[j]=true;
            }
        }
        for(int i=Math.max(2,a);i<=b;i++){
            if(!isNotPrime[i]) sb.append(i).append("\n");
        }
        System.out.print(sb.toString());
    }
}