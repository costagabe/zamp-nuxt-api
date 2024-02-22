package com.br.zamp.dto.utils;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class CustomPage<T> {

  CustomPagePagination pagination;
  private List<T> content;

  public CustomPage(Page<T> page) {
    content = page.getContent();
    pagination = new CustomPagePagination(
      page.getNumber(),
      page.getSize(),
      page.getTotalElements(),
      page.getTotalPages(),
      page.getSort().isSorted(),
      page.isFirst(),
      page.isLast()
    );
  }

}