package Entidades;

public class Sephiroth extends Enemigo {
    private int contadorSuperNova = 0;

    /* Ejecuta el ataque definitivo SuperNova que aniquila a Cloud
       instantaneamente. Se activa cuando el contadorSuperNova llega
       a su limite de 10 turnos. No recibe parametros ni retorna nada. */
    public void lanzarSuperNova() {
    }

    /* Ataca a Cloud con un ataque fisico basico (precision del 90%).
       Tambien incrementa el contadorSuperNova en cada turno.
       Parametro: cloud - jugador que recibira el ataque. */
    @Override
    public void atacar(Jugador cloud) {
    }

    /* Entrega la recompensa de experiencia a Cloud tras vencer a
       Sephiroth. Se llama al final del combate definitivo.
       Parametro: cloud - jugador que recibe la XP. */
    @Override
    public void giveXpRecompensa(Jugador cloud) {
    }

    public int getContadorSuperNova() { return contadorSuperNova; }
}
