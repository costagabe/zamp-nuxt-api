package com.br.zamp.mapper;

import com.br.zamp.domain.Contract;
import com.br.zamp.dto.contract.CreateContractDTO;
import com.br.zamp.dto.contract.ReadAndUpdateContractDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContractMapper extends BaseMapper<Contract, CreateContractDTO, ReadAndUpdateContractDTO> {
  ContractMapper INSTANCE = Mappers.getMapper(ContractMapper.class);
}