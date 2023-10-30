import java.util.InputMismatchException;
import java.util.Scanner;

public class biblioCentral {

    private static int posicaoMidias;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println("1 - Criar autor");
            System.out.println("2 - Criar livro");
            System.out.println("3 - Criar mídia");
            System.out.println("4 - Criar biblioteca");
            System.out.println("5 - Adicionar livro");
            System.out.println("6 - Adicionar mídia");
            System.out.println("7 - Emprestar livro");
            System.out.println("8 - Devolver livro");
            System.out.println("9 - Emprestar mídia");
            System.out.println("10 - Devolver mídia");
            System.out.println("Opção escolhida: ");

            try {
                op = sc.nextInt();
            } catch (InputMismatchException e) {
                op = 99;
            }
            switch (op) {
                case 0: {
                    System.out.println("Obrigado(a)!");
                }
                case 1: {
                    System.out.println("Digite o nome do autor: ");
                    String nomeAutor = sc.next();
                    new Autor(nomeAutor);
                    break;
                }
                case 2: {
                    System.out.println("Digite o nome do livro: ");
                    String titulo = sc.next();
                    int posicaoAutor = -1;
                    do {
                        Autor.listaAutors();
                        try {
                            posicaoAutor = sc.nextInt();
                            if (posicaoAutor >= Autor.getlistaAutors().size()) {
                                throw new Exception("Autor inválido");
                            }
                        } catch (Exception e) {
                            System.out.println("Autor inválido");
                            posicaoAutor = -1;
                        }
                    } while (posicaoAutor < 0);
                    Autor autor = Autor.getlistaAutors().get(posicaoAutor);
                    new Livro(autor, titulo);

                    break;
                }
                case 3: {
                    System.out.println("Digite o nome da mídia que você deseja adicionar: ");
                    String titulo = sc.next();
                    System.out.println("Agora, digite o ano correspondente desta mídia: ");
                    int ano = sc.nextInt();
                     do {
                        Midias.listaMidias();
                        try {
                            op = sc.nextInt();
                            if (op >= Midias.getlistaMidias().size()) {
                                throw new Exception("Mídia inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Autor inválido");
                            op = -1;
                        }
                    } while (posicaoMidias < 0);
                    Midias.getlistaMidias().get(posicaoMidias);
                    new Midias(titulo, ano);
                    break;
                }
                case 4: {
                    System.out.println("Digite o nome da Biblioteca que você deseja adcicionar: ");
                    String nome = sc.next();
                    new Biblioteca(nome);
                    break;
                }
                case 5: {
                    int posicaoBiblioteca = -1;
                    do {
                        Biblioteca.listarBibliotecas();
                        try {
                            System.out.println("Digite o código da biblioteca");
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca inválida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                    Biblioteca biblioteca = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                    int posicaoLivro = -1;
                    do {
                        Livro.listaLivros();
                        try {
                            System.out.println("Digite o código do livro: ");
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= Livro.livros.size()) {
                                throw new Exception("Livro inválido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro inválido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);
                    Livro livro = Livro.livros.get(posicaoLivro);
                    biblioteca.adicionarLivro(livro);
                    break;
                }
                case 6: {
                    int posicaoBiblioteca = -1;
                    do {
                        Biblioteca.listarBibliotecas();
                        try {
                            System.out.println("Digite o código da biblioteca: ");
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca inválida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                    Biblioteca biblioteca = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                    int posicaoMidias = -1;
                    do {
                        Midias.listaMidias();
                        try {
                            System.out.println("Digite o nome da mídia que deseja adicionar: ");
                            posicaoMidias = sc.nextInt();
                            if (posicaoMidias >= Midias.midias.size()) {
                                throw new Exception("Mídia inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Mídia inválida");
                            posicaoMidias = -1;
                        }
                    } while (posicaoMidias < 0);
                    Midias midias = Midias.midias.get(posicaoMidias);
                    biblioteca.adicionarMidias(midias);
                    break;
                }
                case 7: {
                    System.out.println("Digite seu nome: ");
                    String usuario = sc.next();
                    Usuario usuarioEmprestado = new Usuario(usuario);
                    int posicaoBiblioteca = -1;
                    do {
                        Biblioteca.listarBibliotecas();
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca inválida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                    Biblioteca bibliotecas = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                    int posicaoLivro = -1;
                    do {
                        bibliotecas.listaLivros();
                        try {
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= Livro.livros.size()) {
                                throw new Exception("Livro inválido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro inválido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);
                    Livro livros = bibliotecas.listaLivros.get(posicaoLivro);
                    try {
                        livros.emprestimo(usuarioEmprestado);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 8: {
                    int posicaoBiblioteca = -1;
                    do {
                        Biblioteca.listarBibliotecas();
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca inválida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                    Biblioteca bibliotecas = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                    int posicaoLivro = -1;
                    do {
                        bibliotecas.listaLivros();
                        try {
                            posicaoLivro = sc.nextInt();
                            if (posicaoLivro >= Livro.livros.size()) {
                                throw new Exception("Livro inválido");
                            }
                        } catch (Exception e) {
                            System.out.println("Livro inválido");
                            posicaoLivro = -1;
                        }
                    } while (posicaoLivro < 0);
                    Livro listaLivro = bibliotecas.listaLivros.get(posicaoLivro);
                    try {
                        listaLivro.devolucao();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 9: {
                    System.out.println("Digite seu nome: ");
                    String usuario = sc.next();
                    Usuario usuarioEmprestado = new Usuario(usuario);
                    int posicaoBiblioteca = -1;
                    do {
                        Biblioteca.listarBibliotecas();
                        try {
                            System.out.println("Digite o código da biblioteca: ");
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca inválida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                    Biblioteca bibliotecas = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                    int posicaoMidias = -1;
                    do {
                        bibliotecas.listaMidias();
                        try {
                            System.out.println("Digite o código da mídia: ");
                            posicaoMidias = sc.nextInt();
                            if (posicaoMidias >= Midias.midias.size()) {
                                throw new Exception("Mídia inválido");
                            }
                        } catch (Exception e) {
                            System.out.println("Mídia inválido");
                            posicaoMidias = -1;
                        }
                    } while (posicaoMidias < 0);
                    Midias midias = bibliotecas.listaMidias.get(posicaoMidias);
                    try {
                        midias.emprestimo(usuarioEmprestado);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 10: {
                    int posicaoBiblioteca = -1;
                    do {
                        Biblioteca.listarBibliotecas();
                        try {
                            posicaoBiblioteca = sc.nextInt();
                            if (posicaoBiblioteca >= Biblioteca.bibliotecas.size()) {
                                throw new Exception("Biblioteca inválida");
                            }
                        } catch (Exception e) {
                            System.out.println("Biblioteca inválida");
                            posicaoBiblioteca = -1;
                        }
                    } while (posicaoBiblioteca < 0);
                    Biblioteca bibliotecas = Biblioteca.bibliotecas.get(posicaoBiblioteca);
                    int posicaoMidias = -1;
                    do {
                        bibliotecas.listaMidias();
                        try {
                            posicaoMidias = sc.nextInt();
                            if (posicaoMidias >= Midias.midias.size()) {
                                throw new Exception("Mídia inválido");
                            }
                        } catch (Exception e) {
                            System.out.println("Mídia inválido");
                            posicaoMidias = -1;
                        }
                    } while (posicaoMidias < 0);
                    Midias listaMidias = bibliotecas.listaMidias.get(posicaoMidias);
                    try {
                        listaMidias.devolucao();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
            }
        } while (op != 0);
        sc.close();
    }
}