import java.util.Scanner;

//Menu e onde irá nos dar direcionamento para todos os outros modulos do programa atráves do SWITCH

public class Menu {

    Scanner scan = new Scanner(System.in);
    int opcao = 0;

    public void MenuPrincipal(){
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

        switch(opcao){
            case 1:
                System.out.println("Cadastro de produtos");
                CadastroDeProdutos cad = new CadastroDeProdutos();
                System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
                System.out.println("SISTEMA DE CONTROLE DE ESTOQUE");
                System.out.println("CADASTRO DE PRODUTOS");
                System.out.println("1 - Inclusão");
                System.out.println("2 - Alteração");
                System.out.println("3 - Consulta");
                System.out.println("4 - Exclusão");
                System.out.println("0 - Retornar");
                System.out.print("Opção: ");
                int opcao2 = scan.nextInt();
                switch(opcao2){
                    case 1: cad.incluirProduto();
                    break;

                    case 2:
                        System.out.println("nada");
                    }
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
    }
}
