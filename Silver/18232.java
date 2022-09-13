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
        std = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(std.nextToken());
        int E = Integer.parseInt(std.nextToken());
        List<Integer>[] list = new List[N+1];
        for(int i=0;i<N+1;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            std = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(std.nextToken());
            int y = Integer.parseInt(std.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        Queue<Integer> Q = new LinkedList<>();
        int[] check = new int[N+1];
        check[S] = 1;
        Q.offer(S);
        int answer = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++) {
                int tmp = Q.poll();
                if(tmp == E) {
                    str.append(answer);
                    answer = -1;
                    break;
                }
                if (tmp + 1 < check.length && check[tmp + 1] == 0) {
                    check[tmp + 1] = 1;
                    Q.offer(tmp + 1);
                }
                if (tmp - 1 >= 1 && check[tmp - 1] == 0) {
                    check[tmp - 1] = 1;
                    Q.offer(tmp - 1);
                }
                for (int x : list[tmp]) {
                    if (check[x] == 0) {
                        Q.offer(x);
                        check[x] = 1;
                    }
                }
            }
            if(answer == -1) break;
            answer++;
        }
        bw.write(str.toString());
        bw.flush();
        bw.close();
     }
}
