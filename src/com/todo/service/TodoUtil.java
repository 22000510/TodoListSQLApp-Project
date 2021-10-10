package com.todo.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {
	
	public static void createItem(TodoList list) {
		int num;
		String category, title, desc, due_date;
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int i = 1;
		for (TodoItem item : list.getList()) {
			a+=1;
		}
		System.out.println("[항목 추가]\n"
				+ "카테고리 > ");
		num = a+1;
		category = sc.next();
		System.out.println("제목 > ");
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.printf("제목이 중복됩니다!");
			return;
		}
		sc.nextLine();
		System.out.println("내용 > ");
		desc = sc.nextLine().trim();
		System.out.println("마감일 > ");
		due_date = sc.nextLine().trim();
		TodoItem t = new TodoItem(num, category,title, desc, due_date);
		list.addItem(t);
		System.out.println("추가되었습니다.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int i = 1;
		for (TodoItem item : l.getList()) {
			a+=1;
		}
		System.out.print("[항목 삭제]\n" + "삭제할 항목의 번호을 입력하시오 > ");
		int num = sc.nextInt();
		if (num > a) {
			System.out.println("없는 번호입니다.");
			return;
		}
		for (TodoItem item : l.getList()) {
			if (item.getNum() == num) {
				l.deleteItem(item);
				System.out.println("삭제되었습니다.");
				break;
			}
		}
	}


	public static void updateItem(TodoList l) {
		int a = 0;
		int i = 1;
		for (TodoItem item : l.getList()) {
			a+=1;
		}
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[항목 수정]\n"
				 + "수정할 항목의 번호를 입력하시오 > ");
		int num = sc.nextInt();
		if (num > a) {
			System.out.println("없는 번호입니다.");
			return;
		}
		System.out.print("새 카테고리 > ");
		String new_category = sc.next().trim();
		System.out.print("새 제목 > ");
		String new_title = sc.next().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("제목이 중복됩니다!");
			return;
		}
		sc.nextLine();
		System.out.print("새 내용 > ");
		String new_description = sc.nextLine().trim();
		System.out.println("새 마감일 > ");
		String new_due_date = sc.nextLine().trim();
	
		for (TodoItem item : l.getList()) {
			if (item.getNum() == num) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(num, new_category, new_title, new_description, new_due_date);
				l.addItem(t);
				System.out.println("수정되었습니다.");
			}
		}

	}
	public static void findItem(TodoList l, String word) {
		for (TodoItem item : l.getList()) {
			String data = item.toString();
			if(data.contains(word)) {
			System.out.println(data);
			}
		}
	}
	public static void listAll(TodoList l) {
		int a = 0;
		int i = 1;
		for (TodoItem item : l.getList()) {
			a+=1;
		}
		System.out.println("[전체 목록], 총 " + a +"개" );
		for (TodoItem item : l.getList()) {		
			System.out.println(item.toString());

		}
	}
	
	public static void saveList(TodoList l, String filename) {
		try {
			FileWriter fw = new FileWriter( "todolist.txt" ,true);
            BufferedWriter writer = new BufferedWriter( fw );
			for (TodoItem item : l.getList()) {
				System.out.print(item.toSaveString());
				 
				writer.write(item.toSaveString());
				writer.newLine();
				writer.flush();
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadList(TodoList l, String filename){
		try {
			FileReader reader = new FileReader(filename);
			int ch;
			int num;
			String data = "";
			String category, title;
			String desc, date;
			String due_date;
			
			try {
				if ((ch = reader.read()) == -1) {
				System.out.println("내용이 없습니다.");
				}
				else {
					System.out.print("로딩이 완료되었습니다.");
					while ((ch = reader.read()) != -1) {	
						data = data + (char)ch;
					}
					String[] total = data.split("\n");
					int len = total.length;
					for(int i = 0;i<len;i++) {
						String[] line= total[i].split("##");
						num = Integer.parseInt(line[0]);
						category = line[1];
						title = line[2];
						desc = line[3];
						due_date = line[4];
						TodoItem t = new TodoItem(num, category, title, desc, due_date);
						l.addItem(t);
				}
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
