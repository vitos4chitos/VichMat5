package methods;

import javafx.util.Pair;

import java.util.ArrayList;

public class LagrangePolynomial extends Method{

    private ArrayList<Pair<Double, Double>> listOfValue;

    public LagrangePolynomial(String nameOfMethod, ArrayList<Pair<Double, Double>> listOfValue){
        super(nameOfMethod);
        this.listOfValue = listOfValue;
    }

    @Override
    public double getValue(double x){
        double ans = 0;
        double down;
        double up;
        for(int i = 0; i < listOfValue.size(); i++){
            down = 1;
            up = 1;
            for(int j = 0; j < listOfValue.size(); j++){
                if(j != i){
                    down *= (listOfValue.get(i).getKey() - listOfValue.get(j).getKey());
                    up *= (x - listOfValue.get(j).getKey());
                }
            }
            ans += (up / down) * listOfValue.get(i).getValue();
        }
        return ans;
    }

    @Override
    public ArrayList<Pair<Double, Double>> getStaticValues(){
        return new ArrayList<>(listOfValue);
    }
}
