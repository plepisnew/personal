package me.plepis.accenture.bootcamp.spring_boot;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("home")
    public ModelAndView home(Bean bean){
        ModelAndView mv = new ModelAndView("home.jsp");
        mv.addObject(bean);
        return mv;
    }

    @RequestMapping("json")
    @ResponseBody
    public Bean json(Bean bean){
        return bean;
    }
}
