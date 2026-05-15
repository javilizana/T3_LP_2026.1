package Mapa;
import java.util.Scanner;

import Entidades.Jugador;

public class NucleoPlaneta extends Zona {
    private int materiasMinimasRequeridas = 2;

    /* Inicia la batalla directa y definitiva contra Sephiroth.
       No se permite huir de este combate. La victoria termina
       el juego con un mensaje final.
       Parametro: cloud - jugador que enfrenta a Sephiroth. */
    public void iniciarCombate(Jugador cloud) {
    }

    /* Ejecuta la accion de la zona, que es iniciar directamente
       el combate contra Sephiroth (jefe final).
       Parametros:
         cloud   - jugador que entra al nucleo
         scanner - lector de entrada para las acciones en combate */
    @Override
    public void accionZona(Jugador cloud, Scanner scanner) {
    }

    /* Valida el acceso al Nucleo del Planeta. Exige que Cloud sea
       al menos de Nivel 20. Adicionalmente se exige tener minimo
       2 materias equipadas en el Arma (validado al inicio del combate).
       Parametro: cloud - jugador a evaluar.
       Retorna: true si nivel >= 20, false en caso contrario. */
    @Override
    public boolean validarAcceso(Jugador cloud) {
        return cloud.getNivel() >= 20;
    }

    public int getMateriasMinimasRequeridas() { return materiasMinimasRequeridas; }
}