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
        std = new StringTokenizer(br.readLine());
        String s = std.nextToken();
        char[] ch = s.toCharArray();
        int check = 0;
        int answer = 0;
        if(ch[0] == 'E') check = 0;
        else check = 1;
        for(int i=1;i<ch.length;i++){
            if(check == 0){
                if(ch[i] == 'E') continue;
                else check = 1;
            }
            else{
                if(ch[i] == 'E') {
                    answer++;
                    check = 0;
                }
                else continue;
            }
        }
        System.out.println(answer+1);
     }
}
