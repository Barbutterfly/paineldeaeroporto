package projetoA3;
//a arvore 
import java.util.Scanner;

class Voo {
    int id;
    int horario;
    char empresa;
    char destino;
    char portao;

    public Voo(int id, int horario, char empresa, char destino, char portao) {
        this.id = id;
        this.horario = horario;
        this.empresa = empresa;
        this.destino = destino;
        this.portao = portao;
    }

    public int getId() {
        return id;
    }

    public int getHorario() {
        return horario;
    }

    public char getEmpresa() {
        return empresa;
    }

    public char getDestino() {
        return destino;
    }
}

class folha {
    Voo voo;
    folha esquerda, direita;

    public folha(Voo voo) {
        this.voo = voo;
        this.esquerda = this.direita = null;
    }

    public Voo getVoo() {
        return voo;
    }

    public folha getEsquerda() {
        return esquerda;
    }

    public folha getDireita() {
        return direita;
    }

    public int getHorario() {
        return voo.getHorario();
    }

    public char getEmpresa() {
        return voo.getEmpresa();
    }

    public char getDestino() {
        return voo.getDestino();
    }

    public void setEsquerda(folha esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(folha direita) {
        this.direita = direita;
    }
}

public class arvore {
    private folha raiz;

    public arvore() {
        this.raiz = null;
    }

    public void adicionar(Voo voo) {
        raiz = adicionarRec(raiz, voo);
    }

    private folha adicionarRec(folha raiz, Voo voo) {
        if (raiz == null) {
            return new folha(voo);
        }

        if (voo.getId() < raiz.getVoo().getId()) {
            raiz.setEsquerda(adicionarRec(raiz.getEsquerda(), voo));
        } else if (voo.getId() > raiz.getVoo().getId()) {
            raiz.setDireita(adicionarRec(raiz.getDireita(), voo));
        }

        return raiz;
    }

    public Voo pesquisar(int id) {
        return pesquisarRec(raiz, id);
    }

    private Voo pesquisarRec(folha raiz, int id) {
        if (raiz == null || raiz.getVoo().getId() == id) {
            return (raiz != null) ? raiz.getVoo() : null;
        }

        if (id < raiz.getVoo().getId()) {
            return pesquisarRec(raiz.getEsquerda(), id);
        }

        return pesquisarRec(raiz.getDireita(), id);
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdemRec(raiz);
        System.out.println();
    }

    private void percorrerEmOrdemRec(folha raiz) {
        if (raiz != null) {
            percorrerEmOrdemRec(raiz.getEsquerda());
            System.out.print("ID: " + raiz.getVoo().getId() + " ");
            percorrerEmOrdemRec(raiz.getDireita());
        }
    }

    public static void main(String[] args) {
    	arvore filas = new arvore();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
           /* System.out.println("Informe os detalhes do voo:");
            System.out.print("ID: ");*/
            int id = scanner.nextInt();
           // System.out.print("Horário: ");
            int horario = scanner.nextInt();
           // System.out.print("Empresa: ");
            char empresa = scanner.next().charAt(0);
          //  System.out.print("Destino: ");
            char destino = scanner.next().charAt(0);
           // System.out.print("Portão: ");
            char portao = scanner.next().charAt(0);

            Voo novoVoo = new Voo(id, horario, empresa, destino, portao);
            filas.adicionar(novoVoo);
        }

        System.out.println("Árvore em ordem:");
        filas.percorrerEmOrdem();

        System.out.print("Informe o ID do voo a ser pesquisado: ");
        int idPesquisa = scanner.nextInt();
        Voo vooEncontrado = filas.pesquisar(idPesquisa);
        if (vooEncontrado != null) {
            System.out.println("O voo com ID " + idPesquisa + " foi encontrado. Detalhes:");
            System.out.println("Horário: " + vooEncontrado.getHorario() +
                    ", Empresa: " + vooEncontrado.getEmpresa() +
                    ", Destino: " + vooEncontrado.getDestino());
        } else {
            System.out.println("O voo com ID " + idPesquisa + " não foi encontrado.");
        }

        scanner.close();
    }
}
