package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.BookDao;
import domain.Book;

@WebServlet("/book")
@MultipartConfig(location = "/Users/liuji/upload/", maxFileSize = 8388608, fileSizeThreshold = 819200)
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookServlet() {
		super();
	}

	private static final String imageDir = "/Users/liuji/upload/";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		try {
			switch (op) {
			case "add":
				// url=/book?op=add
				showAddBookForm(request, response);
				break;
			case "list":
				// url=/book?op=list
				listBooks(request, response);
				break;
			case "view":
				// url=/book?op=view
				viewBook(request, response);
				break;
			case "edit":
				// url=/book?op=edit
				showEditBookForm(request, response);
				break;
			case "delete":
				// url=/book?op=delete
				doDeleteBook(request, response);
				break;
			case "image":
				// url=/book?op=image
				showImage(request, response);
				break;
			case "exist":
				// url=/book?op=exist
				checkExist(request,response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
			//e.printStackTrace(response.getWriter());

		}

	}

	private void checkExist(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		String id=request.getParameter("id");
		Book book=BookDao.get(id);
		PrintWriter out=response.getWriter();
		if(book==null)
			out.println(0);
		else
			out.println(1);
		
	}

	private void showImage(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Book book = BookDao.get(id);
		File file = new File(imageDir, book.image);
		InputStream in = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		copy(in, out);

	}

	private void copy(InputStream in, OutputStream out) throws IOException {
		byte[] bytes = new byte[1024];
		int len = 0;
		while ((len = in.read(bytes)) > 0)
			out.write(bytes, 0, len);
		out.close();
		in.close();
	}

	private void doDeleteBook(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Book book = BookDao.get(id);
		File file = new File(imageDir, book.image);
		file.delete();
		BookDao.delete(id);
		response.sendRedirect("book?op=list");

	}

	private void showEditBookForm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Book book = BookDao.get(id);
		request.setAttribute("book", book);
		RequestDispatcher rd = request
				.getRequestDispatcher("/WEB-INF/edit.jsp");
		rd.forward(request, response);

	}

	private void viewBook(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		Book book = BookDao.get(id);
		request.setAttribute("book", book);
		RequestDispatcher rd = request
				.getRequestDispatcher("/WEB-INF/view.jsp");
		rd.forward(request, response);

	}

	private void listBooks(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Book> books = BookDao.getAll();
		request.setAttribute("books", books);
		RequestDispatcher rd = request
				.getRequestDispatcher("/WEB-INF/list.jsp");
		rd.forward(request, response);
	}

	private void showAddBookForm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/add.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		try {
			switch (op) {
			case "doAdd":
				// url=/book?op=doAdd
				doAddBook(request, response);
				break;
			case "doEdit":
				// url=/book?op=doEdit
				doEditBook(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void doEditBook(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Book book = new Book();
		book.id = request.getParameter("id");
		book.name = request.getParameter("name");
		book.price = Double.valueOf(request.getParameter("price"));
		book.des = request.getParameter("des");
		String oldId = request.getParameter("oldId");
		Book oldBook = BookDao.get(oldId);
		String fileName = oldBook.image;
		book.image = fileName;
		BookDao.update(book, oldId);
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part.getName().equals("image")) {
				// 文件保存到 /Users/liuji/upload/{book.id+System.nanoTime()}
				part.write(fileName);
				break;
			}
		}
		response.sendRedirect("book?op=list");
	}

	private void doAddBook(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Book book = new Book();
		book.id = request.getParameter("id");
		book.name = request.getParameter("name");
		book.price = Double.valueOf(request.getParameter("price"));
		book.des = request.getParameter("des");
		// book.id+System.nanoTime()使得文件名唯一
		String fileName = book.id + System.nanoTime();
		book.image = fileName;
		BookDao.add(book);
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			if (part.getName().equals("image")) {
				// 文件保存到 /Users/liuji/upload/{book.id+System.nanoTime()}
				part.write(fileName);
				break;
			}
		}
		response.sendRedirect("book?op=list");

	}
}
