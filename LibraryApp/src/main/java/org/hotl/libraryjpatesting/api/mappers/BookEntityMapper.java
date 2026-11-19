package org.hotl.libraryjpatesting.api.mappers;

import org.hotl.libraryjpatesting.api.dtos.books.BookResponse;
import org.hotl.libraryjpatesting.api.dtos.books.BookResponseSecond;
import org.hotl.libraryjpatesting.domain.entities.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookEntityMapper {

    List<BookResponse> toResponse(List<BookEntity> bookEntity);

    List<BookResponseSecond> toSecondResponse(List<BookEntity> bookEntity);




}
