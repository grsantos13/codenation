package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(0);
		numbers.add(1);
		for (int i = 2; numbers.get(i - 1) <= 350; i++ ){
			numbers.add(numbers.get(i - 1) + numbers.get(i - 2));
		}
		return numbers;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}