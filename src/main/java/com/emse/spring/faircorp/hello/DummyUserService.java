package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class DummyUserService implements UserService {

    @Autowired
    private GreetingService greetingService;

    @Override
    public void greetAll() {

        List<String> l = new LinkedList<String>();
        l.add("Elodie");
        l.add("Charles");

        l.forEach(s -> greetingService.greet(s));
    }
}
