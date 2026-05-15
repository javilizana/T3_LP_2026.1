package Mapa;
import java.util.Scanner;

import Entidades.Jugador;

public class NucleoPlaneta extends Zona {
    private int materiasMinimasRequeridas = 2;

    /* Inicia la batalla directa y definitiva contra Sephiroth.
       Recibe a Cloud como parametro para el combate. */
    public void iniciarCombate(Jugador cloud) {
        // Logica a implementar
    }

    @Override
    public void accionZona(Jugador cloud, Scanner scanner) {
        // Llama a iniciarCombate
    }

    @Override
    public boolean validarAcceso(Jugador cloud) {
        return cloud.getNivel() >= 20;
    }

    //ELIMINAR DSP
    public int getMateriasMinimasRequeridas() { return materiasMinimasRequeridas; }
}