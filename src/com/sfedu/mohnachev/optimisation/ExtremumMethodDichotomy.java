package com.sfedu.mohnachev.optimisation;

import java.util.function.Function;

public class ExtremumMethodDichotomy implements ExtremumMethod {

    public double findMin(
            Function<Double, Double> function,
            double a, double b, double e
    ) {
        return findExtremum(function, true, a, b, e, 0);
    }

    public double findMax(
            Function<Double, Double> function,
            double a, double b, double e
    ) {
        return findExtremum(function, false, a, b, e, 0);
    }

    private double findExtremum(
            Function<Double, Double> function, boolean isMinExtremum,
            double a, double b, double e,
            int iterations
    ) {
        iterations++;

        double x1 = a + ((b-a)/2) - (e / 2);
        double x2 = a + ((b-a)/2) + (e / 2);
        double xc = x1 + ((x2 - x1) / 2);

        if ((b - a) <= e) {
            System.out.println("Iterations: " + iterations);
            return function.apply(xc);
        }

        double fx1 = function.apply(x1);
        double fx2 = function.apply(x2);

        double aNext, bNext;
        if (isMinExtremum) {
            aNext = fx1 <= fx2 ? a : xc;
            bNext = fx1 <= fx2 ? xc : b;
        } else {
            aNext = fx1 > fx2 ? a : xc;
            bNext = fx1 > fx2 ? xc : b;
        }

        try {
            return findExtremum(function, isMinExtremum, aNext, bNext, e, iterations);
        } catch (StackOverflowError exception) {
            System.out.println("Iterations: " + iterations);
            return function.apply(xc);
        }
    }

}
