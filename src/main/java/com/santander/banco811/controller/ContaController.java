package com.santander.banco811.controller;

import com.santander.banco811.dto.conta.ContaRequest;
import com.santander.banco811.dto.conta.ContaResponse;
import com.santander.banco811.model.TipoConta;
import com.santander.banco811.projections.ContaView;
import com.santander.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ContaResponse create(@PathVariable Integer id, @RequestBody ContaRequest contaRequest) {
        return contaService.create(id, contaRequest);
    }

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContaResponse update(@PathVariable Integer id, @RequestBody ContaRequest contaRequest) {
        return contaService.update(contaRequest, id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContaResponse> getAll() {
        return contaService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContaResponse getById(@PathVariable Integer id) {
        return contaService.getById(id);
    }

    @GetMapping("/view")
    @ResponseStatus(HttpStatus.OK)
    public List<ContaView> getAllContaViewByTipoConta(@RequestParam TipoConta tipoConta) {
        return contaService.getAllViewByTipoConta(tipoConta);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id) {
        contaService.delete(id);
    }
}
