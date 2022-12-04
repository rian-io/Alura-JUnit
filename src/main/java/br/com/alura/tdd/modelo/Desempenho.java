package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR(BigDecimal.valueOf(0.03)),
    BOM(BigDecimal.valueOf(0.15)),
    OTIMO(BigDecimal.valueOf(0.20));

    private BigDecimal percentualReajuste;

    Desempenho(BigDecimal percentualReajuste) {
        this.percentualReajuste = percentualReajuste;
    }

    public BigDecimal percentualReajuste() {
        return this.percentualReajuste;
    }
}
