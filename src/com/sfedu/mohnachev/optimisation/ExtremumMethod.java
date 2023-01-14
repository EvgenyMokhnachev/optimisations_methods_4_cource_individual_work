package com.sfedu.mohnachev.optimisation;

import java.util.function.Function;

public interface ExtremumMethod {

    double findMin(Function<Double, Double> function, double a, double b, double e);

    double findMax(Function<Double, Double> function, double a, double b, double e);

}
