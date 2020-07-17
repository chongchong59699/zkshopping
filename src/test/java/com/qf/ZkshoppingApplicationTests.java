package com.qf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZkshoppingApplicationTests {

    @Test
    void contextLoads() {
        for (int i = 2; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

    }

    boolean isPrime(int num) {
        int result=0;
        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0)
                result+=i;
        }
        //System.out.println(num+"   "+result);
        return result==0;
    }

}
