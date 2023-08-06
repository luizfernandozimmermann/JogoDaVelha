import java.util.Random;

public class JogoDaVelha_Mapa
{
    private char[][] mapa = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public int sortear(int inicio, int fim)
    {
        Random geradorRandom = new Random();
        
        return geradorRandom.nextInt(inicio, fim);
    }

    public void limpaMapa()
    {
        for (int linha = 0; linha < mapa.length; linha++)
        {
            for (int coluna = 0; coluna < mapa[linha].length; coluna++)
            {
                mapa[linha][coluna] = ' ';
            }
        }
    }

    public void desenha(int jogada)
    {
        System.out.println("------------- .. jogada: " + jogada);
        for (char[] linha : mapa) 
        {
            System.out.print("|");
            for (char letra : linha) 
            {
                System.out.print(" " + letra + " |");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean jogar(int l, int c, char jogador)
    {
        if (mapa[l][c] != ' ')
        {
            return false;
        }
        mapa[l][c] = jogador;
        return true;
    }

    public boolean ganhou(char jogador)
    {
        // horizontal
        for (char[] linha : mapa) {
            if (linha[0] == linha[1] && 
                linha[1] == linha[2] && 
                linha[0] == jogador)
            {
                return true;
            }
        }

        // vertical
        for (int i = 0; i < 3; i++)
        {
            if (mapa[0][i] == mapa[1][i] && 
                mapa[1][i] == mapa[2][i] && 
                mapa[0][i] == jogador)
            {
                return true;
            }
        }

        // diagonal
        if ((mapa[0][0] == mapa[1][1] &&
            mapa[1][1] == mapa[2][2] &&
            mapa[0][0] == jogador) 
            || 
            (mapa[0][2] == mapa[1][1] &&
            mapa[1][1] == mapa[2][0] &&
            mapa[0][2] == jogador))
        {
            return true;
        }

        return false;
    }
}