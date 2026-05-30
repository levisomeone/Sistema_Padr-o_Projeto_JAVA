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


OCP
Exemplo ruim (ERRADO)
Checkout de loja com if/else para cada nova forma de pagamento.

class Checkout {
    void pagar(String tipo) {
        if (tipo.equals("cartao")) System.out.println("Cobrando cartão...");
        else if (tipo.equals("pix")) System.out.println("Gerando QR Code...");
        // Toda nova forma exige alterar esta classe
    }
}

Exemplo correto (CORRIGIDO)
Uso de interface para estender sem modificar o núcleo
interface MetodoPagamento { void processar(); }

class Cartao implements MetodoPagamento { 
    public void processar() { System.out.println("Cobrando cartão..."); } 
}
class Pix implements MetodoPagamento { 
    public void processar() { System.out.println("Gerando QR Code..."); } 
}
// Uso: checkout.pagar(new Pix());

LSP
ERRADO:
Classe Ave com voar(). Pinguim herda mas não voa

class Ave { void voar() { System.out.println("Voando..."); } }

class Pinguim extends Ave {
    @Override void voar() { 
        throw new RuntimeException("Pinguins não voam!"); 
    }
}


CERTO:
Separação por comportamento real, sem forçar herança inadequada

class Animal { void mover() { System.out.println("Andando..."); } }

class AveVoadora extends Animal { 
    void voar() { System.out.println("Voando..."); } 
}
class Pinguim extends Animal { 
    void nadar() { System.out.println("Nadando..."); } 
}

ISP
Exemplo ruim (ERRADO)
No exemplo abaixo, a interface obriga todas as classes a implementarem métodos de voo, mesmo que alguns objetos não consigam voar.
interface Animal {
    void comer();
    void voar();
}
class Cachorro implements Animal {
    public void comer() {
        System.out.println("Cachorro comendo");
    }
    public void voar() {
        System.out.println("Cachorro nao voa");
    }
    //Nesse caso, o método voar() não faz sentido para a classe Cachorro, mas ela foi obrigada a implementá-lo por causa da interface grande demais.
}

interface Animal {
    void comer();
}
interface AnimalVoador {
    void voar();
}
class Cachorro implements Animal {
    public void comer() {
        System.out.println("Cachorro comendo");
    } }
class Passaro implements Animal, AnimalVoador {
    public void comer() {
        System.out.println("Passaro comendo");
    }
    public void voar() {
        System.out.println("Passaro voando");
        //Agora cada classe implementa apenas os métodos que realmente precisa utilizar.
    } 
}

DIP
Exemplo ruim (ERRADO)
Nesse exemplo, a classe Computador depende diretamente da classe Teclado.
class Teclado {
    public void conectar() {
        System.out.println("Teclado conectado");
    } }
class Computador {
    private Teclado teclado = new Teclado();
    public void iniciar() {
        teclado.conectar();
        //O problema é que, caso o sistema precise trocar o teclado futuramente, 
        //será necessário alterar diretamente a classe Computador, Aumenta desnecessariamente o acoplamento.
    }
}

Exemplo correto (CORRIGIDO)
Agora o sistema utiliza uma abstração através de interface.
interface Dispositivo {
    void conectar();
}
class Teclado implements Dispositivo {
    public void conectar() {
        System.out.println("Teclado conectado");
    } }
class Mouse implements Dispositivo {
    public void conectar() {
        System.out.println("Mouse conectado");
    } }
class Computador {
    private Dispositivo dispositivo;
    public Computador(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
    public void iniciar() {
        dispositivo.conectar();
        //Agora a classe Computador depende apenas da interface Dispositivo, 
        //podendo trabalhar com diferentes implementações sem necessidade de alterações internas.
    }
}
