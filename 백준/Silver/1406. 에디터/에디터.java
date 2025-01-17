import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayDeque<String> Left = new ArrayDeque<>();
        ArrayDeque<String> Right = new ArrayDeque<>();
        String s = br.readLine();
        for(int i=0;i<s.length();i++){
            Left.addLast(s.charAt(i)+"");
        }
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[] split = br.readLine().split(" ");
            if(split[0].equals("L")){
                if(Left.isEmpty()) continue;
                Right.addFirst(Left.pollLast());
            }
            else if(split[0].equals("D")){
                if(Right.isEmpty()) continue;
                Left.addLast(Right.pollFirst());
            }
            else if(split[0].equals("B")){
                if(Left.isEmpty()) continue;
                Left.pollLast();
            }
            else{
                Left.addLast(split[1]);
            }
        }
        for(;!Left.isEmpty();){
            sb.append(Left.pollFirst());
        }
        for (;!Right.isEmpty();){
            sb.append(Right.pollFirst());
        }
        System.out.print(sb);
    }
}