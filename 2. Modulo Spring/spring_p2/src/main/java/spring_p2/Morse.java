package spring_p2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epic.morse.service.MorseCode;

@RestController
public class Morse {
  
  @GetMapping("/morse")
  public String morse(@RequestBody String text) {    
    return (String) MorseCode.convertToText(text);
  }
}