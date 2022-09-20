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
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer std = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();
        Scanner key = new Scanner(System.in);
        int a = key.nextInt();
        int[][] ch = new int[9][9];
        int[] ck = {1,1,-1,-1};
        int[] cj = {1,-1,1,-1};
        for(int i=0;i<a;i++){
            int x = ((int) key.next().charAt(0)) -64;
            int y = key.nextInt();
            int x2 = ((int) key.next().charAt(0)) -64;
            int y2 = key.nextInt();
            Queue<point> Q = new LinkedList<>();
            Q.offer(new point(9-y,x));
            int count = 0;
            int[][] check = new int[9][9];
            check[9-y][x] = 1;
            if(x2 == x && y2 == y){
                str.append(count+" "+(char)(x+64)+" "+y+"\n");
                Q.poll();
                count = -1;
            }
//            System.out.println("y2 = "+y2+ " x2  = "+x2);
            while(!Q.isEmpty()){
                int len = Q.size();
                for(int j=0;j<len;j++){
                    point tmp = Q.poll();
                    for(int k=0;k<4;k++){
                        int nx = tmp.x+ck[k];
                        int ny = tmp.y+cj[k];
                        while(nx>=1&&nx<9&&ny>=1&&ny<9){
                            if(check[nx][ny] == 0) {
                                check[nx][ny] = 1;
                                Q.offer(new point(nx, ny));
                                if (nx == 9 - y2 && ny == x2) {
                                    if (count == 0)
                                        str.append((count + 1) + " " + (char) (x + 64) + " " + y + " " + (char) (x2 + 64) + " " + y2 + "\n");
                                    else if (count == 1)
                                        str.append((count + 1) + " " + (char) (x + 64) + " " + y + " " + (char) (tmp.y + 64) + " " + (9 - tmp.x) +" "+ (char) (x2 + 64) + " " + y2 + "\n");
                                    count = -1;
                                    break;
                                }
                            }
                            nx = nx+ck[k];
                            ny = ny+cj[k];
                        }
                        if(count == -1) break;
                    }
                    if(count == -1) break;
                }
                if(count == -1) break;
                count++;
            }
            if(count != -1) str.append("Impossible\n");

        }
        System.out.println(str.toString());
    }
}
