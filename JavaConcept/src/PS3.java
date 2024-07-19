import org.testng.annotations.Test;

public class PS3 extends PS4{
		
		int a =0;
		public PS3(int a2) { //instance variable
			// Constructor
			super(a2);
			this.a=a2;  ///this. called current class variable 
		}
		public int Increment()
		{
			a=a+1;
			return a;
			
			
		}
		public int Decrement()
		{
			a=a-1;
			return a;
			
			
		}

	}
