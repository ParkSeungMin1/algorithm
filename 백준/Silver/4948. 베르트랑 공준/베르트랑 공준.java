import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean [] isNotPrime = new boolean[246913];
        isNotPrime[1] = true;

        for(int i=2;i<=Math.sqrt(246912);i++) {
            if(isNotPrime[i]) continue;
            for(int j=i*i;j<=246912;j+=i) {
                isNotPrime[j] = true;
            }
        }


        for(;;){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int ret=0;
            for(int i=n+1;i<=2*n;i++){
                if(!isNotPrime[i]) ret++;
            }
            sb.append(ret).append("\n");
        }
        System.out.println(sb);
    }
}