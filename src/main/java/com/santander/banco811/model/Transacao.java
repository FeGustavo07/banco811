package com.santander.banco811.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "transacao")
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class Transacao {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "agencia", nullable = false)
    private Integer agencia;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "tipo_transacao", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoTransacao tipoTransacao;

    @Column(name = "data_criacao")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "conta_id", referencedColumnName = "id")
    private Conta conta;
}
