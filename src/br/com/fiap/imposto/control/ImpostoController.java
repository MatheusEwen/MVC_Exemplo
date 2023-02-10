package br.com.fiap.imposto.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.fiap.imposto.model.Imposto;
import br.com.fiap.imposto.view.TelaDeImposto;

//ImpostoController implementa ActionListener para capturar
//o evento do botão da view
public class ImpostoController implements ActionListener{

    //O Controller possui referências a Imposto e a tela
    //é reutilizavel para telas que calculem Impostos
    //ou seja, classes que implementam estas interfaces

    private Imposto model;
    private TelaDeImposto view;


    public ImpostoController(Imposto model, TelaDeImposto view) {
        System.out.println("Construtor do controller chamado");
        this.model = model;
        this.view = view;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        model.calcularImposto(view.getValor());

    }

}
