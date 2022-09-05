package bigmac;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int a = key.nextInt();
        int i = a;
        for(i=1;i<=a;i++) {
            for(int j = 0;j<i;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        }

    }
    
    
    
    
    
    import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int a = key.nextInt();
        int i = 1;
        while (i < a) {
            for(int j = 0;j<i;j++){
                System.out.print(" * ");
            }
            System.out.println();
            i++;
        }
    }