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
        int M = Integer.parseInt(std.nextToken());
        int K = Integer.parseInt(std.nextToken());
        int X = Integer.parseInt(std.nextToken());
        List<Integer>[] list = new List[N+1];
        for(int i=0;i<N+1;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            std = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(std.nextToken());
            int y = Integer.parseInt(std.nextToken());
            list[x].add(y);
        }
        int[] check = new int[N+1];
        check[X] = 1;
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(X);
        int count = 0;
        while(!Q.isEmpty()){
            if(count == K) break;
            int len = Q.size();
            for(int i=0;i<len;i++){
                int tmp = Q.poll();
                for(int x : list[tmp]){
                    if(check[x] == 0){
                        check[x] = 1;
                        Q.offer(x);
                    }
                }
            }
            count++;
        }
        if(Q.size() == 0 || count < K) System.out.println(-1);
        else{
            ArrayList<Integer> ans = new ArrayList<>();
            while(!Q.isEmpty()) ans.add(Q.poll());
            Collections.sort(ans);
            for(int x : ans) str.append(x+"\n");
            bw.write(str.toString());
            bw.flush();
            bw.close();
        }
     }
}
