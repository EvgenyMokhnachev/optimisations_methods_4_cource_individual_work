package com.sfedu.mohnachev.optimisation;

public class Main {

    public static void main(String[] args) {
        double a = 0;
        double b = 10;
        double e = 0.1;

        System.out.println("Dichotomy Method: ");

        ExtremumMethod dichotomyMethod = new ExtremumMethodDichotomy();

        double minDichotomy = dichotomyMethod.findMin(Main::func, a, b, e);
        System.out.println("Min: " + minDichotomy);

        double maxDichotomy = dichotomyMethod.findMax(Main::func, a, b, e);
        System.out.println("Max: " + maxDichotomy);

        System.out.println("\nGolder Method: ");

        ExtremumMethod goldenMethod = new ExtremumMethodGold();

        double minGolden = goldenMethod.findMin(Main::func, a, b, e);
        System.out.println("Min: " + minGolden);

        double maxGolden = goldenMethod.findMax(Main::func, a, b, e);
        System.out.println("Max: " + maxGolden);
    }

    private static Double func(Double xVal) {
        return (5 * Math.pow(xVal, 2)) - (4 * xVal) + 1;
    }

}
