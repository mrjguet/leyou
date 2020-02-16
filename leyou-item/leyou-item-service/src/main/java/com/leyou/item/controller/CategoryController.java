package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryServvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryServvice categoryServvice;
    /**
    *@Description 根据pid查询分类列表
    *@Param
    *@Return
    *@Author mrjguet
    *@Date 2020/2/16
    *@Time 10:52
    */
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategorysByPid(@RequestParam(value = "pid",defaultValue = "0") Long pid){
        if(pid == null || pid<0){
            return  ResponseEntity.badRequest().build();
        }
        List<Category> categoryList = categoryServvice.queryCategorysByPid(pid);
        if(CollectionUtils.isEmpty(categoryList)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryList);
    }
}
