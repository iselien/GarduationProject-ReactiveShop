package com.yovelas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Controller
public class App {

//    @RequestMapping("/")
//    String home() {
//        return "index.html";
//    }

    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}
