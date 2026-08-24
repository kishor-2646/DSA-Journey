package Experiences_And_OldPapers.Set0004;

import java.util.Scanner;

/*
1. Print the word with odd letters as
P         M
 R      A
   O  R
     G
  O    R
 R       A
P          M
 */
public class PrintOddWord {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a valid string:");
        String str = sc.nextLine();

        if(str.length() % 2 != 0)
            System.out.println("Invalid String");
        else
            printPattern(str);
    }

    public static String printPattern(String str){

        int n = str.length();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                
            }
        }
    }
}
