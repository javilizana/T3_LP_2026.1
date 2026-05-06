package Entidades;

public class Sephiroth extends Enemigo {
    private int contadorSuperNova = 0;

    /* Ejecuta el ataque final que reduce instantaneamente el HP de Cloud a 0. */
    public void lanzarSuperNova() {
        // Logica a implementar
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
    public int getContadorSuperNova() { return contadorSuperNova; }
}
