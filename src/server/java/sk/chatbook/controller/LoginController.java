package sk.chatbook.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "http://localhost:8082", maxAge = 3600)
@RequestMapping("/")
public class LoginController implements ErrorController {
    private static final String PATH = "/error";

    @PostMapping("login")
    public ResponseEntity<?> getLoginView(){

        return new ResponseEntity<>("IDEM horeeeee", HttpStatus.OK);
    }

    @RequestMapping(value = PATH)
    public ModelAndView saveLeadQuery() {
        return new ModelAndView("forward:/");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
