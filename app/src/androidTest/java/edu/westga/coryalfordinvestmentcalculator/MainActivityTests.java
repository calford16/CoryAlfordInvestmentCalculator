package edu.westga.coryalfordinvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.widget.EditText;

/**
 * Created by Cory on 3/4/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {

    EditText paymentEditText, rateEditText, numberEditText, resultEditText;
    MainActivity activity;

    public MainActivityTests(){
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        paymentEditText = (EditText) activity.findViewById(R.id.paymentEditText);
        rateEditText = (EditText) activity.findViewById(R.id.rateEditText);
        numberEditText = (EditText) activity.findViewById(R.id.numberEditText);
        resultEditText = (EditText) activity.findViewById(R.id.resultEditText);
    }

    public void testActivityExists() {
        assertNotNull(activity);
    }

    @UiThreadTest
    public void testInvalidUserInput1() {
        paymentEditText.setText("a");
        assertEquals("$0.00", resultEditText.getText().toString());
    }

    @UiThreadTest
    public void testInvalidUserInput2() {
        paymentEditText.setText("5");
        rateEditText.setText("a");
        numberEditText.setText("4");
        assertEquals("$0.00", resultEditText.getText().toString());
    }

    @UiThreadTest
    public void testNoUserInput() {
        assertEquals("", resultEditText.getText().toString());
    }

    @UiThreadTest
    public void testPartialUserInput() {
        paymentEditText.setText("5");
        assertEquals("$0.00", resultEditText.getText().toString());
    }

    @UiThreadTest
    public void testValidUserInput() {
        paymentEditText.setText("5");
        rateEditText.setText("2");
        numberEditText.setText("4");
        assertEquals("$20.61", resultEditText.getText().toString());
    }
}
