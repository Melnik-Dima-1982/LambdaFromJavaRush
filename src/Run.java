import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Run {

    public static void main(String[] args) {
        BinaryOperator<Double> bin = makeFunction(userInput("Enter your number -"));
        double res = calculate(50, 30, bin);
        System.out.println(res);

    }

    public static Double calculate(double a, double b, BinaryOperator<Double> count) {
        return count.apply(a, b);
    }

    public static BinaryOperator makeFunction(int a) {//Double s, Double d
        List<BinaryOperator<Double>> list = new ArrayList<>();
        BinaryOperator<Double> sum = (s, d) -> s + d;
        BinaryOperator<Double> raznost = (s, d) -> s - d;
        BinaryOperator<Double> umnogenie = (s, d) -> s * d;
        BinaryOperator<Double> del = (s, d) -> {
            if (d == null) {
                throw new InvalidParameterException();
            }
            return s / d;
        };

        list = Arrays.asList(sum, raznost, umnogenie, del);
        return list.get(a);
    }

    public static int userInput (String message){
        Object n;
        System.out.println("0 - Сумма." + '\n' + "1 - Разность" + '\n' + "2 - Умножение" + '\n' + "3 - Деление.");
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

}
