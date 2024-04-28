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
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ // model에 담으면 랜더링할 때 name 쓴다
        model.addAttribute("name" , name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // body에 return 내용을 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //데이터를 그대로 내려줌
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        // java bean 표준 규약, 프로퍼티 접근방식
        private String name; // private라서 외부에서 못꺼낸다. 메서드를 통해 접근
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
