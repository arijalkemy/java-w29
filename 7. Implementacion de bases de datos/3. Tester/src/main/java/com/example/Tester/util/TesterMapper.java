package com.example.Tester.util;

import com.example.Tester.dto.request.TestDtoRequest;
import com.example.Tester.dto.response.TestDtoResponse;
import com.example.Tester.entity.Tester;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TesterMapper {

    TesterMapper INSTANCE = Mappers.getMapper(TesterMapper.class);

    @Mappings({
            @Mapping(target = "idCase", ignore = true)
    })
    Tester testerDtoToTester(TestDtoRequest testDtoRequest);

    TestDtoResponse testerToTesterDto(Tester tester);
}
