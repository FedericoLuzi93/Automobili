package it.luzi.automobili.mapper;

import org.mapstruct.Mapper;

import it.luzi.automobili.dto.StudenteLombokDTO;
import it.luzi.automobili.entities.StudenteLombok;


@Mapper(componentModel = "spring")
public interface StudenteLombokMapper extends GenericMapper<StudenteLombok, StudenteLombokDTO>
{

}
