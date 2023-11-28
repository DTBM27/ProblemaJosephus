public class ProblemaJosephus {
    public static void main(String[] args) {
        ListaCircular roda = new ListaCircular();

    
        for (int i = 1; i <= 20; i++) {
            roda.adicionarPessoa(i, "Pessoa " + i, "Telefone " + i, "Endereço " + i, "CPF " + i);
        }

        int m = 5; 
        int sobrevivente = roda.sobrevivente(m);
        System.out.println("\nA pessoa sobrevivente é: " + sobrevivente);
    }
}

class Pessoa {
    int numero;
    String nome;
    String telefone;
    String endereco;
    String cpf;
    Pessoa proxima;

    public Pessoa(int numero, String nome, String telefone, String endereco, String cpf) {
        this.numero = numero;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.proxima = null;
    }
}

class ListaCircular {
    Pessoa cabeca;

    public ListaCircular() {
        this.cabeca = null;
    }

    public void adicionarPessoa(int numero, String nome, String telefone, String endereco, String cpf) {
        Pessoa novaPessoa = new Pessoa(numero, nome, telefone, endereco, cpf);
        if (cabeca == null) {
            cabeca = novaPessoa;
            cabeca.proxima = cabeca; 
        } else {
            Pessoa temp = cabeca;
            while (temp.proxima != cabeca) {
                temp = temp.proxima;
            }
            temp.proxima = novaPessoa;
            novaPessoa.proxima = cabeca; 
        }
    }

    public int sobrevivente(int m) {
        Pessoa atual = cabeca;
        Pessoa anterior = null;

        while (atual.proxima != atual) {
            
            for (int i = 0; i < m - 1; i++) {
                anterior = atual;
                atual = atual.proxima;
            }
            
            anterior.proxima = atual.proxima;
            System.out.println("Pessoa removida: " + atual.numero + " (" + atual.nome + ")");
            atual = anterior.proxima; 
        }
        return atual.numero; 
    }
}

