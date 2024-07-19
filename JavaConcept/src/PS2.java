import org.testng.annotations.Test;

public class PS2 extends PS1 {
		
		@Test
		public void doingThis()
		{
			//PS1 ps1 = new PS1();
			//ps1.doThis();   OR just extend PS2 in PS1 
			doThis();
			int a =3;
			PS3 ps3 = new PS3(a);  //parameterized constructor
			System.out.println(ps3.Increment());
			System.out.println(ps3.Decrement());
			System.out.println(ps3.Multiplication());
			System.out.println(ps3.Division());
		}
		

	}
