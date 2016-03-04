package edu.westga.coryalfordinvestmentcalculator.model;

/**
 * Created by Cory on 3/4/2016.
 */
public class InvestmentCalculator {
    private int numberOfPayments;
    private double rate;
    private double payment;

    public InvestmentCalculator() {
        this.numberOfPayments = 0;
        this.rate = 0;
        this.payment = 0;
    }

    public void setNumberOfPayments(int num) {
        if (num < 0) {
            this.numberOfPayments = 0;
        }
        this.numberOfPayments = num;
    }

    public void setRate(double rate) {
        if (rate < 0) {
            this.rate = 0;
        }
        this.rate = rate;
    }

    public void setPayment(double pay) {
        if (pay < 0) {
            this.payment = 0;
        }
        this.payment = pay;
    }
}
