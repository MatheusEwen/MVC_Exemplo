package br.com.fiap.imposto.model;

import java.util.Observable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.fiap.imposto.config.ConfigSingleton;


//MOdel é um Observable
//A Classe Pis da camada model não possui referência a View ou ao  controller
//Ao implementar Imposto, teremos maior flexibilidade no controller
public class Pis extends Observable implements Imposto{

    private static final Logger logger = LogManager.getLogger(Pis.class);
    private final float ALIQUOTA;
    private float valorDoPis = 0;



    public Pis() {
        ALIQUOTA = Float.parseFloat(ConfigSingleton.getInstance().getProperty("aliquota"));
    }




    public float getValorDoPis() {
        return valorDoPis;
    }

    public float getALIQUOTA() {
        return ALIQUOTA;
    }

    @Override
    public void calcularImposto(float valor) {

        valorDoPis = valor * ALIQUOTA;
        //setChanged Altera o estado interno do objeto
        //para true, pois houve alteração no estado valorDoPis

        setChanged();
        logger.info("Calculando Imposto");
        //os observadores devem ser notificados
        //envia o valor do PIS COMO PARTE DA MENSAGEM
        //notificação para a view que é um observer
        notifyObservers(valorDoPis);


    }

    @Override
    public String toString() {
        return "Pis [ALIQUOTA=" + ALIQUOTA + ", valorDoPis=" + valorDoPis + "]";
    }


}
