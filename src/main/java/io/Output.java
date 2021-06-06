package io;

import methods.Method;

public class Output {

    public void output(Method method, double x){
        System.out.printf("Значение в точке %.4f при использовании " + method.getNameOfMethod() + ": %.4f", x, method.getValue(x));
        System.out.println();
        ChartDrawer chartDrawer = new ChartDrawer(method, x);
    }
}
