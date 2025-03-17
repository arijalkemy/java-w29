package com.example.qatester.service;

import com.example.qatester.dto.in.TesterDto;
import com.example.qatester.dto.out.MessageDto;
import com.example.qatester.model.TestCase;
import com.example.qatester.model.Tester;
import com.example.qatester.repository.ITestCaseRepository;
import com.example.qatester.repository.ITesterRepository;
import org.hibernate.PropertyValueException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class TesterService implements ITesterService{
    private final ITesterRepository iTesterRepository;
    private final ModelMapper modelMapper;

    public TesterService(ITesterRepository testerRepository){
        this.iTesterRepository = testerRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public MessageDto addTester(TesterDto testerDto) {
        try {
            iTesterRepository.save(modelMapper.map(testerDto, Tester.class));
            return new MessageDto("Tester guardado con éxito.");
        } catch (PropertyValueException e){
            throw new DataIntegrityViolationException("Tester no guardado");
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar el tester: " + e.getMessage());
        }
    }
}
