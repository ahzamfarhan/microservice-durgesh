package com.play;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Demo01 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    List<String> list= Arrays.asList("test1","test2","test3","test2","test1");
    
    
   Map<String,Long> countmap=list.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting()));
   
   
   System.out.println(countmap);
    
    
		
	}
	
	
	

}
