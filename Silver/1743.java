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
        int[][] ch = new int[N][M];
        int[][] check = new int[N][M];
        for(int i=0;i<K;i++){
            std = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(std.nextToken());
            int y = Integer.parseInt(std.nextToken());
            ch[x-1][y-1] = 1;
        }
        int answer = 0;
        Queue<point> Q = new LinkedList<>();
        int[] ck = {1,0,-1,0};
        int[] cj = {0,1,0,-1};
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(ch[i][j] == 1){
                    int count = 1;
                    ch[i][j] = 0;
                    Q.offer(new point(i,j));
                    while(!Q.isEmpty()){
                        point tmp = Q.poll();
                        for(int k=0;k<4;k++){
                            int nx = tmp.x+ck[k];
                            int ny = tmp.y+cj[k];
                            if(nx>=0&&nx<N&&ny>=0&&ny<M&&ch[nx][ny] == 1){
                                ch[nx][ny] = 0;
                                count++;
                                Q.offer(new point(nx,ny));
                            }
                        }
                    }
                    answer = Math.max(answer,count);
                }
            }
        }
        System.out.println(answer);
    }
}
