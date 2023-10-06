package hanghoa;

import java.time.LocalDate;

public class HangThucPham extends HangHoa {
	private String nhaCungCap;
	private LocalDate ngaySanXuat, ngayHetHan;
	
	public HangThucPham() {
		super();
	}
	
	public HangThucPham(String maHang, String tenHang, double donGia, double soLuongTon, String nhaCungCap,
			LocalDate ngaySanXuat, LocalDate ngayHetHan) throws Exception {
		super(maHang, tenHang, donGia, soLuongTon);
		setNhaCungCap(nhaCungCap);
		setNgaySanXuat(ngaySanXuat);
		setNgayHetHan(ngayHetHan);
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if(ngaySanXuat.isBefore(LocalDate.now())) {
			this.ngaySanXuat = ngaySanXuat;
		}
		else {
			this.ngaySanXuat = LocalDate.now();
		}
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if(ngayHetHan.isAfter(ngaySanXuat)) {
			this.ngayHetHan = ngayHetHan;
		}
		else {
			this.ngayHetHan = LocalDate.now();
		}
	}

	@Override
	public double thueVAT() {
		return 0.05 * getDonGia();
	}
	
	public boolean hetHan() {
		if(ngayHetHan.isBefore(LocalDate.now())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String danhGia() {
		return (getSoLuongTon() > 0 && hetHan()) ? "kho ban" : "da ban het";
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" %-10.2f %-10s %-20s", thueVAT(), danhGia(), "Hang Thuc Pham");
	}
}
