public import java.io.*;
import java.util.*;
class point{
    int x,y;
    point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer std = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();
        int a = Integer.parseInt(std.nextToken());
        int k = Integer.parseInt(std.nextToken());
        Queue<Integer> Q = new LinkedList<>();
        int[] check = new int[1000001];
        Q.offer(a);
        int answer = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                int tmp = Q.poll();
                if(tmp == k) {
                    str.append(answer);
                    answer = -1;
                    break;
                }
                if(tmp+1<check.length&&check[tmp+1] == 0){
                    check[tmp+1] = 1;
                    Q.offer(tmp+1);
                }
                if(tmp*2<check.length&&check[tmp*2] == 0){
                    check[tmp*2] = 1;
                    Q.offer(tmp*2);
                }
            }
            if(answer == -1) break;
            answer++;
        }
        System.out.println(str.toString());
     }
}
 25418 {
    
}
