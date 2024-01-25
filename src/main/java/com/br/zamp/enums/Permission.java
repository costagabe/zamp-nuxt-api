package com.br.zamp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;


@AllArgsConstructor
@Getter
public enum Permission implements GrantedAuthority {
  ALL("Libera todos os acessos para o usuário", PermissionType.GERAL),

  CREATE_USER("Criação de usuários", PermissionType.REQUISICAO),
  UPDATE_USER("Atualização de usuários", PermissionType.REQUISICAO),
  READ_USER("Listagem de usuários", PermissionType.REQUISICAO),
  DELETE_USER("Remoção de usuários", PermissionType.REQUISICAO),

  GET_USER_PROFILE("Listagem de perfis de usuário", PermissionType.REQUISICAO),
  LIST_ALL_PARAMETERS("Listagem de parâmetros", PermissionType.REQUISICAO),
  CREATE_PARAMETERS("Criação de parâmetros", PermissionType.REQUISICAO),
  UPDATE_PARAMETERS("Alterar parâmetros", PermissionType.REQUISICAO),
  FIND_BY_ID_PARAMETERS("Ler parâmetros por ID", PermissionType.REQUISICAO),
  DELETE_PARAMETERS("Apagar parâmetros", PermissionType.REQUISICAO),
  HOME_MENU("Menu home", PermissionType.MENU),
  USERS_MENU("Menu de usuários", PermissionType.MENU),
  PROFILES_MENU("Menu de perfis", PermissionType.MENU),
  PARAMETERS_MENU("Menu de parâmetros", PermissionType.MENU),
  COMPANIES_MENU("Menu de empresas", PermissionType.MENU),
  ACCOUNTS_MENU("Menu de contas do livro caixa", PermissionType.MENU),
  ENTRIES_MENU("Menu de lançamentos do livro caixa", PermissionType.MENU),

  ;

  private final String description;
  private final PermissionType type;

  @Override
  public String getAuthority() {
    return String.format("PERM_%s", name());
  }
}
