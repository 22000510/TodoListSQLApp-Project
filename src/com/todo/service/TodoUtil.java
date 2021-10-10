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
		System.out.println("[�׸� �߰�]\n"
				+ "ī�װ� > ");
		num = a+1;
		category = sc.next();
		System.out.println("���� > ");
		title = sc.next();
		if (list.isDuplicate(title)) {
			System.out.printf("������ �ߺ��˴ϴ�!");
			return;
		}
		sc.nextLine();
		System.out.println("���� > ");
		desc = sc.nextLine().trim();
		System.out.println("������ > ");
		due_date = sc.nextLine().trim();
		TodoItem t = new TodoItem(num, category,title, desc, due_date);
		list.addItem(t);
		System.out.println("�߰��Ǿ����ϴ�.");
	}

	public static void deleteItem(TodoList l) {
		
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int i = 1;
		for (TodoItem item : l.getList()) {
			a+=1;
		}
		System.out.print("[�׸� ����]\n" + "������ �׸��� ��ȣ�� �Է��Ͻÿ� > ");
		int num = sc.nextInt();
		if (num > a) {
			System.out.println("���� ��ȣ�Դϴ�.");
			return;
		}
		for (TodoItem item : l.getList()) {
			if (item.getNum() == num) {
				l.deleteItem(item);
				System.out.println("�����Ǿ����ϴ�.");
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
		
		System.out.print("[�׸� ����]\n"
				 + "������ �׸��� ��ȣ�� �Է��Ͻÿ� > ");
		int num = sc.nextInt();
		if (num > a) {
			System.out.println("���� ��ȣ�Դϴ�.");
			return;
		}
		System.out.print("�� ī�װ� > ");
		String new_category = sc.next().trim();
		System.out.print("�� ���� > ");
		String new_title = sc.next().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("������ �ߺ��˴ϴ�!");
			return;
		}
		sc.nextLine();
		System.out.print("�� ���� > ");
		String new_description = sc.nextLine().trim();
		System.out.println("�� ������ > ");
		String new_due_date = sc.nextLine().trim();
	
		for (TodoItem item : l.getList()) {
			if (item.getNum() == num) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(num, new_category, new_title, new_description, new_due_date);
				l.addItem(t);
				System.out.println("�����Ǿ����ϴ�.");
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
		System.out.println("[��ü ���], �� " + a +"��" );
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
				System.out.println("������ �����ϴ�.");
				}
				else {
					System.out.print("�ε��� �Ϸ�Ǿ����ϴ�.");
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
