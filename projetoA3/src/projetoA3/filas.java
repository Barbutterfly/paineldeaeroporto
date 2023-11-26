package projetoA3;
 /* Primeiro o painel vai conter as seguintes informações: horario do voo, id do voo, empresa do voo, destino, portao esssas informaçoes
 	quem vai colocar vai ser um usuario, então o SCANNER vai ser usado pra isso	
 * Com as informações vai ser preciso estruturar tudo em fila com todas as variaveis usadas para os atributos do painel 
 * Depois da estrutura criada precisa ordenar os voos, por uma árvore binaria e ela ordena pelo id do voo
 * Ele precisa retirar da fila por ordem de horario, o mais próximo
 */

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class filas {
	//Aqui ele já esta criando a estrutura que no caso é fila que armazena os dados 
    private Queue<Character> empString = new LinkedList<>();  
    private Queue<Character> destString = new LinkedList<>();
    private Queue<Character> portString = new LinkedList<>();
    private Queue<Integer> horarioInt = new LinkedList<>();
    private Queue<Integer> idInt = new LinkedList<>();

    //aqui esta armazenando e aplicando a fila os dados inseridos pelo usuario 
    public void adicionarVoo(int id, int horario, char empresa, char destino, char portao) {
        horarioInt.add(horario);
        idInt.add(id);
        empString.add(empresa);
        destString.add(destino);
        portString.add(portao);
    }
    //print para o ususario inserir os dados 
    public void mostrarDados() {
        System.out.println("Informações do voo  ");
        System.out.println("Horario do voo: " + horarioInt);
        System.out.println("ID do voo: " + idInt);
        System.out.println("Empresa aérea: " + empString);
        System.out.println("Destino do voo: " + destString);
        System.out.println("Portão de embarque: " + portString);
    }
    //aqui ele esta armazenando no vetor e imprimindo para o usuario as informações
    public static void main(String[] args) {
        filas Filas = new filas();
        try (Scanner scanner = new Scanner(System.in)) {
        	//for criado em um para iterar 4 vezes para ter uma tabala grande mas o tamanho pode mudar dai dentro desse laço estou usando Scanner para interação com user
            for (int i = 0; i < 4; i++) { 
                System.out.println("Informe os detalhes do voo " + (i + 1) + ":");
                System.out.print("ID do voo: ");
                int id = scanner.nextInt();
                System.out.print("Horário do voo: ");
                int horario = scanner.nextInt();
                System.out.print("Empresa aérea: ");
                char empresa = scanner.next().charAt(0);
                System.out.print("Destino do voo: ");
                char destino = scanner.next().charAt(0);
                System.out.print("Portão de embarque: ");
                char portao = scanner.next().charAt(0);

                Filas.adicionarVoo(id, horario, empresa, destino, portao);  //aquie o metodo adicionarVoo esta sendo usado para adicionar o voo na estrutura
            }

            Filas.mostrarDados(); //para mostrar tudo estruturadinho de uma vez
        }
    }
}
