package quanlicd;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			CDList ds = new CDList(3);
			ds.add(new CD(1, "toi yeu em", 10, 10000));
			ds.add(new CD(2, "Buoc qua mua ha", 5, 20000));
			ds.add(new CD(3, "Anh khong yeu em", 15, 5000));
			int luaChon;
			do {
				System.out.println("=============================MENU=========================");
				System.out.println("**       1. Xuat danh sach CD                           **");
				System.out.println("**       2. Tinh so luong CD trong danh sach            **");
				System.out.println("**       3. Tinh tong gia thanh cua cac CD              **");
				System.out.println("**       4. Tim kiem CD theo ma CD                      **");
				System.out.println("**       5. Sap xep danh sach giam dan theo gia thanh   **");
				System.out.println("**       6. Sap xep danh sach tang dan theo tua CD      **");
				System.out.println("**       0. Thoat chuong trinh                          **");
				System.out.println("==========================================================");
				System.out.println("Vui long chon");
				luaChon = sc.nextInt();
				switch (luaChon) {
				case 1: {
					System.out.println(ds.getTieuDe());
					System.out.println(ds);
					break;
				}
				case 2: {
					System.out.println("So luong CD trong danh sach: " + ds.tinhSoLuongCDTrongList());
					break;
				}
				case 3: {
					System.out.println("Tong gia thanh: " + ds.tinhTongGiaThanh());
					break;
				}
				case 4: {
					System.out.println("Nhap vao ma can tim: ");
					int maCanTim = sc.nextInt();
					System.out.println(ds.getTieuDe());
					System.out.println(ds.timKiemTheoMa(maCanTim).toString());
					break;
				}
				case 5: {
					ds.sapXepGiamDanTheoGia();
					System.out.println("Sap xep thanh cong, Vui long chon chuc nang 1 de xem ket qua!!!");
					break;
				}
				case 6: {
					ds.sapXepTangDanTheoTua();
					System.out.println("Sap xep thanh cong, Vui long chon chuc nang 1 de xem ket qua!!!");
					break;
				}
				case 0: {
					System.out.println("Da thoat chuong trinh!!!");
					break;
				}
				}
			} while (luaChon != 0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
