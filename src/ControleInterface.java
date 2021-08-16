public interface ControleInterface {
    //Métodos especiais
    void incluirProduto();

    public String alterarProduto();
    public String consultarProduto();

    //Do tipo inteiro, pq ira procurar um indice no vetor e excluir.
    public int excluirProduto();

}
