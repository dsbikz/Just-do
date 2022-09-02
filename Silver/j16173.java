import java.io.*;
import java.util.*;
class point{
    int x,y;
    point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
public class j16173 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer std = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();
        int N = Integer.parseInt(std.nextToken());
        int[][] ch = new int[N][N];
        for(int i=0;i<N;i++){
            std = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                ch[i][j] = Integer.parseInt(std.nextToken());
            }
        }
        Queue<point> Q = new LinkedList<>();
        int[][] check = new int[N][N];
        check[0][0] = 1;
        Q.offer(new point(0,0));
        while(!Q.isEmpty()){
            point tmp = Q.poll();
            if(tmp.x == N-1&&tmp.y == N-1) break;
            int nx = tmp.x+ch[tmp.x][tmp.y];
            int ny = tmp.y+ch[tmp.x][tmp.y];
            if(nx>=0&&nx<N&&tmp.y>=0&&tmp.y<N&&check[nx][tmp.y] == 0) {
                check[nx][tmp.y] = 1;
                Q.offer(new point(nx,tmp.y));
            }
            if(tmp.x>=0&&tmp.x<N&&ny>=0&&ny<N&&check[tmp.x][ny] == 0){
                check[tmp.x][ny] = 1;
                Q.offer(new point(tmp.x,ny));
            }
        }
        if(check[N-1][N-1] == 1) System.out.println("HaruHaru");
        else System.out.println("Hing");
     }
}
