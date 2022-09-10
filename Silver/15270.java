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
    static int answer = 0;
    public static void DFS(int k, int N,int[] check,List<Integer>[] list,int count){
        for(int i=k;i<=N;i++){
            if(check[i] == 0){
                for(int x : list[i]){
                    if(check[x] == 0){
                        check[x] = 1;
                        check[i] = 1;
                        DFS(k+1,N,check,list,count+2);
                        check[x] = 0;
                        check[i] = 0;
                    }
                }
            }
        }
        if(count == check.length-1) answer = Math.max(answer,count);
        else answer = Math.max(answer,count+1);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer std = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();
        int N = Integer.parseInt(std.nextToken());
        int M = Integer.parseInt(std.nextToken());
        List<Integer>[] list = new List[N+1];
        int[] count = new int[N+1];
        for(int i=0;i<N+1;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            std = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(std.nextToken());
            int y = Integer.parseInt(std.nextToken());
            int min = Math.min(x,y);
            int max = Math.max(x,y);
            list[min].add(max);
        }
        int[] check = new int[N+1];
//        for(int i=1;i<=N;i++){
//            System.out.print("i = "+ i+" : ");
//            for(int x : list[i]) System.out.print(x+" ");
//            System.out.println();
//        }
        DFS(1,N,check,list,0);
        System.out.println(answer);
     }
}
