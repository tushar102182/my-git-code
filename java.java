import java.util.Scanner;

public class java {

    public  static void main (String [] args){

       Scanner input = new Scanner(System.in);
        System.out.println("Enter your name :");
    String name = input.nextLine();
    System.out.println( " Good Modrning " + name);
        System.out.println("Enter your age also :");
int age =input.nextInt();
        System.out.println("  your age is :" +age);

    }
}