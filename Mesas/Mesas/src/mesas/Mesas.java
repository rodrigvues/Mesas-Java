package mesas;
import java.util.Scanner;

public class Mesas {

    public static void main(String[] args) {
        Scanner meuscanner = new Scanner(System.in);
        int numMesas = 20;  // definindo quantidade de passageiros
        boolean[] ocupacaoMesas = new boolean[numMesas];

        // dando lugares como false para dizer que todos estão zerados
        // usando o loop for para fazer 10 vezes dentro da array ocupacaoLugares
        for (int i = 0; i < numMesas; i++) {
            ocupacaoMesas[i] = false;
        }

        int opcao;
        
        do {
            // mostrando o menu
            System.out.println("\nMenu:");
            System.out.println("1) Confira ocupação de mesas");
            System.out.println("2) Faça reserva de uma mesa");
            System.out.println("3) Sair");
            System.out.println("Escolha uma das opções: ");
            opcao = meuscanner.nextInt();

            //usando switch para programar o que fazer quando entrar no caso escolhido pelo usuário
            switch (opcao) {
                case 1:
                    verificarOcupacao(ocupacaoMesas);
                    break;
                case 2:
                    fazerReserva(ocupacaoMesas);
                    break;
                case 3:
                    System.out.println("Saindo do programa");
                    break;
                default:
                    System.out.println("Opção inválida: Tente novamente.");
                    
                    opcao = meuscanner.nextInt();
            }
        } while (opcao != 3 );
    }
    
    
    // função que verifica a ocupação de lugares usando um loop for que mostra cada lugar
    public static void verificarOcupacao(boolean[] ocupacaoMesas) {
        System.out.println("\nOcupação de mesas:");
        for (int i = 0; i < ocupacaoMesas.length; i++) {
            System.out.println("M"+ (i + 1) + ": " + (ocupacaoMesas[i] ? "Reservado" : "Livre"));
        }
    }

    // função que faz a reserva de lugares usando um if else para também verificar se o número escolhido está reservado ou não
    public static void fazerReserva(boolean[] ocupacaoMesas) {
        int numLugar;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da mesa a ser reservada: ");
        numLugar = scanner.nextInt();

        if (numLugar >= 1 && numLugar <= ocupacaoMesas.length) {
            if (!ocupacaoMesas[numLugar - 1]) {
                ocupacaoMesas[numLugar - 1] = true;
                System.out.println("Reserva efetuada com sucesso!");
            } else  {
                System.out.println("Esta mesa já está reservada. Escolha outra.");
            }
        } else {
            System.out.println("Número de mesa inválido. Tente novamente.");
        }
    }

    
}