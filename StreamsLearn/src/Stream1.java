import java.util.ArrayList;

public class Stream1 {

	public static void main(String[] args) {
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
		System.out.print(count);

	}

}
