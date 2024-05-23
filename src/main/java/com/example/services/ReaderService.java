package com.example.services;

import com.example.dto.readers.InputReaderDTO;
import com.example.dto.readers.OutputReaderDTO;
import com.example.mappers.ReaderMapper;
import com.example.repositories.ReaderRepository;

import java.util.List;

public class ReaderService {
    private final ReaderRepository readerRepository = new ReaderRepository();
    private final ReaderMapper readerMapper = new ReaderMapper();

    public List<OutputReaderDTO> findAllReaders() {
        var readers = readerRepository.findAll();
        return readers.stream()
                .map(readerMapper::map)
                .toList();
    }
    
    public OutputReaderDTO createReader(InputReaderDTO inputReaderDTO) {
        var reader = readerMapper.map(inputReaderDTO);
        readerRepository.save(reader);
        return readerMapper.map(reader);
    }

    public OutputReaderDTO findReader(Long id) {
        var reader = readerRepository.findById(id);
        return readerMapper.map(reader);
    }

    public OutputReaderDTO updateReader(InputReaderDTO inputReaderDTO, Long id) {
        var reader = readerRepository.findById(id);
        readerMapper.update(inputReaderDTO, reader);
        readerRepository.update(reader);
        return readerMapper.map(reader);
    }

    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }
}
