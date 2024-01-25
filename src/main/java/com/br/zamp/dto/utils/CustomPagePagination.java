package com.br.zamp.dto.utils;

public record CustomPagePagination(
    Integer pageNumber,
    Integer pageSize,
    Long totalItems,
    Integer totalPages,
    Boolean sorted,
    Boolean isFirst,
    Boolean isLast
) {
}
