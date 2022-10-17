import java.util.Scanner;
import java.util.Random;

public class Jogo{
    public static void main(String [] args){

        Scanner scan = new Scanner(System.in);
        Random aleatorio = new Random();

        int palpite, fase_atual = 1, chances = 6, range = 10, aux = 0, creditos = 5;
        char continua = 'S', resp_creditos;

        System.out.println("\nOlá! Você está entrando no mais novo jogo de adivinhação. Tente acertar o número que pensei!\n");
        System.out.println("Na primeira fase, você possui 6 chances. A medida que avança, esse número diminui");

        while (fase_atual <= 5 && (continua ==  'S' || continua == 's')){

            chances = 6;
            chances -= aux;
            aux++;

            int numero_aleatorio = aleatorio.nextInt(range);
            System.out.printf("\n================================\nFASE %d\n================================\n", fase_atual);
            System.out.printf("Dica: números entre 0 e %d\nVocê tem %d chances!\n", range, chances);

            do{
                System.out.print("\nSeu palpite: ");
                palpite = scan.nextInt();

                if (palpite != numero_aleatorio){
                    chances--;

                    System.out.printf("\nOps... Não foi no número %d que eu pensei. ", palpite); 
                    
                    if (chances > 0){
                        System.out.printf("Você ainda tem %d chance(s), tente novamente\n", chances);


                        if (creditos > 0){
                            System.out.printf("Deseja usar um crédito? (total: %d) [S/N]: ", creditos);
                            resp_creditos = scan.next().charAt(0);

                            if (resp_creditos == 'S' || resp_creditos == 's'){
                                if (palpite > numero_aleatorio){
                                    System.out.println("Menos...");
                                }
                                else{
                                    System.out.println("Mais...");
                                }

                                creditos--;
                            }
                        }
                    }
                }
                else{
                    fase_atual++;
                    System.out.printf("\nObaaaa! Foi exatamente no número %d que pensei!\n", palpite);
                    

                    if (fase_atual == 6){
                        System.out.println("Uau... Você zerou o jogo! Brabo!");
                    }
                    else{
                        System.out.printf("\nVocê ganhou mais 2 créditos! Vamos para a fase %d!!\n", fase_atual);
                        creditos += 2;
                    }

                    range += 10;
                }

                

            } while (chances > 0 && palpite != numero_aleatorio);

            if (chances == 0){
                System.out.println("\nGAME OVER! Suas chances acabaram :(\nMas não desista, jogue novamente!\n");
                System.out.printf("\nTinha pensado no número %d", numero_aleatorio);

                System.out.print("\nDeseja jogar mais uma vez? [S/N]: \n");
                continua = scan.next().charAt(0);
                fase_atual = 1; chances = 6; range = 10; aux = 0; creditos = 5;
            }
        }
    }
}