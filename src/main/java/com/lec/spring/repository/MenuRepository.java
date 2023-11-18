package com.lec.spring.repository;

import com.lec.spring.domain.Menu;

import java.util.List;

public interface MenuRepository {

    //새글작성
    int save(Menu menu);


    //특정 id글 내용읽기(SELECT)
    Menu findById(Long mid);

    //전체 글목록 : 최신순(SELECT)
    List<Menu> findAll();

    //특정 id글 수정(이름 종류 가격)(UPDATE)
    int update(Menu menu);

    //특정id 글 삭제하기 (DELETE)
    int delete(Menu menu);

}
