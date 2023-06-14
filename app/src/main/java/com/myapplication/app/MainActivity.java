
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


        MaterialButton buttonC = findViewById(R.id.button_c);
        buttonC.setOnClickListener(this);

        MaterialButton buttonClear = findViewById(R.id.clear);
        buttonClear.setOnClickListener(this);


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