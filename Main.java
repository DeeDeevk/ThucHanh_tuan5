package hanghoa;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int luaChon;
			DanhSachHangHoa ds = new DanhSachHangHoa(6);
			ds.them(new HangThucPham("HTP1", "Banh mi", 4500, 10, "Khong biet ten", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 4)));
			ds.them(new HangDienMay("HDM1", "May lanh", 1000000, 51, 10, 100));
			ds.them(new HangSanhSu("HSS1", "Binh su", 500000, 20, "Khong biet nua", LocalDate.of(2023, 9, 30)));
			ds.them(new HangThucPham("HTP2", "Banh cuon", 20000, 5, "Chiu", LocalDate.of(2023, 10, 2), LocalDate.of(2023, 10, 10)));
			ds.them(new HangDienMay("HDM2", "May giat", 3000000, 15, 12, 200));
			ds.them(new HangSanhSu("HSS2", "Chen su", 17, 13, "Nhu tren", LocalDate.of(2023, 5, 10)));
			
			do {
				System.out.println("==========================MENU====================");
				System.out.println("**   1. Lay thong tin toan bo                   **");
				System.out.println("**   2. Lay thong tin tung loai hang hoa        **");
				System.out.println("**   3. Tim kiem theo ma hang hoa               **");
				System.out.println("**   4. Sap xep hang hoa theo ten hang tang dan **");
				System.out.println("**   5. Sap xep hang hoa theo so luong ton giam **");
				System.out.println("**   6. Xoa thong hang hoa khi biet ma hang     **");
				System.out.println("**   7. Sua thong tin don gia theo ma hang      **");
				System.out.println("**   8. Lay thong tin hang thuc pham kho ban    **");
				System.out.println("==================================================");
				System.out.println("Vui long chon: ");
				luaChon = sc.nextInt();
				switch(luaChon) {
					case 1:{
						System.out.println(ds);
						break;
					}
					case 2:{
						System.out.println("1. Hang thuc pham");
						System.out.println("2. Hang dien may");
						System.out.println("3. Hang sanh su");
						System.out.println("Vui long chon: ");
						int chon = sc.nextInt();
						switch(chon) {
							case 1:{
								ds.getHangThucPham();
								break;
							}
							case 2:{
								ds.getHangDienMay();
								break;
							}
							case 3:{
								ds.getHangSanhSu();
								break;
							}
							default:{
								System.out.println("Khong tim thay!!!");
								break;
							}
						}
						break;
					}
					case 3:{
						System.out.println("Nhap vao ma hang hoa can tim: ");
						sc.nextLine();
						String k = sc.nextLine();
						System.out.println(HangHoa.tieuDe());
						System.out.println(ds.timKiemTheoMaHang(k));
						break;
					}
					case 4:{
						ds.sapXepTangTheoTenHang();
						System.out.println("Sap xep thanh cong!!!");
						break;
					}
					case 5:{
						ds.sapXepGiamTheoSoLuongTon();
						System.out.println("Sap xep thanh cong!!!");
						break;
					}
					case 6:{
						System.out.println("Nhap vao ma hang hoa can xoa: ");
						sc.nextLine();
						String maCanXoa = sc.nextLine();
						ds.xoa(maCanXoa);
						System.out.println("Xoa thanh cong!!");
						break;
					}
					case 7:{
						System.out.println("Nhap vao ma hang hoa can sua: ");
						sc.nextLine();
						String maCanSua = sc.nextLine();
						System.out.println("Nhap vao gia tri can sua: ");
						double newDonGia = sc.nextDouble();
						ds.suaThongTinDonGia(maCanSua, newDonGia);
						System.out.println("Sua thanh cong!!!");
						break;
					}
					case 8:{
						ds.layThongTinHangThucPhamKhoBan();
						break;
					}
					default:{
						System.out.println("Thoat!!!");
						break;
					}
				}
			}while(luaChon != 0);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
