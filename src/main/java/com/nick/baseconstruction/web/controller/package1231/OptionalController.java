package com.nick.baseconstruction.web.controller.package1231;

import com.nick.baseconstruction.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/optional/")
public class OptionalController {

    @RequestMapping("test")
    @ResponseBody
    public void method(){
        Optional<Object> empty = Optional.empty();
        boolean present = empty.isPresent();
        System.out.println(present);
        Optional<User> user = Optional.of(new User("nick","male",18));
        System.out.println(user.isPresent());
        empty.ifPresent(System.out::println);
        user.ifPresent(u->System.out.println(u.getUserName()));
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.get());
    }
}
