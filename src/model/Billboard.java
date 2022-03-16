package model;

public class Billboard {
	
	private int width;
	private int heigth;
	private int area;
	private String brand;
	private boolean inUse;
	
	public Billboard(int width, int heigth, int area, String brand, boolean inUse) {
		super();
		this.width = width;
		this.heigth = heigth;
		this.area = area;
		this.brand = brand;
		this.inUse = inUse;
	}
	public int getWidth() {
		return width;
	}
	public int getHeigth() {
		return heigth;
	}
	public int getArea() {
		return area;
	}
	public String getBrand() {
		return brand;
	}
	public boolean isInUse() {
		return inUse;
	}
}
