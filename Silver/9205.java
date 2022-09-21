import java.io.*;
import java.util.*;
class point{
    int x,y,beer,count;
    point(int x,int y,int beer,int count){
        this.x=x;
        this.y=y;
        this.beer = beer;
        this.count = count;
    }
}
public class Main {
    public static boolean BFS(int startx,int starty,int finalx,int finaly,List<int[]> list){
        Queue<int[]> Q = new LinkedList<>();
        int[] check = new int[list.size()];
        Q.offer(new int[]{startx,starty});
        while(!Q.isEmpty()){
            int[] tmp = Q.poll();
            int dx = tmp[0];
            int dy = tmp[1];
            if(Math.abs(dx-finalx)+Math.abs(dy-finaly)<=1000) return true;
            else{
                for(int i=0;i<list.size();i++){
                    if(check[i] == 0){
                        int[] x = list.get(i);
                        if(Math.abs(dx-x[0])+Math.abs(dy-x[1])<=1000){
                            Q.offer(new int[]{x[0],x[1]});
                            check[i] = 1;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer std = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();
        int t = Integer.parseInt(std.nextToken());
        for(int T=0;T<t;T++) {
            std = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(std.nextToken());
            std = new StringTokenizer(br.readLine());
            int startx = Integer.parseInt(std.nextToken());
            int starty = Integer.parseInt(std.nextToken());
            List<int[]> list = new ArrayList<>();
            for(int i=0;i<n;i++){
                std = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(std.nextToken());
                int y = Integer.parseInt(std.nextToken());
                list.add(new int[]{x,y});
            }
            std = new StringTokenizer(br.readLine());
            int finalx = Integer.parseInt(std.nextToken());
            int finaly = Integer.parseInt(std.nextToken());
            int[] ck = {1,0,-1,0};
            int[] cj = {0,1,0,-1};
            if(BFS(startx,starty,finalx,finaly,list)) str.append("happy\n");
            else str.append("sad\n");
        }

        System.out.println(str.toString());

    }
}
