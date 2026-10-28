import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number : ");
		int n1=sc.nextInt();
		System.out.println("Enter Second number : ");
		int n2=sc.nextInt();
		try {
			int res=n1/n2;	
			System.out.println("in try block");
			System.out.println(res);	
		}catch (Exception e) {
			System.out.println("in catch block");
			e.printStackTrace();
		}
		System.out.println("Operations excecuted ");
	}
}
