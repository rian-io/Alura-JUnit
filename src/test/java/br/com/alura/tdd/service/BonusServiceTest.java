package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;


public class BonusServiceTest {

    private static BonusService service;
    private Funcionario funcionario;

    @BeforeAll
    public static void init() {
        service = new BonusService();
    }

    @Test
    public void testarBonusZeroParaSalarioAcimaDeDezMil() {
        init();
        this.funcionario = new Funcionario("Marina", LocalDate.now(), BigDecimal.valueOf(11_000));
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(funcionario));
    }

    @Test
    public void testarBonusDeDezPorcentoParaSalarioAbaixoDeDezMil() {
        init();
        this.funcionario = new Funcionario("Marina", LocalDate.now(), BigDecimal.valueOf(2_500));
        BigDecimal bonus = service.calcularBonus(funcionario);
        Assertions.assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void testarBonusDeDezPorcentoParaSalarioIgualADezMil() {
        init();
        this.funcionario = new Funcionario("Marina", LocalDate.now(), BigDecimal.valueOf(10_000));
        BigDecimal bonus = service.calcularBonus(funcionario);
        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
