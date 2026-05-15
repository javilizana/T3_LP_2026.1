package Entidades;
import Componentes.Estadisticas;

public class EnemigoSimulador extends Enemigo{
    
    /* Constructor del Soldado Comun, enemigo de entrenamiento del
       Sector 7. Stats: HP Maximo 50, Fuerza 15. Su xpRecompensa se
       genera aleatoriamente entre 15 y 20 al instanciarse. */
    public EnemigoSimulador(){
        this.nombre = "Soldado Común"; 
        //HP Máximo: 50, MP Máximo: 0, Fuerza: 15, Magia: 0
        this.stats = new Estadisticas(50, 0, 15, 0);
        this.xpRecompensa = (int)(Math.random() * 6) + 15;  
    }

    /* Verifica que el daño calculado no reduzca el HP de Cloud por
       debajo de 1 en el simulador (regla de seguridad de la zona).
       Parametro: cloud - jugador a evaluar.
       Retorna: true si el daño es seguro, false si necesita ajustarse. */
    public boolean checkDanoSeguro (Jugador cloud){ 
        return true; 
    }

    /* Ataca a Cloud con un 85% de probabilidad de acierto. El daño
       sigue la formula floor(Fuerza * 1.25), pero se ajusta para
       nunca dejar a Cloud por debajo de 1 HP (regla del simulador).
       Parametro: cloud - jugador que recibe el ataque. */
    @Override
    public void atacar(Jugador cloud){
        if (Math.random() <= 0.85){
            int dano = (int) (this.stats.getFuerza() * 1.25);
            int hpCloud = cloud.getStats().getHpActual();
            if (hpCloud - dano < 1){
                dano = hpCloud - 1;

                if (dano < 0){
                    dano = 0;
                }
            }
            cloud.getStats().recibirDMG(dano);
            System.out.println("El " + this.nombre + " ataca y causa " + dano + " de daño a Cloud!");
        } else{
            System.out.println("El " + this.nombre + " falló su ataque!");
        }
    }

    /* Entrega la recompensa de XP a Cloud al ser derrotado el
       Soldado Comun y muestra un mensaje por consola.
       Parametro: cloud - jugador que recibe la XP. */
    @Override
    public void giveXpRecompensa(Jugador cloud){
        System.out.println(this.nombre + " derrotado! Cloud gana " + this.xpRecompensa + " XP.");
        cloud.recibeXP(this.xpRecompensa);
    }
}
