package com.lcwd.userservice.controllers;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

interface changer<T> {
	
	T change(T t);
}

public class Test {
	
	
	public static void main(String[] a) {
		
		List<Integer> ls = new ArrayList<>();
		
		ls.add(1);
		ls.add(2);
		ls.add(3);
		
		ls.replaceAll(i->i%2);
		
		
		
		System.out.println(ls.stream().distinct().count());		
		
		
	}

	
	
}
