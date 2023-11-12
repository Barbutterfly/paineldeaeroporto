package projetoA3;

/*
 * Primeiro o painel vai conter as seguintes informações: horario do voo, id do voo, empresa do voo, destino, portao esssas informaçoes
 	quem vai colocar vai ser um usuario, então o SCANNER vai ser usado pra isso	
 * Com as informações vai ser preciso estruturar tudo em fila com todas as variaveis usadas para os atributos do painel 
 * Depois da estrutura criada precisa ordenar os voos, por uma árvore binaria e ela ordena pelo id do voo
 * Ele precisa retirar da fila por ordem de horario, o mais próximo
 */
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class filas {
	public static void main(String [] args) {
		 Queue<Character> empString = new LinkedList<>(); /*Aqui ele esta criando uma lista que armazena os dados com as strings*/
		 Queue<Character> destString = new LinkedList<>();
		 Queue<Character> portString = new LinkedList<>();
		 Queue<Integer> horarioInt = new LinkedList<>();
		 Queue<Integer> idInt = new LinkedList<>();//Aqui ele cria com numeros inteiros 
		try (Scanner scanner = new Scanner(System.in)) { //Aqui é onde o usuario coloca os atributos
		      System.out.print("Digite os horários dos próximos voos: ");  
		      
		      int [] horario = new int [4]; //aqui esta criando o vetor para o horario
		      
		      for (int i = 0; i < horario.length; i++) { //aqui ele esta armazenando os dados fornecidos pelo user
		    	  horario[i] = scanner.nextInt();
		      }
		      for (int horarios : horario) { //aqui ele esta inserindo na lista 
		    	  horarioInt.add(horarios);
		      }
		      System.out.print("ID do voo: ");
		      int [] idvoo = new int [4];
		      
		      for (int i = 0; i < idvoo.length; i++) {
		    	  idvoo[i] = scanner.nextInt();
		      }

		      for (int idvoos : idvoo) {
		    	  idInt.add(idvoos);
		      }
		      System.out.print("Empresa aérea: ");
		      char [] empresa = new char[4];
		      for (char i = 0; i < empresa.length; i++) {
		    	  empresa[i] = scanner.next().charAt(0);
		      }
		      for (char empresas : empresa) {
		    	  empString.add(empresas);
		      }
		      System.out.print("Destino do voo: ");
		      char [] destino = new char[4];
		      for (char i = 0; i < destino.length; i++) {
		    	  destino[i] = scanner.next().charAt(0);
		      }
		      for (char destinos : destino) {
		    	  destString.add(destinos);
		      }
		      System.out.print("Portão de embarque: ");
		      char [] portao = new char[4];
		      for (char i = 0; i < portao.length; i++) {
		    	  portao[i] = scanner.next().charAt(0);
		      }
		      for (char portoes : portao) {
		    	  portString.add(portoes);
		      //Aqui ele imprime as info.
		      System.out.println("Informações do voo  ");
		      System.out.println("Horario do voo: "+ horarioInt);
		      System.out.println("ID do voo: "+idInt);
		      System.out.println("Empresa aérea: "+empString);
		      System.out.println("Destino do voo: "+destString);
		      System.out.println("Portão de embarque: "+portString);

		    }
		  }
	}
}

