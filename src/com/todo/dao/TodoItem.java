package com.todo.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItem {
	private String category;
    private String title;
    private String desc;
    private String current_date;
    private String due_date;
    private int is_completed;
    private int progress;
    private int importance;
	private int num;
	private int id;


	public TodoItem(String title, int is_completed, String desc, String category, String due_date, int progress, int importance){
		this.category=category;
    	this.title=title;
    	this.is_completed = is_completed;
    	this.progress = progress;
    	this.importance = importance;
        this.desc=desc;
        this.due_date=due_date;
        SimpleDateFormat f =new SimpleDateFormat("yyy/MM/dd kk:mm:ss");
        this.current_date= f.format(new Date());
    }
	public String getCategory() {
			return category;
	}

	public void setCategory(String category) {
			this.category = category;
	}
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getIs_completed() {
        return is_completed;
    }

    public void setIs_completed(int is_completed) {
        this.is_completed = is_completed;
    }
    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }
    public int getId() {
		return id;
	}

	public void setId(int id) {
		 this.id = id;
		
	}
	@Override
	public String toString() {
		return id + "." + "[" + category + "] " + title + " " + is_completed + " - " + desc + " - " + due_date + " - " + importance + " - " + progress + " - " + current_date;
	}
    
    public String toSaveString() {
    	return id+ "##" + category + "##" + title + "##" + is_completed +"##" + desc + "##" + due_date + " ## " +current_date + "/n";
    }
    
    
	
	
}
