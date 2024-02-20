package com.br.zamp.dto.utils;

public record CustomPagePagination(
    Integer page,
    Integer size,
    Long totalItems,
    Integer totalPages,
    Boolean sorted,
    Boolean isFirst,
    Boolean isLast
) {
}
