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
        int col = Integer.parseInt(std.nextToken());
        int row = Integer.parseInt(std.nextToken());
        char[][] ch = new char[row][col];
        for(int i=0;i<row;i++){
            std = new StringTokenizer(br.readLine());
            String s = std.nextToken();
            ch[i] = s.toCharArray();
        }
        int[][] check = new int[row][col];
        Queue<point> Q = new LinkedList<>();
        int[] ck = {1,0,-1,0};
        int[] cj = {0,1,0,-1};
        int our_solidier = 0;
        int their_soilder = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(check[i][j] == 0){
                    check[i][j] = 1;
                    Q.offer(new point(i,j));
                    int count = 1;
                    while(!Q.isEmpty()){
                        point tmp = Q.poll();
                        for(int k=0;k<4;k++){
                            int nx = tmp.x+ck[k];
                            int ny = tmp.y+cj[k];
                            if(nx>=0&&nx<row&&ny>=0&&ny<col&&ch[nx][ny] == ch[i][j]&&check[nx][ny] == 0){
                                check[nx][ny] = 1;
                                Q.offer(new point(nx,ny));
                                count++;
                            }
                        }
                    }
                    if(ch[i][j] == 'W') our_solidier += (int)(Math.pow((double)count,2));
                    else their_soilder += (int)(Math.pow((double)count,2));
                }
            }
        }
        System.out.print(our_solidier+" "+their_soilder);
     }
}
