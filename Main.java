import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== SISTEMA DE PAGAMENTO ===");

        System.out.print("Digite o nome do produto: ");
        String produto = sc.nextLine();

        System.out.print("Digite o valor do produto: ");
        double valor = sc.nextDouble();

        sc.nextLine();

        System.out.println("Escolha o pagamento:");
        System.out.println("pix");
        System.out.println("cartao");
        System.out.println("boleto");

        String tipoPagamento = sc.nextLine();

        Pagamento pagamento =
            FabricaPagamento.criarPagamento(tipoPagamento);

        Pedido pedido =
            new Pedido(produto, valor, pagamento);

        pedido.finalizarPedido();

        sc.close();
    }
}
