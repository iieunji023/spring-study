package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");

        return "hello";

    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);   // 파라미터로 넘어온 name 넘겨줌
        return "hello-template";
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public String helloString(@RequestParam String name) {
        return "hello " + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name) {
        Hello hello = new Hello();  // 객체 생성
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
