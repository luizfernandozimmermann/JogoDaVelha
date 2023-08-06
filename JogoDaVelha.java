import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {
    private static JogoDaVelha_Mapa jogoMapa;
    private static JogoDaVelha_Jogador jogoJogador;
    private static JogoDaVelha_PC jogoPC;
    
    public static void main(String[] args) 
    {
        jogoMapa = new JogoDaVelha_Mapa();
        jogoJogador = new JogoDaVelha_Jogador(jogoMapa);
        jogoPC = new JogoDaVelha_PC(jogoMapa);
        Scanner teclado = new Scanner(System.in);

        Boolean jogarNovamente = true;
        while (jogarNovamente)
        {
            jogar(teclado);

            System.out.println("Deseja jogar novamente? (S/N): ");

            String resposta = teclado.next();

            if (resposta.equalsIgnoreCase("N"))
            {
                jogarNovamente = false;
                System.out.println("Obrigado por jogar!");
            }
        }
    }

    private static void jogar(Scanner teclado)
    {
        jogoMapa.limpaMapa();
        int jogada = 0;

        Random geradorRandom = new Random();
        boolean jogadorComecar = geradorRandom.nextBoolean();
        
        if (jogadorComecar)
        {
            System.out.println("\nVocê começa jogando...");
            jogoMapa.desenha(jogada);
            jogoJogador.joga(teclado);
            jogada += 1;
        }
        else
        {

            System.out.println("\nPC começa jogando...");
        }

        while (true)
        {
            boolean PCGanhou = jogoPC.joga();
            jogoMapa.desenha(jogada);
            jogada += 1;
            if (PCGanhou)
            {
                System.out.println("... PC GANHOU!");
                return;
            }

            if (jogada == 9)
            {
                System.out.println("... EMPATE");
                return;
            }
            
            boolean jogadorGanhou = jogoJogador.joga(teclado);
            jogoMapa.desenha(jogada);
            jogada += 1;  
            if (jogadorGanhou)
            {
                System.out.println("... JOGADOR GANHOU!");
                return;
            }  

            if (jogada == 9)
            {
                System.out.println("... EMPATE");
                return;
            }
        }
    }
}
