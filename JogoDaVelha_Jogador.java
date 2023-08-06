import java.util.Scanner;

public class JogoDaVelha_Jogador
{
    private JogoDaVelha_Mapa mapa;
    private char letra = 'X';
    
    public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa)
    {
        this.mapa = mapa;
    }

    public boolean joga(Scanner teclado)
    {
        boolean jogadaValida = false;
        while (!jogadaValida)
        {
            System.out.println("\nJogador ..");
            System.out.println("Escolha entre os números 0 e 2 e onde esteja vago:");
            System.out.println("    linha:");
            int linha = -1;
            while (linha < 0 || linha > 2)
            {
                linha = teclado.nextInt();
            }

            System.out.println("    coluna:");
            int coluna = -1;
            while (coluna < 0 || coluna > 2)
            {
                coluna = teclado.nextInt();
            }
            jogadaValida = mapa.jogar(linha, coluna, letra);
        }
        return mapa.ganhou(letra);
    }
}