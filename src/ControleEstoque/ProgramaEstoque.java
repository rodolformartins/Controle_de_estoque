package ControleEstoque;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaEstoque {

    private Produtos prodList[] = new Produtos[10];
    private int posicaoAtual = 0;


    public static void main(String[] args) {
        ProgramaEstoque aplicacao = new ProgramaEstoque();
        aplicacao.refMenu();
        aplicacao.menuPrincipal();
    }

    private void menuPrincipal() {
        int opcao = 0;
        do {
            opcao = opcaoMenuPadrao();
            switch (opcao) {
                case 1:
                    menuCadastroProdutos();
                    break;
                case 2:
                    menuMovimentacao();
                    break;
                case 3:
                    relatorioDeProdutos();
                    break;
                case 0:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    opcaoInvalida();
                    break;
            }
        } while (opcao != 0);
    }


    private void relatorioDeProdutos() {
        this.refMenu();
        System.out.println("RELATÓRIO");
        for (int i = 0; i < posicaoAtual; i++) {
            System.out.println("\n");
            System.out.println("Produtos: \n" + "Código: " +
                    i + "\n" +
                    prodList[i]);

        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println("APERTE QUALQUER CARACTERE + ENTER PARA CONTINUAR");
        scanner.next();
    }


    private void menuMovimentacao() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ALTERAÇAO DOS PRODUTOS");
        System.out.println("1 - ENTRADA\n" +
                "2 - SAÍDA\n" +
                "0 - RETORNAR\n" +
                "OPÇÃO  : \n");
        int opcaoMovimentacao = scanner.nextInt();
        switch (opcaoMovimentacao) {
            case 1:
                compraProdutos();
                break;
            case 2:
                saidaProdutos();
                break;
            case 0:
                System.out.println("Retornando para o menu");
                break;
            default:
                opcaoInvalida();
                break;
        }
    }

    private void saidaProdutos() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Venda dos produtos");
            System.out.println("Nome do produto");
            String nomeProduto = scanner.nextLine();

            boolean controle = true;
            for (int i = 0; i < posicaoAtual; i++) {
                if (nomeProduto.equalsIgnoreCase(prodList[i].getNome())) {
                    controle=false;
                    Produtos produtosMovimentacao = prodList[i];
                    System.out.println("QTDE ATUAL : " + produtosMovimentacao.getQuantidade());
                    System.out.println("QTDE SAÍDA : ");
                    int quantidadeSaida = scanner.nextInt();
                    System.out.println("QTDE FINAL : " + (produtosMovimentacao.getQuantidade() - quantidadeSaida));
                    if (produtosMovimentacao.getQuantidade() < quantidadeSaida) {
                        System.out.println("Quantidade maior que no estoque, saída não é possível");
                        break;
                    }
                    escolha = confirmaOperacao();
                    if (escolha.equalsIgnoreCase("S")) {
                        produtosMovimentacao.setDiminuirQuantidade(quantidadeSaida);
                        prodList[i] = produtosMovimentacao;
                    }
                    break;
                }
            }
            mensagemConsultaNaoEncontrada(controle);
            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void compraProdutos() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("COMPRA DE PRODUTOS");
            System.out.println("Nome do produto");
            String nomeMantimento = scanner.nextLine();
            Produtos produtosMovimentacao;
            boolean controle=true;
            for (int i = 0; i < posicaoAtual; i++) {
                if (nomeMantimento.equalsIgnoreCase(prodList[i].getNome())) {
                    controle=false;
                    produtosMovimentacao = prodList[i];
                    System.out.println("QTDE ATUAL : " + produtosMovimentacao.getQuantidade());
                    System.out.println("QTDE ENTRADA : ");
                    int quantidadeEntrada = scanner.nextInt();
                    System.out.println("QTDE FINAL : " + (produtosMovimentacao.getQuantidade() + quantidadeEntrada));
                    escolha = confirmaOperacao();
                    if (escolha.equalsIgnoreCase("S")) {
                        produtosMovimentacao.setAdicionarQuantidade(quantidadeEntrada);
                        prodList[i] = produtosMovimentacao;
                    }
                    break;
                }
            }
            mensagemConsultaNaoEncontrada(controle);

            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void opcaoInvalida() {
        System.out.println("Opção inválida");
    }

    private int opcaoMenuPadrao() {
        int opcao;
        System.out.println("**** MENU PRINCIPAL ****\n" +
                "\n1 - CADASTRO DE PRODUTOS\n" +
                "2 - MOVIMENTAÇÕES\n" +
                "3 - RELATÓRIOS\n" +
                "0 - FINALIZAR\n");
        System.out.print("OPÇÃO: ");
        opcao = getEscolhaMenu();
        return opcao;
    }

    private void menuCadastroProdutos() {
        int opcao;
        this.refMenu();
        System.out.println("**** CADASTRO DE PRODUTOS ****");
        System.out.println("\n1 - INCLUSÃO\n" +
                "2 - ALTERAÇÃO\n" +
                "3 - CONSULTA\n" +
                "4 - EXCLUSÃO\n" +
                "0 - RETORNAR");
        System.out.print("\nOPÇÃO: ");
        opcao = getEscolhaMenu();
        switch (opcao) {
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                alterarProduto();
                break;
            case 3:
                consultarProduto();
                break;
            case 4:
                excluirProduto();
                break;
            default:
                opcaoInvalida();
                break;
        }
    }


    private void excluirProduto() {

        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            this.refMenu();
            System.out.println("EXCLUSÃO DE PRODUTOS");
            System.out.println("Informe o nome do produto para pesquisa");
            String nomeConsulta = scanner.nextLine();
            boolean controle = true;
            ArrayList<Produtos> arrayList = new ArrayList();
            arrayList.add(new Produtos());
            for (int i = 0; i < posicaoAtual; i++) {
                scanner = new Scanner(System.in);
                Produtos produtos = arrayList.get(i);
                if (nomeConsulta.equalsIgnoreCase(prodList[i].getNome())) {
                    controle=false;
                    System.out.println(prodList[i].toString());
                    System.out.println("CONFIRMA EXCLUSÃO ( S/N ) ?");
                    escolha = scanner.next();
                    if (escolha.equalsIgnoreCase("S")) {
                        for (int j = i; j < posicaoAtual - 1; j++) {
                            prodList[j] = prodList[j + 1];
                            posicaoAtual--;

                        }


                    }
                    break;
                }
            }
            mensagemConsultaNaoEncontrada(controle);
            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }



    private void consultarProduto() {

        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            this.refMenu();
            System.out.println("CONSULTA DE PRODUTOS");
            System.out.println("Informe o nome do produto para pesquisa");
            String nomeConsulta = scanner.nextLine();
            boolean controle=true;
            for (int i = 0; i < posicaoAtual; i++) {
                if (nomeConsulta.equalsIgnoreCase(prodList[i].getNome())) {
                    controle=false;
                    System.out.println(prodList[i].toString());
                    break;
                }
            }
            mensagemConsultaNaoEncontrada(controle);
            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void alterarProduto() {
        String escolha;
        do {
            Scanner scanner = new Scanner(System.in);
            this.refMenu();
            System.out.println("ALTERAÇÃO DE PRODUTO");
            System.out.println("Informe o nome do produto para alterar");
            String nomeConsulta = scanner.nextLine();
            boolean controle=true;
            for (int i = 0; i < posicaoAtual; i++) {

                if (nomeConsulta.equalsIgnoreCase(prodList[i].getNome())) {
                    controle=false;
                    System.out.println("PRODUTO ENCONTRADO\n");
                    Produtos produtos = setDadosDoProduto();
                    escolha = confirmaOperacao();
                    if (escolha.equalsIgnoreCase("S")) {
                        prodList[i] = produtos;
                    }
                    break;
                }
            }
            mensagemConsultaNaoEncontrada(controle);
            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }

    private void mensagemConsultaNaoEncontrada(boolean controle) {
        if (controle) {
            System.out.println("Produto não encontrado");
        }
    }

    private void cadastrarProdutos() {
        String escolha;
        do {
            this.refMenu();

            System.out.println("**** INCLUSÃO DE PRODUTOS ****");
            Produtos produtos = setDadosDoProduto();
            escolha = confirmaOperacao();
            if (escolha.equalsIgnoreCase("S")) {
                prodList[posicaoAtual] = produtos;
                posicaoAtual++;
            }
            escolha = getRepetirOperacao();

        } while (escolha.equalsIgnoreCase("S"));
    }


    private Produtos setDadosDoProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nInforme o nome do produto");
        String nome = scanner.nextLine();
        System.out.println("Informe a unidade de medida");
        scanner = new Scanner(System.in);
        String unidade = scanner.nextLine();
        System.out.println("Informe a quantidade");
        int quantidade = scanner.nextInt();
        System.out.println("Informe o preço");
        float preco = scanner.nextFloat();

        Produtos produtos = new Produtos();
        produtos.setNome(nome);
        produtos.setUnidade(unidade);
        produtos.setPreco(preco);
        produtos.setQuantidade(quantidade);
        return produtos;
    }


    private String getRepetirOperacao() {
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.print("\nREPETIR OPERAÇÃO ( S/N ) ? ");
        escolha = scanner.next();
        return escolha;
    }

    private String confirmaOperacao() {
        Scanner scanner = new Scanner(System.in);
        String escolha;
        System.out.print("CONFIRMA ALTERACAO ( S/N )?_");
        escolha = scanner.next();
        return escolha;
    }

    private int getEscolhaMenu() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }

    private void refMenu() {
        System.out.println("\nEMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.\nSISTEMA DE CONTROLE DE ESTOQUE");
    }




}