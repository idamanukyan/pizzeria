package com.company.util;

import java.util.Random;

public class GenerateRandom {


    public int generateRandom() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }
}
