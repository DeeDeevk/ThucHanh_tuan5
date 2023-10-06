package hanghoa;

import java.util.Arrays;
import java.util.Comparator;

public class DanhSachHangHoa {
	private HangHoa[] danhSach;
	int count = 0;
	
	public DanhSachHangHoa(int n) {
		danhSach = new HangHoa[n];
		count = 0;
	}
	
	public void them(HangHoa hh) throws Exception {
		for(int i = 0; i < count; i++) {
			if(danhSach[i].getMaHang().equalsIgnoreCase(hh.getMaHang())) {
				throw new Exception("Ma hang " + hh.getMaHang() + " da co!!!");
			}
		}
		danhSach[count++] = hh;
	}
	
	@Override
	public String toString() {
		String s = String.format("%-10s %-20s %-15s %-15s %-15s\n", "Ma Hang", "Ten Hang", "Don Gia", "So Luong Ton", "LoaiHang");
		for(int i = 0; i < count; i++) {
			if(danhSach[i] instanceof HangThucPham) {
				s += String.format("%-10s %-20s %-15.2f %-15.2f %-15s\n", danhSach[i].getMaHang(), danhSach[i].getTenHang(), danhSach[i].getDonGia(), danhSach[i].getSoLuongTon(), "Hang Thuc Pham");
			}
			else if(danhSach[i] instanceof HangDienMay) {
				s += String.format("%-10s %-20s %-15.2f %-15.2f %-15s\n", danhSach[i].getMaHang(), danhSach[i].getTenHang(), danhSach[i].getDonGia(), danhSach[i].getSoLuongTon(), "Hang Dien May");
			}
			else {
				s += String.format("%-10s %-20s %-15.2f %-15.2f %-15s\n", danhSach[i].getMaHang(), danhSach[i].getTenHang(), danhSach[i].getDonGia(), danhSach[i].getSoLuongTon(), "Hang Sanh Su");
			}
		}
		return s;
	}
	
	public void getHangThucPham() {
		System.out.println(HangHoa.tieuDe());
		for(int i = 0; i < count; i++) {
			if(danhSach[i] instanceof HangThucPham) {
				System.out.println(danhSach[i].toString());
			}
		}
	}
	
	public void getHangDienMay() {
		System.out.println(HangHoa.tieuDe());
		for(int i = 0; i < count; i++) {
			if(danhSach[i] instanceof HangDienMay) {
				System.out.println(danhSach[i].toString());
			}
		}
	}
	
	public void getHangSanhSu() {
		System.out.println(HangHoa.tieuDe());
		for(int i = 0; i < count; i++) {
			if(danhSach[i] instanceof HangSanhSu) {
				System.out.println(danhSach[i].toString());
			}
		}
	}
	
	public HangHoa timKiemTheoMaHang(String ma) {
		for(int i = 0; i < count; i++) {
			if(danhSach[i].getMaHang().equalsIgnoreCase(ma)) {
				return danhSach[i];
			}
		}
		return null;
	}
	
	public void sapXepTangTheoTenHang() {
		Arrays.sort(danhSach, new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				// TODO Auto-generated method stub
				if(o1 != null && o2 != null) {
					if(o1.getTenHang().compareTo(o2.getTenHang()) > 0) {
						return 1;
					}
					else if(o1.getTenHang().compareTo(o2.getTenHang()) < 0) {
						return -1;
					}
				}
				return 0;
			}
		});
	}
	
	public void sapXepGiamTheoSoLuongTon() {
		Arrays.sort(danhSach, new Comparator<HangHoa>() {

			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				if(o1 != null && o2 != null) {
					if(o1.getSoLuongTon() < o2.getSoLuongTon()) {
						return 1;
					}
					else if(o1.getSoLuongTon() > o2.getSoLuongTon()) {
						return -1;
					}
				}
				return 0;
			}
		});
	}
	
	public boolean xoa(String maHang) {
		HangHoa hh = timKiemTheoMaHang(maHang);
		if(hh == null) {
			return false;
		}
		HangHoa[] temp = new HangHoa[count -1];
		int j = 0;
		for(int i = 0; i < count; i++) {
			if(!danhSach[i].getMaHang().equalsIgnoreCase(maHang)) {
				temp[j] = danhSach[i];
				j++;
			}
		}
		danhSach = temp;
		count--;
		return true;
	}
	
	public void layThongTinHangThucPhamKhoBan() {
		System.out.println(HangHoa.tieuDe());
		for(int i = 0; i < count; i++) {
			if(danhSach[i] instanceof HangThucPham) {
				if(danhSach[i].danhGia().equalsIgnoreCase("kho ban")) {
					System.out.println(danhSach[i]);
				}
			}
		}
	}
	
	public boolean suaThongTinDonGia(String maHang, double newDonGia) {
		for(int i = 0; i < count; i++) {
			if(danhSach[i].getMaHang().equalsIgnoreCase(maHang)) {
				danhSach[i].setDonGia(newDonGia);
				return true;
			}
		}
		return false;
	}
}
