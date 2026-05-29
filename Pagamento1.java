class Pedido {

    private String produto;
    private double valor;
    private Pagamento pagamento;

    public Pedido(String produto, double valor, Pagamento pagamento) {
        this.produto = produto;
        this.valor = valor;
        this.pagamento = pagamento;
    }

    public void finalizarPedido() {

        System.out.println("Produto: " + produto);
        System.out.println("Valor: R$" + valor);

        pagamento.pagar(valor);

        System.out.println("Pedido finalizado");
    }
}
