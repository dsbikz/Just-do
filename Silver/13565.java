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
        int row = Integer.parseInt(std.nextToken());
        int col = Integer.parseInt(std.nextToken());
        int[][] ch = new int[row][col];
        Queue<point> Q = new LinkedList<>();
        for(int i=0;i<row;i++){
            std = new StringTokenizer(br.readLine());
            String tmp = std.nextToken();
            for(int j=0;j<col;j++){
                ch[i][j] = tmp.charAt(j)-'0';
            }
        }
        for(int i=0;i<col;i++) {
            if(ch[0][i] == 0){
                ch[0][i] = -1;
                Q.offer(new point(0,i));
            }
        }
        int[] ck = {1,0,-1,0};
        int[] cj = {0,1,0,-1};
        while(!Q.isEmpty()){
            point tmp = Q.poll();
            for(int i=0;i<4;i++){
                int nx = tmp.x+ck[i];
                int ny = tmp.y+cj[i];
                if(nx>=0&&nx<row&&ny>=0&&ny<col&&ch[nx][ny] == 0){
                    ch[nx][ny] =- 1;
                    Q.offer(new point(nx,ny));
                }
            }
        }
        int check = 0;
        for(int i=0;i<col;i++){
            if(ch[row-1][i] == -1){
                check = 1;
                break;
            }
        }
        if(check == 1) System.out.println("YES");
        else System.out.println("NO");

     }
}
