package garapen;

public class Sancion {
    private String jugador;
    private String comentario;
    private double multa;
    private int partidosDeSancion;

    public Sancion(String jugador, String comentario, double multa, int partidosDeSancion) {
        this.jugador = jugador;
        this.comentario = comentario;
        this.multa = multa;
        this.partidosDeSancion = partidosDeSancion;
    }
}
