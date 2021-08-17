import java.util.Scanner;


    public class Produtos implements ControleInterface {
        //Atributos
        private String nomeProduto;
        private float precoUnitario;
        private String unidade;
        private int quantidade;
        private Object Produtos;

        //Construtor
        public Produtos() {
            nomeProduto = " ";
            precoUnitario = 0.0f;
            unidade = " ";
            quantidade = 0;
        }

        //Inicializando vetor
        //Criando o vetor para armazenar os produtos








        Scanner scan = new Scanner(System.in);

        //Métodos getters and setters
        public String getNomeProduto() {
            return nomeProduto;
        }

        public void setNomeProduto(String nomeProduto) {
            this.nomeProduto = nomeProduto;
        }

        public float getPrecoUnitario() {
            return precoUnitario;
        }

        public void setPrecoUnitario(float precoUnitario) {
            this.precoUnitario = precoUnitario;
        }

        public String getUnidade() {
            return unidade;
        }

        public void setUnidade(String unidade) {
            this.unidade = unidade;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }


        //Métodos especiais
        @Override
        public Produtos incluirProduto() {
            Produtos prods = new Produtos();
            System.out.println("Voce realmente quer incluir um novo produto? Se sim digite 1, se não digite 0");
            int opcao = 0;
            opcao = scan.nextInt();

           if (opcao == 1) {
                for(int i = 0; i <= 10; i++) {
                    System.out.println("Qual nome do produto?");
                    prods.setNomeProduto(scan.next());
                    System.out.println("Qual preço unitário do produto?");
                    prods.setPrecoUnitario(scan.nextFloat());
                    System.out.println("Qual tipo de unidade do produto? (KG, UN)");
                    prods.setUnidade(scan.next());
                    System.out.println("Qual a quantidade a ser adicionada?");
                    prods.setQuantidade(scan.nextInt());
                    System.out.println("Voce realmente quer incluir um novo produto? Se sim digite 1, se não digite 0");
                    opcao = scan.nextInt();
                    if(opcao != 1){
                        break;
                    }
                }
                System.out.println("Para confirmar saida do menu digite 0");
                opcao = scan.nextInt();
            }
            //Laco para armazenar os dados dos produtos
            return prods;
        }




    @Override
    public String alterarProduto() {
        return null;
    }

    @Override
    public String consultarProduto() {
        return null;
    }

    @Override
    public int excluirProduto() {
        return 0;
    }

}


/* Funcao para exibir nome de todos os produtos
        for(int i = 0; i < 10; i++) {
        System.out.println(prods[i].getNomeProduto());
        } */