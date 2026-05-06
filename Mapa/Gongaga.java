package Mapa;
import Entidades.Enemigo;
import Entidades.Jugador;
import Componentes.Materia;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Gongaga extends Zona {
    private List<Materia> poolMaterias = new ArrayList<>();

    /* Genera aleatoriamente un grupo de 1 a 3 enemigos salvajes.
       Retorna una lista con los enemigos generados. */
    public List<Enemigo> generarGrupoEnemigo() {
        return new ArrayList<>(); // Retorna lista vacia para compilar
    }

    @Override
    public void accionZona(Jugador cloud, Scanner scanner) {
        // Logica a implementar (Exploracion y batallas aleatorias)
    }

    @Override
    public boolean validarAcceso(Jugador cloud) {
        return false; // Por defecto no deja entrar
    }


    //ELIMINAR DSP
    public List<Materia> getPoolMaterias() { return poolMaterias; }
}