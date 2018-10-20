package com.example.demo2.web;

import com.example.demo2.dao.CategoryDAO;
import com.example.demo2.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;
    @RequestMapping("/listCategory")
    public String listCategory(Model m)throws Exception{
        List<Category> cs=categoryDAO.findAll();
        m.addAttribute("cs",cs);
        return "listCategory.jsp";
    }
}
