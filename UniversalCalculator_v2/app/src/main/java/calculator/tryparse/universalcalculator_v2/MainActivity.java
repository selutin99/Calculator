package calculator.tryparse.universalcalculator_v2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivity extends AppCompatActivity {

    private TextView e1, e2;
    private int count = 0;
    private boolean countOfSymbol = false;
    private String expression = "";
    private String text = "";
    private Double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Калькулятор");
        e1 = (TextView)findViewById(R.id.editText1);
        e2 = (TextView)findViewById(R.id.editText2);

        e2.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.mainCalculator:
                Intent intent1 = new Intent(this, MainActivity.class);
                this.startActivity(intent1);
                return true;
            case R.id.derivativeCalculator:
                Intent intent2 = new Intent(this, DerivativeActivity.class);
                this.startActivity(intent2);
                return true;
            case R.id.logariphmCalculator:
                Intent intent3 = new Intent(this, LogariphmActivity.class);
                this.startActivity(intent3);
                return true;
            case R.id.integralCalculator:
                Intent intent4 = new Intent(this, IntegralActivity.class);
                this.startActivity(intent4);
                return true;
            case R.id.helper:
                Intent intent5 = new Intent(this, HelperActivity.class);
                this.startActivity(intent5);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick (View v) {

        switch (v.getId()) {
            case R.id.btnClear:
                e2.setText("");
                countOfSymbol = !countOfSymbol;
                count = 0;
                break;
            case R.id.btn0:
                if(!countOfSymbol){
                    e2.setText("");
                    e2.setText(e2.getText() + "0");
                    countOfSymbol = !countOfSymbol;
                }
                else{
                    e2.setText(e2.getText() + "0");
                }
                break;
            case R.id.btn1:
                if(!countOfSymbol){
                    e2.setText("");
                    e2.setText(e2.getText() + "1");
                    countOfSymbol = !countOfSymbol;
                }
                else{
                    e2.setText(e2.getText() + "1");
                }
                break;
            case R.id.btn2:
                if(!countOfSymbol){
                    e2.setText("");
                    e2.setText(e2.getText() + "2");
                    countOfSymbol = !countOfSymbol;
                }
                else{
                    e2.setText(e2.getText() + "2");
                }
                break;
            case R.id.btn3:
                if(!countOfSymbol){
                    e2.setText("");
                    e2.setText(e2.getText() + "3");
                    countOfSymbol = !countOfSymbol;
                }
                else{
                    e2.setText(e2.getText() + "3");
                }
                break;
            case R.id.btn4:
                if(!countOfSymbol){
                    e2.setText("");
                    e2.setText(e2.getText() + "4");
                    countOfSymbol = !countOfSymbol;
                }
                else{
                    e2.setText(e2.getText() + "4");
                }
                break;
            case R.id.btn5:
                if(!countOfSymbol){
                    e2.setText("");
                    e2.setText(e2.getText() + "5");
                    countOfSymbol = !countOfSymbol;
                }
                else{
                    e2.setText(e2.getText() + "5");
                }
                break;
            case R.id.btn6:
                if(!countOfSymbol){
                    e2.setText("");
                    e2.setText(e2.getText() + "6");
                    countOfSymbol = !countOfSymbol;
                }
                else{
                    e2.setText(e2.getText() + "6");
                }
                break;
            case R.id.btn7:
                if(!countOfSymbol){
                    e2.setText("");
                    e2.setText(e2.getText() + "7");
                    countOfSymbol = !countOfSymbol;
                }
                else{
                    e2.setText(e2.getText() + "7");
                }
                break;
            case R.id.btn8:
                if(!countOfSymbol){
                    e2.setText("");
                    e2.setText(e2.getText() + "8");
                    countOfSymbol = !countOfSymbol;
                }
                else{
                    e2.setText(e2.getText() + "8");
                }
                break;
            case R.id.btn9:
                if(!countOfSymbol){
                    e2.setText("");
                    e2.setText(e2.getText() + "9");
                    countOfSymbol = !countOfSymbol;
                }
                else{
                    e2.setText(e2.getText() + "9");
                }
                break;
            case R.id.btnBack:
                text = e2.getText().toString();
                if (text.length() > 0) {
                    if (text.endsWith(".")) {
                        count = 0;
                    }
                    String newText = text.substring(0, text.length() - 1);

                    if (text.endsWith(")")) {
                        char []a = text.toCharArray();
                        int pos = a.length - 2;
                        int counter = 1;

                        for (int i = a.length - 1; i>= 0; i--) {
                            if (a[i] == ')') counter++;
                            else if (a[i] == '(') counter --;
                            else if (a[i] == '.') count =0;
                            else if (counter == 0) {
                                pos = i;
                                break;
                            }
                        }

                        newText = text.substring(0, pos);
                    }

                    if (newText.equals("-") || newText.endsWith("sqrt")) {
                        newText = " ";
                    }
                    else if (newText.endsWith("^")) {
                        newText = newText.substring(0, newText.length() - 1);
                    }
                    e2.setText(newText);


                }
                e2.setText(e2.getText());
                break;
            case R.id.btnCloseBracket:
                e2.setText(e2.getText() + ")");
                break;
            case R.id.btnOpenBracket:
                e2.setText(e2.getText() + "(");
                break;
            case R.id.btnDivide:
                if(operationClicked(e2.getText().toString()))
                    e2.setText(e2.getText() + "/");
                break;
            case R.id.btnDot:
                e2.setText(e2.getText() + ".");
                break;
            case R.id.btnEquals:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    expression = e1.getText().toString() + text;
                }

                e1.setText("");
                if (expression.length() == 0) {

                    expression = "0.0";
                }

                DoubleEvaluator evaluator = new DoubleEvaluator();

                try {
                    result = new ExtendedDoubleEvaluator().evaluate(expression);
                    if (!evaluator.equals("0.0")) e2.setText(result + "");
                } catch (Exception e) {
                    e2.setText("Ошибка!");
                    e1.setText("");
                    expression = "";
                    e.printStackTrace();
                }
                countOfSymbol = !countOfSymbol;
                break;
            case R.id.btnMinus:
                if(operationClicked(e2.getText().toString()))
                    e2.setText(e2.getText() + "-");
                break;
            case R.id.btnMulti:
                if(operationClicked(e2.getText().toString()))
                    e2.setText(e2.getText() + "*");
                break;
            case R.id.btnPercent:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("percent(" + text + ")");
                }
                break;
            case R.id.btnPlusMinus:
                if (e2.length() != 0) {
                    String s = e2.getText().toString();
                    char arr[] = s.toCharArray();
                    if (arr[0] == '-') {
                        e2.setText(s.substring(1, s.length()));
                    }
                    else e2.setText("-" + s);
                }
                break;
            case R.id.btnSqrt:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("sqrt(" + text + ")");
                }
                break;
            case R.id.btnSquare:
                if (e2.length() != 0) {
                    text = e2.getText().toString();
                    e2.setText("(" + text + ")^2");
                }
                break;
            case R.id.btnSum:
                if(operationClicked(e2.getText().toString()))
                    e2.setText(e2.getText() + "+");
                break;

        }
    }

    private boolean operationClicked(String s) {
        String[] opr = {"+", "/", "-", "*", "%", "("};
        for (int i = 0; i < opr.length; i++) {
            if (s.endsWith(opr[i]) || s.length() == 0) {
                return false;
            }
        }
        return true;
    }
    //TODO this function
    /*private void forTxtViews(String op) {
        if (e2.length() != 0) {
            String text = e2.getText().toString();
            e1.setText(e1.getText() + text + op);
            e2.setText("");
            count = 0;

        } else {
            String text = e1.getText().toString();
            if (text.length() > 0) {
                String newText = text.substring(0, text.length() - 1) + op;
                e1.setText(newText);
            }
        }
    }*/
}
