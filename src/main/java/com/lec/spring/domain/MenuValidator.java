package com.lec.spring.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MenuValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        System.out.println("supports( " + clazz.getName() + ")");
        boolean result = Menu.class.isAssignableFrom(clazz);
        System.out.println(result);
        return result;
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("validate()호출");
        Menu menu = (Menu) target;



        // mn_name
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","음식이름는 필수입니다.");
        String name = menu.getName();
        if(name != null &&name.length() > 20) {
            errors.rejectValue("name","음식이름의 길이는 20자 까지만 가능합니다.");};



        //mn_kind
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"kind","음식종류는 필수입니다.");
        String kind = menu.getKind();
        if(!"한식".equals(kind) && !"중식".equals(kind) && !"일식".equals(kind)){
            errors.rejectValue("kind","아직은 '한식', '일식', '중식' 만 입력이 가능합니다.");
        }


        //mn_price
        Long price = menu.getPrice();
        if(price < 0){
            errors.rejectValue("price","음식가격이 음수는 불가능합니다.");
        } else if(errors.hasFieldErrors("price")){
            errors.rejectValue("price","가격에 '문자','소수점'은 불가합니다.");
        }



    }
}
