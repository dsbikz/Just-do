import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
       for(int i = 1;i<=9;i++){
           for(int j = 1;j<=9; j++){
               System.out.print(j+" x "+i+" = "+(j*i)+ " ");
           }
           System.out.println();
       }


    }
}