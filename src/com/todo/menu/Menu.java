package com.todo.menu;
public class Menu {

    public static void displaymenu()
    {
        System.out.println();
        System.out.println("<ToDoList ���� ��ɾ� ����> ");
        System.out.println("add - �׸� �߰�");
        System.out.println("del(���� ����) - �׸� ����");
        System.out.println("edit - �׸� ����");
        System.out.println("ls - ��ü���");
        System.out.println("ls_name - ����� ����");
        System.out.println("ls_name_desc - ���񿪼� ����");
        System.out.println("ls_date - ��¥�� ����");
        System.out.println("ls_cate - ī�װ� ����");
        System.out.println("find_cate<keyword> - ī�װ� ã��");
        System.out.println("ls_date - ��¥�� ����");
        System.out.println("find<Ű����> - <Ű����>�� ������ ����Ʈ ���");
        System.out.println("comp - �Ϸ�üũ(���� ����) ����");
        System.out.println("ls_comp - �Ϸ�� �� ����");
        System.out.println("exit - ����");
        System.out.println("���� ����: id, �Ϸ�ǥ��(�Ϸ�-1, �̿Ϸ�-0), ī�װ�, ����, ����, ������, ���൵, �߿䵵, ����� ��¥");
    }
    public static void prompt()
    {
    	System.out.print("\nCommand > ");
    }
}
