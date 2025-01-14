import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n,m,ret=0;

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        s = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Math.abs(m-Integer.parseInt(s[i]));
            if(i==0) ret = arr[i];
            ret = gcd(ret,arr[i]);
        }
        System.out.println(ret);
    }

    public static int gcd(int a,int b){
        if(a==b) return a;
        int q,r1=Math.max(a,b),r2=Math.min(a,b),r,s,s1=1,s2=0,t,t1=0,t2=1;
        for(;r2!=0;){
            q = r1/r2;
            r = r1 - q*r2;
            s = s1 - q*s2;
            t = t1 - q*t2;
            r1=r2;r2=r;s1=s2;s2=s;t1=t2;t2=t;
        }
        return r1;
    }
}