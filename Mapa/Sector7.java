package Mapa;
import Entidades.Jugador;
import Entidades.EnemigoSimulador;
import Componentes.Mejora;
import java.util.List;
import java.util.ArrayList; //ELIMINAR DSP
import java.util.Scanner;

public class Sector7 extends Zona {
    private List<Mejora> tiendaLocal;

    public Sector7(){
        this.nombre = "Sector 7";
        this.tiendaLocal = new ArrayList<>(); //ELIMINAR DSP
    }

    @Override
    public void accionZona(Jugador cloud, Scanner scanner){
        //Scanner scanner = new Scanner(System.in); //REVISAR DSP
        boolean EnSector7 = true; 

        while (EnSector7) {
            int nivel = cloud.getNivel();
            int hpActual = cloud.getStats().getHpActual();
            int hpMaximo = cloud.getStats().getHpMaximo();
            int XpActual = cloud.getXpActual();
            int MpActual = cloud.getStats().getMpActual();
            int MpMaximo = cloud.getStats().getMpMaximo();
            int fuerza = cloud.getStats().getFuerza();
            int magia = cloud.getStats().getMagia();


            System.out.println("\n--- SECTOR 7 - BASE DE OPERACIONES ---");
            System.out.println("1. Simulador de Combate");
            System.out.println("2. Tienda de Chatarra");
            System.out.println("3. Ver estado de Cloud");
            System.out.println("4. Ver mapa");
            System.out.println("0. Salir del Juego");
            System.out.print("Elige: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    iniciarSimulador(cloud, scanner);
                    break;
                case 2:
                    abrirTienda(cloud);
                    break;
                case 3: //Ver estado de Cloud
                    System.out.println("\n--- ESTADO DE CLOUD ---");
                    System.out.println("Nivel: " + nivel + "  |  XP: " + XpActual + "/" + (10 * nivel));
                    System.out.println("HP: "+ hpActual + "/" + hpMaximo + " | MP: " + MpActual + "/" + MpMaximo + " | Fuerza: " + fuerza + " | Magia: " + magia);
                    System.out.println("Chatarra: " + cloud.getChatarra());
                    System.out.println("Barra de Limite: "); //REVISAR DSP
                    System.out.println("Mochila: "); //REVISAR DSP
                    break;
                case 4: //Volver al mapa
                    //REVISAR DSP
                    //System.out.println("Regresando al mapa del mundo...");
                    EnSector7 = false;
                    break;
                case 0:
                    System.out.println("Saliendo del juego...");
                    System.exit(0);
                default:
                    System.out.println("Opcion Invalida");
            }
        }
    }

    @Override
    public boolean validarAcceso(Jugador cloud) { return true; }

    //Inicia un combate contra EnemigoSimulador y Cloud realiza un ataque
    public void iniciarSimulador(Jugador cloud, Scanner scanner){
        //Scanner scanner = new Scanner(System.in); //REVISAR DSP
        System.out.println("Entrando al Simulador de Combate...");

        EnemigoSimulador enemigo = new EnemigoSimulador();

        System.out.println("Aparece un " + enemigo.getNombre() + " con " + enemigo.getStats().getHpActual() + " de HP");

        boolean EnCombate = true;
        while (EnCombate) {
            System.out.println("\n--- TURNO DE CLOUD ---");
            System.out.println("Cloud HP: " + cloud.getStats().getHpActual() + "/" + cloud.getStats().getHpMaximo() + " | MP: " + cloud.getStats().getMpActual() + "/" + cloud.getStats().getMpMaximo());
            System.out.println("Enemigo HP: " + enemigo.getStats().getHpActual());

            System.out.println("1. Atacar (Físico)");
            System.out.println("2. Magia (En construcción)"); //REVISAR DSP
            System.out.println("3. Huir");
            if (cloud.getLimiteActual() == 100) {
                System.out.println("4. ATAQUE LÍMITE!!!!");
            }
            System.out.print("Elige tu acción: ");
            int accion = scanner.nextInt();

            boolean turnoConsumido = false;

            switch (accion) {
                case 1: //REVISAR DSP
                    int danoFisico = cloud.getBusterSword().calcularDanoFisico();
                    enemigo.getStats().recibirDMG(danoFisico);
                    System.out.println("Cloud ataca con su espada y causa " + danoFisico + " de daño!");
                    turnoConsumido = true;
                    break;
                case 2:
                    //AGREGAR DSP
                    turnoConsumido = true;
                    break;
                case 3:
                    if (Math.random() < 0.5) {
                        System.out.println("Cloud huyó exitosamente del simulador!");
                        EnCombate = false;
                    }else{
                        System.out.println("Cloud intentó huir pero falló! Pierde el turno");
                        turnoConsumido = true;
                    }
                    break;
                case 4: //REVISAR DSP
                    if (cloud.getLimiteActual() == 100) {
                        int danoLimite = cloud.getBusterSword().calcularDanoLimite();
                        enemigo.getStats().recibirDMG(danoLimite);
                        System.out.println("Cloud causa " + danoLimite + " de daño devastador");
                        turnoConsumido = true;
                    } else{
                        System.out.println("Acción inválida.");
                    }
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
            if (enemigo.getStats().getHpActual() <= 0){
                System.out.println("\n" + enemigo.getNombre() + " derrotado!");

                int xpGanada = (int)(Math.random() * 6) + 15;
                cloud.recibeXP(xpGanada); //REVISAR DSP
                System.out.println("Combate de prueba finalizado con éxito. Cloud gana " + xpGanada + " XP.");
                EnCombate = false;
                continue;
            }

            if (EnCombate && turnoConsumido){
                System.out.println("\n--- TURNO DEL ENEMIGO ---");

                enemigo.atacar(cloud);

                if (cloud.getStats().getHpActual() <= 1){
                    System.out.println("Cloud ha llegado a su límite de resistencia en el simulador");
                    System.out.println("La simulacion termina. Cloud queda con 1 HP");
                    EnCombate = false;
                }
            }

        }

    }

    //Metodo para abrir tienda (vacio por ahora) REVISAR DSP
    public void abrirTienda(Jugador cloud) {}

    //ELIMINAR DSP
    public List<Mejora> getTiendaLocal() {
        return tiendaLocal;
    }
}