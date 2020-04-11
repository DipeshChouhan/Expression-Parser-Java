package com.miniblocks.org;

import com.miniblocks.org.evaluator.Evaluator;

public class Main {

    public static void main(String[] args) {
        System.out.println(Evaluator.getInstance().evaluate("sum(10)"));
    }


}
