package app;

import controller.Funcionalidade;
import java.util.*;

public class SopaMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha, opcao;

        Funcionalidade funcionalidade = new Funcionalidade();
        
        System.out.println("-----------------------------------------------");
        System.out.println("           SEJA BEM-VINDO AO JOGO              ");
        System.out.println("-----------------------------------------------");
        do {
            System.out.println("-------------------------------------------");
            System.out.println("1. Iniciar o jogo");
            System.out.println("2. Cancelar");
            System.out.println("-------------------------------------------");
            System.out.print("Escolha uma das opções: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("---------Modo de Jogo------------");
                    System.out.println("1. Modo Manual");
                    System.out.println("2. Modo Automatico");
                    System.out.println("3. Cancelar");
                    System.out.println("---------------------------------");
                    System.out.print("Escolha o modo de jogo: ");
                    opcao = scanner.nextInt();

                    if (opcao == 1) {
                        funcionalidade.adicionarPalavrasManualmente(scanner);
                        funcionalidade.gerarSopa();
                        funcionalidade.imprimeSopa();
                        funcionalidade.adivinharPosicoesPalavras();
                        
                    } else if (opcao == 2) {
                        System.out.println("Modo Automático selecionado.");
                        System.out.println("Ainda não foi implementado...");
                        System.out.println("As palavras as palavras virão do ficheiro");
                        //funcionalidade.carregarPalavrasFicheiro();
                        //funcionalidade.gerarSopaAutomaticamente();
                        //funcionalidade.imprimeSopa();
                    }
                    break;
                case 2:
                    System.out.println("Canclando...");
                    System.out.println("Jogo cancelado.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
            }
        } while (escolha != 2);
        scanner.close();
    }
}
