package com.threeline.algorithm;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Encoder {

    static Logger logger = LoggerFactory.getLogger(Encoder.class);

    public static int encodeInteger(int x, int n) {
        n = n << (1 << (1 << (1 << 1)));
        x = x | n;
        return x;
    }

    public static int[] encodeArray(int A[], int B[], int n) {
        for (int i = 0; i < n; i++) {
            A[i] = encodeInteger(A[i], B[i]);
        }
        return A;
    }

    public static String decodeArrayB(int encodedArray[], int A[]) {
        int len = encodedArray.length;
        int B[] = new int[len];
        int key = 1 << (1 << (1 << 1));
        for (int i = 0; i < len; i++) {
            int c = (encodedArray[i] ^ A[i]) >> key;
            B[i] = c;
        }
        return Arrays.toString(B);
    }

    public static void main(String[] args) {
        int[] E = Encoder.encodeArray(new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, 3);
        System.out.println(Encoder.decodeArrayB(E, new int[] { 1, 2, 3 }));
    }

}