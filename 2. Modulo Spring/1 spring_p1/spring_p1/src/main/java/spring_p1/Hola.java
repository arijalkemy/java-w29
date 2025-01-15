package spring_p1;

import org.springframework.web.bind.annotation.*;

@RestController
public class Hola {
  
  @GetMapping("/{name}")
  String getHello(@PathVariable String name){
    return "Hola mundo " + name;
  }
}
