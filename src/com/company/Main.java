package com.company;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    private static String[] externalRefs = {"Number.txt", "Number2.txt"};

    public static void main(String[] args) {
	// write your code here




        ExecutorService executor = Executors.newFixedThreadPool(externalRefs.length);


        Runnable runnable = ()-> {
            String text = ReaderFromFile.getText(externalRefs[0]);
            List<Integer> integers = Parser.parseText(text);


            integers.stream().reduce((d1,d2)->
            {
                System.out.println("number: " + (d1 + d2));
                return (d1+d2);
            });


        };


        Runnable runnable2 = ()-> {
            String text = ReaderFromFile.getText(externalRefs[1]);
            List<Integer> integers = Parser.parseText(text);


            integers.stream().reduce((d1,d2)->
            {
                System.out.println("number2: " + (d1 + d2));
                return (d1+d2);
            });


        };




        executor.execute(runnable);
        executor.execute(runnable2);

        executor.shutdown();

    }
}
