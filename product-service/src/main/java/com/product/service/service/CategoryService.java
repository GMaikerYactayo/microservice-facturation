package com.product.service.service;

import com.product.service.domain.Category;

import java.util.List;

public interface CategoryService {

    Category save(Category category);

    List<Category> findAll();

}
