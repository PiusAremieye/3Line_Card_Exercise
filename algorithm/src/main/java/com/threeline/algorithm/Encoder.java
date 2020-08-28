package com.threeline.algorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Encoder {

    static Logger logger = LoggerFactory.getLogger(Encoder.class);

    public static int encodeInteger(int x, int n) {
        n = n << (1 << (1 << (1 << 1)));
        x = x | n;
        return x;
    }

    public static void encodeArray(int A[], int B[], int n) {
        for (int i = 0; i < n; i++) {
            A[i] = encodeInteger(A[i], B[i]);
            logger.info("i {}", A[i]);
        }
    }

}