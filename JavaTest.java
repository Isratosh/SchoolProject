import java.util.Scanner;
public class JavaTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello world!");
		Scanner user_input = new Scanner( System.in );
		String health;
		System.out.println("Please input your health.");
		health = user_input.next();
		new HelloWorld(health);
	}
	public JavaTest(String health)
	{
		
		System.out.println("You have " + health + " health. ayylmao");
	}

}
