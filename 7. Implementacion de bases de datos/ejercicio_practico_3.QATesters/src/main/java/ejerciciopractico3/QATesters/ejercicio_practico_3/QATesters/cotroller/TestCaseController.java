package ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.cotroller;

import com.fasterxml.jackson.databind.JsonMappingException;
import ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.dto.MessageDto;
import ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.dto.TestCaseDto;
import ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.service.ITestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class TestCaseController {
    @Autowired
    private ITestCaseService service;

    @PostMapping("/api/testcases/new")
    public ResponseEntity<MessageDto> newTestCase(@RequestBody TestCaseDto testDto){
        return ResponseEntity.ok(service.saveTestCase(testDto));
    }

    @GetMapping("/api/testcases")
    public ResponseEntity<List<TestCaseDto>> getAllTestCases(){
        return ResponseEntity.ok(service.findAllTestCases());
    }

    @GetMapping("/api/testcases/{id}")
    public ResponseEntity<TestCaseDto> getTestCaseById(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.findTestCaseById(id));
    }

    @GetMapping("/api/testcases/date")
    public ResponseEntity<List<TestCaseDto>> getAllTestCasesByDate(@RequestParam("date") String date) throws ParseException {
        return ResponseEntity.ok(service.findAllTestCasesByUpdateDate(date));
    }

    @PutMapping("/api/testcases/{id}")
    public ResponseEntity<MessageDto> updateTestCase(@PathVariable("id") Long id, @RequestBody TestCaseDto testDto) throws JsonMappingException {
        return ResponseEntity.ok(service.updateTestCase(id,testDto));
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<MessageDto> deleteTestCase(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.deleteTestCase(id));
    }

}
