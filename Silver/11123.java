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
        int T = Integer.parseInt(std.nextToken());
        for(int t=0;t<T;t++){
            std = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(std.nextToken());
            int col = Integer.parseInt(std.nextToken());
            char[][] ch = new char[row][col];
            for(int i=0;i<row;i++){
                std = new StringTokenizer(br.readLine());
                String tmp = std.nextToken();
                ch[i] = tmp.toCharArray();
            }
            Queue<point> Q = new LinkedList<>();
            int[][] check = new int[row][col];
            int[] ck = {1,0,-1,0};
            int[] cj = {0,1,0,-1};
            int answer = 0;
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(ch[i][j] == '#' && check[i][j] == 0){
                        Q.offer(new point(i,j));
                        check[i][j] = 1;
                        while(!Q.isEmpty()){
                            point tmp = Q.poll();
                            for(int k=0;k<4;k++){
                                int nx = tmp.x+ck[k];
                                int ny = tmp.y+cj[k];
                                if(nx>=0&&nx<row&&ny>=0&&ny<col&&ch[nx][ny] == '#' && check[nx][ny] == 0){
                                    check[nx][ny] = 1;
                                    Q.offer(new point(nx,ny));
                                }
                            }
                        }
                        answer++;
                    }
                }
            }
            str.append(answer+"\n");
        }
        System.out.println(str.toString());
     }
}
