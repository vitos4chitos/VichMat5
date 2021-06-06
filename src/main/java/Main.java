import io.Input;
import io.Output;
import methods.LagrangePolynomial;
import methods.Method;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Method method = input.getData();
        double x = input.getX();
        Output output = new Output();
        output.output(method, x);
    }
}
