package hanghoa;

public abstract class HangHoa {
	private String maHang;
	private String tenHang;
	private double donGia;
	private double soLuongTon;
	
	public HangHoa() {
		
	}
	
	public HangHoa(String maHang, String tenHang, double donGia, double soLuongTon) throws Exception {
		super();
		setMaHang(maHang);
		setTenHang(tenHang);
		setDonGia(donGia);
		setSoLuongTon(soLuongTon);
	}

	public String getMaHang() {
		return maHang;
	}
	
	private void setMaHang(String maHang) throws Exception{
		if(!maHang.trim().equals("")) {
			this.maHang = maHang;
		}
		else {
			this.maHang = "0";
		}
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if(!tenHang.trim().equals("")){
			this.tenHang = tenHang;
		}
		else {
			this.tenHang = "xxx";
		}
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if(donGia > 0) {
			this.donGia = donGia;
		}
		else {
			this.donGia = 0;
		}
	}

	public double getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(double soLuongTon) {
		if(soLuongTon > 0) {
			this.soLuongTon = soLuongTon;
		}
		else {
			this.soLuongTon = 0;
		}
	}
	
	public static String tieuDe() {
		return String.format("%-10s %-20s %-10s %-15s %-10s %-10s %-15s", "Ma Hang", "Ten Hang", "Don Gia", "So Luong Ton", "Thue VAT", "Danh Gia", "Loai Hang");
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-20s %-10.2f %-15.2f", maHang, tenHang, donGia, soLuongTon);
	}
	
	public abstract double thueVAT();
	
	public abstract String danhGia();
}
