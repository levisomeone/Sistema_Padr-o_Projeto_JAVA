class Boleto implements Pagamento {

    @Override
    public void pagar(double valor) {
        System.out.println("Boleto gerado no valor de R$" + valor);
    }
}
