package Entidades;
import Componentes.Elemento;
import Componentes.Vulnerable;
import java.util.List;
import java.util.ArrayList;

public class EnemigoSalvaje extends Enemigo implements Vulnerable {
    private List<Elemento> debilidades = new ArrayList<>();
    private List<Elemento> resistencias = new ArrayList<>();
    private List<Elemento> inmunidades = new ArrayList<>();

    /* Otorga la chatarra correspondiente a Cloud al ser derrotado.
       Recibe al Jugador como parametro para sumarle la chatarra. */
    public void giveChatarraRecompensa(Jugador cloud) {
        // Logica a implementar
    }

    @Override
    public double evaluarDebilidad(Elemento elementoMagia) {
        // Retorna neutro (1.0) por defecto para que compile
        return 1.0; 
    }

    @Override
    public void atacar(Jugador cloud) {
        // Logica a implementar
    }

    @Override
    public void giveXpRecompensa(Jugador cloud) {
        // Logica a implementar
    }

    //ELIMINAR DSP
    public List<Elemento> getDebilidades() { return debilidades; }
    public List<Elemento> getResistencias() { return resistencias; }
    public List<Elemento> getInmunidades() { return inmunidades; }
}