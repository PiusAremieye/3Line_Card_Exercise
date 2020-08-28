package com.threeline.algorithm;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlgorithmApplication {

	public static void main(String[] args) {
		Encoder.encodeArray(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, 3);
	}

}
