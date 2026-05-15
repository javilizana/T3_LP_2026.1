package Entidades;
import Componentes.Estadisticas;

public abstract class Enemigo {
    protected String nombre;
    protected int xpRecompensa;
    protected int chatarraRecompensa;
    protected Estadisticas stats;

    /* Metodo abstracto que define como cada subclase de enemigo
       ataca a Cloud. Cada tipo implementa su propia logica de daño
       y precision.
       Parametro: cloud - jugador que recibe el ataque. */
    public abstract void atacar(Jugador cloud);


    /* Metodo abstracto que entrega la recompensa de experiencia a
       Cloud al ser derrotado el enemigo. Cada subclase define el
       rango de XP que otorga.
       Parametro: cloud - jugador que recibira la XP. */
    public abstract void giveXpRecompensa(Jugador cloud);

    public String getNombre() { return nombre; }
    public Estadisticas getStats() { return stats; }
}