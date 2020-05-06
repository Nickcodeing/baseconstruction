package com.nick.baseconstruction.web.index;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice(annotations = Controller.class)
@Controller
public class NickErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error2";
    }
}
