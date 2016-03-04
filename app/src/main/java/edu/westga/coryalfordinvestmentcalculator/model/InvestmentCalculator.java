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

    public int getNumberOfPayments() {
        return this.numberOfPayments;
    }

    public double getRate() {
        return this.rate;
    }

    public double getPayment() {
        return this.payment;
    }

    public void setNumberOfPayments(int num) {
        if (num < 0) {
            this.numberOfPayments = 0;
        } else {
            this.numberOfPayments = num;
        }
    }

    public void setRate(double rate) {
        if (rate < 0) {
            this.rate = 0;
        } else {
            this.rate = rate / 100;
        }
    }

    public void setPayment(double pay) {
        if (pay < 0) {
            this.payment = 0;
        } else {
            this.payment = pay;
        }
    }

    public double calculateInvestment() {
        if (this.rate == 0) {
            return this.payment * this.numberOfPayments;
        }

        double futureValue = Math.pow(1 + this.rate, this.numberOfPayments) - 1;
        return this.payment * futureValue / this.rate;
    }
}
