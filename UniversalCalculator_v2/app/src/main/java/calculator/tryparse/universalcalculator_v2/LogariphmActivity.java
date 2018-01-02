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

import calculator.tryparse.universalcalculator_v2.ast.Operation;
import calculator.tryparse.universalcalculator_v2.tokenizer.AbstractTreeBuilder;

public class LogariphmActivity extends AppCompatActivity {

    private EditText etLog;
    private TextView resultLogtext;
    private Button bLog;
    private Expression expression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logariphm);
        this.setTitle("Логарифмы");

        etLog = (EditText) findViewById(R.id.logEditText);
        resultLogtext = (TextView) findViewById(R.id.textLogResult);
        bLog = (Button) findViewById(R.id.solveLogBtn);
        etLog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                etLog.setText("");
            }
        });
        bLog.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                try {
                    expression = new ExpressionBuilder(etLog.getText().toString()).build();
                    resultLogtext.setText(String.valueOf(expression.evaluate()));
                }
                catch (Exception e){
                    resultLogtext.setText("Ошибка! Проверьте правильность введённой функции!");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
