package cn.scxh.carmangger.model;

public class Car {
	private int id;
	private String carNums;//车牌号
	private String carOwnner;//车主
	private String telePhone;//电话
	private String color;//颜色
	private String factory;//厂家
	private String remarks;//备注
	
	public Car() {
	}

	public Car(String carNum, String carOwnner, String telePhone,
			String color, String factory, String remarks) {
		this.carNums = carNum;
		this.carOwnner = carOwnner;
		this.telePhone = telePhone;
		this.color = color;
		this.factory = factory;
		this.remarks = remarks;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getCarNums() {
		return carNums;
	}

	public void setCarNums(String carNums) {
		this.carNums = carNums;
	}

	public String getCarOwnner() {
		return carOwnner;
	}

	public void setCarOwnner(String carOwnner) {
		this.carOwnner = carOwnner;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", carNum=" + carNums + ", carOwnner="
				+ carOwnner + ", telePhone=" + telePhone + ", color=" + color
				+ ", factory=" + factory + ", remarks=" + remarks + "]";
	}


	
}
