package com.med.voll.api.controller;

import com.med.voll.api.dto.MedicoRequest;
import com.med.voll.api.model.Medico;
import com.med.voll.api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    public ResponseEntity cadastrarMedico(@RequestBody @Valid MedicoRequest medicoRequest){
    return ResponseEntity.ok(medicoRepository.save(new Medico(medicoRequest))) ;
    }
}
