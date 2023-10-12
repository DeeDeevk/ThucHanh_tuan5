package quanlicd;

public class CD {
	private int maCD;
	private String tuaCD;
	private int soBaiHat;
	private double giaThanh;

	public CD() {
		super();
	}

	public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) throws Exception {
		super();
		setMaCD(maCD);
		setTuaCD(tuaCD);
		setSoBaiHat(soBaiHat);
		setGiaThanh(giaThanh);
	}

	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		if (maCD > 0) {
			this.maCD = maCD;
		} else {
			this.maCD = 999999;
		}

	}

	public String getTuaCD() {
		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		if (!tuaCD.trim().equalsIgnoreCase("")) {
			this.tuaCD = tuaCD;
		} else {
			this.tuaCD = "chua xac dinh";
		}

	}

	public int getSoBaiHat() {
		return soBaiHat;
	}

	public void setSoBaiHat(int soBaiHat) {
		if (soBaiHat > 0) {
			this.soBaiHat = soBaiHat;
		} else {
			this.soBaiHat = 0;
		}
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(double giaThanh) {
		if (giaThanh > 0) {
			this.giaThanh = giaThanh;
		} else {
			this.giaThanh = 0;
		}
	}

	@Override
	public String toString() {
		return String.format("%-10d %-20s %-10d %-10.2f", maCD, tuaCD, soBaiHat, giaThanh);
	}
}
