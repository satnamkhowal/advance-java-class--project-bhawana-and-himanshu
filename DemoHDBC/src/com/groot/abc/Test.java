package com.groot.abc;

public class Test {
	public static void main(String[] args)  {
//		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Before exception ");
		try {
		XYZ.say();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("After exception ");
	}
}

class XYZ {
	public static void say()  throws CutomeEx{
		int age=12;
		if(age<=17) {
			throw new CutomeEx("Age invalid ");
		}else {
			System.out.println("Welcome for votig ");
		}
	}
}
class CutomeEx extends Exception{
	CutomeEx(String msg){
		super(msg);
	}
}
