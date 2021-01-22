package com.zup.projetoLoteria.entities;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateRandomNumbers {

	public static String genRandom() {

		SecureRandom sr = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		List<Integer> random = sr.ints(6, 1, 60).boxed().collect(Collectors.toList());
		random.forEach(rand -> sb.append(rand).append(" "));
		String str = sb.toString();
		return str;
		
	}
}
