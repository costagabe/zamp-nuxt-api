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
  READ_ALL_USER("Listagem de usuários", PermissionType.REQUISICAO),
  DELETE_USER("Remoção de usuários", PermissionType.REQUISICAO),

  CREATE_USER_PROFILE("Criação de perfis de usuários", PermissionType.REQUISICAO),
  UPDATE_USER_PROFILE("Atualização de perfis de usuários", PermissionType.REQUISICAO),
  READ_USER_PROFILE("Listagem de perfis de usuários", PermissionType.REQUISICAO),
  READ_ALL_USER_PROFILE("Listagem de perfis de usuários", PermissionType.REQUISICAO),
  DELETE_USER_PROFILE("Remoção de perfis de usuários", PermissionType.REQUISICAO),

  CREATE_PARAMETER("Criação de parâmetros", PermissionType.REQUISICAO),
  UPDATE_PARAMETER("Atualização de parâmetros", PermissionType.REQUISICAO),
  READ_PARAMETER("Listagem de parâmetros", PermissionType.REQUISICAO),
  READ_ALL_PARAMETER("Listagem de parâmetros", PermissionType.REQUISICAO),
  DELETE_PARAMETER("Remoção de parâmetros", PermissionType.REQUISICAO),

  CREATE_ACCOUNTS("Criação de contas", PermissionType.REQUISICAO),
  UPDATE_ACCOUNTS("Atualização de contas", PermissionType.REQUISICAO),
  READ_ACCOUNTS("Listagem de contas", PermissionType.REQUISICAO),
  READ_ALL_ACCOUNTS("Listagem de contas", PermissionType.REQUISICAO),
  DELETE_ACCOUNTS("Remoção de contas", PermissionType.REQUISICAO),

  CREATE_COMPANIES("Criação de empresas", PermissionType.REQUISICAO),
  UPDATE_COMPANIES("Atualização de empresas", PermissionType.REQUISICAO),
  READ_COMPANIES("Listagem de empresas", PermissionType.REQUISICAO),
  READ_ALL_COMPANIES("Listagem de empresas", PermissionType.REQUISICAO),
  DELETE_COMPANIES("Remoção de empresas", PermissionType.REQUISICAO),




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
