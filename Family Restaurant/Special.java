
public class Special extends Regular{
	 private Double Discount;
	 private Double TotalPrice;
	 public Special(String code, String name, Double price,Double Discount,Double TotalPrice) {
		super(code, name, price);
		this.Discount = Discount;
		this.TotalPrice = TotalPrice;
	}

	 
	public Double getDiscount() {
		return Discount;
	}
	public void setDiscount(Double discount) {
		Discount = discount;
	}
	public Double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		TotalPrice = totalPrice;
	}


	


}
