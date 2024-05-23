package com.example.controllers;

import com.example.dto.readers.InputReaderDTO;
import com.example.dto.readers.OutputReaderDTO;
import com.example.services.ReaderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderService readerService = new ReaderService();

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OutputReaderDTO> getList() {
        return readerService.findAllReaders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OutputReaderDTO create(@Valid @RequestBody InputReaderDTO readerData) {
        return readerService.createReader(readerData);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OutputReaderDTO show(@PathVariable Long id) {
        return readerService.findReader(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OutputReaderDTO update(@RequestBody @Valid InputReaderDTO readerData, @PathVariable Long id) {
        return readerService.updateReader(readerData, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        readerService.deleteReader(id);
    }
}
