import Entidades.Jugador;
import Mapa.Gongaga;
import Mapa.NucleoPlaneta;
import Mapa.Sector7;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Instanciamos a Cloud y las zonas
        Jugador cloud = new Jugador();
        Sector7 sector7 = new Sector7();
        Gongaga gongaga = new Gongaga();
        NucleoPlaneta nucleo = new NucleoPlaneta();
        Scanner scanner = new Scanner(System.in);

        sector7.accionZona(cloud, scanner);

        boolean jugando = true;
        while (jugando) {
            mostrarHeaderMapa(cloud);
            System.out.println("1. Sector 7 (Zona segura)");
            System.out.println("2. Gongaga (Nivel minimo para entrar: 5)");
            System.out.println("3. Nucleo Planeta (Nivel minimo para entrar: 20)");
            System.out.println("4. Ver estado de Cloud");
            System.out.println("0. Salir");
            System.out.print("\n> Destino: ");

            int destino = leerEntero(scanner);

            switch (destino) {
                case 1: //Sector 7
                    if (sector7.validarAcceso(cloud)){
                        System.out.println("Viajando a Sector 7...");
                        sector7.accionZona(cloud, scanner);
                    }
                    break;
                case 2: //Gongaga
                    if (gongaga.validarAcceso(cloud)){
                        System.out.println("Viajando a Gongaga...");
                        gongaga.accionZona(cloud, scanner);
                    }else{
                        System.out.println("Necesitas ser Nivel 5 para ir a Gongaga!!!");
                    }
                    break;
                case 3: //Nucleo Planeta
                    if (nucleo.validarAcceso(cloud)){
                        System.out.println("Desendiendo al Nucleo del Planeta...");
                        nucleo.accionZona(cloud, scanner);
                    }else{
                        System.out.println("Necesitas ser Nivel 20 para ir al Nucleo del Planeta!!!");
                    }
                    break;
                case 4: //Ver estado de Cloud
                    System.out.println("\n--- ESTADISTICAS ---");
                    System.out.println("Fuerza: " + cloud.getStats().getFuerza() + " | Magia: " + cloud.getStats().getMagia());
                    System.out.println("Arma equipada: " + cloud.getBusterSword().getNombre());
                    System.out.print("\nPresiona Enter para volver...");
                    scanner.nextLine(); // consume el \n pendiente
                    scanner.nextLine(); // espera al Enter real
                    break;
                case 0: //Salir
                    System.out.println("Saliendo del juego...");
                    jugando = false;
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        }

        scanner.close();

    }

    private static int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada invalida, ingresa un numero: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    /* Imprime el header decorativo del mapa del mundo con el estado
       actual de Cloud. Se usa para el menu de seleccion de zona.
       Parametro: cloud - el jugador del que se mostrara el estado. */
    private static void mostrarHeaderMapa(Jugador cloud) {
        int nivel = cloud.getNivel();
        int hpAct = cloud.getStats().getHpActual();
        int hpMax = cloud.getStats().getHpMaximo();
        int mpAct = cloud.getStats().getMpActual();
        int mpMax = cloud.getStats().getMpMaximo();
        int xpAct = cloud.getXpActual();
        int xpNec = 10 * nivel;
        int matEq = cloud.getBusterSword().getMateriasEquipadas().size();

        System.out.println("\n==================================================");
        System.out.println(" ZONA: Mapa del Mundo | NIVEL: " + nivel);
        System.out.println(" HP: " + hpAct + "/" + hpMax + " | MP: " + mpAct + "/" + mpMax);
        System.out.println(" XP: " + xpAct + "/" + xpNec + " | MATERIAS EQUIPADAS: " + matEq + "/5");
        System.out.println("==================================================");
    }
}
