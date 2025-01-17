package example.controller;

import example.entity.TemplateClass;
import example.service.TemplateService;
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

    private final TemplateService templateService;

    public TestController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping
    public ResponseEntity<?> get() {
        List<TemplateClass> templates = templateService.selectAll();
        return new ResponseEntity<>(templates, HttpStatus.OK);
    }

}
