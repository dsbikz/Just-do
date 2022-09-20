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
        int X = Integer.parseInt(std.nextToken())+500;
        int Y = Integer.parseInt(std.nextToken())+500;
        int N = Integer.parseInt(std.nextToken());
        int[][] ch = new int[1001][1001];
        for(int i=0;i<N;i++){
            std = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(std.nextToken());
            int y = Integer.parseInt(std.nextToken());
            ch[500+x][500+y] = -1;
        }
        Queue<point> Q = new LinkedList<>();
        Q.offer(new point(500,500));
        ch[500][500] = -1;
        int count = 0;
        int[] ck = {1,0,-1,0};
        int[] cj = {0,1,0,-1};
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0;i<len;i++){
                point tmp = Q.poll();
                if(tmp.x == X && tmp.y == Y) {
                    System.out.println(count);
                    count = -1;
                    break;
                }
                for(int k=0;k<4;k++){
                    int nx = tmp.x+ck[k];
                    int ny = tmp.y+cj[k];
                    if(nx>=0&&nx<1001&&ny>=0&&ny<1001&&ch[nx][ny] != -1){
                        ch[nx][ny] = -1;
                        Q.offer(new point(nx,ny));
                    }
                }
            }
            if(count == -1) break;
            count++;
        }
    }
}
