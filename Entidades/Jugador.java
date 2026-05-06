package Entidades;

import Componentes.Estadisticas;
import Componentes.Materia;
import java.util.List;
import java.util.ArrayList;

public class Jugador {
    private String nombre = "Cloud";
    private int nivel = 1;
    private int xpActual = 0;
    private int chatarra = 0;
    private int limiteActual = 0;
    private Estadisticas stats;
    private List<Materia> mochila;
    private Arma busterSword;

    //Constructor inicializador de Cloud
    public Jugador(){
        //HP Máximo: 200, MP Máximo: 50, Fuerza: 15, Magia: 15
        this.stats = new Estadisticas(200, 50, 15, 15);
        this.mochila = new ArrayList<>();
        this.busterSword = new Arma();
    }

    public class Arma {
        private String nombre = "Buster Sword";
        private List<Materia> materiasEquipadas;
        
        public Arma(){
            this.materiasEquipadas = new ArrayList<>();
        }

        //Cálculo daño fisico:
        public int calcularDanoFisico(){
            return (int) (stats.getFuerza() * 1.25);
        }

        //Métodos (vacios por ahora) REVISAR DSP
        public int calcularDanoMagico (Componentes.Elemento elemento) {return 0; }
        public int calcularDanoLimite() { return 0; }


        //ELIMINAR DSP
        // Getters para evitar warnings en la clase Arma
        public String getNombre() { return nombre; }
        public List<Materia> getMateriasEquipadas() { return materiasEquipadas; }


    }
    //Métodos (vacios por ahora) REVISAR DSP
    public void recibeXP(int xp) {}

    public Arma getBusterSword() { return busterSword; }
    public Estadisticas getStats() { return stats; }

    //ELIMINAR DSP
    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getXpActual() { return xpActual; }
    public int getChatarra() { return chatarra; }
    public int getLimiteActual() { return limiteActual; }
    public List<Materia> getMochila() { return mochila; }
}
