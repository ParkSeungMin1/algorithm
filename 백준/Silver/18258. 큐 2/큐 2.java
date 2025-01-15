import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=1;i<=n;i++){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("push")){
                q.add(Integer.parseInt(s[1]));
            }
            else if(s[0].equals("pop")){
                if(q.peek() == null) sb.append("-1\n");
                else sb.append(q.poll()).append("\n");
            }
            else if(s[0].equals("size")){
                sb.append(q.size()).append("\n");
            }
            else if(s[0].equals("empty")){
                if(q.isEmpty()) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(s[0].equals("front")){
                if(q.isEmpty()) sb.append("-1\n");
                else sb.append(q.peek()).append("\n");
            }
            else {
                if (q.isEmpty()) sb.append("-1\n");
                else sb.append(q.peekLast()).append("\n");
            }
        }
        System.out.print(sb);
    }
}