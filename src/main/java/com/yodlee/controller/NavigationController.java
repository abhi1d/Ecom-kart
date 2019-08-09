package com.yodlee.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yodlee.model.Item;
import com.yodlee.model.Products;

@Controller
public class NavigationController {
	String products_list[];
	String productName;
	String price;
	String id;
	String desc;
	String imgSrc;

	
	
    @GetMapping("/products")
    public String getProducts()
    {
    	return "products";
    }
    
    @GetMapping("/category")
    public String categories()
    {
    	return "categories";
    }
    
    @GetMapping("/")
    public String landingPage()
    {
    	
    	return "home";
    }
    
    @GetMapping("/men")
    public ModelAndView menPage()
    {
    	Item item_list[] = null;
      	try{
            // create object mapper
            ObjectMapper mapper = new ObjectMapper();
            // read JSON file and map/convert to Java POJO :
            // data/sample-lite.json
            Products products =
              mapper.readValue(new File("data/item.json"), Products.class);
            
            item_list = products.getItem();

    
            
            // print first name and last name
            System.out.println("product = "  + item_list[0].getProductName());
            System.out.println("price = "  + item_list[1].getPrice());
            System.out.println("id= "  + item_list[2].getId());
            System.out.println("desc = "  + item_list[3].getDesc());
            
            
          
             
    
        } catch (Exception e){
            e.printStackTrace();
        }
        ModelAndView mv = new ModelAndView();
       
		mv.addObject("items_list",item_list);
      
    	
        mv.setViewName("men");	
    	return mv;
    }
    
    @GetMapping("/navbar")
    public String navbar()
    {
    	return "navbar";
    }
}
