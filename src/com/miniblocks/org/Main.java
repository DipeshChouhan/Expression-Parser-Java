package com.miniblocks.org;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Evaluator evaluator = new Evaluator();
        String postFix = evaluator.infixToPostFix("12.3*4-sin(10").toString();
        System.out.println(postFix);
    }


}
