package Decola04.view;

import Decola02.entity.*;
import Decola01.dao.*;

import java.util.List;
import java.util.Scanner;

public class MainDecola {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UsuarioDAO2 usuarioDAO = new UsuarioDAO2();
        ProfissaoDAO profissaoDAO = new ProfissaoDAO();
        EmpregoDAO empregoDAO = new EmpregoDAO();
        TesteVocacionalDAO testeDAO = new TesteVocacionalDAO();

        int opt;
        do {
            System.out.println("\n=== MENU DECOLA ===");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Explorar profissões");
            System.out.println("3 - Teste Vocacional");
            System.out.println("4 - Listar Usuários");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();

                    Usuario u = new Usuario(nome, email, senha);
                    usuarioDAO.inserir(u);
                    System.out.println("Usuário cadastrado!");
                }
                case 2 -> {
                    List<Profissao> profs = profissaoDAO.listar();
                    for (Profissao p : profs) {
                        System.out.println("\nCategoria: " + p.getNome());
                        List<Emprego> empregos = empregoDAO.listarPorProfissao(p.getId());
                        for (Emprego e : empregos) {
                            System.out.println(" - " + e.getNome());
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Digite o ID do usuário para o teste: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Resultado do teste vocacional: ");
                    String resultado = sc.nextLine();
                    TesteVocacional t = new TesteVocacional(userId, resultado);
                    testeDAO.inserir(t);
                    System.out.println("Resultado salvo!");
                }
                case 4 -> {
                    List<Usuario> usuarios = usuarioDAO.listar();
                    for (Usuario u : usuarios) {
                        System.out.println("ID: " + u.getId() + " | Nome: " + u.getNome() + " | Email: " + u.getEmail());
                    }
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opt != 0);

        sc.close();
    }
}
