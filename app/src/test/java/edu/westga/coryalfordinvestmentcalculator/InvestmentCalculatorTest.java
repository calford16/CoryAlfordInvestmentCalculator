package edu.westga.coryalfordinvestmentcalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.westga.coryalfordinvestmentcalculator.model.InvestmentCalculator;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class InvestmentCalculatorTest {
    InvestmentCalculator calc;

    @Before
    public void setUp() {
        this.calc = new InvestmentCalculator();
    }

    @After
    public void tearDown() {
        this.calc = null;
    }

    @Test
    public void unsetCalculatorReturnsZero() throws Exception {
        assertEquals(0, calc.calculateInvestment(), 0.01);
    }

    @Test
    public void negativeValuesSetToZero() throws Exception {
        calc.setPayment(-1000);
        assertEquals(0, calc.getPayment(), 0.01);

        calc.setRate(-1000);
        assertEquals(0, calc.getRate(), 0.01);

        calc.setNumberOfPayments(-1000);
        assertEquals(0, calc.getNumberOfPayments());
    }

    @Test
    public void zeroRateCalculationReturnsSimpleProduct() throws Exception {
        calc.setNumberOfPayments(3);
        calc.setPayment(1000);
        assertEquals(3000, calc.calculateInvestment(), 0.01);
    }

    @Test
    public void unrealisticValueCalculation1() throws Exception {
        calc.setNumberOfPayments(5);
        calc.setPayment(-1000);
        calc.setRate(3);
        assertEquals(0, calc.calculateInvestment(), 0.05);
    }

    @Test
    public void unrealisticValueCalculation2() throws Exception {
        calc.setNumberOfPayments(-2);
        calc.setPayment(1000);
        calc.setRate(3);
        assertEquals(0, calc.calculateInvestment(), 0.05);
    }

    @Test
    public void realisticValueCalculation1() throws Exception {
        calc.setNumberOfPayments(5);
        calc.setPayment(1000);
        calc.setRate(3);
        assertEquals(5309.14, calc.calculateInvestment(), 0.05);
    }

    @Test
    public void realisticValueCalculation2() throws Exception {
        calc.setNumberOfPayments(6);
        calc.setPayment(731.5);
        calc.setRate(3.62);
        assertEquals(4805.90, calc.calculateInvestment(), 0.05);
    }
}