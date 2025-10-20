package klasekoariketak;

public class AppIkaslea {
	
	public static void main(String[] args) {
		
		Ikaslea ikasle0=new Ikaslea
	("N´","Zézé","GOAT@onlyfans.com",15,"674795865");
		
		Ikaslea ikasle1 = new Ikaslea();
		ikasle1.setIzena("Beñat");
		ikasle1.setAbizena("Perez");
		ikasle1.setAdina(25);
		
		Ikaslea ikasle2 = new Ikaslea("Juanjo","Perez",69);
		
		Ikaslea ikasle3 = new Ikaslea("Beñat","Perez",25);
		
		
		ikasle0.inprimitu();
		System.out.println(ikasle0.toString());
		System.out.println(ikasle0.getIzena()+" "+ikasle0.getAbizena()+" Adin nagusia: "+ikasle0.adinNagusia());
		System.out.println(ikasle0.hashCode());
		
		ikasle1.inprimitu();
		System.out.println(ikasle1.toString());
		System.out.println(ikasle1.getIzena()+" "+ikasle1.getAbizena()+" adin nagusia: "+ikasle1.adinNagusia());
		System.out.println(ikasle1.hashCode());
		if (ikasle1.equals(ikasle3)) {
			System.out.println("Ikasle berdina da!");
		}else {
			System.out.println("Ikasle ezberdina da!");
		}
		
		ikasle2.inprimitu();
		System.out.println(ikasle2.toString());
		System.out.println(ikasle2.getIzena()+" "+ikasle2.getAbizena()+" Adin nagusia: "+ikasle2.adinNagusia());
		System.out.println(ikasle2.hashCode());
		
		ikasle3.inprimitu();
		System.out.println(ikasle3.toString());
		System.out.println(ikasle3.getIzena()+" "+ikasle3.getAbizena()+" Adin nagusia: "+ikasle3.adinNagusia());
		System.out.println(ikasle3.hashCode());
		System.out.println("ikasle2 eta ikasle3 berdinak dira: "+ikasle2.equals(ikasle3));
	}
}
