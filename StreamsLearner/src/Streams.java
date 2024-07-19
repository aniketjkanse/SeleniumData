import java.util.ArrayList;
import java.util.stream.Stream;

public class Streams {

	//To get a count of names which is present in the arraylist
		public void main() 
		{
			// TODO Auto-generated method stub
			
			ArrayList<String> names = new ArrayList<String>();
					
			names.add("Aniket");
			names.add("Dhaval");
			names.add("Akash");
			names.add("Kunal");
			names.add("Ganesh");
			names.add("Aditya");
			int count=0;
			for (int i=0;i<names.size();i++)
			{
				String actual = names.get(i);
				if(actual.startsWith("A"))
				{
					count++;
				}
			}
			System.out.println(count);
			//System.out.print("count is "+a);
		}
	//same above code with the help of streams	
		public static void regular()
		{
			
			ArrayList<String> names = new ArrayList<String>();
			
			/*names.add("Aniket");
			names.add("Dhaval");
			names.add("Akash");
			names.add("Kunal");
			names.add("Ganesh");
			names.add("Aditya");
			
		      Long actual = names.stream().filter(s-> s.startsWith("A")).count();
			
			  return actual;
			  */
			//or we can write the code by below technique
			long b = Stream.of("Aniket","Dhaval","Akash","Kunal","Ganesh","Aditya").filter(s->
			{
				s.startsWith("A");
				return true;
			}).count();
			System.out.println("count is "+b);
			
		}
		

	}

