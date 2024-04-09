package com.ohgiraffers.section03.remix;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section03.remix.Template.getSqlSession;

public class MenuService {
    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllMenu();
        sqlSession.close();
        return menuList;
    }

    public MenuDTO selectMenuByCode(int code) {

        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO menu = menuMapper.selectByMenuCode(code);

        sqlSession.close();

        return menu;
    }
}
