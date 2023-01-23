package com.example;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class Uppercase implements Function<Message<String>, String> {
    public String apply(Message<String> msg) {
        return msg.getPayload().toUpperCase();
    }
}
