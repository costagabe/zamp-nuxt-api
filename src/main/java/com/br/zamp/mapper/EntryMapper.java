package com.br.zamp.mapper;

import com.br.zamp.domain.Account;
import com.br.zamp.domain.Entry;
import com.br.zamp.dto.entry.CreateEntryDTO;
import com.br.zamp.dto.entry.ReadAndUpdateEntryDTO;
import com.br.zamp.service.AccountService;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class EntryMapper implements BaseMapper<Entry, CreateEntryDTO, ReadAndUpdateEntryDTO> {
  @Setter(onMethod_ = @Autowired)
  AccountService accountService;

  @Mapping(target = "classificationAccount", source = "classificationAccount.id")
  @Mapping(target = "financialAccount", source = "financialAccount.id")
  public abstract ReadAndUpdateEntryDTO toReadAndUpdateDTO(Entry entity);

  @Mapping(target = "classificationAccount", source = "classificationAccount.id")
  @Mapping(target = "financialAccount", source = "financialAccount.id")
  @Mapping(target = "date", ignore = true)
  public abstract ReadAndUpdateEntryDTO toDTO(Entry entity);

  @Mapping(target = "date", ignore = true)
  @Mapping(target = "company", ignore = true)
  @Mapping(target = "version", ignore = true)
  public abstract Entry readAndUpdateDTOToEntity(ReadAndUpdateEntryDTO dto);

  public Account map(UUID classificationAccountId) {
    return accountService.findById(classificationAccountId);
  }

  public Entry createDTOToEntity(CreateEntryDTO dto, UUID accountId) {
    Account account = accountService.findById(accountId);
    Account classificationAccount = accountService.findById(dto.classificationAccount());

    Entry entry = new Entry();
    entry.setDate(LocalDate.now());
    entry.setType(dto.type());
    entry.setHistory(dto.history());
    entry.setValue(dto.value());
    entry.setFinancialAccount(account);
    entry.setClassificationAccount(classificationAccount);

    return entry;
  }
}