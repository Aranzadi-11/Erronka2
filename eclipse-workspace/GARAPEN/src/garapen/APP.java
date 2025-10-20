package garapen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class APP {
    private static List<Equipo> equipos = new ArrayList<>();
    private static List<Partido> partidos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        equipos.add(new Equipo("Equipo A"));
        equipos.add(new Equipo("Equipo B"));
        equipos.add(new Equipo("Equipo C"));
        equipos.add(new Equipo("Equipo D"));
        equipos.add(new Equipo("Equipo E"));
        equipos.add(new Equipo("Equipo F"));

        while (true) {
            System.out.println("1. Agregar partido");
            System.out.println("2. Introducir resultado");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarPartido();
                    break;
                case 2:
                    introducirResultado();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void agregarPartido() {
        if (equipos.size() < 2) {
            System.out.println("No hay suficientes equipos para un partido.");
            return;
        }
        int indice1 = 0;
        int indice2 = 1;

        Partido partido = new Partido(new Date(), equipos.get(indice1), equipos.get(indice2));
        partidos.add(partido);
        System.out.println("Partido agregado: " + equipos.get(indice1).getNombre() + " vs " + equipos.get(indice2).getNombre());
    }

    private static void introducirResultado() {
        if (partidos.isEmpty()) {
            System.out.println("No hay partidos registrados.");
            return;
        }
        
        System.out.println("Seleccione un partido:");
        for (int i = 0; i < partidos.size(); i++) {
            System.out.println(i + ". " + partidos.get(i).getResultado());
        }
        
        int indice = scanner.nextInt();
        scanner.nextLine();
        
        if (indice < 0 || indice >= partidos.size()) {
            System.out.println("Índice de partido no válido.");
            return;
        }
        
        Partido partido = partidos.get(indice);
        System.out.println("Ingrese goles para " + partido.getResultado().split(" ")[0] + ":");
        int golesEquipo1 = scanner.nextInt();
        
        System.out.println("Ingrese goles para " + partido.getResultado().split(" ")[3] + ":");
        int golesEquipo2 = scanner.nextInt();

        partido.setResultado(golesEquipo1, golesEquipo2);
        System.out.println("Resultado actualizado: " + partido.getResultado());
    }
}
