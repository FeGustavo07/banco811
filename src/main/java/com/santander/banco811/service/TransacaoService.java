package com.santander.banco811.service;

import com.santander.banco811.dto.transacao.TransacaoRequest;
import com.santander.banco811.dto.transacao.TransacaoResponse;
import com.santander.banco811.model.TipoTransacao;
import com.santander.banco811.model.Transacao;
import com.santander.banco811.projections.TransacaoView;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TransacaoService {

    TransacaoResponse create(Integer id, TransacaoRequest transacaoRequest);

    TransacaoResponse update(Integer id, TransacaoRequest transacaoRequest);

    Page<Transacao> getAll(Integer agencia, int pagina, int tamanho);

    List<TransacaoView> getAllByTipoTransacao(TipoTransacao tipoTransacao);

    TransacaoResponse getById(Integer id);

    void delete(Integer id);
}
