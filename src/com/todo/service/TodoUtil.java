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
	
	public static void createItem(TodoList l) {
		String category, title, desc, due_date;
		int is_completed = 0;
		Scanner sc = new Scanner(System.in);
		int progress=0;
		int importance = 0;
		System.out.print("[항목 추가]\n"+"제목 > ");
		title = sc.next();
		/*if(l.isDuplicate(title)) {
			System.out.println("제목이 중복됩니다!");
			return;
		}*/
		System.out.print("카테고리 > ");
		category = sc.next();
		sc.nextLine();
		System.out.print("내용 > ");
		desc = sc.nextLine().trim();
		System.out.print("마감일자 > ");
		due_date = sc.nextLine().trim();
		System.out.print("진행도 > ");
		progress = sc.nextInt();
		System.out.print("중요도 > ");
		importance = sc.nextInt();
		
		TodoItem t = new TodoItem(title,is_completed, desc, category, due_date,progress,importance);
		if(l.addItem(t)>0)
			System.out.println("추가되었습니다.");
	}
	/*public static void createItem(TodoList list) {
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
*/
	public static void deleteItem(TodoList l) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[항목 삭제])\n"
				+ "삭제할 항목의 번호를 입력하시오 > ");
		String[] index = sc.nextLine().split(" ");
		for(int i=0; i<index.length;i++) {
			int index1 = Integer.parseInt(index[i]);
			if (l.deleteItem(index1)>0);
		}
		
			System.out.println("삭제되었습니다.");
	}
	/*public static void deleteItem(TodoList l) {
		
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
	}*\


	/*public static void updateItem(TodoList l) {
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

	}*/
	public static void updateItem(TodoList l) {
		String new_title, new_desc, new_category, new_due_date;
		Scanner sc = new Scanner(System.in);
		int is_completed = 0;
		int new_progress =0;
		int new_importance=0;
		System.out.print("[항목 수정]\n"
				+ "수정할 항목의 번호를 입력하시오 > ");
		int index = sc.nextInt();
		
		System.out.print("새 제목 > ");
		new_title = sc.next().trim();
		System.out.print("새 카테고리 > ");
		new_category = sc.next();
		sc.nextLine();
		System.out.print("새 내용 > ");
		new_desc = sc.nextLine().trim();
		System.out.print("새 마감일자 > ");
		new_due_date = sc.nextLine().trim();
		System.out.print("새 진행도 > ");
		new_progress = sc.nextInt();
		System.out.print("새 중요도 > ");
		new_importance = sc.nextInt();
		
		TodoItem t = new TodoItem(new_title,is_completed , new_desc, new_category, new_due_date, new_progress, new_importance);
		t.setId(index);
		if(l.updateItem(t) > 0)
			System.out.println("수정되었습니다.");
	}
	public static void findItem(TodoList l, String word) {
		for (TodoItem item : l.getList()) {
			String data = item.toString();
			if(data.contains(word)) {
			System.out.println(data);
			}
		}
	}
	public static void findList(TodoList l, String keyword) {
		int count=0;
		for (TodoItem item : l.getList(keyword)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("총 %d개의 항목을 찾았습니다.\n", count);
	}
	/*public static void listAll(TodoList l) {
		int a = 0;
		int i = 1;
		for (TodoItem item : l.getList()) {
			a+=1;
		}
		System.out.println("[전체 목록], 총 " + a +"개" );
		for (TodoItem item : l.getList()) {		
			System.out.println(item.toString());

		}
	}*/
	public static void listAll(TodoList l) {
		System.out.printf("[전체 목록, 총 %d개]\n", l.getCount());
		for(TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
	}
	public static void listAll(TodoList l, String orderby, int ordering) {
		System.out.printf("[전체 목록, 총 %d개]\n", l.getCount());
		for(TodoItem item : l.getOrderedList(orderby,ordering)) {
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
	public static void listCateAll(TodoList l) {
		int count = 0;
		for (String item : l.getCategories()) {
			System.out.print(item+" ");
			count++;
		}
		System.out.printf("\n총 %d개의 카테고리가 등록되어 있습니다.\n",count );
	}
	public static void findCateList(TodoList l, String cate) {
		int count = 0;
		for (TodoItem item : l.getListCategory(cate)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("\n총 %d개의 항목을 찾았습니다.\n", count);
	}
	
	public static void completeItem(TodoList l) {
		String category, title, desc, due_date, is_completed = "0";
		Scanner sc = new Scanner(System.in);
		String[] num = sc.nextLine().split(" ");
		for(int i=0; i<num.length;i++) {
			int index1 = Integer.parseInt(num[i]);
			l.completeItem(index1);
		}
		
			System.out.println("체크되었습니다.");
	}
	
	public static void listAll(TodoList l, int index) {
		int count=0;
		for (TodoItem item : l.getList(index)) {
			System.out.println(item.toString());
			count++;
		}
		System.out.printf("총 %d개의 항목을 찾았습니다.\n", count);
	}
	
	
/*	public static void loadList(TodoList l, String filename){
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
						TodoItem t = new TodoItem(category, title, desc, due_date);
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
	*/
}
