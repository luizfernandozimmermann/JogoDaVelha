public class JogoDaVelha_PC
{
    private JogoDaVelha_Mapa mapa;
    private char letra = 'O';
    
    public JogoDaVelha_PC(JogoDaVelha_Mapa mapa)
    {
        this.mapa = mapa;
    }

    public boolean joga()
    {
        boolean jogadaValida = false;
        int linha = -1;
        int coluna = -1;
        while (!jogadaValida)
        {
            linha = mapa.sortear(0, 3);
            coluna = mapa.sortear(0, 3);
            
            jogadaValida = mapa.jogar(linha, coluna, letra);
        }
        
        System.out.println("\nPC[" + linha + ", " + coluna + "]");
        return mapa.ganhou(letra);
    }
}