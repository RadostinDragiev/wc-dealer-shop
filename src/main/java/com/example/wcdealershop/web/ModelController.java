package com.example.wcdealershop.web;

import com.example.wcdealershop.models.dtos.ModelAddDto;
import com.example.wcdealershop.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/add")
    public String getPage() {
        return "model-add";
    }

    @PostMapping("/add")
    public String addModel(ModelAddDto modelAddDto) {
       this.modelService.addModel(modelAddDto);

        return "redirect:/";
    }
}
