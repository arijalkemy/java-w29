package spring_pg;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.chaosfirebolt.converter.RomanInteger;

@RestController
public class Roma {
  @GetMapping
  String getRoma(@RequestParam("num") String num){
    RomanInteger converter = RomanInteger.parse(num);
    return converter.getRoman();
  }
}
