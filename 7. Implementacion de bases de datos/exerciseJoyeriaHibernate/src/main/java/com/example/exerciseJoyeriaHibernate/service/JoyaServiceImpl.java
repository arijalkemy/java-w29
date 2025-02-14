package com.example.exerciseJoyeriaHibernate.service;

import com.example.exerciseJoyeriaHibernate.dto.JoyaNroIdentificatorioResponseDto;
import com.example.exerciseJoyeriaHibernate.dto.JoyaRequestDto;
import com.example.exerciseJoyeriaHibernate.dto.JoyaResponseDto;
import com.example.exerciseJoyeriaHibernate.exception.NotFoundExecption;
import com.example.exerciseJoyeriaHibernate.model.Joya;
import com.example.exerciseJoyeriaHibernate.repository.JoyaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JoyaServiceImpl implements IJoyaService{

    private final JoyaRepository joyaRepository;

    final ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional
    public JoyaNroIdentificatorioResponseDto addJoya(JoyaRequestDto joyaRequestDto) {

        Joya joya = Joya.builder()
                .nombre(joyaRequestDto.getNombre())
                .material(joyaRequestDto.getMaterial())
                .peso(joyaRequestDto.getPeso())
                .particularidad(joyaRequestDto.getParticularidad())
                .posee_piedra(joyaRequestDto.isPosee_piedra())
                .ventaONo(joyaRequestDto.isVentaONo())
                .build();

         Joya joraResponse = joyaRepository.save(joya);

        return JoyaNroIdentificatorioResponseDto.builder()
                .nro_identificatorio(joraResponse.getNro_identificatorio())
                .build();
    }

    @Override
    @Transactional()
    public List<JoyaResponseDto> findAll() {
        List<Joya> responseList = joyaRepository.findAll();

        return responseList.stream().map(this::converToDto).toList();
    }

    @Override
    public void delete(Long id) {
        Joya joya = this.findById(id);
        joyaRepository.delete(joya);
    }

    @Override
    public JoyaResponseDto postUpdateJoya(Long id, JoyaRequestDto joyaRequestDto) {
        Joya joyatoUpdate = joyaRepository.findById(id).orElse(null);

        Long idUpdate = joyatoUpdate.getNro_identificatorio();
        joyatoUpdate = mapper.map(joyaRequestDto, Joya.class);
        joyatoUpdate.setNro_identificatorio(idUpdate);
        joyaRepository.save(joyatoUpdate);


        return mapper.map(joyatoUpdate, JoyaResponseDto.class);
    }

    @Override
    public List<JoyaResponseDto> findJoyaIsVenta() {
        List<Joya> joyaList = joyaRepository.findByVentaONoTrue();

        List<JoyaResponseDto> joyaResponseDtoList = joyaList.stream()
                .map(j-> mapper.map(j, JoyaResponseDto.class)).toList();
        return joyaResponseDtoList;
    }

    private Joya findById(Long id){
        Optional<Joya> joya = Optional.ofNullable(joyaRepository.findById(id).orElseThrow(() -> new NotFoundExecption("No existe la joya")));

        return joya.get();

    }
    private JoyaResponseDto converToDto(Joya joya){

        return JoyaResponseDto.builder()
                .nombre(joya.getNombre())
                .material(joya.getMaterial())
                .peso(joya.getPeso())
                .particularidad(joya.getParticularidad())
                .posee_piedra(joya.isPosee_piedra())
                .ventaONo(joya.isVentaONo())
                .build();
    }
}
