package com.med.voll.api.controller;

import com.med.voll.api.dto.MedicoRequest;
import com.med.voll.api.dto.MedicoResponse;
import com.med.voll.api.model.Medico;
import com.med.voll.api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    public ResponseEntity cadastrarMedico(@RequestBody @Valid MedicoRequest medicoRequest) {
        Medico medico = medicoRepository.save(new Medico(medicoRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(new MedicoResponse(medico));
    }

    @GetMapping
    public ResponseEntity getAllMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll(pageable).map(MedicoResponse::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity getMedico(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findById(id));
    }
}
