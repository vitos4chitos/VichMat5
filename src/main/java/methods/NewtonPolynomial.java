package methods;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.TreeMap;

public class NewtonPolynomial extends Method{

    private ArrayList<Pair<Double, Double>> listOfValue;
    private ArrayList<Double> listOfAns;

    public NewtonPolynomial(String nameOfMethod, ArrayList<Pair<Double, Double>> listOfValue){
        super(nameOfMethod);
        this.listOfValue = listOfValue;
        listOfAns = new ArrayList<>();
    }

    @Override
    public double getValue(double x){
        double ans = listOfValue.get(0).getValue();
        double sum;
        double pr;
        double temp;
        for(int i = 0; i < listOfValue.size() - 1; i++){
            sum = 0;
            pr = 1;
            for(int j = 0; j <= i + 1; j++){
                temp = 1;
                for(int k = 0; k <= i + 1; k++){
                    if(k != j){
                        temp *= (listOfValue.get(j).getKey() - listOfValue.get(k).getKey());
                    }
                }
                sum += (listOfValue.get(j).getValue()/temp);
                if(j != i + 1){
                    pr *= (x - listOfValue.get(j).getKey());
                }
            }
            ans += pr * sum;
        }
        return ans;
    }

    @Override
    public ArrayList<Pair<Double, Double>> getStaticValues(){
        return new ArrayList<>(listOfValue);
    }
}
