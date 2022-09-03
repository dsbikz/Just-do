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
        int Row = Integer.parseInt(std.nextToken());
        int Col = Integer.parseInt(std.nextToken());
        char[][] ch = new char[Row][Col];
        for(int i=0;i<Row;i++){
            std = new StringTokenizer(br.readLine());
            String tmp = std.nextToken();
            ch[i] = tmp.toCharArray();
        }
        int[][] check = new int[Row][Col];
        int answer = 0;
        for(int i=0;i<Row;i++){
            for(int j=0;j<Col;j++){
                if(check[i][j] == 0){
                    if(ch[i][j] == '-'){
                        for(int k=j;k<Col;k++) {
                            if(ch[i][k] == '-') check[i][k] = 1;
                            else break;
                        }
                    }
                    else{
                        for(int k=i;k<Row;k++) {
                            if(ch[k][j] == '|') check[k][j] = 1;
                            else break;
                        }
                    }
                    answer++;
                }
            }
        }
        System.out.println(answer);
     }
}
