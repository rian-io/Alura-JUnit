package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private Funcionario funcionario;
    private ReajusteService service;

    @BeforeEach
    public void init() {
        funcionario = new Funcionario("nome", LocalDate.now(), new BigDecimal(1_000));
        service = new ReajusteService();
    }

    @Test
    public void testaReajusteDeTresPorcentoQuandoADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void testaReajusteDeQuinzePorcentoQuandoBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario().setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void testaReajusteDeVintePorcentoQuandoOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario().setScale(2, RoundingMode.HALF_UP));
    }
}
