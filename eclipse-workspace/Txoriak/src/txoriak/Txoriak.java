package txoriak;

import java.util.Objects;

public class Txoriak {

	String izena;
	double x,y;
	
	//Sortzaile bat parametro guztiekin.
	public Txoriak(String izena, double x, double y) {
		this.izena = izena;
		this.x = x;
		this.y = y;
	}

	//Sortzaile bat izena datuekin eta x eta y defektuz 0 dira.
	public Txoriak (String izena) {
		this.izena = izena;
		this.x = 0;
		this.y = 0;
	}	
	
	//Sortzaile bat datu guztiak hutsik.
	public Txoriak() {}

	//GET eta SETTERS
	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Txoriak [izena=" + izena + ", x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(izena, x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Txoriak other = (Txoriak) obj;
		return Objects.equals(izena, other.izena) && Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}

}
