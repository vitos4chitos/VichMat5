package methods;

import javafx.util.Pair;

import java.util.ArrayList;

public abstract class Method {

    private String nameOfMethod;

    public Method(String nameOfMethod){
        this.nameOfMethod = nameOfMethod;
    }

    public String getNameOfMethod(){
        return nameOfMethod;
    }

    public abstract double getValue(double x);

    public abstract ArrayList<Pair<Double, Double>> getStaticValues();
}
