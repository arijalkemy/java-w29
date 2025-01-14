package com.example.demo.API.factorial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactorialController {

    @GetMapping("/factorial/{n}")
    public long factorialController(@PathVariable long n){
        if (n < 0) {
            return -1;
        }
        return this.factorial(n);
    }
    private long factorial(long n){
        if(n == 0 || n == 1){
            return 1;
        }

        return   n * factorial(n - 1);
    }

}
