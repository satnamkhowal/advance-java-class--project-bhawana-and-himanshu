import java.util.Scanner;

public class ValidateUser {
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Username : ");
			String uname=sc.next();
			System.out.println("Enter your password: ");
			String pass=sc.next();
			
			boolean res= Logic.validate(uname, pass);
			if(res) {
				System.out.println("Welcome ");
			}else {
				System.out.println("Invalid username or pssword");
			}
		}
}
class Logic{
	public static boolean validate(String userName, String password) {
		if(userName.equals("admin")&& password.equals("1234")) {
			return true;
		}
		return false;
	}
}
