package com.br.zamp.mapper;

import com.br.zamp.domain.Account;
import com.br.zamp.domain.Entry;
import com.br.zamp.dto.entry.CreateEntryDTO;
import com.br.zamp.dto.entry.ReadAndUpdateEntryDTO;
import com.br.zamp.service.AccountService;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class EntryMapper implements BaseMapper<Entry, CreateEntryDTO, ReadAndUpdateEntryDTO> {
    @Setter(onMethod_ = @Autowired)
    AccountService accountService;

    public Entry createDTOToEntity(CreateEntryDTO dto, UUID accountId) {
        Account account = accountService.findById(accountId);
        Account otherAccount = accountService.findById(dto.otherAccountId());

        Entry entry = new Entry();
        entry.setDate(LocalDate.now());
        entry.setType(dto.type());
        entry.setHistory(dto.history());
        entry.setValue(dto.value());
        entry.setFinancialAccount(account);
        entry.setClassificationAccount(otherAccount);

        return entry;
    }
}