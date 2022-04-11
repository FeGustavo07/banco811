package com.santander.banco811.service.Impl;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.projections.ContaView;
import com.santander.banco811.repository.ContaRepository;
import com.santander.banco811.repository.UsuarioRepository;
import com.santander.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public ContaResponse create(Integer id, ContaRequest contaRequest) {
        var usuario = usuarioRepository.findById(id).orElseThrow();
        Conta conta = new Conta();
        conta.setUsuario(usuario);
        conta.setTipoConta(contaRequest.getTipoConta());
        conta.setAgencia(contaRequest.getAgencia());
        conta.setNumero(contaRequest.getNumero());
        conta.setSaldo(contaRequest.getSaldo());
        contaRepository.save(conta);
        return new ContaResponse(conta);
    }

    @Override
    public ContaResponse update(ContaRequest contaRequest, Integer id) {
        Conta conta = contaRepository.findById(id).orElseThrow();
        conta.setTipoConta(contaRequest.getTipoConta());
        conta.setAgencia(contaRequest.getAgencia());
        conta.setNumero(contaRequest.getNumero());
        conta.setSaldo(contaRequest.getSaldo());
        contaRepository.save(conta);
        return new ContaResponse(conta);
    }

    @Override
    public List<ContaResponse> getAll() {
        return ContaResponse.toResponse(
                contaRepository.findAll()
        );
    }

    @Override
    public List<ContaView> getAllViewByTipoConta(TipoConta tipoConta) {
        return contaRepository.findAllByTipoConta(tipoConta);
    }

    @Override
    public ContaResponse getById(Integer id) {
        Conta conta = contaRepository.findById(id).orElseThrow();
        return new ContaResponse(conta);
    }

    @Override
    public void delete(Integer id) {
        Conta conta = contaRepository.findById(id).orElseThrow();
        contaRepository.delete(conta);
    }
}
