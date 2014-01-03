import java.sql.Date;
import java.util.*;

public class GlobalMembers
{
	private static int TAM = 5;
	public static int falha()
	{
		  int falha;
		  RandomNumbers.seed(0);
		  falha = RandomNumbers.nextNumber() % TAM;
	  return falha;
	}

	public static int promove_eleicao()
	{
		  int eleicao;
		  eleicao = RandomNumbers.nextNumber() % TAM;
	 return eleicao;
	}

	public static void main(String[] args) {
		
		int proc_falha = 0;
		int proc_eleicao = 0;
		int proc_lider = 0;
		int[] vet_proc = TAM;
		int i;
		int cont;
		new  processos() ;

		
	}
	
	private void processos() {
		
		if (TAM < 2) {
		  System.out.print("clear");
		  System.out.print("Voce precisa ter pelo menos 2 processos.\n");
		  new Thread();
		Thread.sleep(3000);  
		  System.exit(0);
		}
		System.out.println("clear");

		for (int j = 0; j < TAM; j++) {
				//inicializa os processo preenchendo a struct com numero do processo (PID)
			 for (i = 0; i <  TAM; i++)	 {
				vet_proc[i] = proc[TAM].pid = i;
				}
				do {
					proc_falha = GlobalMembers.falha();
					proc_eleicao = GlobalMembers.promove_eleicao();
				 } while (proc_eleicao == proc_falha);

				 //inicializa o processo com falha colocando -1
				 for (i = 0; i < DefineConstants.TAM; i++)
				 {
					 if (vet_proc[i] == proc_falha)
					 {
					 vet_proc[i] = -1;
					 }
				 }

	 proc_lider = vet_proc[0];
	 for (i = 0; i < TAM; i++) //faz a escolha do novo lider
	 {
			   if (vet_proc[i] > proc_lider)
			   {
			   proc_lider = vet_proc[i];
			   }
	 }
	 System.out.print("|\033[32m PROC PID\033[37m |\n"); //faz a impressão na tela
	 for (i = 0; i < DefineConstants.TAM; i++)
	 {
			 System.out.printf("| [%d] [%d] |\n",vet_proc[i],proc[TAM].pid = i);
	 }
	 new Thread().sleep(1000);
	 System.out.printf("\n\nProcesso de PID\033[31m [%d]\033[37m falhou.\n",proc_falha);
	 new Thread().sleep(3000);
	 System.out.printf("Processo de PID\033[33m [%d]\033[37m iniciou eleicao.\n",proc_eleicao);
	 new Thread().sleep(3000);
	 System.out.print("\033[36mEscolhendo novo lider...\033[37m \n");
	 new Thread().sleep(3000);
	 System.out.printf("Processo de PID\033[33m [%d]\033[37m e o novo lider.\n",proc_lider);
	 new Thread().sleep(3000);
	 System.out.println("clear");
		  }
	return 0;
	}
}

struct struct Processos
{
	int pid;
}

