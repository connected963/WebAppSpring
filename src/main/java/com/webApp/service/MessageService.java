package com.webApp.service;

import com.webApp.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by connected on 2/7/17.
 */

@Service
public class MessageService {

    public List<Message> generateMessages() {
        List<Message> messages = new ArrayList<>();

        IntStream.range(0, 7)
                .boxed()
                .map(i -> Message.generateMessage())
                .forEach(messages::add);

        return messages;
    }
}