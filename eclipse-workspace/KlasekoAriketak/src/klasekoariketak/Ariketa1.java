package klasekoariketak;
import java.util.Scanner;

//Idatzi programa bat erabiltzailea agurtzen duena
public class Ariketa1{
public static void main(String[] args){
	//Hurrengo aginduan kontsolatik mezu bat inprimitu.
	String izena;//Sortzen dugu aldagaia izena gordetzeko.
	//izena = "Beñat"; 
	System.out.println("Sartu zure izena mesedez:");
	//sc izeneko Scanner bat sortu etra erabiltzailearen izena jasotzeko.
	   Scanner sc = new Scanner(System.in);
	    izena = sc.next(); //Itxaron erabiltzailea izena sartu harte hurrengo pausora jarraitzeko
  System.out.println("Kaixo "+izena+"!");
  }
}
