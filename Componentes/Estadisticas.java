package Componentes;

public class Estadisticas {
    private int hpActual;
    private int hpMaximo;
    private int mpActual;
    private int mpMaximo;
    private int fuerza;
    private int magia;

    /* Constructor que inicializa las estadisticas base de una entidad.
       El HP y MP actuales parten igual a sus valores maximos.
       Parametros:
         hpMaximo - valor maximo de puntos de vida
         mpMaximo - valor maximo de puntos de magia
         fuerza   - valor base de fuerza fisica
         magia    - valor base de poder magico */
    public Estadisticas(int hpMaximo, int mpMaximo, int fuerza, int magia){
        this.hpMaximo = hpMaximo;
        this.hpActual = hpMaximo;
        this.mpMaximo = mpMaximo;
        this.mpActual = mpMaximo;
        this.fuerza = fuerza;
        this.magia = magia;
    }

    /* Reduce el HP actual segun el daño recibido. Si el HP queda
       bajo 0, se ajusta a 0 para evitar valores negativos.
       Parametro: valor - cantidad de daño a aplicar al HP actual. */
    public void recibirDMG(int valor){
        this.hpActual -= valor;
        if (this.hpActual < 0){
            this.hpActual = 0;
        }
    }


    /* Aumenta las estadisticas base al subir de nivel. Tras aplicar
       los bonos, restaura el HP y MP actuales al maximo.
       Parametros:
         bonoHp     - aumento al HP maximo
         bonoMp     - aumento al MP maximo
         bonoFuerza - aumento a la fuerza
         bonoMagia  - aumento a la magia */
    public void subirStats(int bonoHp, int bonoMp, int bonoFuerza, int bonoMagia) {
        this.hpMaximo += bonoHp;
        this.hpActual = this.hpMaximo; // Se cura al máximo al subir nivel
        this.mpMaximo += bonoMp;
        this.mpActual = this.mpMaximo; // Se recarga MP al máximo
        this.fuerza += bonoFuerza;
        this.magia += bonoMagia;
    }

    public int getHpActual () {return hpActual; }
    public int getFuerza() {return fuerza; }

    public int getHpMaximo() { return hpMaximo; }
    public int getMpActual() { return mpActual; }
    public int getMpMaximo() { return mpMaximo; }
    public int getMagia() { return magia; }

}
