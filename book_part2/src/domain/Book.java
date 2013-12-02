package domain;
/**
 * 书籍
 * @author liuji
 *
 */
public class Book {
	/**
	 * 编号
	 */
	public String id;
	/**
	 * 名称
	 */
	public String name;
	/**
	 * 价格
	 */
	public double price;
	/**
	 * 描述
	 */
	public String des;
	/**
	 * 图片位置
	 */
	public String image;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
