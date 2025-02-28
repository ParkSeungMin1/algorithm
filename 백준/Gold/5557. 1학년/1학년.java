import java.io.*;
import java.util.*;

public class Main {
    static int n,endNum;
    static int[] arr;
    static long dp[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String [] s = br.readLine().split(" ");
        arr = new int[n-1];
        for(int i=0;i<n-1;i++) arr[i] = Integer.parseInt(s[i]);
        endNum = Integer.parseInt(s[n-1]);
        dp = new long[n-1][21];

        dp[0][arr[0]] = 1;
        for(int i=1;i<n-1;i++){
            for(int j=0;j<=20;j++){
                if(dp[i-1][j] >= 1){
                    if(j+arr[i] >=0 && j+arr[i] <=20){
                        dp[i][j+arr[i]] += dp[i-1][j];
                    }
                    if(j-arr[i] >=0 && j-arr[i] <=20){
                        dp[i][j-arr[i]] += dp[i-1][j];
                    }
                }
            }
        }
        System.out.println(dp[n-2][endNum]);
    }

}