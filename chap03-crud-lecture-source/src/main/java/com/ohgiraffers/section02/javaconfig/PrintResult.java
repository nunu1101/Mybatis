package com.ohgiraffers.section02.javaconfig;

import java.util.List;

public class PrintResult {
    public void printMenuList(List<MenuDTO> menuList) {
        for (MenuDTO menu : menuList) {
            System.out.println(menu);
        }
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";
        switch (errorCode) {
            case "selectList" : errorMessage = "메뉴 목록 조회를 실패하셨습니다."; break;
        }
        System.out.println(errorMessage);
    }
    public void printMenu(MenuDTO menu) {
        System.out.println(menu);
    }
}
