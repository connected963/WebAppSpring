package com.webApp.controller;

import com.webApp.configurations.SpringConfigurations;
import com.webApp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by connected on 2/7/17.
 */

@Controller
@RequestMapping("/message")
public class MessageController {

    @Value("${spring.application.name}")
    private String appName;

    private final MessageService messageService;

    @Autowired
    public MessageController(final MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping("/")
    public String list(Model model) {

        model.addAttribute("appName", appName);
        model.addAttribute("messages", messageService.generateMessages());

        return "views/messagesList";
    }

    @RequestMapping("/chat")
    public String chat(Model model) {
        return "views/chat";
     }

    @RequestMapping("/message/{message}")
    public String getMessage(@PathVariable(value="message") String message) throws Exception {
        throw new Exception("We couldn't find the message for: " + message);
    }


    //Example of how handle exception for only this controller
    /*@ExceptionHandler(Exception.class)
    public String handleException(HttpServletRequest request, Exception exception, Model model) {
        model.addAttribute("errorName", exception.toString());
        model.addAttribute("errorCode", "Exception");
        model.addAttribute("errorMessage", exception.getMessage());
        model.addAttribute("errorDate", new Date());

        return "customError";
    }*/
}