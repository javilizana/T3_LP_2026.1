package Mapa;
import Entidades.Enemigo;
import Entidades.Jugador;
import Componentes.Materia;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Gongaga extends Zona {
    private List<Materia> poolMaterias = new ArrayList<>();

    /* Genera aleatoriamente un grupo de 1 a 3 enemigos salvajes
       cuando ocurre una emboscada en Gongaga. Probabilidades:
       60% un enemigo, 30% dos enemigos, 10% tres enemigos. Los
       enemigos generados pueden ser de tipos distintos.
       Retorna: lista con los enemigos generados para el combate. */
    public List<Enemigo> generarGrupoEnemigo() {
        return new ArrayList<>(); // Retorna lista vacia para compilar
    }

    /* Ejecuta la accion de exploracion en Gongaga. Evento aleatorio:
       30% encontrar una Materia con elemento aleatorio (FUEGO, HIELO,
       RAYO o CURA) que se añade a la mochila, o 70% sufrir una
       emboscada de 1 a 3 EnemigoSalvaje.
       Parametros:
         cloud   - jugador que explora la zona
         scanner - lector de entrada para las acciones en combate */
    @Override
    public void accionZona(Jugador cloud, Scanner scanner) {
    }

    /* Valida el acceso a Gongaga. Exige que Cloud sea al menos
       de Nivel 5.
       Parametro: cloud - jugador a evaluar.
       Retorna: true si nivel >= 5, false en caso contrario. */
    @Override
    public boolean validarAcceso(Jugador cloud) {
        return cloud.getNivel() >= 5;
    }


    public List<Materia> getPoolMaterias() { return poolMaterias; }
}