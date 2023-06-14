//package com.myapplication.app;
//
//import org.mozilla.javascript.Context;
//import org.mozilla.javascript.Scriptable;
//
//
//public class Calculator {
//    private String expression;
//
//    public Calculator() {
//        expression = "";
//    }
//
//    public void appendExpression(String text) {
//        expression += text;
//    }
//
//    public void deleteLastCharacter() {
//        if (expression.length() > 0) {
//            expression = expression.substring(0, expression.length() - 1);
//        }
//    }
//
//    public void clearExpression() {
//        expression = "";
//    }
//
//    public String calculateResult() {
//
//        try {
//            Context context = Context.enter();
//            context.setOptimizationLevel(-1);
//            Scriptable scope = context.initSafeStandardObjects();
//
//            Object result = context.evaluateString(scope, expression, "JavaScript", 1, null);
//            String finalResult = Context.toString(result);
//
//            if (finalResult.equals("undefined")) {
//                return "0";
//            }
//
//            if (finalResult.endsWith(".0")) {
//                finalResult = finalResult.replace(".0", "");
//            }
//
//            return finalResult;
//        } catch (Exception e) {
//            return "Err";
//        } finally {
//            Context.exit();
//        }
//    }
//
//    public String getExpression() {
//        return expression;
//    }
//}

package com.myapplication.app;

public class Calculator {
    private String expression;

    public Calculator() {
        expression = "";
    }

    public void appendExpression(String text) {
        expression += text;
    }

    public void deleteLastCharacter() {
        if (expression.length() > 0) {
            expression = expression.substring(0, expression.length() - 1);
        }
    }

    public void clearExpression() {
        expression = "";
    }

    public String calculateResult() {
        try {
            double result = evaluateExpression(expression);
            return formatResult(result);
        } catch (Exception e) {
            return "Err";
        }
    }

    private double evaluateExpression(String expression) {
        // Implement your own expression evaluation logic here
        // You can use algorithms like Reverse Polish Notation (RPN) or recursive descent parsing
        // to evaluate the expression and calculate the result
        // This is a simplified example using basic arithmetic operations
        return evaluateSimpleExpression(expression);
    }

    private double evaluateSimpleExpression(String expression) {
        // Split the expression into tokens and evaluate it
        String[] tokens = expression.split("\\s+");
        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            double operand = Double.parseDouble(tokens[i + 1]);

            switch (operator) {
                case "+":
                    result += operand;
                    break;
                case "-":
                    result -= operand;
                    break;
                case "*":
                    result *= operand;
                    break;
                case "/":
                    result /= operand;
                    break;
            }
        }

        return result;
    }

    private String formatResult(double result) {
        String formattedResult = Double.toString(result);

        if (formattedResult.endsWith(".0")) {
            formattedResult = formattedResult.replace(".0", "");
        }

        return formattedResult;
    }

    public String getExpression() {
        return expression;
    }
}



