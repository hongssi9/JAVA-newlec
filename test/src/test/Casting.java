package test;

public class Casting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s_num = "10";
		int i_num = Integer.parseInt(s_num); //String -> Int 1번방식
		int i_num2 = Integer.valueOf(s_num); //String -> Int 2번방식
		
		String snum = "10";
		double d_num = Double.valueOf(s_num); //String -> Double
		float f_num = Float.valueOf(s_num); //String -> Float
		
		
		
	}

}
