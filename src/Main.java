import br.com.fiap.imposto.control.ImpostoController;
import br.com.fiap.imposto.model.Pis;
import br.com.fiap.imposto.view.CalculaPis;

public class Main {
    public static void main(String[] args) {
        Pis modelPis = new Pis();
        CalculaPis viewCalculaPis = new CalculaPis();

        // Adiciona um observador para o objeto observado Pis
        modelPis.addObserver(viewCalculaPis);

        // Instancia um Controller e informa quem ele controlarĂ¡
        ImpostoController controller = new ImpostoController(modelPis, viewCalculaPis);

        // Envia o controller criado para a View
        viewCalculaPis.addController(controller);
    }
}