package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Di on 24.04.2017.
 */
public class Parser
{




    public static List<Integer> parseText(String text)
    {
        List<String> wordsList = new ArrayList<>(Arrays.asList(text.split("\\s+")));

        wordsList.remove(0);
        String str = wordsList.get(0);
        str = str.substring(1);
        wordsList.set(0,str);


        List<Integer> vals = new ArrayList<>();
        for (String s:wordsList
             ) {
            Integer val = Integer.parseInt(s);
            vals.add(val);
        }

       return vals;
    }






}
