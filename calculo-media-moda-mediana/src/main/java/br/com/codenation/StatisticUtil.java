package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int) Arrays.stream(elements).average().getAsDouble();
	}

	public static int mode(int[] elements) {
		int count = 0;
		int highestCount = 0;
		int highestElement = 0;

		Arrays.sort(elements);

		for (int i = 0; i < elements.length; i++){
			count = 0;

			for (int j = 0; j < elements.length; j++){
				if (elements[j] == elements[i]){
					count++;
				}
			}
			if (count > highestCount){
				highestCount = count;
				highestElement = elements[i];
			}
		}

		return highestElement;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);

		int i = elements.length % 2 == 0 ?
				(elements[elements.length / 2] + elements[elements.length / 2 - 1]) / 2 :
				elements[elements.length / 2];

		return i;
	}
}