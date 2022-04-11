package com.santander.banco811.repository;

import com.santander.banco811.model.TipoTransacao;
import com.santander.banco811.model.Transacao;
import com.santander.banco811.projections.TransacaoView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {

    List<TransacaoView> findAllByTipoTransacao(TipoTransacao tipoTransacao);

    Page<Transacao> findAllByAgencia(Integer agencia, Pageable pageable);
}
