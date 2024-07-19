import org.testng.annotations.Test;

public class PS4{
		
		int a =0;
		public PS4(int a2) { //instance variable
			// Constructor
			this.a=a2;  ///this. called current class variable 
		}
		public int Multiplication()
		{
			a=a*2;
			return a;
			
			
		}
		public int Division()
		{
			a=a/2;
			return a;
			
			
		}

	}
