import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int a = Math.min(Integer.parseInt(input[0]),Integer.parseInt(input[1])),b = Math.max(Integer.parseInt(input[0]),Integer.parseInt(input[1]));

        int max=1;
        for(int i=2;i<=b;i++){
            if(a%i==0 && b%i==0){
                max = i;
            }
        }
        for(int i=b;;i++){
            if(i%a==0 && i%b==0) {
                sb.append(max).append("\n").append(i);
                break;
            }
        }

        System.out.println(sb);
    }
}