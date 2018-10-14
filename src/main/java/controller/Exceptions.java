package controller;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
class Exceptions extends RuntimeException {

    Exceptions(String message) {
        super(message);
    }
}
