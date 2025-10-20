package klasekoariketak;

public class Kotxea {

	// Ezaugarriak
	private String marka;
	private String modeloa;
	private int urtea;

	// Sortzaileak (Constructores)
	public Kotxea(String pasatakoMarka, String pasatakoModeloa, int urtea) {
		this.marka = pasatakoMarka;
		this.modeloa = pasatakoModeloa;
		this.urtea = urtea;
	}
	
	public Kotxea(String marka, String modeloa) {
		this.marka = marka;
		this.modeloa = modeloa;
	}

	public Kotxea() {}
	
	//Ekintza
	public void martxanjarri() {		
		System.out.println(marka+" "+modeloa+" "+urtea+" kotxea martxan jarri da.");
	}
	public void gelditu() {		
		System.out.println(marka+" "+modeloa+" "+urtea+" kotxea gelditu da.");
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModeloa() {
		return modeloa;
	}

	public void setModeloa(String modeloa) {
		this.modeloa = modeloa;
	}

	public int getUrtea() {
		return urtea;
	}

	public void setUrtea(int urtea) {
		this.urtea = urtea;
	}
	
	public String toString() {
		return "Kotxea [marka=" + marka + ", modeloa=" + modeloa + ", urtea=" + urtea + "]";
	}
}
