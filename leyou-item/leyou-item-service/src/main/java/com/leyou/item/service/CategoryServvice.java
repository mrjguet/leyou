package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class CategoryServvice {
    @Autowired
    private CategoryMapper categoryMapper;
    /**
    *@Description 根据pid查询分类列表
    *@Param
    *@Return
    *@Author mrjguet
    *@Date 2020/2/16
    *@Time 10:53
    */

    public List<Category> queryCategorysByPid(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        List<Category> categoryList = this.categoryMapper.select(category);
        return categoryList;
    }
}
