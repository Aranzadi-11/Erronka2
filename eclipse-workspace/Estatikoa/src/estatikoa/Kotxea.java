package estatikoa;

public class Kotxea {
	
	private String kolorea;
	private final static int GURPIL_KOPURUA = 4;
	private static int kotxeKopurua=0;
	private static String MARKA="Mercedes";
	
	public Kotxea() {
		this.kolorea="Txuria";
		kotxeKopurua++;
	}
	public Kotxea(String kolorea) {
		this.kolorea=kolorea;
		kotxeKopurua++;
	}
	
	/**
	 * @return the kotxeKopurua
	 */
	public static int getKotxeKopurua() {
		return kotxeKopurua;
	}
	
	public void inprimatuInformazioa() {
		System.out.println("Kotxe honen kolorea " +this.kolorea+ " da.");
		System.out.println("Orain arte egindako kotxe kopurua: "+ Kotxea.getKotxeKopurua());
		System.out.println("Kotxe honen gurpil kopurua: " +Kotxea.GURPIL_KOPURUA);
	}
	
}
