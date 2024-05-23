package com.example.mappers;

import com.example.dto.readers.InputReaderDTO;
import com.example.dto.readers.OutputReaderDTO;
import com.example.models.Reader;

public class ReaderMapper {
    public Reader map(InputReaderDTO dto) {
        var model = new Reader();
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setPhoneNumber(dto.getPhoneNumber());
        model.setEmail(dto.getEmail());
        model.setAddress(dto.getAddress());
        return model;
    }

    public OutputReaderDTO map(Reader model) {
        var dto = new OutputReaderDTO();
        dto.setId(model.getId());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setPhoneNumber(model.getPhoneNumber());
        dto.setEmail(model.getEmail());
        dto.setAddress(model.getAddress());
        return dto;
    }

    public void update(InputReaderDTO dto, Reader model) {
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setPhoneNumber(dto.getPhoneNumber());
        model.setEmail(dto.getEmail());
        model.setAddress(dto.getAddress());
    }
}
