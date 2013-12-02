import java.util.List;

import dao.BookDao;
import domain.Book;


public class Test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Book book1=new Book();
		book1.id="1";
		book1.name="C++ Primer";
		book1.price=100;
		book1.des="一本C++图书";
		book1.image="没有图片";
		//add book1 to database
		BookDao.add(book1);
		//add book2 to database
		Book book2=new Book();
		book2.id="2";
		book2.name="Java";
		book2.price=50;
		book2.des="一本Java图书";
		book2.image="没有图片";
		BookDao.add(book2);
		//get all bookes
		List<Book> books=BookDao.getAll();
		System.out.println("所有的书籍为：");
		for(Book book:books)
		{
			System.out.printf("id=%s,name=%s,price=%f,des=%s,image=%s\n", book.id,book.name,book.price,book.des,book.image);
		}
		//get book whose id is 1
		Book book=BookDao.get("1");
		System.out.printf("id=1的书籍为name=%s,price=%f,des=%s,image=%s\n", book.name,book.price,book.des,book.image);
		//update book
		book.price=10;
		BookDao.update(book, book.id);
		book=BookDao.get("1");
		System.out.printf("修改后id=1的书籍为name=%s,price=%f,des=%s,image=%s\n", book.name,book.price,book.des,book.image);
		//delete book whose id is 1
		BookDao.delete("1");
		//delete book whose id is 2
		BookDao.delete("2");

	}

}
