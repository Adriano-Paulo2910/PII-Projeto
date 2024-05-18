package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Funcionalidade {

    Scanner scanner = new Scanner(System.in);

    // Lista de palavras a serem adicionadas na sopa
    ArrayList<String> palavras = new ArrayList();
    //Matriz que representa a sopa de letra
    char sopaDeLetra[][];

    public Funcionalidade() {
    }

    // Função que adiciona 
    public void adicionarPalavrasManualmente(Scanner scanner) {
        System.out.println("Escolha o tema das palavras a serem inseridos na sopa");
        System.out.println("-------Temas-------------");
        System.out.println("1. Frutas");
        System.out.println("2. Disciplinas");
        System.out.println("3. Objetos");
        System.out.println("4. Animais");
        System.out.println("5. Todos os temas");
        System.out.println("-------------------------");
        System.out.print("Escolha qual dos temas deseja adicionar na sopa: ");
        int escolha = scanner.nextInt();

        scanner.nextLine();
        switch (escolha) {
            case 1:
                System.out.println("Adicione 5 nomes de frutas na sopa");
                for (int i = 1; i <= 5; i++) {
                    System.out.printf("%dº. Fruta: ", i);
                    String palavrasManual = scanner.nextLine();
                    palavras.add(palavrasManual);
                }
                System.out.println("Palavras adicionadas com sucesso....");
                break;

            case 2:
                System.out.println("Adicione 5 nomes de Disciplinas na sopa");
                for (int i = 1; i <= 5; i++) {
                    System.out.printf("%dº. Disciplinas: ", i);
                    String palavrasManual = scanner.next();
                    palavras.add(palavrasManual.toUpperCase());
                }
                System.out.println("Palavras adicionadas com sucesso....");
                break;

            case 3:
                System.out.println("Adicione 5 nomes de Objetos na sopa");
                for (int i = 1; i <= 5; i++) {
                    System.out.printf("%dº. Objectos: ", i);
                    String palavrasManual = scanner.next();
                    palavras.add(palavrasManual.toUpperCase());
                }
                System.out.println("Palavras adicionadas com sucesso....");
                break;
            case 4:
                System.out.println("Adicione 5 nomes de animais na sopa");
                for (int i = 1; i <= 5; i++) {
                    System.out.printf("%dº. Animais: ", i);
                    String palavrasManual = scanner.next();
                    palavras.add(palavrasManual.toUpperCase());
                }
                System.out.println("Palavras adicionadas com sucesso....");
                break;
            case 5:
                System.out.println("Adicione 5 nomes de aleatórios na sopa");
                for (int i = 1; i <= 5; i++) {
                    System.out.printf("%dº. Nome aleatório: ", i);
                    String palavrasManual = scanner.next();
                    palavras.add(palavrasManual.toUpperCase());
                }
                System.out.println("Palavras adicionadas com sucesso....");
                break;
            default:
                System.out.println("Opção Inválida");
        }
    }

    public void gerarSopa() {
        Random random = new Random();
        int tamanho = 15; // Tamanho da sopa de letras (15x15)

        sopaDeLetra = new char[tamanho][tamanho];

        // Preenche a sopa de letras com caracteres aleatórios
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                sopaDeLetra[i][j] = (char) (random.nextInt(26) + 'A');
            }
        }

        // Adiciona as palavras na sopa de letras em posições aleatórias
        for (String palavra : palavras) {
            boolean adicionada = false;
            while (!adicionada) {
                int linha = random.nextInt(tamanho);
                int coluna = random.nextInt(tamanho);
                int direcaoDasPalavrasNaSopa = random.nextInt(6);

                // Verifica se a palavra pode ser colocada na posição gerada
                boolean podeColocar = podeColocarPalavraNaPosicao(tamanho, palavra, linha, coluna, direcaoDasPalavrasNaSopa);
                if (podeColocar) {
                    // Coloca a palavra na posição adequada
                    adicionarPalavraPosicao(palavra, linha, coluna, direcaoDasPalavrasNaSopa);
                    adicionada = true;
                }
            }
        }
    }

    // Verifica se é possível colocar uma palavra na posição especificada
    public boolean podeColocarPalavraNaPosicao(int tamanho, String palavra, int linha, int coluna, int direcaoDasPalavrasNaSopa) {
        int tamanhoPalavra = palavra.length();

        // Verifica se a palavra cabe na posição especificada com a direção escolhida
        switch (direcaoDasPalavrasNaSopa) {
            case 0: // Horizontal (direita)
                if (coluna + tamanhoPalavra <= tamanho) {
                    return true;
                }
                break;
            case 1: // Horizontal (esquerda)
                if (coluna - tamanhoPalavra >= -1) {
                    return true;
                }
                break;
            case 2: // Vertical (para baixo)
                if (linha + tamanhoPalavra <= tamanho) {
                    return true;
                }
                break;
            case 3: // Vertical (para cima)
                if (linha - tamanhoPalavra >= -1) {
                    return true;
                }
                break;
            case 4: // Diagonal (sudeste)
                if (linha + tamanhoPalavra <= tamanho && coluna + tamanhoPalavra <= tamanho) {
                    return true;
                }
                break;
            case 5: // Diagonal (sudoeste)
                if (linha + tamanhoPalavra <= tamanho && coluna - tamanhoPalavra >= -1) {
                    return true;
                }
                break;
            default:
                return false;
        }
        return false;
    }

    // Coloca uma palavra na sopa de letras na posição especificada
    public void adicionarPalavraPosicao(String palavra, int linha, int coluna, int direcaoDasPalavrasNaSopa) {
        int tamanhoPalavra = palavra.length();

        // Coloca a palavra na sopa de letras de acordo com a direção especificada
        switch (direcaoDasPalavrasNaSopa) {
            case 0: // Horizontal (direita)
                for (int i = 0; i < tamanhoPalavra; i++) {
                    sopaDeLetra[linha][coluna + i] = palavra.charAt(i);
                }
                break;
            case 1: // Horizontal (esquerda)
                for (int i = 0; i < tamanhoPalavra; i++) {
                    sopaDeLetra[linha][coluna - i] = palavra.charAt(i);
                }
                break;
            case 2: // Vertical (para baixo)
                for (int i = 0; i < tamanhoPalavra; i++) {
                    sopaDeLetra[linha + i][coluna] = palavra.charAt(i);
                }
                break;
            case 3: // Vertical (para cima)
                for (int i = 0; i < tamanhoPalavra; i++) {
                    sopaDeLetra[linha - i][coluna] = palavra.charAt(i);
                }
                break;
            case 4: // Diagonal (sudeste)
                for (int i = 0; i < tamanhoPalavra; i++) {
                    sopaDeLetra[linha + i][coluna + i] = palavra.charAt(i);
                }
                break;
            case 5: // Diagonal (sudoeste)
                for (int i = 0; i < tamanhoPalavra; i++) {
                    sopaDeLetra[linha + i][coluna - i] = palavra.charAt(i);
                }
                break;
            case 6: // Diagonal (nordeste)
                for (int i = 0; i < tamanhoPalavra; i++) {
                    sopaDeLetra[linha - i][coluna + i] = palavra.charAt(i);
                }
                break;
            case 7: // Diagonal (noroeste)
                for (int i = 0; i < tamanhoPalavra; i++) {
                    sopaDeLetra[linha - i][coluna - i] = palavra.charAt(i);
                }
                break;
            default:
                break;
        }
    }

    // Imprime a sopa de letras com as palavras adicionadas
    public void imprimeSopa() {
        int tamanho = sopaDeLetra.length;
        System.out.println("---------- SOPA DE LETRAS ----------");

        // Imprime a linha de números de colunas
        System.out.print("   ");
        for (int i = 0; i < tamanho; i++) {
            System.out.printf("%2d ", i);
        }
        System.out.println();

        // Imprime cada linha com o número da linha no início
        for (int i = 0; i < tamanho; i++) {
            System.out.printf("%2d| ", i);
            for (int j = 0; j < tamanho; j++) {
                System.out.print(sopaDeLetra[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------");
    }

//    public void imprimeSopa() {
//        int tamanho = sopaDeLetra.length;
//        System.out.println("---------- SOPA DE LETRAS ----------");
//        for (int i = 0; i < tamanho; i++) {
//            for (int j = 0; j < tamanho; j++) {
//                System.out.print(sopaDeLetra[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("------------------------------------");
//    }
    
    // Verifica se a palavra está na posição especificada na sopa de letras
    public boolean procurarPalavra(String palavra, int linha, int coluna) {
        for (int i = 0; i < palavra.length(); i++) {
            if (sopaDeLetra[linha][coluna + i] != palavra.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public void adivinharPosicoesPalavras() {
        for (String palavra : palavras) {
            System.out.printf("Digite a linha e a coluna da palavra \"%s\" (no formato linha coluna): ", palavra);
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (procurarPalavra(palavra, linha, coluna)) {
                System.out.println("Parabéns! Você acertou a posição da palavra.");
            } else {
                System.out.println("Ops! Você errou a posição da palavra.");
            }
        }
    }
}
