package it.luzi.automobili.mapper;

import java.util.List;

public interface GenericMapper<E, D>
{
	D asDTO(E Entity);
	List<D> asDTOList(List<E> entities);
}
