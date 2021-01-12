package com.spring.mvc.psi.controller;

import java.util.Optional;
import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.repository.Inventory2Repository;
import com.spring.mvc.psi.repository.InventoryRepository;
import com.spring.mvc.psi.repository.ProductRepository;
import com.spring.mvc.psi.repository.PurchaseRepository;
import com.spring.mvc.psi.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/psi")
public class PSIController {
    
    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    InventoryRepository inventoryRepository;
   
    @Autowired
    Inventory2Repository inventory2Repository;
    
    @Autowired
    PurchaseRepository purchaseRepository;
    
    @Autowired
    SalesRepository salesRepository;
    
    // 讀取商品資料
    @GetMapping(value = {"/product", "/product/{id}", "/product/{delete}/{id}"})
    public String readProduct(  Model model, 
                                @RequestParam Optional<Boolean> deleteError,
                                @PathVariable Optional<Integer> id,
                                @PathVariable Optional<String> delete ){
        Product product = new Product();
        String _method = "POST";
        
        if(id.isPresent()) {
            product = productRepository.findOne(id.get());
            if(delete.isPresent() && delete.get().equals("delete")) {
                _method = "DELETE";
            } else {
                _method = "PUT";
            }
        }
        
        model.addAttribute("_method", _method);
        model.addAttribute("product", product);
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("deleteError", deleteError.isPresent()?"刪除失敗":"");
        return "psi/product";
    }
    
   // 新增商品
    @PostMapping(value = {"/product"})
    public String createProduct(@ModelAttribute("product") Product product) {
        productRepository.saveAndFlush(product);
        return "redirect: ../psi/product";
    }
    
    // 修改商品
    @PutMapping(value = {"/product"})
    public String updateProduct(@ModelAttribute("product") Product product) {
        productRepository.saveAndFlush(product);
        return "redirect: ../psi/product";
    }
    
    // 刪除商品
    @DeleteMapping(value = {"/product"})
    public String deleteProduct(@ModelAttribute("product") Product product) {
        try{
            productRepository.delete(product.getId());
        }catch(Exception e){
            return "redirect: ../psi/product?deleteError=true";
        }
        
        return "redirect: ../psi/product";
    }
    
    // 讀取庫存
    @GetMapping(value = {"/inventory"})
    public String readInventory(Model model) {
        model.addAttribute("inventories", inventoryRepository.findAll());
        model.addAttribute("inventories2", inventory2Repository.findAll());
        return "psi/inventory";
    }   
    
    // 讀取進貨
    @GetMapping(value = {"/purchase"})
    public String readPurchase(Model model) {
        model.addAttribute("purchases", purchaseRepository.findAll());
        model.addAttribute("inventories2", inventory2Repository.findAll());
        return "psi/purchase";
    } 
    
    // 讀取銷貨
    @GetMapping(value = {"/sales"})
    public String readSales(Model model) {
        model.addAttribute("sales", salesRepository.findAll());
        model.addAttribute("inventories2", inventory2Repository.findAll());
        return "psi/sales";
    } 
}
