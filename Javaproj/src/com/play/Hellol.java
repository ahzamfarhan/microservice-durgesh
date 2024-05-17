package com.play;

import java.util.Arrays;
import java.util.List;

public class Hellol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List <Integer> numbers = Arrays.asList(1, 4, 8, 40, 11, 22, 33, 99);
		numbers.stream().filter(n->n%2==0).forEach(System.out::println);
	}

}
