package com.webApp.controller.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * Created by connected on 2/8/17.
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception, Model model) {
        model.addAttribute("errorName", exception.toString());
        model.addAttribute("errorCode", "Exception");
        model.addAttribute("errorMessage", exception.getMessage());
        //This is using date because I reuse the html file that handle errors
        model.addAttribute("errorDate", new Date());

        return "customError";
    }

}
