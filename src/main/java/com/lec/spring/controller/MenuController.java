package com.lec.spring.controller;


import com.lec.spring.domain.Menu;
import com.lec.spring.domain.MenuValidator;
import com.lec.spring.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.WeakHashMap;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    public MenuService menuService;

    public MenuController(){

    }


    @GetMapping ("/list")
    public void list(Model model){
        List<Menu> list = menuService.list();
        model.addAttribute("list",list);
    }


    @GetMapping("/make")
    public void make(){}

    @PostMapping("/make")
    public String makeOk(@Valid Menu menu
            , BindingResult result
            , Model model   //매개변수 선언시 BindingResult 보다 Model  을 뒤에 두어야 한다.
            , RedirectAttributes redirectAttrs
    ) {
        if (result.hasErrors()) {
            redirectAttrs.addFlashAttribute("name", menu.getName());
            redirectAttrs.addFlashAttribute("kind", menu.getKind());
            redirectAttrs.addFlashAttribute("price", menu.getPrice());
            for (var err : result.getFieldErrors()) {
                redirectAttrs.addFlashAttribute("error_" + err.getField(), err.getCode());
            }

            return "redirect:/menu/make";

        }
        model.addAttribute("result", menuService.make(menu));
        return "menu/makeOk";
    }

    @GetMapping("/lookup/{mid}")
    public String lookup(@PathVariable Long mid, Model model){
        model.addAttribute("menu",menuService.lookup(mid));
        return "menu/lookup";
    }


    @GetMapping("/change/{mid}")
    public String change(@PathVariable Long mid, Model model){
        Menu menu = menuService.selectById(mid);
        model.addAttribute("menu",menu);
        return "menu/change";
    }

    @PostMapping("/change")
    public String changeOk(
            @Valid Menu menu
            , BindingResult result
            , Model model
            , RedirectAttributes redirectAttrs
    ){


        if(result.hasErrors()){
            redirectAttrs.addFlashAttribute("name",menu.getName());
            redirectAttrs.addFlashAttribute("kind",menu.getKind());
            redirectAttrs.addFlashAttribute("price",menu.getPrice());


            for(var err : result.getFieldErrors()){
                redirectAttrs.addFlashAttribute("error_" + err.getField(),err.getCode());
            }
            return "redirect:/menu/change/" + menu.getMid();

        }


        model.addAttribute("result",menuService.change(menu));
        return "menu/changeOk";
    }


    @PostMapping("/erase")
    public String erase(Long mid,Model model){
        int result = menuService.eraseById(mid);
        model.addAttribute("result",result);
        return "menu/eraseOk";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        System.out.println("initBinder() 호출");
        binder.setValidator(new MenuValidator());
    }

}
