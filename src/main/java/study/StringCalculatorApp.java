package study;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.Scanner;

@Slf4j
public class StringCalculatorApp {
    public static void main(String[] args) {
        String ex = "2 + 3 * 4 / 2";
        log.info(calculate(ex)+"");
    }



    public static double calculate(String expression) {
        String[] values = expression.trim().split(" ");
        String operator = "";
        Double result = null;
        for(int i=0;i<values.length;i++){
            if(i%2==0){
                Double currentOperand = Double.parseDouble(values[i]);
                if(result == null){
                    result = currentOperand;
                }else{
                    switch(operator){
                        case "+" :
                            result = result + currentOperand;
                            break;
                        case "-" :
                            result = result - currentOperand;
                            break;
                        case "*" :
                            result = result * currentOperand;
                            break;
                        case "/" :
                            result = result / currentOperand;
                            break;
                    }
                }
            }else{
                operator = values[i];
            }
        }
        return result;
    }

    /*ublic static double calculate(String expression) {
        double result = 0.0;
        String[] values = expression.split(" ");
        int op = 0;
        char operator = '-';
        for (int i = 0; i < values.length; i++) {
            if(i % 2 == 0) {
                // 피연산자
                if(i == 0)
                    result = Integer.parseInt(values[i]);
                else
                    op = Integer.parseInt(values[i]);
            } else {
                // 연산자
                operator = values[i].charAt(0);
            }

            if(i >= 2 && i % 2 == 0) {
                switch (operator) {
                    case '+' :
                        result += op;
                        break;
                    case '-' :
                        result -= op;
                        break;
                    case '*' :
                        result *= op;
                        break;
                    case '/' :
                        result /= op;
                        break;
                }
            }


        }

        return result;
    }*/
}
