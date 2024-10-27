import java.util.ArrayList;
import java.util.Scanner;

class Tarefa {
    private String descricao;
    private boolean concluida;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcarConcluida() {
        this.concluida = true;
    }

    @Override
    public String toString() {
        return (concluida ? "[X] " : "[ ] ") + descricao;
    }
}

public class App {
    private static ArrayList<Tarefa> tarefas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        System.out.println("Bem-vindo ao Gerenciador de Tarefas!");
        
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer de nova linha

            switch (opcao) {
                case 1 -> adicionarTarefa();
                case 2 -> listarTarefas();
                case 3 -> marcarTarefaComoConcluida();
                case 4 -> removerTarefa();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Listar tarefas");
        System.out.println("3. Marcar tarefa como concluída");
        System.out.println("4. Remover tarefa");
        System.out.println("5. Sair");
        System.out.print("Opção: ");
    }

    private static void adicionarTarefa() {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        tarefas.add(new Tarefa(descricao));
        System.out.println("Tarefa adicionada com sucesso.");
    }

    private static void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa disponível.");
        } else {
            System.out.println("\nLista de Tarefas:");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    private static void marcarTarefaComoConcluida() {
        listarTarefas();
        if (!tarefas.isEmpty()) {
            System.out.print("Digite o número da tarefa para marcar como concluída: ");
            int indice = scanner.nextInt();
            if (indice > 0 && indice <= tarefas.size()) {
                tarefas.get(indice - 1).marcarConcluida();
                System.out.println("Tarefa marcada como concluída.");
            } else {
                System.out.println("Número inválido.");
            }
        }
    }

    private static void removerTarefa() {
        listarTarefas();
        if (!tarefas.isEmpty()) {
            System.out.print("Digite o número da tarefa para remover: ");
            int indice = scanner.nextInt();
            if (indice > 0 && indice <= tarefas.size()) {
                tarefas.remove(indice - 1);
                System.out.println("Tarefa removida com sucesso.");
            } else {
                System.out.println("Número inválido.");
            }
        }
    }
}
