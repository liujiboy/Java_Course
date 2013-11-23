package javabean;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
	private List<Product> products=new ArrayList<Product>();
	public ProductList()
	{
		products.add(new Product("1","C++程序设计",20.0,"一本书"));
		products.add(new Product("2","Sony电视",10000.0,"一台电视机"));
		products.add(new Product("3","尼康相机",200000.0,"数码相机"));
	}
	public List<Product> getAllProducts()
	{
		return products;
	}
}
