package com.santander.banco811.dto.conta;

import com.santander.banco811.dto.usuario.UsuarioResponse;
import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.model.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class ContaResponse {
    private Integer id;
    private Integer numero;
    private Integer agencia;
    private BigDecimal saldo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private TipoConta tipoConta;
    private UsuarioResponse usuario;

    public ContaResponse(Conta conta) {
        this.id = conta.getId();
        this.numero = conta.getNumero();
        this.agencia = conta.getAgencia();
        this.dataAtualizacao = conta.getDataAtualizacao();
        this.dataCriacao = conta.getDataCriacao();
        this.saldo = conta.getSaldo();
        this.tipoConta = conta.getTipoConta();
        this.usuario = new UsuarioResponse(conta.getUsuario());
    }

    public static List<ContaResponse> toResponse(List<Conta> contas) {
        return contas.stream().map(ContaResponse::new).collect(Collectors.toList());
    }
}
