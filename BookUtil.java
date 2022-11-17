package com.bookutil;
import java.util.Scanner;
import com.book.*;
import com.book.exception.InvalidBookException;

public class BookUtil {
     public Book getbookobj() throws InvalidBookException{
    	 Scanner sc=new Scanner(System.in);
    	 System.out.print("BookId:");
    	 String BookId=sc.nextLine();
    	 System.out.print("Title:");
    	 String Title=sc.nextLine();
    	 System.out.print("Author:");
    	 String Author=sc.nextLine();
    	 System.out.print("Category:");
    	 String Category=sc.nextLine();
    	 System.out.print("Price:");
    	 Float Price=sc.nextFloat();
    	 Book b1=new Book(BookId,Title,Author,Category,Price);
    	 return b1;
     }
     public String getString() {
    	 Scanner sc=new Scanner(System.in);
    	 String val=sc.nextLine();
    	 return val;
     }
     public static void main(String[] args) throws InvalidBookException{
    	
    	 BookUtil butil=new BookUtil();
    	BookStore obj=new BookStore();
    	for(int i=0;i<1;i++) {
    		System.out.println("Fill Details for Book:"+i+"\n");
    		obj.addBook(butil.getbookobj());
    		
    	}
    	
    	Scanner sc1=new Scanner(System.in);
    	System.out.println("Give title name to find:");
    	obj.display(obj.searchByTitle(butil.getString()));
    	System.out.println("Give Author name to find:");
    	obj.display(obj.searchByAuthor(butil.getString()));
    	obj.displayAll();
    	System.out.println("---------------------------------------------");
    	int id;
    	do {
    		System.out.println("1.Add book");
    		System.out.println("2.Modify book details");
    		System.out.println("3.Delete book details");
    		System.out.println("4.Display all the book details");
    		System.out.println("5.Display specific book details");
    		System.out.println("6.Search book by title");
    		System.out.println("7.Search book by author");
    		System.out.println("8.Exit");
    		
    		System.out.println("Enter value:");
    		id=sc1.nextInt();
    		switch(id) {
    		case 1:
    			obj.addBook(butil.getbookobj());
    			break;
    		case 2:
    			Book objn=butil.getbookobj();
    			boolean isitmodify=obj.modifyBook(objn.getBookID());
    			if(isitmodify==true) {
    				obj.deleteBook(objn.getBookID());
    				obj.addBook(objn);
    			}
    			else {
    				System.out.println("There is no book id to modify\n");
    			}
    			break;
    		case 3:
    			System.out.println("Enter Book ID to delete:\n");
    			obj.deleteBook(butil.getString());
    			break;
    		case 4:
    			obj.displayAll();
    			break;
    		case 5:
    			System.out.println("Enter Book ID to display:\n");
    			obj.displaybyid(butil.getString());
    			break;
    		case 6:
    			System.out.println("Give Title name to find:\n");
    			obj.display(obj.searchByTitle(butil.getString()));
    			break;
    		case 7:
    			System.out.println("Give author name to find:\n");
    			obj.diaplay(obj.searchByAuthor(butil.getString()));
    			break;
    		default:
    			System.out.println("Execution Successful\n");
    			break;
    		}
    	}
    	while(id<8);
     }
}
