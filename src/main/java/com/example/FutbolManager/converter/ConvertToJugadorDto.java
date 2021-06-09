package com.example.FutbolManager.converter;

import com.example.FutbolManager.models.Jugador;
import com.example.FutbolManager.models.dto.JugadorDto;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ConvertToJugadorDto implements Converter<Jugador, JugadorDto> {

    private final ModelMapper modelMapper;

    public ConvertToJugadorDto(final ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public JugadorDto convert(Jugador source){
        return modelMapper.map(source, JugadorDto.class);
    }

}