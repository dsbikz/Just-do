import java.io.*;
import java.util.*;
class point{
    int x,y,count;
    String string;
    point(int x,int y,int count,String string){
        this.x=x;
        this.y=y;
        this.count = count;
        this.string = string;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer std = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();
        int T = Integer.parseInt(std.nextToken());
        std = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(std.nextToken());
        List<Integer>[] list = new List[T+1];
        for(int i=0;i<T+1;i++) list[i] = new ArrayList<>();
        for(int i=0;i<n;i++){
            std = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(std.nextToken());
            int y = Integer.parseInt(std.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        int[] check = new int[T+1];
        Queue<Integer> Q = new LinkedList<>();
        for(int x : list[1]) {
            check[x] = 1;
            Q.offer(x);
        }
        int answer = Q.size();
        check[1] = 1;
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for(int x : list[tmp]){
                if(check[x] == 0){
                    check[x] = 1;
                    answer++;
                }
            }
        }
        System.out.println(answer);
     }
}
