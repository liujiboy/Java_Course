package servlet;

import java.io.IOException;
import java.util.List;

import javabean.Product;
import javabean.ProductList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/products") //servletӳ�䵽/products
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductList pList=new ProductList();
		List<Product> products=pList.getAllProducts();
		request.setAttribute("products", products);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/products.jsp");
		rd.forward(request, response);
	}

}
