import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
// Classe Membro
class Membro {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private List<ProjetoSocial> projetosAssociados;
    private List<Doacao> doacoes;
    private List<String> setoresAssociados;

    // Construtor padrão
    public Membro() {
        projetosAssociados = new ArrayList<>();
        doacoes = new ArrayList<>();
        setoresAssociados = new ArrayList<>();
    }

    // Sobrecarga de construtores
    public Membro(int id, String nome, String email, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.projetosAssociados = new ArrayList<>();
        this.doacoes = new ArrayList<>();
        this.setoresAssociados = new ArrayList<>();
    }

    // Métodos getter e setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<ProjetoSocial> getProjetosAssociados() {
        return projetosAssociados;
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    public List<String> getSetoresAssociados() {
        return setoresAssociados;
    }

    // Método para associar o membro a um projeto social
    public void associarProjeto(ProjetoSocial projeto) {
        projetosAssociados.add(projeto);
        projeto.adicionarMembro(this); // Adiciona o próprio membro à lista de membros do projeto
    }

    // Método para associar o membro a um setor
    public void associarSetor(String setor) {
        setoresAssociados.add(setor);
    }

    // Método para fazer uma nova doação pelo membro
    public void fazerNovaDoacao(double valor, ProjetoSocial projeto, String setor) {
        Doacao novaDoacao = new Doacao(doacoes.size() + 1, valor, new Date(), setor);
        doacoes.add(novaDoacao);
        projeto.adicionarDoacao(novaDoacao);
    }
}

// Classe Doacao
class Doacao {
    private int id;
    private double valor;
    private Date data;
    private String setor;
    // Construtor padrão
    public Doacao() {
    }

    // Sobrecarga de construtores
    public Doacao(int id, double valor, Date data, String setor) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.setor = setor;
    }

    // Métodos getter e setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}

// Classe ProjetoSocial
class ProjetoSocial {
    private int id;
    private String nome;
    private String descricao;
    private List<Membro> membros;
    private List<Doacao> doacoes;

    // Construtor padrão
    public ProjetoSocial() {
        membros = new ArrayList<>();
        doacoes = new ArrayList<>();
    }

    // Sobrecarga de construtores
    public ProjetoSocial(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.membros = new ArrayList<>();
        this.doacoes = new ArrayList<>();
    }

    // Métodos getter e setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public List<Doacao> getDoacoes() {
        return doacoes;
    }

    // Método para adicionar membro ao projeto
    public void adicionarMembro(Membro membro) {
        membros.add(membro);
    }

    // Método para adicionar doação ao projeto
    public void adicionarDoacao(Doacao doacao) {
        doacoes.add(doacao);
    }
}

// Classe Relatorio
class Relatorio {
    private int id;
    private String conteudo;
    private Date dataGeracao;

    // Construtor padrão
    public Relatorio() {
    }

    // Sobrecarga de construtores
    public Relatorio(int id, String conteudo, Date dataGeracao) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataGeracao = dataGeracao;
    }

    // Métodos getter e setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }
}

