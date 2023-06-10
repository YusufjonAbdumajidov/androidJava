//package com.myapplication.app;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.View;
//import android.widget.TextView;
//
//import com.google.android.material.button.MaterialButton;
//import org.mozilla.javascript.Context;
//import org.mozilla.javascript.Scriptable;
//
//
//
//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
//    TextView resultTv, solutionTv;
//    MaterialButton buttonC, buttonBrackOpen, buttonBrackClose;
//    MaterialButton buttonDivide, buttonMultiply, buttonPlus, buttonMinus, buttonEquals;
//    MaterialButton button0,button1, button2, button3, button4, button5, button6, button7, button8, button9;
//    MaterialButton buttonDot;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        resultTv = findViewById(R.id.result_tv);
//        solutionTv = findViewById(R.id.solution_tv);
//
//        assignId(buttonC, R.id.button_c);
//        assignId(buttonBrackOpen, R.id.left_bracket);
//        assignId(buttonBrackClose, R.id.right_bracket);
//        assignId(buttonDivide, R.id.button_divide);
//        assignId(buttonMultiply, R.id.button_multiply);
//        assignId(buttonPlus, R.id.button_plus);
//        assignId(buttonMinus, R.id.button_minus);
//        assignId(buttonEquals, R.id.button_equal);
//        assignId(button0, R.id.button_zero);
//        assignId(button1, R.id.button_one);
//        assignId(button2, R.id.button_two);
//        assignId(button3, R.id.button_three);
//        assignId(button4, R.id.button_four);
//        assignId(button5, R.id.button_five);
//        assignId(button6, R.id.button_six);
//        assignId(button7, R.id.button_seven);
//        assignId(button8, R.id.button_eight);
//        assignId(button9, R.id.button_nine);
//        assignId(buttonDot, R.id.button_dot);
//    }
//
//    void assignId(MaterialButton btn, int id){
//        btn = findViewById(id);
//        btn.setOnClickListener(this);
//    }
//
//    @Override
//    public void onClick(View view) {
//        MaterialButton button = (MaterialButton) view;
//        String buttonText = button.getText().toString();
//        String dataToCalculate = solutionTv.getText().toString();
//
//        if(buttonText.equals("AC")){
//            solutionTv.setText("");
//            resultTv.setText("0");
//            return;
//        }
//
//        if(buttonText.equals("C")){
//            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length()-1);
//        }else{
//            dataToCalculate = dataToCalculate+buttonText;
//        }
//
//        if (buttonText.equals("=")){
//            solutionTv.setText(resultTv.getText());
//            return;
//        }
//
////        dataToCalculate = dataToCalculate+buttonText;
//        solutionTv.setText(dataToCalculate);
//
//        String finalResult = getResult(dataToCalculate);
//
//        if(!finalResult.equals("Err")){
//            resultTv.setText(finalResult);
//        }
//    }
//    String getResult(String data){
//        try{
//            Context context = Context.enter();
//            context.setOptimizationLevel(-1);
//            Scriptable scriptable = context.initSafeStandardObjects();
//            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
//            if(finalResult.endsWith(".0")){
//                finalResult = finalResult.replace(".0", "");
//            }
//            return finalResult;
//        }catch(Exception e){
//            return "Err";
//        }
//    }
//}
package com.myapplication.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultTv, solutionTv;
    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);
        calculator = new Calculator();

        // Initialize and set click listeners for the buttons
        MaterialButton buttonC = findViewById(R.id.button_c);
        buttonC.setOnClickListener(this);

        MaterialButton buttonBrackOpen = findViewById(R.id.left_bracket);
        buttonBrackOpen.setOnClickListener(this);

        // ... initialize and set click listeners for other buttons ...
        MaterialButton button0 = findViewById(R.id.button_zero);
        button0.setOnClickListener(this);

        MaterialButton button1 = findViewById(R.id.button_one);
        button1.setOnClickListener(this);

        MaterialButton button2 = findViewById(R.id.button_two);
        button2.setOnClickListener(this);

        MaterialButton button3 = findViewById(R.id.button_three);
        button3.setOnClickListener(this);

        MaterialButton button4 = findViewById(R.id.button_four);
        button4.setOnClickListener(this);

        MaterialButton button5 = findViewById(R.id.button_five);
        button5.setOnClickListener(this);

        MaterialButton button6 = findViewById(R.id.button_six);
        button6.setOnClickListener(this);

        MaterialButton button7 = findViewById(R.id.button_seven);
        button7.setOnClickListener(this);

        MaterialButton button8 = findViewById(R.id.button_eight);
        button8.setOnClickListener(this);

        MaterialButton button9 = findViewById(R.id.button_nine);
        button9.setOnClickListener(this);

        MaterialButton buttonPlus = findViewById(R.id.button_plus);
        buttonPlus.setOnClickListener(this);

        MaterialButton buttonMinus = findViewById(R.id.button_minus);
        buttonMinus.setOnClickListener(this);


        MaterialButton buttonMultiply = findViewById(R.id.button_multiply);
        buttonMultiply.setOnClickListener(this);

        MaterialButton buttonDivide = findViewById(R.id.button_divide);
        buttonDivide.setOnClickListener(this);


        //
        MaterialButton buttonEquals = findViewById(R.id.button_equal);
        buttonEquals.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "AC":
                calculator.clearExpression();
                resultTv.setText("0");
                break;
            case "C":
                calculator.deleteLastCharacter();
                break;
            case "=":
                solutionTv.setText(resultTv.getText());
                break;
            default:
                calculator.appendExpression(buttonText);
                break;
        }

        solutionTv.setText(calculator.getExpression());
        String finalResult = calculator.calculateResult();
        if (!finalResult.equals("Err")) {
            resultTv.setText(finalResult);
        }
    }
}