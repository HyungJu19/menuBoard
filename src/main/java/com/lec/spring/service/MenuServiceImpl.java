package com.lec.spring.service;

import com.lec.spring.domain.Menu;
import com.lec.spring.repository.MenuRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(SqlSession sqlSession){

        menuRepository = sqlSession.getMapper(MenuRepository.class);
        System.out.println("BoardService() 생성");
    }


    @Override
    public int make(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public Menu lookup(Long mid) {
        Menu menu = menuRepository.findById(mid);
        return menu;
    }

    @Override
    public List<Menu> list() {
        return menuRepository.findAll();
    }

    @Override
    public Menu selectById(Long mid) {
        return menuRepository.findById(mid);
    }

    @Override
    public Object change(Menu menu) {
        return menuRepository.update(menu);
    }

    @Override
    public int eraseById(Long mid) {
        int result = 0;
        Menu menu = menuRepository.findById(mid);
        if(menu != null){
            result = menuRepository.delete(menu);
        }
        return result;
    }
}
