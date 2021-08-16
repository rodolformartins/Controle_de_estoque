import java.util.Scanner;


public class CadastroDeProdutos implements ControleInterface {
    //Atributos
        private String nomeProduto;
        private float precoUnitario;
        private String unidade;
        private int quantidade;


        Scanner scan = new Scanner(System.in);

    //Métodos getters and setters
        public String getNomeProduto() {
            return nomeProduto;
        }

        public void setNomeProduto(String nomeProduto) {
            this.nomeProduto = nomeProduto;
        }

        public float getPrecoUnitario(){
            return precoUnitario;
        }

        public void setPrecoUnitario(float precoUnitario){
            this.precoUnitario = precoUnitario;
        }

        public String getUnidade(){
            return unidade;
        }

        public void setUnidade(String unidade){
            this.unidade = unidade;
        }

        public int getQuantidade(){
            return quantidade;
        }

        public void setQuantidade(int quantidade){
            this.quantidade = quantidade;
        }



    //Métodos especiais
    @Override
    public void incluirProduto() {
        System.out.println("Qual nome do produto?");
        setNomeProduto(scan.next());
        System.out.println("Qual preço unitário do produto?");
        this.setPrecoUnitario(scan.nextFloat());
        System.out.println("Qual tipo de unidade do produto? (KG, UN)");
        this.setUnidade(scan.next());
        System.out.println("Qual a quantidade a ser adicionada?");
        this.setQuantidade(scan.nextInt());
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
