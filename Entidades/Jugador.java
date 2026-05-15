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



    /* Constructor que inicializa a Cloud en su estado base (Nivel 1).
       Stats iniciales: HP Maximo: 200, MP Maximo: 50, Fuerza: 15,
       Magia: 15. Tambien crea una mochila vacia y su arma Buster Sword. */
    public Jugador(){
        //HP Máximo: 200, MP Máximo: 50, Fuerza: 15, Magia: 15
        this.stats = new Estadisticas(200, 50, 15, 15);
        this.mochila = new ArrayList<>();
        this.busterSword = new Arma();
    }

    public class Arma {
        private String nombre = "Buster Sword";
        private List<Materia> materiasEquipadas;
        
        /* Constructor del arma anidada de Cloud. Inicializa la lista
           de materias equipadas vacia (limite maximo: 5 ranuras). */
        public Arma(){
            this.materiasEquipadas = new ArrayList<>();
        }

        /* Calcula el daño fisico aplicando la formula floor(Fuerza * 1.25).
           Aprovecha el acceso directo a las stats de Cloud por ser
           clase anidada.
           Retorna: el daño fisico calculado como entero. */
        public int calcularDanoFisico(){
            return (int) (stats.getFuerza() * 1.25);
        }

        /* Calcula el daño magico segun el elemento seleccionado y la
           cantidad de materias del mismo tipo equipadas. Formula:
           floor(Magia * (1.0 + 0.5 * n)), donde n es la cantidad de
           materias del elemento. No aplica aun el multiplicador del
           enemigo (eso lo hace evaluarDebilidad).
           Parametro: elemento - elemento magico a lanzar.
           Retorna: el daño magico base calculado como entero. */
        public int calcularDanoMagico (Componentes.Elemento elemento) {return 0; }

         /* Calcula el daño del ataque Limite, definido como Fuerza * 5.
           Ignora coste de MP y multiplicadores elementales.
           Retorna: el daño limite calculado como entero. */
        public int calcularDanoLimite() { return 0; }


        public String getNombre() { return nombre; }
        public List<Materia> getMateriasEquipadas() { return materiasEquipadas; }


    }
    

    /* Suma experiencia a Cloud y verifica si debe subir de nivel.
       Si la xpActual supera (10 * nivel), descuenta ese valor y llama
       a subirNivel. Soporta multiples subidas en una sola llamada.
       Parametro: xp - cantidad de experiencia a sumar. */
    public void recibeXP(int xp) {
        this.xpActual += xp;

        while (this.xpActual >= 10 * this.nivel) {
            this.xpActual -= 10 * this.nivel;
            subirNivel();
        }
    }

    /* Sube de nivel a Cloud, aplicando los bonos automaticos a sus
       estadisticas base (+10 HP Max, +5 MP Max, +4 Fuerza, +6 Magia)
       y restaurando HP y MP al maximo. Es privado porque solo se
       llama internamente desde recibeXP. */
    private void subirNivel() {
        this.nivel++;
        this.stats.subirStats(10, 5, 4, 6);
        System.out.println(">>> Cloud subió a nivel " + this.nivel + "!!! HP y MP restaurados. <<<");
        System.out.println(">>> +10 HP Máx | +5 MP Máx | +4 Fuerza | +6 Magia <<<");
    }

    public Arma getBusterSword() { return busterSword; }
    public Estadisticas getStats() { return stats; }

    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getXpActual() { return xpActual; }
    public int getChatarra() { return chatarra; }
    public int getLimiteActual() { return limiteActual; }
    public List<Materia> getMochila() { return mochila; }
}
