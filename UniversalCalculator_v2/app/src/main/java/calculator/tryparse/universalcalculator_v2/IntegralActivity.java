package calculator.tryparse.universalcalculator_v2;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class IntegralActivity extends AppCompatActivity {

    private int n = 100;
    private double a, b;
    private Expression expression;
    private EditText upText;
    private EditText downText;
    private EditText integralFormulaText;

    private Button bIntegrate;
    private TextView resultIntegralText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integral);
        this.setTitle("Интегралы");

        upText = (EditText) findViewById(R.id.upBound);
        downText = (EditText) findViewById(R.id.downBound);
        integralFormulaText = (EditText) findViewById(R.id.integralTextBox);

        resultIntegralText = (TextView) findViewById(R.id.textIntegralResult);
        bIntegrate = (Button) findViewById(R.id.solveIntegralBtn);

        integralFormulaText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                integralFormulaText.setText("");
            }
        });
            bIntegrate.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View v) {
                    try {
                        a = Double.valueOf(downText.getText().toString());
                        b = Double.valueOf(upText.getText().toString());
                        expression = new ExpressionBuilder(integralFormulaText.getText().toString()).variables("x").build();
                        double h = (b - a) / n;
                        double sum = 0;
                        for (int i = 0; i < n; i++) {
                            sum += f(a + (i + 0.5) * h);
                        }
                        double result = sum * h;
                        resultIntegralText.setText(String.valueOf(result));
                    }
                    catch(Exception e){
                        upText.setText("");
                        downText.setText("");
                        resultIntegralText.setText("Ошибка! Проверьте правильность введённой функции и границ интегрирования!");
                    }
                }
            });

    }

    public double f(double x){
        try{
            return expression.setVariable("x", x).evaluate();
        }
        catch (Exception e){
            upText.setText("");
            downText.setText("");
            resultIntegralText.setText("Ошибка! Проверьте правильность введённой функции и границ интегрирования!");
            return 0;
        }
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
}
