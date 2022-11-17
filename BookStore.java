package com.book;
import java.util.*;

public class BookStrore {
	List<Book>BookList=new ArrayList<Book>();
	public void addBook(Book b) {
		BookList.add(b);
	}
	public List<Book> searchByTitle(String title){
		List<Book> selectedList=new ArrayList<Book>();
		for(Book b:BookList) {
			if(b.getTitle().equals(title)) {
				selectedList.add(b);
			}
		}
		return selectedList;
	}
	public List<Book> searchByAuthor(String author){
		List<Book> selectedList=new ArrayList<Book>();
		for(Book b:BookList) {
			if(b.getAuthor().equals(author)) {
				selectedList.add(b);
			}
		}
		return selectedList;
	}
	public void display(List<Book> BookList) {
		System.out.println("Books are:");
		System.out.println("-------------------------------------------");
		System.out.println("BookID     Title     Author    Category    Price    ");
		for(Book b:BookList) {
			System.out.println(b.getBookID()+"   "+b.getTitle()+"    "+b.getAuthor()+"   "+b.getCategory()+"   "+b.getPrice());
			}
	}
    public void displaybyid(String Bookid) {
    	System.out.println("BookID     Title     Author    Category    Price    ");
    	for(Book b:BookList) {
    		if(b.getBookID().equals(Bookid)) {
    			System.out.println(b.getBookID()+"   "+b.getTitle()+"    "+b.getAuthor()+"   "+b.getCategory()+"   "+b.getPrice());
    		}
    	}
    	
    }
    public void displayAll() {
    	System.out.println("Books are:");
    	System.out.println("----------------------------------------------------");
    	System.out.println("BookID     Title     Author    Category    Price    ");
    	for(Book b:BookList) {
			System.out.println(b.getBookID()+"   "+b.getTitle()+"    "+b.getAuthor()+"   "+b.getCategory()+"   "+b.getPrice());
			}
    }
    public void deleteBook(String bookID) {
    	Iterator<Book>itr=BookList.iterator();
    	while(itr.hasNext()) {
    		if(itr.next().getBookID().equals(bookID)) {
    			itr.remove();
    		}
    	}
    }
    public boolean modifyBook(String Bookid) {
    	int c=0;
    	for(Book b:BookList) {
    		if(b.getBookID().equals(Bookid)) {
    			c=c+1;
    		}
    	}
    	if(c>0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
