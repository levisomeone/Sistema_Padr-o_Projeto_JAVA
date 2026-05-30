CERTO:
Cada classe cuida apenas da sua própria  responsabilidade.
class ValidadorValor {
    boolean isValid(double v) { return v > 0; }
}

class CalculadoraConta {
    double dividir(double total, int pessoas) { return (total * 1.10) / pessoas; }
}

class ImpressoraCupom {
    void emitir(double valor) { System.out.println("Cupom: R$ " + valor); }
}
