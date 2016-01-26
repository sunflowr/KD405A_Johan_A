public class House {
	private int yearBuilt;
	private int size; // Unit is kvm.
	private final int minSize = 10;

	public House(int yearBuilt, int size) {
		// Clamp size between minSize and 1000 kvm.
		if(size < minSize) {
			this.size = minSize;
		} else if(size > 1000) {
			this.size = 1000;
		} else {
			this.size = size;
		}

		// Clamp yearBuilt between the years 1800 and 2015.
		if(yearBuilt < 1800) {
			this.yearBuilt = 1800;
		} else if(yearBuilt > 2015) {
			this.yearBuilt = 2015;
		} else {
			this.yearBuilt = yearBuilt;
		}
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public int getSize() {
		return size;
	}
}
