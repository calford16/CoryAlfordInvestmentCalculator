package edu.westga.coryalfordinvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by Cory on 3/4/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTests(){
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }
}
