package com.example.wcdealershop.web;

import com.example.wcdealershop.models.dtos.BrandAddDto;
import com.example.wcdealershop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/add")
    public String getAddPage() {
        return "brand-add";
    }

    @PostMapping("/add")
    public String addBrand(BrandAddDto brandAddDto) {
        this.brandService.addBrand(brandAddDto);
        return "redirect:/";
    }
}
