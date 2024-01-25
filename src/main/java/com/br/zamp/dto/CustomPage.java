package com.br.zamp.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class CustomPage<T> {

  private List<T> content;
  private int pageNumber;
  private int pageSize;
  private long totalItems;
  private int totalPages;
  private boolean sorted;
  private boolean isFirst;
  private boolean isLast;

  public CustomPage(Page<T> page) {
    content = page.getContent();
    pageNumber = page.getNumber();
    pageSize = page.getSize();
    totalItems = page.getTotalElements();
    totalPages = page.getTotalPages();
    sorted = page.getSort().isSorted();
    isFirst = page.isFirst();
    isLast = page.isLast();
  }

}