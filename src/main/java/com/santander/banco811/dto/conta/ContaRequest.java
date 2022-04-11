package com.santander.banco811.dto.conta;

import com.santander.banco811.dto.usuario.UsuarioRequest;
import com.santander.banco811.model.TipoConta;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
public class ContaRequest {
    private Integer numero;
    private Integer agencia;
    private BigDecimal saldo;
    private TipoConta tipoConta;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private UsuarioRequest usuario;
}
