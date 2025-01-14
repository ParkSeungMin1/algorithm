import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()),ret=0;
        ArrayList<Integer> arr = new ArrayList<>();
        int[] tmp_arr = new int[n];

        for(int i=0;i<n;i++) tmp_arr[i] = Integer.parseInt(br.readLine());
        for(int i=1;i<n;i++) arr.add(Math.abs(tmp_arr[i]-tmp_arr[i-1]));

        for(int i=0;i<arr.size();i++){
            if(i==0) ret = arr.get(0);
            ret = gcd(ret,arr.get(i));
        }
        for(int i=2;i<=ret/2;i++){
            if(ret%i==0) sb.append(i).append(" ");
        }
        sb.append(ret);
        System.out.print(sb);
    }

    public static int gcd(int a,int b){
        if(a==b) return a;
        if(a==0 || b==0) return 1;
        int q,r1=Math.max(a,b),r2=Math.min(a,b),r,s1=1,s2=0,s,t1=0,t2=1,t;
        for(;r2>0;){
            q = r1/r2;
            r = r1 - q*r2;
            s = s1 - q*s2;
            t = t1 - q*t2;
            r1=r2;r2=r;s1=s2;s2=s;t1=t2;t2=t;
        }
        return r1;
    }
}