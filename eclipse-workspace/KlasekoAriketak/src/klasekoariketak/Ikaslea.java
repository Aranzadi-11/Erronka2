package klasekoariketak;

import java.util.Objects;

public class Ikaslea {
	
	//Ezaugarriak
	private String izena;
	private String abizena;
	private String email;
	private int adina;
	private String telefonoa;
	
	//Sortzaileak
	public Ikaslea() {
	}
	
	public Ikaslea(String izena, String abizena, int adina) {
		this.izena = izena;
		this.abizena = abizena;
		this.adina = adina;
	}

	public Ikaslea(String izena, String abizena, String email, int adina, String telefonoa) {
		this.izena = izena;
		this.abizena = abizena;
		this.email = email;
		this.adina = adina;
		this.telefonoa = telefonoa;
	}
	
	// Adin nagusia da
	public boolean adinNagusia() {
		if (adina >= 18) {
			return true;
		} else {
			return false;
		}
	}
	
	//Get eta Set
	public void setIzena (String izena) {
		this.izena = izena;
	}
	
	public String getIzena () {
		return izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAdina() {
		return adina;
	}

	public void setAdina(int adina) {
		this.adina = adina;
	}

	public String getTelefonoa() {
		return telefonoa;
	}

	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}
	
	//To string
	public void inprimitu() {
		System.out.println("Hau da ikaslearen informazioa: \n Izena: "+izena+"\n Abizena: " +abizena+"\n emaila: "+email);
	}

	@Override
	public String toString() {
		return "Ikaslea [izena=" + izena + ", abizena=" + abizena + ", email=" + email + ", adina=" + adina
				+ ", telefonoa=" + telefonoa + "]";
	}

	//Hashcode eta equal
	public int hashCode() {
		return Objects.hash(abizena, adina, email, izena, telefonoa);
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ikaslea other = (Ikaslea) obj;
		return Objects.equals(abizena, other.abizena) && adina == other.adina && Objects.equals(email, other.email)
				&& Objects.equals(izena, other.izena) && Objects.equals(telefonoa, other.telefonoa);
	}

}
