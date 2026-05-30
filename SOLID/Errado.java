SRP
ERRADO:
Fechar e dividir a conta de um restaurante. Uma classe para fazer a validação, o cálculo e a impressão.
class ContaRestaurante {
    void fechar(double valor, int pessoas) {
        if (valor <= 0) throw new IllegalArgumentException("Valor inválido");
        double total = valor * 1.10; // com os 10% serviço do trabalho do garçom né
        double porPessoa = total / pessoas;
        System.out.println("Salvando no caixa...");
        System.out.println("Cupom: R$ " + porPessoa + " por pessoa");
    }
}

