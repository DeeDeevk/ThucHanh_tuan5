package hanghoa;

public class HangDienMay extends HangHoa {
	private int thoiGianBaoHanh;
	private double congSuat;
	
	public HangDienMay(String maHang, String tenHang, double donGia, double soLuongTon, int thoiGianBaoHanh,
			double congSuat) throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		setThoiGianBaoHanh(thoiGianBaoHanh);
		setCongSuat(congSuat);
	}

	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}

	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		if(thoiGianBaoHanh > 0) {
			this.thoiGianBaoHanh = thoiGianBaoHanh;
		}
		else {
			this.thoiGianBaoHanh = 0;
		}
	}

	public double getCongSuat() {
		return congSuat;
	}

	public void setCongSuat(double congSuat) {
		if(congSuat > 0) {
			this.congSuat = congSuat;
		}
		else {
			this.congSuat = 0;
		}
	}

	@Override
	public double thueVAT() {
		return 0.1 * getDonGia();
	}

	@Override
	public String danhGia() {
		return (getSoLuongTon() < 3) ? "ban duoc" : "kho ban";
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" %-10.2f %-10s %-20s", thueVAT(), danhGia(), "Hang Dien May");
	}
}
