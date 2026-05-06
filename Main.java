import Entidades.Jugador;
import Mapa.Sector7;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Instanciamos a Cloud y las zonas
        Jugador cloud = new Jugador();
        Sector7 sector7 = new Sector7();
        Scanner scanner = new Scanner(System.in);

        sector7.accionZona(cloud, scanner);

        boolean jugando = true;
        while (jugando) {
            int nivel = cloud.getNivel();
            int hpActual = cloud.getStats().getHpActual();
            int hpMaximo = cloud.getStats().getHpMaximo();
            int XpActual = cloud.getXpActual();
            int MpActual = cloud.getStats().getMpActual();
            int MpMaximo = cloud.getStats().getMpMaximo();
            int fuerza = cloud.getStats().getFuerza();
            int magia = cloud.getStats().getMagia();

            System.out.println("\n--- MAPA DEL MUNDO ---");
            System.out.println("Cloud - Nivel " + nivel + "   |   HP: " + hpActual + "/" + hpMaximo);
            System.out.println("1. Sector 7 (Zona segura)");
            System.out.println("2. Gongaga (Nivel minimo para entrar: 5)");
            System.out.println("3. Nucleo Planeta (Nivel minimo para entrar: 20)");
            System.out.println("4. Ver estado de Cloud");
            System.out.println("0. Salir");
            System.out.print("\nDestino: ");

            int destino = scanner.nextInt();

            switch (destino) {
                case 1: //Sector 7
                    System.out.println("Viajando a Sector 7...");
                    sector7.accionZona(cloud, scanner);
                    break;
                case 2: //Gongaga
                    if (cloud.getNivel() >= 5){
                        System.out.println("Viajando a Gongaga...");
                        // gongaga.accionZona(cloud); // Descomentar se implemente REVISAR DSP
                    }else{
                        System.out.println("Necesitas ser Nivel 5 para ir a Gongaga!!!");
                    }
                    break;
                case 3: //Nucleo Planeta
                    if (cloud.getNivel() >= 20){
                        System.out.println("Desendiendo al Nucleo del Planeta...");
                        // nucleo.accionZona(cloud); // Descomentar se implemente REVISAR DSP
                    }else{
                        System.out.println("Necesitas ser Nivel 20 ir al Nucleo del Planeta!!!");
                    }
                    break;
                case 4: //Ver estado de Cloud
                    System.out.println("\n--- ESTADO DE CLOUD ---");
                    System.out.println("Nivel: " + nivel + "  |  XP: " + XpActual + "/" + (10 * nivel));
                    System.out.println("HP: "+ hpActual + "/" + hpMaximo + " | MP: " + MpActual + "/" + MpMaximo + " | Fuerza: " + fuerza + " | Magia: " + magia);
                    System.out.println("Chatarra: " + cloud.getChatarra());
                    System.out.println("Barra de Limite: "); //REVISAR DSP
                    System.out.println("Mochila: "); //REVISAR DSP
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
}
