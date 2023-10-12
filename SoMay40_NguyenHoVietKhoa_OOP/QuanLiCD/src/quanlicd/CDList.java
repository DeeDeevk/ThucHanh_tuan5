package quanlicd;

public class CDList {
	private CD[] list;
	int count = 0;

	public CDList(int n) {
		list = new CD[n];
		count = 0;
	}

	public boolean add(CD cd) throws Exception {
		if (count < list.length) {
			for (int i = 1; i < count; i++) {
				if (list[i].getMaCD() == list[i - 1].getMaCD()) {
					throw new Exception("Ma CD Trung!!!");
				}
			}
			list[count++] = cd;
			return true;
		} else {
			throw new Exception("Mang day!!!");
		}
	}

	public int tinhSoLuongCDTrongList() {
		int soluong = 0;
		for (int i = 0; i < count; i++) {
			soluong++;
		}
		return soluong;
	}

	public double tinhTongGiaThanh() {
		double sum = 0;
		for (int i = 0; i < count; i++) {
			sum += list[i].getGiaThanh();
		}
		return sum;
	}

	public static String getTieuDe() {
		return String.format("%-10s %-20s %-10s %-10s", "Ma CD", "Tua CD", "So bai hat", "Gia thanh");
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < count; i++) {
			s += list[i].toString() + "\n";
		}
		return s;
	}

	public CD timKiemTheoMa(int ma) {
		for (int i = 0; i < count; i++) {
			if (list[i].getMaCD() == ma) {
				return list[i];
			}
		}
		return null;
	}

	public void sapXepGiamDanTheoGia() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count - 1; j++) {
				if (list[i].getGiaThanh() < list[j].getGiaThanh()) {
					CD temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}

	public void sapXepTangDanTheoTua() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count; j++) {
				if (list[i].getTuaCD().compareToIgnoreCase(list[j].getTuaCD()) > 0) {
					CD temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
}
