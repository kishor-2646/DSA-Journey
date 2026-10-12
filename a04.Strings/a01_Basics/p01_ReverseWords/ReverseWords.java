package a01_Basics.p01_ReverseWords;

import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String:");
        String str = sc.nextLine();
        System.out.println(reserveWords(str));
    }

    public static String reserveWords(String str){
        StringBuilder res = new StringBuilder();

        int i = str.length();

        while(i >= 0)
        {
            while(i >= 0 && str.charAt(i) == ' ')
                i--; // skip spaces

            if(i < 0) // if string had only spaces ,i will reach -1, so break
                break;

            int j = i; //if word is found , mark the end of word

            while(i >= 0 && str.charAt(i) != ' ') //  go to beginning of that word
                i--;

            if(res.length() != 0)
                res.append(' '); // if it is not first word to be added , add space

            res.append(str.substring(i + 1, j + 1)); // add the word to res
        }

        return res.toString();
    }
}
