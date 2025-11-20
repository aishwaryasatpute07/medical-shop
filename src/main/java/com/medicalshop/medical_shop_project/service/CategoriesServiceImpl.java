package com.medicalshop.medical_shop_project.service;

import com.medicalshop.medical_shop_project.model.Categories;
import com.medicalshop.medical_shop_project.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<Categories> getAllCategories() {
        return new ArrayList<>(categoriesRepository.findAll());
    }
}
