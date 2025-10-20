package pertsona;

public class Pertsona {
		
		private String izena, abizena1, abizena2,lanbidea;
		private int adina,NAN;

		public Pertsona(String izena, String abizena1, String abizena2, String lanbidea, int adina, int NAN) {
			
			this.izena= izena;
			this.abizena1= abizena1;
			this.abizena2= abizena2;
			this.lanbidea= lanbidea;
			this.adina= adina;
			this.NAN= NAN;
		}
		public Pertsona(String izena, String abizena1, String abizena2, int adina) {
			this.izena= izena;
			this.abizena1= abizena1;
			this.abizena2= abizena2;
			this.adina= adina;
			
		}
		
		public void inprimatu() {
			System.out.println("Izena: "+this.izena);
			System.out.println("Lehenengo Abizena: "+this.abizena1);
			System.out.println("Bigarren Abizena: "+this.abizena2);
			System.out.println("Lanbidea: "+this.lanbidea);
			System.out.println("Adina: "+this.adina);
			System.out.println("NAN zenbakia: "+this.NAN);
		}
		
		//Adina konparatu
		public boolean bainoZaharragoaDa (Pertsona pertsona) {
			boolean zaharragoaDa = false;
			
			if(this.adina>pertsona.adina) {
				zaharragoaDa = true;
			}
			
			return zaharragoaDa;
		}
		
		//Izenaren konparaketa
		public boolean izenBerdina (Pertsona pertsona) {
			boolean berdinaDa = false;
			
			if(this.izena.equals(pertsona.izena)) {
				berdinaDa = true;
			}
			
			return berdinaDa;
		}
		
		//Abizenen konparaketa
		public boolean abizenBerdina (Pertsona pertsona) {
			boolean abizenBerdinaDu = false;
			
			if(this.abizena1.equals(pertsona.abizena1) || this.abizena1.equals(pertsona.abizena2) || this.abizena2.equals(pertsona.abizena2) || this.abizena2.equals(pertsona.abizena1)) {
				abizenBerdinaDu = true;
			}
			
			return abizenBerdinaDu;
		}
		
		//Jubilatuta konparaketa
		public boolean jubilatuDa (Pertsona pertsona) {
			boolean jubitautaDago = false;
			
			if(this.adina>67 || pertsona.adina>67) {
				this.lanbidea = "Jubilatuta";
				jubitautaDago = true;
			}
			
			return jubitautaDago;
		}
		
		//Adingabea den edo ez jakiteko
		public boolean adingabeaDa (Pertsona pertsona) {
			boolean adingabea=false;
			if(this.adina>=18 || pertsona.adina>=18) {
				adingabea=true;
			}
			return adingabea;
			
		}
		
		
		@Override
		public String toString() {
			return "Pertsona [izena=" + izena + ", abizena1=" + abizena1 + ", abizena2=" + abizena2 + ", lanbidea="
					+ lanbidea + ", adina=" + adina + ", NAN=" + NAN + "]";
		}
		
		//Getters
		public Pertsona() {	
		}
		public String getIzena() {
			return izena;
		}
		public String getAbizena1() {
			return abizena1;
		}
		public String getAbizena2() {
			return abizena2;
		}
		public String getLanbidea() {
			return lanbidea;
		}
		public int getAdina() {
			return adina;
		}
		public int getNAN() {
			return NAN;
		}
		
	}
