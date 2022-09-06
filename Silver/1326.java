import java.io.*;
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
        int N = Integer.parseInt(std.nextToken());
        int[] ch = new int[N+1];
        std = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) ch[i] = Integer.parseInt(std.nextToken());
        std = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(std.nextToken());
        int b = Integer.parseInt(std.nextToken());
        Queue<Integer> Q = new LinkedList<>();
        int[] check = new int[N+1];
        Q.offer(a);
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int i=tmp+ch[tmp];i<ch.length;i+=ch[tmp]){
                if(check[i] == 0){
                    check[i] = check[tmp] + 1;
                    Q.offer(i);
                }
            }
            for(int i = tmp-ch[tmp];i>=1;i -= ch[tmp]){
                if(check[i] == 0){
                    check[i] = check[tmp]+1;
                    Q.offer(i);
                }
            }
            if(check[b] != 0) break;
        }
        if( a== b) System.out.println(0);
        else if(check[b] == 0) System.out.println(-1);
        else System.out.println(check[b]);
     }
}