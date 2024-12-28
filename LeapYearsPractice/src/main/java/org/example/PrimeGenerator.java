package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrimeGenerator {
    public static int getPrime(){
        List<Integer> primes = new ArrayList<>();
        for (int i = 501; i < 600; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        // Generate a random prime number from the list
        Random random = new Random();
        return primes.get(random.nextInt(primes.size()));

    }
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
