package edu.westga.coryalfordinvestmentcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import edu.westga.coryalfordinvestmentcalculator.model.InvestmentCalculator;

public class MainActivity extends AppCompatActivity {

    InvestmentCalculator calc = new InvestmentCalculator();
    EditText payment, rate, number, result;
    double paymentDouble, rateDouble;
    int numberInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.payment = (EditText) findViewById(R.id.paymentEditText);
        this.rate = (EditText) findViewById(R.id.rateEditText);
        this.number = (EditText) findViewById(R.id.numberEditText);
        this.result = (EditText) findViewById(R.id.resultEditText);

        this.payment.addTextChangedListener(inputTextWatcher);
        this.rate.addTextChangedListener(inputTextWatcher);
        this.number.addTextChangedListener(inputTextWatcher);
        this.result.setKeyListener(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    TextWatcher inputTextWatcher = new TextWatcher() {
        public void afterTextChanged(Editable s) {
            MainActivity.this.updateCalculator();
            MainActivity.this.calculateResult();
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after){
        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    };

    private void calculateResult() {
        this.result.setText(String.format("$%.2f", calc.calculateInvestment()));
    }

    public void updateCalculator() {
        try {
            this.paymentDouble = Integer.parseInt(this.payment.getText().toString());
            this.rateDouble = Integer.parseInt(this.rate.getText().toString());
            this.numberInt = Integer.parseInt(this.number.getText().toString());

            this.calc.setPayment(this.paymentDouble);
            this.calc.setRate(this.rateDouble);
            this.calc.setNumberOfPayments(this.numberInt);
        } catch (NumberFormatException nfe) {
            //exit try/catch
            //this should only occur when a field is empty
        }
    }
}
