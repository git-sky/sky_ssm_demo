package cn.com.sky.spring.beanfactory.programmatic;

public class Account {

	private String cardNo;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	@Override
	public String toString() {
		return "Account [cardNo=" + cardNo + "]";
	}

}
