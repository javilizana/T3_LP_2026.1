package Mapa;
import Entidades.Jugador;
import Entidades.Enemigo;
import java.util.List;
import java.util.Scanner;

public abstract class Zona {
    protected String nombre;
    protected int nivelRequerido;
    protected List<Enemigo> enemigosDisponibles;

    //public abstract void accionZona(Jugador cloud); //REVISAR DSP
    public abstract void accionZona(Jugador cloud, Scanner scanner);
    public abstract boolean validarAcceso(Jugador cloud);
    
}