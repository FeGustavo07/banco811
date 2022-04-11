package com.santander.banco811.repository;

import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.projections.ContaView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

    @Query("select c from Conta c where " +
            "(c.tipoConta = :tipoConta and c.usuario.cpf = :cpf) " +
            "or (c.tipoConta = :tipoConta and c.saldo = :saldo)")
    List<Conta> findByTipoContaAndCpfOrTipoContaAndSaldo(
            @Param("tipoConta") TipoConta tipoConta,
            @Param("cpf") String cpf,
            @Param("saldo") BigDecimal saldo);

    List<ContaView> findAllByTipoConta(TipoConta tipoConta);
}
