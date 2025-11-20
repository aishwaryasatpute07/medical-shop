package com.medicalshop.medical_shop_project.controller;

import com.medicalshop.medical_shop_project.model.Categories;
import com.medicalshop.medical_shop_project.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/getAllCategories")
    public List<Categories> getAllCustomers() {
        return categoriesService.getAllCategories();
    }
}
