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
    public static int[] BFS(int a,int b,char[][] ch,int[][] check,int x,int y){
        Queue<point> Q = new LinkedList<>();
        Q.offer(new point(x,y));
        check[x][y] = 1;
        int[] rtr = new int[2];
        int[] ck = {1,0,-1,0};
        int[] cj = {0,1,0,-1};
        while(!Q.isEmpty()){
            point tmp = Q.poll();
            if(ch[tmp.x][tmp.y] == 'o') rtr[0]++;
            else if(ch[tmp.x][tmp.y] == 'v') rtr[1]++;
            for(int i=0;i<4;i++){
                int nx = tmp.x+ck[i];
                int ny = tmp.y+cj[i];
                if(nx>=0&&nx<a&&ny>=0&&ny<b&&check[nx][ny] == 0 && ch[nx][ny] != '#'){
                    check[nx][ny] = 1;
                    Q.offer(new point(nx,ny));
                }
            }
        }
        return rtr;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer std = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();
        int a = Integer.parseInt(std.nextToken());
        int b = Integer.parseInt(std.nextToken());
        char[][] ch = new char[a][b];
        int[][] check = new int[a][b];
        for(int i=0;i<a;i++){
            std = new StringTokenizer(br.readLine());
            String tmp = std.nextToken();
            ch[i] = tmp.toCharArray();
        }
        int sheep = 0;
        int wolf = 0;
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if((ch[i][j] == 'o' || ch[i][j] == 'v') && check[i][j] == 0){
                    int[] rtr = BFS(a,b,ch,check,i,j);
                    if(rtr[0] > rtr[1]) sheep += rtr[0];
                    else wolf += rtr[1];
                }
            }
        }
        System.out.println(sheep+" "+wolf);
    }
}
