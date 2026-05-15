package Entidades;
import Componentes.Elemento;
import Componentes.Vulnerable;
import java.util.List;
import java.util.ArrayList;

public class EnemigoSalvaje extends Enemigo implements Vulnerable {
    private List<Elemento> debilidades = new ArrayList<>();
    private List<Elemento> resistencias = new ArrayList<>();
    private List<Elemento> inmunidades = new ArrayList<>();

    /* Entrega la recompensa de chatarra a Cloud al vencer a este
       enemigo. Los enemigos salvajes sueltan entre 50 y 75 de chatarra.
       Parametro: cloud - jugador que recibira la chatarra. */
    public void giveChatarraRecompensa(Jugador cloud) {
    }

    /* Evalua el multiplicador de daño elemental segun las afinidades
       de este enemigo. Retorna 2.0 si el elemento es debilidad, 0.5
       si es resistencia, 0.0 si es inmunidad, o 1.0 (neutro) en caso
       contrario.
       Parametro: elementoMagia - elemento del ataque recibido.
       Retorna: multiplicador de daño como double. */
    @Override
    public double evaluarDebilidad(Elemento elementoMagia) {
        return 1.0; 
    }

    /* Ataca a Cloud aplicando daño fisico con la formula
       floor(Fuerza * 1.25) y un 85% de probabilidad de acierto.
       Parametro: cloud - jugador que recibe el ataque. */
    @Override
    public void atacar(Jugador cloud) {
    }

    /* Entrega la recompensa de XP (entre 80 y 100) a Cloud al ser
       derrotado este enemigo salvaje.
       Parametro: cloud - jugador que recibe la XP. */
    @Override
    public void giveXpRecompensa(Jugador cloud) {
    }

    public List<Elemento> getDebilidades() { return debilidades; }
    public List<Elemento> getResistencias() { return resistencias; }
    public List<Elemento> getInmunidades() { return inmunidades; }
}