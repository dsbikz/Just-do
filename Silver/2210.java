import java.io.*;
import java.util.*;
class point{
    int x,y,count;
    String string;
    point(int x,int y,int count,String string){
        this.x=x;
        this.y=y;
        this.count = count;
        this.string = string;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer std = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();
        char[][] ch = new char[5][5];
        for(int i=0;i<5;i++){
            if(i!=0) std = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                ch[i][j] = (char)Integer.parseInt(std.nextToken());
            }
        }
        HashMap<String,Integer> map = new HashMap<>();
        int[] ck = {1,0,-1,0};
        int[] cj = {0,1,0,-1};
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                String st = ""+ch[i][j];
                Queue<point> Q = new LinkedList<>();
                Q.offer(new point(i,j,1,st));
                while(!Q.isEmpty()){
                    point tmp = Q.poll();
                    for(int k=0;k<4;k++){
                        int nx = tmp.x+ck[k];
                        int ny = tmp.y+cj[k];
                        if(nx>=0&&nx<5&&ny>=0&&ny<5){
                            String s= tmp.string+ch[nx][ny];
                            if(s.length() == 6) map.put(s,map.getOrDefault(s,0)+1);
                            else Q.offer(new point(nx,ny,tmp.count+1,s));
                        }
                    }
                }
            }
        }
        System.out.println(map.size());
     }
}
