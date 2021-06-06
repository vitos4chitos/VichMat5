package io;

import javafx.util.Pair;
import methods.LagrangePolynomial;
import methods.Method;
import methods.NewtonPolynomial;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    Scanner scanner;

    public Input(){
        scanner = new Scanner(System.in);
    }

    public Method getData(){
        ArrayList<Pair<Double, Double>> listOfValue = new ArrayList<>();
        System.out.println("Выберите метод: ");
        System.out.println("1) Многочлен Лагранжа");
        System.out.println("2) Многочлен Ньютона с разделенными разностями");
        int n = 0;
        while(true){
            try{
                n = Integer.parseInt(scanner.nextLine());
                if(n > 2 || n < 1){
                    System.out.println("Вы ввели что-то не то, попробуйте ещё раз");
                }
                else{
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Вы ввели что-то не то, попробуйте ещё раз");
            }
        }
        System.out.println("Введите число значений (не меньше 5)");
        int num = 0;
        while(true){
            try{
                num = Integer.parseInt(scanner.nextLine());
                if(num < 3){
                    System.out.println("Вы ввели что-то не то, попробуйте ещё раз");
                }
                else{
                    break;
                }
            }
            catch (Exception e){
                System.out.println("Вы ввели что-то не то, попробуйте ещё раз");
            }
        }
        double x, y;
        String[] xy;
        System.out.println("Введите " + num + " значений построчно(x y)");
        while (true){
            try {
                for(int i = 0; i < num; i++){
                    xy = scanner.nextLine().split(" ");
                    x = Double.parseDouble(xy[0]);
                    y = Double.parseDouble(xy[1]);
                    listOfValue.add(new Pair<>(x,y));
                }
                break;
            }
            catch (Exception e){
                System.out.println("Вы ввели что-то не то, попробуйте ещё раз");
                listOfValue.clear();
            }
        }
        if(n == 1){
            return  new LagrangePolynomial("Многочлена Лагранжа", listOfValue);
        }
        else {
            return new NewtonPolynomial("Многочлена Ньютона с разделенными разностями", listOfValue);
        }
    }

    public double getX(){
        System.out.println("Введите значение, которое нужно найти");
        double x;
        while (true){
            try {
                x = Double.parseDouble(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("Вы ввели что-то не то, попробуйте ещё раз");
            }
        }
        return x;
    }
}