// Classe Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um projeto social
        ProjetoSocial projeto = new ProjetoSocial(1, "Projeto A", "Descrição do Projeto A");

        int escolha;
        do {
            // Exibindo o menu principal
            System.out.println("\n===== Menu Principal =====");
            System.out.println("1. Cadastrar Novo Membro");
            System.out.println("2. Controlar Doações de Membro");
            System.out.println("3. Gerenciar Projetos Sociais para Membro");
            System.out.println("4. Emitir Relatório de Atividades de Membro");
            System.out.println("0. Sair do Programa");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            switch (escolha) {
                case 1:
                    cadastrarNovoMembro(scanner, projeto);
                    break;
                case 2:
                    controlarDoacoes(scanner, projeto);
                    break;
                case 3:
                    gerenciarProjetosSociais(scanner, projeto);
                    break;
                case 4:
                    emitirRelatorio(scanner, projeto);
                    break;
                case 0:
                    // Sair do programa
                    System.out.println("Encerrando o programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 0);

        // Fechando o scanner
        scanner.close();
    }

    // Métodos auxiliares
    // (Incluindo métodos para cadastrar novo membro, visualizar doações de membro
    // existente,
    // fazer nova doação por membro existente e obter membro por ID)

    // Método para cadastrar um novo membro
    private static void cadastrarNovoMembro(Scanner scanner, ProjetoSocial projeto) {
        System.out.println("\n===== Cadastrar Novo Membro =====");

        // Obtém os detalhes do membro do usuário
        System.out.print("Informe o ID do Membro: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha pendente

        System.out.print("Informe o Nome do Membro: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o Email do Membro: ");
        String email = scanner.nextLine();

        System.out.print("Informe o Telefone do Membro: ");
        String telefone = scanner.nextLine();

        System.out.print("Informe o Endereço do Membro: ");
        String endereco = scanner.nextLine();

        // Cria um novo membro
        Membro novoMembro = new Membro(id, nome, email, telefone, endereco);

        // Adiciona o novo membro ao projeto
        projeto.adicionarMembro(novoMembro);

        System.out.println("Novo membro cadastrado com sucesso!");
    }

    // Método para controlar doações de um membro
    private static void controlarDoacoes(Scanner scanner, ProjetoSocial projeto) {
        int escolhaDoacoes;
        do {
            // Exibindo o menu de controle de doações
            System.out.println("\n===== Controle de Doações =====");
            System.out.println("1. Visualizar Doações de Membro Existente");
            System.out.println("2. Fazer Nova Doação por Membro Existente");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            escolhaDoacoes = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            switch (escolhaDoacoes) {
                case 1:
                    visualizarDoacoesMembroExistente(scanner, projeto);
                    break;
                case 2:
                    fazerNovaDoacaoMembroExistente(scanner, projeto);
                    break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolhaDoacoes != 0);
    }

    // Método para visualizar doações feitas por um membro existente
    private static void visualizarDoacoesMembroExistente(Scanner scanner, ProjetoSocial projeto) {
        System.out.println("\n===== Visualizar Doações de Membro Existente =====");
    
        // Obter o ID do membro
        System.out.print("Informe o ID do Membro: ");
        int idMembro = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente
    
        // Obter o membro pelo ID
        Membro membro = obterMembroPorId(projeto, idMembro);
    
        if (membro != null) {
            List<Doacao> doacoesMembro = membro.getDoacoes();
    
            if (doacoesMembro.isEmpty()) {
                System.out.println("O membro não fez nenhuma doação até o momento.");
            } else {
                System.out.println("Lista de Doações do Membro " + membro.getNome() + ":");
                for (Doacao doacao : doacoesMembro) {
                    System.out.println("ID da Doação: " + doacao.getId());
                    System.out.println("Setor da Doação: " + doacao.getSetor());
                    System.out.println("Valor da Doação: " + doacao.getValor());
                    System.out.println("Data da Doação: " + doacao.getData());
                    System.out.println("-----------");
                }
            }
        } else {
            System.out.println("Membro não encontrado.");
        }
    }
    


    // Método para fazer nova doação por membro existente
    private static void fazerNovaDoacaoMembroExistente(Scanner scanner, ProjetoSocial projeto) {
        System.out.println("\n===== Fazer Nova Doação por Membro Existente =====");
    
        // Obter o ID do membro
        System.out.print("Informe o ID do Membro: ");
        int idMembro = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente
    
        // Obter o membro pelo ID
        Membro membro = obterMembroPorId(projeto, idMembro);
    
        if (membro != null) {
            // Exibir os setores disponíveis
            System.out.println("\nEscolha o setor para a doação:");
            System.out.println("1. Meio Ambiente");
            System.out.println("2. Assistência a Idosos");
            System.out.println("3. Proteção aos Animais");
            System.out.println("4. Assistência a Pessoas em Situação de Vulnerabilidade Socioeconômica");
            System.out.println("5. Apoio a Pessoas com Deficiência");
    
            System.out.print("Escolha um setor: ");
            int escolhaSetor = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente
    
            // Mapear a escolha do setor para uma string correspondente
            String setor;
            switch (escolhaSetor) {
                case 1:
                    setor = "Meio Ambiente";
                    break;
                case 2:
                    setor = "Assistência a Idosos";
                    break;
                case 3:
                    setor = "Proteção aos Animais";
                    break;
                case 4:
                    setor = "Assistência a Pessoas em Situação de Vulnerabilidade Socioeconômica";
                    break;
                case 5:
                    setor = "Apoio a Pessoas com Deficiência";
                    break;
                default:
                    System.out.println("Escolha inválida. A doação será registrada sem setor específico.");
                    setor = "Sem Setor Específico";
                    break;
            }
    
            System.out.print("Informe o valor da doação: ");
            double valorDoacao = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha pendente
    
            // Realizar a nova doação com o setor escolhido
            membro.fazerNovaDoacao(valorDoacao, projeto, setor);
            System.out.println("Doação realizada com sucesso para o setor: " + setor);
        } else {
            System.out.println("Membro não encontrado.");
        }
    }
    
    // Método para obter um membro pelo ID
    private static Membro obterMembroPorId(ProjetoSocial projeto, int idMembro) {
        for (Membro membro : projeto.getMembros()) {
            if (membro.getId() == idMembro) {
                return membro;
            }
        }
        return null; // Retorna null se o membro não for encontrado
    }

   private static void gerenciarProjetosSociais(Scanner scanner, ProjetoSocial projeto) {
    System.out.println("\n===== Gerenciar Projetos Sociais para Membro =====");

    // Obter o ID do membro
    System.out.print("Informe o ID do Membro: ");
    int idMembro = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha pendente

    // Obter o membro pelo ID
    Membro membro = obterMembroPorId(projeto, idMembro);

    if (membro != null) {
        // Exibir os setores disponíveis de forma mais formal
        System.out.println("\nEscolha um setor para participar:");

        // Exibir os setores disponíveis
        System.out.println("1. Meio Ambiente");
        System.out.println("2. Assistência a Idosos");
        System.out.println("3. Proteção aos Animais");
        System.out.println("4. Assistência a Pessoas em Situação de Vulnerabilidade Socioeconômica");
        System.out.println("5. Apoio a Pessoas com Deficiência");

        System.out.print("Escolha um setor: ");
        int escolhaSetor = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente

        // Associar o membro ao setor escolhido
        switch (escolhaSetor) {
            case 1:
                membro.associarSetor("Meio Ambiente");
                break;
            case 2:
                membro.associarSetor("Assistência a Idosos");
                break;
            case 3:
                membro.associarSetor("Proteção aos Animais");
                break;
            case 4:
                membro.associarSetor("Assistência a Pessoas em Situação de Vulnerabilidade Socioeconômica");
                break;
            case 5:
                membro.associarSetor("Apoio a Pessoas com Deficiência");
                break;
            default:
                System.out.println("Escolha inválida.");
        }

        System.out.println("Membro associado ao setor com sucesso!");
    } else {
        System.out.println("Membro não encontrado.");
    }
}

private static void emitirRelatorio(Scanner scanner, ProjetoSocial projeto) {
    System.out.println("\n===== Emitir Relatório de Atividades de Membro =====");

    // Obter o ID do membro
    System.out.print("Informe o ID do Membro: ");
    int idMembro = scanner.nextInt();
    scanner.nextLine(); // Consumir a quebra de linha pendente

    // Obter o membro pelo ID
    Membro membro = obterMembroPorId(projeto, idMembro);

    if (membro != null) {
        // Exibir informações sobre o membro
        System.out.println("Relatório para o Membro " + membro.getNome() + " (ID: " + membro.getId() + "):");
        System.out.println("Email: " + membro.getEmail());
        System.out.println("Telefone: " + membro.getTelefone());
        System.out.println("Endereço: " + membro.getEndereco());

        // Exibir setores associados
        List<String> setoresAssociados = membro.getSetoresAssociados();
        if (!setoresAssociados.isEmpty()) {
            System.out.println("Setores Associados:");
            for (String setor : setoresAssociados) {
                System.out.println("- " + setor);
            }
        } else {
            System.out.println("O membro não está associado a nenhum setor.");
        }

        // Exibir doações feitas pelo membro
        List<Doacao> doacoesMembro = membro.getDoacoes();
        if (!doacoesMembro.isEmpty()) {
            System.out.println("Doações Realizadas:");
            for (Doacao doacao : doacoesMembro) {
                System.out.println("- Valor: " + doacao.getValor() + " | Data: " + doacao.getData());
            }
        } else {
            System.out.println("O membro não fez nenhuma doação até o momento.");
        }
    } else {
        System.out.println("Membro não encontrado.");
    }
}
}