package com.epam.java8.lesson2.example1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//+,-,* /
public class Calculator {

    /*
     public int calculate(int a, Operation operation, int b) {
if(operation == null){ throw new IllegalArgumentException();
}

          switch (operation) {
              case ADD:
                  return a + b;
              case DIV:
                  return a / b;
              case MULT:
                  return a * b;
              default:
                  throw new IllegalArgumentException();
          }

      }
      */

    private static final Map<Operation, OperationInterface> OPERATION_TO_CALCUALTION = new HashMap<>();
    private static final OperationInterface DEFAULT_OPERATION = (x, y) -> {
        throw new IllegalArgumentException(" Illegal Operation");
    };

    static {
        OPERATION_TO_CALCUALTION.put(Operation.ADD, (a, b) -> a + b); //Integer.sum
        OPERATION_TO_CALCUALTION.put(Operation.DIV, (a, b) -> a / b);
        OPERATION_TO_CALCUALTION.put(Operation.MULT, (a, b) -> a * b);
    }

    public int calculate(int a, Operation operation, int b) {
        return OPERATION_TO_CALCUALTION.getOrDefault(operation, DEFAULT_OPERATION).processOperation(a, b);
    }
}

enum Operation {
    ADD,
    DIV,
    MULT;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            if(true){
            }
        }
        boolean anyMatch =
                Arrays.stream(Operation.values()).anyMatch(x -> x != Operation.DIV);
    }
}

@FunctionalInterface
interface OperationInterface {
    int processOperation(int a, int b);
}
