package code1202;

public class CommodityInfoBean {
	private String name;

	private Float price;

	private String status;



	public String getName() {

		return name;

	}



	public void setName(String name) {

		this.name = name;

	}



	public Float getPrice() {

		return price;

	}



	public void setPrice(Float price) {

		this.price = price;

	}



	public String getStatus() {

		return status;

	}



	public void setStatus(String status) {

		this.status = status;

	}



	public CommodityInfoBean() {

		this.name = "惠普笔记本电脑CQ515";

		this.price = 2950.0f;

		this.status = "在售";

	}


}
