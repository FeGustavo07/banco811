package com.santander.banco811.service;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.projections.ContaView;

import java.util.List;

public interface ContaService {

    ContaResponse create(Integer id, ContaRequest contaRequest);

    ContaResponse update(ContaRequest contaRequest, Integer id);

    List<ContaResponse> getAll();

    List<ContaView> getAllViewByTipoConta(TipoConta tipoConta);

    ContaResponse getById(Integer id);

    void delete(Integer id);
}
