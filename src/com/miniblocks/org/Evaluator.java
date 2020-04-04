package com.miniblocks.org;

import java.math.BigDecimal;
import java.util.Stack;

public class Evaluator {

    public Stack<String> infixToPostFix(String expression){
        char[] tokens = expression.toCharArray();
        Stack<String> exp = new Stack<>();
        Stack<String> ops = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i] == ' '){
                continue;
            }
            if(tokens[i] == ',') continue;

            if(isDigit(tokens[i])){
                String number = String.valueOf(tokens[i++]);

                while(i < tokens.length && isDigit(tokens[i])) number = number.concat(String.valueOf(tokens[i++]));
                exp.push(number);
                i--;
            }else if(isLetter(tokens[i])){
                String fun = String.valueOf(tokens[i++]);
                while(i < tokens.length && isLetter(tokens[i])) fun = fun.concat(String.valueOf(tokens[i++]));
                ops.push(fun);
                i--;
            }
            else if(tokens[i] == '('){
                ops.push(String.valueOf(tokens[i]));
            }else if(tokens[i] == ')'){
                while(!ops.peek().equals("(")) {
                    exp.push(ops.pop());
                }
                ops.pop();
            }else{
                String token = String.valueOf(tokens[i]);
                while(!ops.isEmpty() && !hasPrecedence(ops.peek(), token)){

                    exp.push(ops.pop());
                }
                ops.push(token);
            }
        }
        while(!ops.isEmpty()) exp.push(ops.pop());
        return exp;
    }

    /**
     *
     * @param op1 - operator peek out of stack.
     * @param op2 - operator will be pushed to the stack.
     * @return {boolean} if higher precedence than true else false;
     */
    public boolean hasPrecedence(String op1, String op2){
        if(op1.equals("(") || op2.equals(")")) {
            return true;
        }else if(op1.equals("^") || op2.equals("^")){
            return true;
        }
        else return op1.equals("+") || op1.equals("-") && op2.equals("*") || op2.equals("/");
    }

    /**
     *
     * @param digit - char ex:- '1', '2' etc.
     * @return - true if it is digit or false if it is not.
     */
    public boolean isDigit(char digit){
        return (digit >= '0' && digit <= '9') || digit == '.';
    }

    /**
     *
     * @param l - char ex:- 'l', 'i' etc.
     * @return - true if it is letter or false if it is not.
     */
    private boolean isLetter(char l){
        return l >= 'a' && l <= 'z';
    }

    private double postFixEvaluator(Stack<String> exp){

    }


    private double doOp(double val1, double val2, String op){
        switch (op){
            case "+":
                return val2 + val1;
            case "-":
                return val2 - val1;
            case "*":
                return val2 * val1;
            case "/":
                return val2/val1;
            case "^":
                return Math.pow(val2, val1);

        }
    }

    private double doFunOp(double val, String fun){
        switch (fun){
            case "sin":
                return Math.sin(val);
            case "cos":
                return Math.cos(val);
            case "tan":
                return Math.tan(val);
            case "log":
                return Math.log10(val);
            case "sqr":
                return Math.sqrt(val);
        }
    }

}
