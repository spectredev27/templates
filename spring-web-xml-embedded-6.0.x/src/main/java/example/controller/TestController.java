package example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public ResponseEntity<?> get() {
        Map<String, Object> object = new HashMap<>();
        object.put("id", 1);
        object.put("name", "Spring Framework");
        return new ResponseEntity<>(List.of(object), HttpStatus.OK);
    }

}
