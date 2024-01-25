package com.br.zamp.mapper;

import com.br.zamp.domain.Entry;
import com.br.zamp.dto.entry.CreateEntryDTO;
import com.br.zamp.dto.entry.ReadAndUpdateEntryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EntryMapper extends BaseMapper<Entry, CreateEntryDTO, ReadAndUpdateEntryDTO> {
  EntryMapper INSTANCE = Mappers.getMapper(EntryMapper.class);
}