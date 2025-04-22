import java.util.*;
public class Worksheet1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str = sc.nextLine();
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int special_character = 0;

        for(int i=0;i<str.length();i++){
            str=str.toLowerCase();
            char ch=str.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                vowels++;
            }else if(ch>='a' && ch<='z'){
                consonants++;
            }else if(ch>='0' && ch<='9'){
                digits++;
            }else if(ch!=' ') {
                special_character++;
            }
        }

        System.out.println("No of vowels in string "+str+" is "+vowels);
        System.out.println("No of consonants in string "+str+" is "+consonants);
        System.out.println("No of digits in string "+str+" is "+digits);
        System.out.println("No of special_character in string "+str+" is "+special_character);
    }
}
