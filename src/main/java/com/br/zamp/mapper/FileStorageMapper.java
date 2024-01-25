package com.br.zamp.mapper;

import com.br.zamp.domain.FileStorage;
import com.br.zamp.dto.file.CreateFileStorageDTO;
import com.br.zamp.dto.file.ReadAndUpdateFileStorageDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FileStorageMapper extends BaseMapper<FileStorage, CreateFileStorageDTO, ReadAndUpdateFileStorageDTO> {
  FileStorageMapper INSTANCE = Mappers.getMapper(FileStorageMapper.class);
}