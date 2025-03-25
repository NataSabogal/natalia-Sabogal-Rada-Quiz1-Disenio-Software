package DTO;

public class MotorcycleDTO {
	private int id;
	private String marca;
	private int cilindraje;
	private double precio;
	private String color;

	public MotorcycleDTO(int id, String marca, int cilindraje, double precio, String color) {
		this.id = id;
		this.marca = marca;
		this.cilindraje = cilindraje;
		this.precio = precio;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setBrand(String brand) {
		this.marca = brand;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setDisplacement(int displacement) {
		this.cilindraje = displacement;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrice(double price) {
		this.precio = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
