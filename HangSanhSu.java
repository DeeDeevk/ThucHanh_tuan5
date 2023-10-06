package hanghoa;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class HangSanhSu extends HangHoa {
	private String nhaSanXuat;
	private LocalDate ngayNhapKho;
	
	public HangSanhSu(String maHang, String tenHang, double donGia, double soLuongTon, String nhaSanXuat,
			LocalDate ngayNhapKho) throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		setNhaSanXuat(nhaSanXuat);
		setNgayNhapKho(ngayNhapKho);
	}

	public String getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public LocalDate getNgayNhapKho() {
		return ngayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		if(ngayNhapKho.isBefore(LocalDate.now())) {
			this.ngayNhapKho = ngayNhapKho;
		}
		else {
			this.ngayNhapKho = LocalDate.now();
		}
	}

	@Override
	public double thueVAT() {
		return 0.1 * getDonGia();
	}

	public int thoiGianLuuKho() {
		return (int) ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
	}
	
	@Override
	public String danhGia() {
		return (getSoLuongTon() > 50 && thoiGianLuuKho() > 10) ? "ban cham" : "ban nhanh";
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" %-10.2f %-10s %-20s", thueVAT(), danhGia(), "Hang Sanh Su");
	}
	
}
