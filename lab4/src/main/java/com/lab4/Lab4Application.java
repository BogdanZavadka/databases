package com.lab4;

import com.lab4.view.View;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab4Application implements CommandLineRunner {

    private final View view;

    public Lab4Application(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        view.show();
    }
}
