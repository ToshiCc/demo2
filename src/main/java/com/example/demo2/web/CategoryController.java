package com.example.demo2.web;

import com.example.demo2.dao.CategoryDAO;
import com.example.demo2.mapper.CategoryMapper;
import com.example.demo2.pojo.Category;
import com.example.demo2.pojo.Category2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;
     private CategoryMapper categoryMapper;
    @Autowired
    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }
    //JPA
    @RequestMapping("/listCategory")
    public String listCategory(Model m)throws Exception{
        List<Category> cs=categoryDAO.findAll();
        m.addAttribute("cs",cs);
        return "listCategory.jsp";
    }
    //分页
    @RequestMapping("/listCategoryNew")
    public String listCategoryNew(Model m, @RequestParam(value="start",defaultValue = "0")int start,@RequestParam(value = "size",defaultValue = "5")int size)throws Exception{
        start=start<0?0:start;
        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable=PageRequest.of(start,size,sort);
        Page<Category>page =categoryDAO.findAll(pageable);
        m.addAttribute("page",page);
        return "listCategoryNew.jsp";
    }
    @RequestMapping("/addCategory")
    public String addCategory(Category c)throws Exception{
        categoryDAO.save(c);
        return "redirect:listCategoryNew";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c)throws Exception{
        categoryDAO.delete(c);
        return "redirect:listCategoryNew";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c)throws Exception{
        categoryDAO.save(c);
        return "redirect:listCategoryNew";
    }
    @RequestMapping("/editCategory")
    public String editCategory(int id,Model m)throws Exception{
        Category c=categoryDAO.getOne(id);
        m.addAttribute(c);
        return "editCategory.jsp";
    }
    //MyBatis
    @RequestMapping("/listCategory2")
    public String listCategory2(Model m) throws Exception {
        List<Category2> cs=categoryMapper.findAll();
        m.addAttribute("cs", cs);
        return "listCategory.jsp";
    }
    @RequestMapping("/listCategory3")
    public String listCategory3(Model m) throws Exception {
        List<Category2> cs=categoryMapper.findAll2();
        m.addAttribute("cs", cs);
        return "listCategory.jsp";
    }
}
