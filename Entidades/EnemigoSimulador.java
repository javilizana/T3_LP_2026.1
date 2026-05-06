package Entidades;
import Componentes.Estadisticas;

public class EnemigoSimulador extends Enemigo{
    
    //Constructor enemigo prueba
    public EnemigoSimulador(){
        this.nombre = "Soldado Común"; 
        //HP Máximo: 50, MP Máximo: 0, Fuerza: 15, Magia: 0
        this.stats = new Estadisticas(50, 0, 15, 0);
        this.xpRecompensa = 15;
    }

    //verifica que daño no mate a Cloud en el simulador
    public boolean checkDanoSeguro (Jugador cloud){ 
        return true; 
    }

    @Override
    public void atacar(Jugador cloud){
        //REVISAR DSP
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
            //AGREGAR MÁS DSP
        } else{
            System.out.println("El " + this.nombre + " falló su ataque!");
        }
    }

    @Override
    public void giveXpRecompensa(Jugador cloud){
        //REVISAR DSP
    }
}
