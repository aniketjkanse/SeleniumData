import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class Stream1 {
	
	public static ArrayList<String> names;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		names= new ArrayList<String>();
		
		names.add("Aniket");
		names.add("Dhaval");
		names.add("Akash");
		names.add("KunalDada");
		names.add("Ganesh");
		names.add("Aditya");
		
	      Long actual = names.stream().filter(s-> s.startsWith("A")).count();
	      
	      System.out.println("count is "+actual);
	      
		long b = Stream.of("Aniket","Dhaval","Akash","Kunal","Ganesh","Aditya").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		System.out.println("count is "+b);
	//print the name of array list
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(2).forEach(s->System.out.println("Limited names are : "+s));
		
		streamMap();
		streamCollect();

	}
	

	public static void streamMap()
	{
		names.stream().filter(s->s.endsWith("a")).map(s-> s.toUpperCase()).forEach(s-> System.out.println(s));
		
		List<String> names1 = Arrays.asList("Azhar","Barkha","Aniket","yogesh","Anirudh"); 
		names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println("Sorted data : "+s));
		
		//merge 2 different list 
		
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//System.out.println("Concat two string::");
		//newStream.sorted().forEach(s-> System.out.println(s));
		
		Boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Azhar"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
}
	
	public static void streamCollect()
	{
		List <String>convertList = names.stream().filter(s->s.endsWith("h")).limit(2).map(s-> s.toUpperCase()).sorted().collect(Collectors.toList());
		System.out.println("Converted list : "+convertList.get(0));
		
		//To sort the same record and print 3rd index
		List<Integer>value = Arrays.asList(1,2,2,5,6,9,5,9,0);
		
		List<Integer> li = value.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println("List : "+li);
		System.out.println("The 3rd index is : "+li.get(2));
		
		
	}

}
