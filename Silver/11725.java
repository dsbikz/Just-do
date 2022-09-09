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
        int T = Integer.parseInt(std.nextToken());
        List<Integer>[] list = new List[T+1];
        for(int i=0;i<T+1;i++) list[i] = new ArrayList<>();
        for(int i=0;i<T-1;i++){
            std = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(std.nextToken());
            int y = Integer.parseInt(std.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        int[] check = new int[T+1];
        int[] parent = new int[T+1];
        check[1] = 1;
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int x : list[tmp]){
                if(check[x] == 0){
                    check[x] = 1;
                    parent[x] = tmp;
                    Q.offer(x);
                }
            }
        }
        for(int i=2;i<parent.length;i++){
            System.out.println(parent[i]);
        }
     }
}
