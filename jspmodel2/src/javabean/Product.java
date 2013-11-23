package javabean;
/**
 * 商品
 * @author liuji
 *
 */
public class Product {
	/**
	 * 商品序号
	 */
	private String id;
	/**
	 * 商品名称
	 */
	private String name;
	/**
	 * 商品价格
	 */
	private Double price;
	/**
	 * 商品简介
	 */
	private String des;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Product(String id, String name, Double price, String des) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.des = des;
	}
	
}
