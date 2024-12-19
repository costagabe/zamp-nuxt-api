package com.br.zamp.mapper;

import com.br.zamp.domain.Address;
import com.br.zamp.dto.address.CreateAddressDTO;
import com.br.zamp.dto.address.ReadAndUpdateAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface AddressMapper
    extends BaseMapper<Address, CreateAddressDTO, ReadAndUpdateAddressDTO> {
  AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
}