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
        int[] ch = new int[N];
        std = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) ch[i] = Integer.parseInt(std.nextToken());
        std = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(std.nextToken());
        int[] check = new int[10000];
        int answer  = 0;
        for(int i=1;i<check.length;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<ch.length;j++){
                if(i-ch[j]<0) break;
                min = Math.min(check[i-ch[j]],min);
            }
            if(min == k) {
                answer = i;
                break;
            }
            check[i] = min+1;
        }
        if(answer % 2 == 0) System.out.println("holsoon win at "+answer);
        else System.out.println("jjaksoon win at "+answer);
    }
}
