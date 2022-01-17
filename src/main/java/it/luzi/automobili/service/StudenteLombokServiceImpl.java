package it.luzi.automobili.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.luzi.automobili.dto.StudenteLombokDTO;
import it.luzi.automobili.mapper.StudenteLombokMapper;
import it.luzi.automobili.repository.StudenteLombokRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class StudenteLombokServiceImpl implements StudenteLombokService
{
	@Autowired
	private final StudenteLombokRepository studenteLombokRepository;
	
	@Autowired
	private final StudenteLombokMapper studenteLombokMapper;
	
	@Override
	public List<StudenteLombokDTO> getAll() 
	{
		return studenteLombokMapper.asDTOList(studenteLombokRepository.findAll());
	}

}
