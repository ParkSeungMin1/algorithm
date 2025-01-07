import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()),ret=0;
        boolean [] prime = new boolean[1001];
        boolean flag= false;
        String [] s = br.readLine().split(" ");

        for(int i=2;i<=1000;i++){
            flag = false;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j == 0) flag = true;
            }
            if(flag == false) prime[i] = true;
        }
        for(String tmp : s){
            if(prime[Integer.parseInt(tmp)]) ret++;
        }
        sb.append(ret);
        System.out.println(sb.toString());
    }
}