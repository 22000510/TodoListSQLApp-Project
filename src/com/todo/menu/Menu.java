package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("<ToDoList 관리 명령어 사용법> ");
        System.out.println("add - 항목 추가");
        System.out.println("del(복수 가능) - 항목 삭제");
        System.out.println("edit - 항목 수정");
        System.out.println("ls - 전체목록");
        System.out.println("ls_name - 제목순 정렬");
        System.out.println("ls_name_desc - 제목역순 정렬");
        System.out.println("ls_date - 날짜순 정렬");
        System.out.println("ls_cate - 카테고리 정렬");
        System.out.println("find_cate<keyword> - 카테고리 찾기");
        System.out.println("ls_date - 날짜순 정렬");
        System.out.println("find<키워드> - <키워드>를 포함한 리스트 출력");
        System.out.println("comp - 완료체크(복수 가능) 정렬");
        System.out.println("ls_comp - 완료된 것 정렬");
        System.out.println("exit - 종료");
        System.out.println("정렬 순서: id, 완료표시(완료-1, 미완료-0), 카테고리, 제목, 내용, 마감일, 진행도, 중요도, 저장된 날짜");
    }
    public static void prompt()
    {
    	System.out.print("\nCommand > ");
    }
}
