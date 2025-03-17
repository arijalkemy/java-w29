package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JoyaDto;
import com.example.joyerialasperlas.dto.in.JoyaIdDto;
import com.example.joyerialasperlas.dto.out.EditadoDto;
import com.example.joyerialasperlas.dto.out.MessageDto;
import com.example.joyerialasperlas.exception.DataIntegrityViolationException;
import com.example.joyerialasperlas.model.Joya;
import com.example.joyerialasperlas.repository.IJoyaRepository;
import jakarta.transaction.Transactional;
import org.hibernate.PropertyValueException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JoyaService implements IJoyaService{
    private final IJoyaRepository iJoyaRepository;
    private final ModelMapper modelMapper;

    public JoyaService(IJoyaRepository joyaRepository){
        this.iJoyaRepository = joyaRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    @Transactional
    public MessageDto addJewerly(JoyaDto joyaDto) {
        Joya joya;
        try{
            joya = modelMapper.map(joyaDto, Joya.class);
            iJoyaRepository.save(joya);
            return new MessageDto("Joya guardada con éxito");
        } catch (PropertyValueException e){
            throw new DataIntegrityViolationException("Joya no guardada");
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la joya: " + e.getMessage());
        }
    }

    @Override
    public List<JoyaDto> searchAll() {
        return iJoyaRepository.findAll().stream()
                .map(j -> modelMapper.map(j, JoyaDto.class))
                .toList();
    }

    @Override
    public MessageDto deleteById(Long id) throws Exception {
        Joya joya = iJoyaRepository.findById(id)
                .orElseThrow(() -> new Exception("No se encontró Joya con ese id"));

        joya.setVentaONo(false);
        iJoyaRepository.save(joya);
        return new MessageDto("Se ha eliminado con éxito.");

    }

    @Override
    public EditadoDto modify(JoyaIdDto joyaIdDto) throws Exception {
        iJoyaRepository.findById(joyaIdDto.getId())
                .orElseThrow(() -> new Exception("No se encontró Joya con ese id"));
        Joya joya = modelMapper.map(joyaIdDto, Joya.class);
        iJoyaRepository.save(joya);
        
        return new EditadoDto(modelMapper.map(joyaIdDto, JoyaDto.class), "Editado exitosamente");
    }


}
