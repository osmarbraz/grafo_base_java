
/**
 * Implementação de exemplo que utiliza JOptionPane para construir um menu de
 * opções para um grafo orientado utilizando uma matriz de adjacência.
 */
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Principal {

    //Número de vértices do grafo
    static int n = 0;

    //Matriz M de n por n
    static int[][] G = new int[n][n];

    /**
     * Troca um número pelo rótulo do vértice no grafo.
     *
     * Retorna o rótulo da posição i do vértice no grafo.
     *
     * @param i Posição do vértice no grafo
     * @return Um rótulo para a posição i
     */
    public static String rotuloVertice(int i) {
        String[] rotulos = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        if ((i >= 0) && (i <= rotulos.length)) {
            return (rotulos[i] + "");
        } else {
            return "-";
        }
    }

    /**
     * Troca o rótulo pela posição do vértice no grafo.
     *
     * @param chave Rótulo a ser trocado pela posição do vértice no grafo.
     * @return Um inteiro que representa a posição do vértice no grafo
     */
    public static int indiceRotuloVertice(String chave) {
        String[] rotulos = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int pos = -1;
        for (int i = 0; i < rotulos.length; i++) {
            if (rotulos[i].equals(chave)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Gera uma string formatada com os dados Matriz G.
     *
     * @param M Matriz com os dados a serem exibidos.
     * @param linhas Quantidade de linhas da matriz.
     * @param colunas Quantidade colunas da matriz.
     * @return Uma String formatada com os dados da matriz.
     */
    public static String imprimirMatriz(int[][] M, int linhas, int colunas) {
        if (linhas != 0 || colunas != 0) {
            String saida = "";
            for (int j = 0; j < colunas; j++) {
                saida = saida + "\t" + rotuloVertice(j);
            }
            saida = "n/m" + saida + "\n";
            for (int i = 0; i < linhas; i++) {
                String dados = "";
                for (int j = 0; j < colunas; j++) {
                    dados = dados + "\t" + String.format("%2d", M[i][j]);
                }
                saida = saida + rotuloVertice(i) + dados + "\n";
            }
            return saida;
        } else {
            return "Matriz vazia!";
        }
    }

    /**
     * Carrega um Grado Padrão com valores.
     *
     */
    public static void carregarGrafoPadrao() {
        //Declara a matriz de adjacência do grafo g
        int[][] g = {
            //1  2  3  4  5  6  7
            {0, 1, 0, 1, 0, 0, 0},//1
            {0, 0, 1, 0, 0, 1, 0},//2
            {0, 0, 0, 0, 0, 1, 0},//3
            {0, 1, 0, 0, 0, 0, 1},//4
            {0, 0, 0, 0, 0, 1, 0},//5
            {0, 0, 0, 0, 0, 0, 0},//6
            {0, 0, 0, 0, 1, 0, 0} //7
        };

        //Número de vértices do grafo
        n = 7;

        //Atribui para G
        G = g;
        JOptionPane.showMessageDialog(null, "Grafo carregado!");
    }

    /**
     * Realiza a leitura dos dados do Grafo G.
     */
    public static void leituraGrafo() {
        //Preenche a quantidade de vértice do grafo.
        n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vértices do grafo(G):"));
        //Instância a matriz de adjacência com o novo tamanho.
        G = new int[n][n];
        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(JOptionPane.showInputDialog("Preenchendo os adjacentes de(" + rotuloVertice(i) + ")"
                    + "\nDigite o indice(0-" + n + ") do vértice de incidência de " + i
                    + "\n ou -1 para ir ao próximo vértice:"));
            while (j != -1) {
                G[i][j] = 1;
                j = Integer.parseInt(JOptionPane.showInputDialog("Preenchendo os adjacentes de(" + rotuloVertice(i) + ")"
                        + "\nDigite o índice(0-" + n + ") do vértice de incidência de " + i
                        + "\n ou -1 para ir ao próximo vértice:"));
            }
        }
    }

    //Outras operações vão aqui
    
    /**
     * Programa principal.
     *
     * @param args
     */
    public static void main(String[] args) {

        //Armazena opção lida
        int opcao = -1;

        //Laço do menu de opções
        while (opcao != 99) {
            
            //Realiza a leitura da opção
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Menu de Opções - Grafo Orientado com Matriz de Adjacência ###\n"
                    + "Selecione a opção desejada:\n"
                    + " 0- Carregamento da Grafo\n"
                    + " 1- Imprime Matriz Adjacência\n"
                    + " 2- Leitura do Grafo(i)\n"
                    
                    //Outras opções vão aqui                    

                    + "99- Sair\n"
                    + "Opção:"));
            
            //Verifica a opção
            switch (opcao) {
                case 0: {
                    carregarGrafoPadrao();
                    break;
                }
                case 1: {
                    //Recupera os dados da matriz
                    String dados = "Matriz de Adjacência:" + "\n" + imprimirMatriz(G, n, n);
                    //Adiciona a String em um TextArea
                    JTextArea saida = new JTextArea(dados);
                    //Exibe o TextArea com showMessageDialog
                    JOptionPane.showMessageDialog(null, saida);
                    break;
                }
                case 2: {
                    leituraGrafo();
                    break;
                }

                //Outras opções vão aqui
                
                //Opção de saída do programa
                case 99: {
                    System.out.println("Saindo do programa!");
                    break;
                }
                //Opção inválida do menu
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }//Fim switch
        }//Fim while
    }//Fim main
}
