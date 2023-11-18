package com.lec.spring.service;

import com.lec.spring.domain.Menu;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MenuService {


    //글작성
    //입력 이름,종류,가격
    int make(Menu menu);

    //특정 id 의 글조회
    //글 잃어오기 (SELECT)
    Menu lookup(Long mid);


    //글목록조회
    List<Menu> list();


    //id 가져오기
    Menu selectById(Long mid);


    //글수정
    //음식이름 음식종류 음식가격 수정
    Object change(Menu menu);

    int eraseById(Long mid);
}
