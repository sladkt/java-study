import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = new String[5];
       
        int max = 0;
        for (int i = 0; i < 5; i++) {
            str[i] = sc.next();
            if(max < str[i].length()) max = str[i].length();
        }

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if(i < str[j].length()) {
                    System.out.print(str[j].charAt(i));
                }
            }
        }
    }


}

