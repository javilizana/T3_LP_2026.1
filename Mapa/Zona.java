package Mapa;
import Entidades.Jugador;
import Entidades.Enemigo;
import java.util.List;
import java.util.Scanner;

public abstract class Zona {
    protected String nombre;
    protected int nivelRequerido;
    protected List<Enemigo> enemigosDisponibles;

    /* Metodo abstracto que ejecuta la accion principal de la zona
       (combate, tienda, exploracion, etc). Cada zona define su
       propio menu y comportamiento.
       Parametros:
         cloud   - jugador que esta explorando la zona
         scanner - lector de entrada para interactuar con el usuario */
    public abstract void accionZona(Jugador cloud, Scanner scanner);
    
     /* Metodo abstracto que valida si Cloud cumple los requisitos
       (nivel, materias, etc.) para entrar a la zona.
       Parametro: cloud - jugador a evaluar.
       Retorna: true si puede acceder, false en caso contrario. */
    public abstract boolean validarAcceso(Jugador cloud);

    /* Imprime un header decorativo con el estado actual de Cloud.
       Muestra zona, nivel, HP, MP, EXP y materias equipadas.
       Parametro: cloud - el jugador del que se mostrara el estado. */
    protected void mostrarHeader(Jugador cloud) {
        int nivel = cloud.getNivel();
        int hpAct = cloud.getStats().getHpActual();
        int hpMax = cloud.getStats().getHpMaximo();
        int mpAct = cloud.getStats().getMpActual();
        int mpMax = cloud.getStats().getMpMaximo();
        int xpAct = cloud.getXpActual();
        int xpNec = 10 * nivel;
        int matEq = cloud.getBusterSword().getMateriasEquipadas().size();

        System.out.println("\n==================================================");
        System.out.println(" ZONA: " + this.nombre + " | NIVEL: " + nivel);
        System.out.println(" HP: " + hpAct + "/" + hpMax + " | MP: " + mpAct + "/" + mpMax);
        System.out.println(" EXP: " + xpAct + "/" + xpNec + " | MATERIAS EQUIPADAS: " + matEq + "/5");
        System.out.println("==================================================");
    }
}
    
