import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        //Instanciando os objetos
        Produtos prod = new Produtos();



        //Chamando o scanner
        Scanner scan = new Scanner(System.in);
        int opcao = 0;

        //Variavel para loop do-while
        int opic = 1;

        do {
            System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
            System.out.println("SISTEMA DE CONTROLE DE ESTOQUE");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1 - Cadastro de produtos");
            System.out.println("2 - Movimentação de produtos");
            System.out.println("3 - Reajuste de preços");
            System.out.println("4 - Relatórios");
            System.out.println("0 - Finalizar");
            System.out.print("Opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de produtos");
                    System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
                    System.out.println("SISTEMA DE CONTROLE DE ESTOQUE");
                    System.out.println("\nMENU - CADASTRO DE PRODUTOS");
                    System.out.println("1 - Inclusão");
                    System.out.println("2 - Alteração");
                    System.out.println("3 - Consulta");
                    System.out.println("4 - Exclusão");
                    System.out.println("0 - Retornar");
                    System.out.print("Opção: ");
                    int opcao2 = scan.nextInt();

                    //Entra no submenu de inclusão
                    switch (opcao2) {
                        case 1:
                            prod.incluirProduto();
                            break;
                        case 2:
                            System.out.println("Movimentação de produtos");
                            break;
                        case 3:
                            System.out.println("Reajuste de preços");
                            break;
                        case 4:
                            System.out.println("Emitir relatorios");
                            break;
                        case 0:
                            System.out.println("Finalizando programa");
                            return;
                    }
                    System.out.println("Quer retornar ao menu superior? se sim digite 1, para finalizar digite 0");
                    System.out.print("Opção: ");
                    opic = scan.nextInt();

                case 0:
                    System.out.println("O programa foi finalizado!!");
                    return;

            }

        } while (opic == 1);


    }
}

