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
        int a = Integer.parseInt(std.nextToken());
        char[][] ch = new char[a+1][a+1];
        for(int i=1;i<=a;i++){
            std = new StringTokenizer(br.readLine());
            String tmp = std.nextToken();
            for(int j=1;j<=a;j++){
                ch[i][j] = tmp.charAt(j-1);
            }
        }
        Queue<Integer> Q = new LinkedList<>();
        int answer = 0;
        for(int i=1;i<=a;i++){
            Queue<Integer> First_Friend = new LinkedList<>();
            int[] check = new int[a+1];
            int ans = 0;
            check[i] = 1;
            for(int j=1;j<=a;j++){
                if(ch[i][j] == 'Y') {
                    check[j] = 1;
                    First_Friend.offer(j);
                    ans++;
                }
            }
            while(!First_Friend.isEmpty()){
                int tmp = First_Friend.poll();
                for(int j=1;j<=a;j++){
                    if(ch[tmp][j] == 'Y' && check[j] == 0){
                        check[j] = 1;
                        ans++;
                    }
                }
            }
            answer = Math.max(answer,ans);
        }
        System.out.println(answer);
     }
}
