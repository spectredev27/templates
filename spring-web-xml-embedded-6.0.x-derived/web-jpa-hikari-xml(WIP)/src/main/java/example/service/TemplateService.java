package example.service;

import example.entity.TemplateClass;
import example.repository.TemplateRepository;

import java.util.List;

public class TemplateService {

    private final TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public List<TemplateClass> selectAll() {
        return templateRepository.selectAll();
    }

}
