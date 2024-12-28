package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandNum {
    public static int getRandNum(){
        List<Integer>numbers=new ArrayList<>();
        for(int i=1;i<=1000;i++) {
            if(i%4!=0){
                numbers.add(i);
            }
        }
        Random random=new Random();
        return numbers.get(random.nextInt(numbers.size()));
    }
}
