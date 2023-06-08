package com.med.voll.api.model;

import com.med.voll.api.dto.MedicoRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoRequest medicoRequest) {
        this.nome = medicoRequest.nome();
        this.email = medicoRequest.email();
        this.telefone = medicoRequest.telefone();
        this.crm = medicoRequest.crm();
        this.especialidade = medicoRequest.especialidade();
        this.endereco = new Endereco(medicoRequest.endereco());
    }
}
