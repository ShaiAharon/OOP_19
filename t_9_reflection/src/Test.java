
public class Test 
{
	private String s;

	public Test() 
	{
		s = "Test";
	}

	public void method1()
	{
		System.out.println("The string is " + s);
	}

	public void method2(int n)
	{
		System.out.println("The number is " + n);
	}

	private void method3() 
	{
		System.out.println("Private method invoked");
	}
}