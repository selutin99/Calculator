package calculator.tryparse.universalcalculator_v2;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import calculator.tryparse.universalcalculator_v2.ast.Operation;
import calculator.tryparse.universalcalculator_v2.tokenizer.AbstractTreeBuilder;
import calculator.tryparse.universalcalculator_v2.tokenizer.TokenizerException;

public class DerivativeActivity extends AppCompatActivity {
    private EditText et;
    private TextView tv;
    private Button b;
    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivative);
        et = (EditText) findViewById(R.id.derEditText);
        tv = (TextView) findViewById(R.id.textDevarivativeResult);
        b = (Button) findViewById(R.id.solveDerBtn);

        et.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                et.setText("");
            }
        });
        b.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v){
                try {
                    AbstractTreeBuilder tree = new AbstractTreeBuilder(et.getText().toString());
                    Operation derivative = tree.getTree().getDerivative();
                    tv.setText(derivative.toString());
                } catch (TokenizerException e) {
                    tv.setText("Ошибка! Проверьте правильность введённой функции!");
                }
                catch (Exception e){
                    tv.setText("Ошибка! Проверьте правильность введённой функции!");
                }
            }
        });

        this.setTitle("Производные");
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
