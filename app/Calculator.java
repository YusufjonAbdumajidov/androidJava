package com.myapplication.app;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

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
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            String finalResult = context.evaluateString(scriptable, expression, "Javascript", 1, null).toString();
            if (finalResult.endsWith(".0")) {
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        } catch (Exception e) {
            return "Err";
        }
    }
}
