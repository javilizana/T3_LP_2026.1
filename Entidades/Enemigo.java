package Entidades;
import Componentes.Estadisticas;

public abstract class Enemigo {
    protected String nombre;
    protected int xpRecompensa;
    protected int chatarraRecompensa;
    protected Estadisticas stats;

    //Método abstracto para que el enemigo ataque a Cloud
    public abstract void atacar(Jugador cloud);


    //Método abstracto para dar la recompensa al morir
    public abstract void giveXpRecompensa(Jugador cloud);

    public String getNombre() { return nombre; }
    public Estadisticas getStats() { return stats; }
}