class FabricaPagamento {

    public static Pagamento criarPagamento(String tipo) {

        if(tipo.equalsIgnoreCase("pix")) {
            return new Pix();
        }

        if(tipo.equalsIgnoreCase("cartao")) {
            return new CartaoCredito();
        }

        if(tipo.equalsIgnoreCase("boleto")) {
            return new Boleto();
        }

        throw new IllegalArgumentException("Metodo de pagamento invalido");
    }
}
