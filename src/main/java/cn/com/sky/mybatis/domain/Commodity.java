package cn.com.sky.mybatis.domain;

public class Commodity {

	private int item_id;
	private String item_name;
	private double rebate_ratio;
	private int plan_id;
	private int shop_no;

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public double getRebate_ratio() {
		return rebate_ratio;
	}

	public void setRebate_ratio(double rebate_ratio) {
		this.rebate_ratio = rebate_ratio;
	}

	public int getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}

	public int getShop_no() {
		return shop_no;
	}

	public void setShop_no(int shop_no) {
		this.shop_no = shop_no;
	}

	@Override
	public String toString() {
		return item_id + "," + item_name + "," + rebate_ratio + "," + plan_id + "," + shop_no + "\r\n";
	}

}
