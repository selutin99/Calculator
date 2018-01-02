package calculator.tryparse.universalcalculator_v2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HelperActivity extends AppCompatActivity {
    private Button goHelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper);
        this.setTitle("Справка");
        goHelp = (Button)findViewById(R.id.btnHelp);
        goHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://docs.oracle.com/cd/E17904_01/apirefs.1111/e12048/functmath.htm#CQLLR412");
                Intent intent= new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
            }
        });

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
