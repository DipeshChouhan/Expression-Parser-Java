package com.miniblocks.org;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Evaluator evaluator = Evaluator.getInstance();
        System.out.println(evaluator.evaluate("102*40"));
    }


}
