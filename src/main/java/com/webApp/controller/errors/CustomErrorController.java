package com.webApp.controller.errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by connected on 2/7/17.
 */
@Controller
public class CustomErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    private static final String DEFAULT_ERROR_PATH = "/error";
    private static final String NOT_FOUND_ERROR_PATH = "/404";
    private static final String DEFAULT_ERROR_TEMPLATE = "customError";
    private static final String NOT_FOUND_ERROR_TEMPLATE = "404";

    @Autowired
    public CustomErrorController(final ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(CustomErrorController.DEFAULT_ERROR_PATH)
    public String error(Model model, HttpServletRequest request) {

        setDefaultAttributes(model, request);

        return CustomErrorController.DEFAULT_ERROR_TEMPLATE;
    }

    @RequestMapping(CustomErrorController.NOT_FOUND_ERROR_PATH)
    public String pageNotFound(Model model, HttpServletRequest request) {

        setDefaultAttributes(model, request);

        return CustomErrorController.NOT_FOUND_ERROR_TEMPLATE;
    }

    @Override
    public String getErrorPath() {
        return CustomErrorController.DEFAULT_ERROR_PATH;
    }

    private void setDefaultAttributes(Model model, HttpServletRequest request) {
        final Map<String, Object> error = getErrorAttributes(request, true);

        model.addAttribute("errorDate", error.get("timestamp"));
        model.addAttribute("errorName", error.get("error"));
        model.addAttribute("errorMessage", error.get("message"));
        model.addAttribute("errorCode", error.get("status"));
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, Boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
}