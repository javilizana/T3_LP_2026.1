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
            mostrarHeader(cloud);
            System.out.println("1. Simulador de Combate");
            System.out.println("2. Tienda de Chatarra");
            System.out.println("3. Ver estado de Cloud");
            System.out.println("4. Ver mapa");
            System.out.println("0. Salir del Juego");
            System.out.print("> Elige: ");

            int opcion = leerEntero(scanner);
            
            switch (opcion) {
                case 1:
                    iniciarSimulador(cloud, scanner);
                    break;
                case 2:
                    abrirTienda(cloud);
                    break;
                case 3: //Ver estado de Cloud
                    System.out.println("\n--- ESTADISTICAS ---");
                    System.out.println("Fuerza: " + cloud.getStats().getFuerza() + " | Magia: " + cloud.getStats().getMagia());
                    System.out.println("Arma equipada: " + cloud.getBusterSword().getNombre());
                    System.out.print("\nPresiona Enter para volver...");
                    scanner.nextLine(); // consume el \n pendiente
                    scanner.nextLine(); // espera al Enter real
                    break;
                case 4: //Volver al mapa
                    //REVISAR DSP
                    //System.out.println("Regresando al mapa del mundo...");
                    EnSector7 = false;
                    break;
                case 0:
                    System.out.println("Saliendo del juego...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        }
    }

    @Override
    public boolean validarAcceso(Jugador cloud) { return true; }

    //Inicia un combate contra EnemigoSimulador y Cloud realiza un ataque
    public void iniciarSimulador(Jugador cloud, Scanner scanner){
        System.out.println("Entrando al Simulador de Combate...");

        List<EnemigoSimulador> enemigos = new ArrayList<>();
        enemigos.add(new EnemigoSimulador()); // Siempre aparece 1

        if (Math.random() < 0.25) { // 25% de probabilidad de un 2do 
            enemigos.add(new EnemigoSimulador());
        }

        System.out.println("Aparecen " + enemigos.size() + " enemigo(s) en el simulador:");
        for (int i = 0; i < enemigos.size(); i++) {
            EnemigoSimulador e = enemigos.get(i);
            System.out.println("  [" + (i + 1) + "] " + e.getNombre() + " con " + e.getStats().getHpActual() + " de HP");
        }

        boolean EnCombate = true;
        while (EnCombate) {
            System.out.println("\n--- TURNO DE CLOUD ---");
            System.out.println("Cloud HP: " + cloud.getStats().getHpActual() + "/" + cloud.getStats().getHpMaximo() + " | MP: " + cloud.getStats().getMpActual() + "/" + cloud.getStats().getMpMaximo());

            System.out.println("Enemigos:");
            for (int i = 0; i < enemigos.size(); i++) {
                System.out.println("  [" + (i + 1) + "] " + enemigos.get(i).getNombre() + " - HP: " + enemigos.get(i).getStats().getHpActual());
            }

            System.out.println("1. Atacar (Físico)");
            System.out.println("2. Magia (En construcción)");
            System.out.println("3. Huir");
            if (cloud.getLimiteActual() == 100) {
                System.out.println("4. ATAQUE LÍMITE!!!!");
            }
            System.out.print("Elige tu acción: ");
            int accion = scanner.nextInt();

            boolean turnoConsumido = false;

            switch (accion) {
                case 1:
                    int objetivo = 0;
                    if (enemigos.size() > 1) {
                        while (true) {
                            System.out.print("A cuál atacar??? (1-" + enemigos.size() + "): ");
                            int eleccion = leerEntero(scanner);
                            if (eleccion >= 1 && eleccion <= enemigos.size()) {
                                objetivo = eleccion - 1;
                                break;
                            }
                            System.out.println("Objetivo inválido. Intenta de nuevo.");
                        }
                    }
                    int danoFisico = cloud.getBusterSword().calcularDanoFisico();
                    enemigos.get(objetivo).getStats().recibirDMG(danoFisico);
                    System.out.println("Cloud ataca con su espada y causa " + danoFisico + " de daño!");
                    turnoConsumido = true;
                    break;
                case 2:
                    turnoConsumido = true;
                    break;
                case 3:
                    if (Math.random() < 0.5) {
                        System.out.println("Cloud huyó exitosamente del simulador!");
                        EnCombate = false;
                    } else {
                        System.out.println("Cloud intentó huir pero falló! Pierde el turno");
                        turnoConsumido = true;
                    }
                    break;
                case 4:
                    if (cloud.getLimiteActual() == 100) {
                        // El límite golpea a TODOS los enemigos
                        int danoLimite = cloud.getBusterSword().calcularDanoLimite();
                        for (EnemigoSimulador e : enemigos) {
                            e.getStats().recibirDMG(danoLimite);
                        }
                        System.out.println("Cloud causa " + danoLimite + " de daño devastador a todos los enemigos!");
                        turnoConsumido = true;
                    } else {
                        System.out.println("Acción inválida.");
                    }
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }

            enemigos.removeIf(e -> {
                if (e.getStats().getHpActual() <= 0) {
                    e.giveXpRecompensa(cloud);
                    return true;
                }
                return false;
            });

            // Si no quedan enemigos, victoria
            if (enemigos.isEmpty()) {
                System.out.println("\nCombate de prueba finalizado con éxito.");
                EnCombate = false;
                continue;
            }

            if (EnCombate && turnoConsumido) {
                System.out.println("\n--- TURNO DE LOS ENEMIGOS ---");
                for (EnemigoSimulador e : enemigos) {
                    e.atacar(cloud);
                    if (cloud.getStats().getHpActual() <= 1) {
                        System.out.println("Cloud ha llegado a su límite de resistencia en el simulador");
                        System.out.println("La simulacion termina. Cloud queda con 1 HP");
                        EnCombate = false;
                        break;
                    }
                }
            }
        }
    }

    //Metodo para abrir tienda (vacio por ahora) REVISAR DSP
    public void abrirTienda(Jugador cloud) {}

    private int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada invalida, ingresa un numero: ");
            scanner.next(); // descarta el token invalido
        }
        return scanner.nextInt();
    }





    //ELIMINAR DSP
    public List<Mejora> getTiendaLocal() {
        return tiendaLocal;
    }
}