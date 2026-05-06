package Componentes;

public class Estadisticas {
    private int hpActual;
    private int hpMaximo;
    private int mpActual;
    private int mpMaximo;
    private int fuerza;
    private int magia;

    //Constructor para inicializar las estadisticas
    public Estadisticas(int hpMaximo, int mpMaximo, int fuerza, int magia){
        this.hpMaximo = hpMaximo;
        this.hpActual = hpMaximo;
        this.mpMaximo = mpMaximo;
        this.mpActual = mpMaximo;
        this.fuerza = fuerza;
        this.magia = magia;
    }

    //Reduce el HP actual basado en el daño recibido
    public void recibirDMG(int valor){
        this.hpActual -= valor;
        if (this.hpActual < 0){
            this.hpActual = 0;
        }
    }

    public int getHpActual () {return hpActual; }
    public int getFuerza() {return fuerza; }

    //ELIMINAR DSP
    public int getHpMaximo() { return hpMaximo; }
    public int getMpActual() { return mpActual; }
    public int getMpMaximo() { return mpMaximo; }
    public int getMagia() { return magia; }

}
