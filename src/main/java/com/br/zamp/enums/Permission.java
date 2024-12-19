package com.br.zamp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Permission implements GrantedAuthority {
  ALL("Libera todos os acessos para o usuário", PermissionType.GERAL),

  CREATE_ACCOUNTS("Criação de contas", PermissionType.REQUISICAO),
  UPDATE_ACCOUNTS("Atualização de contas", PermissionType.REQUISICAO),
  READ_ACCOUNTS("Listagem de contas", PermissionType.REQUISICAO),
  READ_ALL_ACCOUNTS("Listagem de contas", PermissionType.REQUISICAO),
  DELETE_ACCOUNTS("Remoção de contas", PermissionType.REQUISICAO),

  CREATE_ADDRESSES("Criação de endereços", PermissionType.REQUISICAO),
  UPDATE_ADDRESSES("Atualização de endereços", PermissionType.REQUISICAO),
  READ_ADDRESSES("Listagem de endereços", PermissionType.REQUISICAO),
  READ_ALL_ADDRESSES("Listagem de endereços", PermissionType.REQUISICAO),
  DELETE_ADDRESSES("Remoção de endereços", PermissionType.REQUISICAO),

  CREATE_BUILDINGS("Criação de imóveis", PermissionType.REQUISICAO),
  UPDATE_BUILDINGS("Atualização de imóveis", PermissionType.REQUISICAO),
  READ_BUILDINGS("Listagem de imóveis", PermissionType.REQUISICAO),
  READ_ALL_BUILDINGS("Listagem de imóveis", PermissionType.REQUISICAO),
  DELETE_BUILDINGS("Remoção de imóveis", PermissionType.REQUISICAO),

  CREATE_COMPANIES("Criação de empresas", PermissionType.REQUISICAO),
  UPDATE_COMPANIES("Atualização de empresas", PermissionType.REQUISICAO),
  READ_COMPANIES("Listagem de empresas", PermissionType.REQUISICAO),
  READ_ALL_COMPANIES("Listagem de empresas", PermissionType.REQUISICAO),
  DELETE_COMPANIES("Remoção de empresas", PermissionType.REQUISICAO),

  CREATE_CONTRACTS("Criação de contratos", PermissionType.REQUISICAO),
  UPDATE_CONTRACTS("Atualização de contratos", PermissionType.REQUISICAO),
  READ_CONTRACTS("Listagem de contratos", PermissionType.REQUISICAO),
  READ_ALL_CONTRACTS("Listagem de contratos", PermissionType.REQUISICAO),
  DELETE_CONTRACTS("Remoção de contratos", PermissionType.REQUISICAO),

  CREATE_DOCUMENTS("Criação de documentos", PermissionType.REQUISICAO),
  UPDATE_DOCUMENTS("Atualização de documentos", PermissionType.REQUISICAO),
  READ_DOCUMENTS("Listagem de documentos", PermissionType.REQUISICAO),
  READ_ALL_DOCUMENTS("Listagem de documentos", PermissionType.REQUISICAO),
  DELETE_DOCUMENTS("Remoção de documentos", PermissionType.REQUISICAO),

  CREATE_ENTRIES("Criação de entradas em contas", PermissionType.REQUISICAO),
  UPDATE_ENTRIES("Atualização de entradas em contas", PermissionType.REQUISICAO),
  READ_ENTRIES("Listagem de entradas em contas", PermissionType.REQUISICAO),
  READ_ALL_ENTRIES("Listagem de entradas em contas", PermissionType.REQUISICAO),
  DELETE_ENTRIES("Remoção de entradas em contas", PermissionType.REQUISICAO),

  CREATE_FILE_STORAGES("Criação de arquivos", PermissionType.REQUISICAO),
  UPDATE_FILE_STORAGES("Atualização de arquivos", PermissionType.REQUISICAO),
  READ_FILE_STORAGES("Listagem de arquivos", PermissionType.REQUISICAO),
  READ_ALL_FILE_STORAGES("Listagem de arquivos", PermissionType.REQUISICAO),
  DELETE_FILE_STORAGES("Remoção de arquivos", PermissionType.REQUISICAO),

  CREATE_CLIENTS("Criação de clientes", PermissionType.REQUISICAO),
  UPDATE_CLIENTS("Atualização de clientes", PermissionType.REQUISICAO),
  READ_CLIENTS("Listagem de clientes", PermissionType.REQUISICAO),
  READ_ALL_CLIENTS("Listagem de clientes", PermissionType.REQUISICAO),
  DELETE_CLIENTS("Remoção de clientes", PermissionType.REQUISICAO),

  CREATE_CLIENT_DOCUMENTS("Criação de documentos de clientes", PermissionType.REQUISICAO),
  UPDATE_CLIENT_DOCUMENTS("Atualização de documentos de clientes", PermissionType.REQUISICAO),
  READ_CLIENT_DOCUMENTS("Listagem de documentos de clientes", PermissionType.REQUISICAO),
  READ_ALL_CLIENT_DOCUMENTS("Listagem de documentos de clientes", PermissionType.REQUISICAO),
  DELETE_CLIENT_DOCUMENTS("Remoção de documentos de clientes", PermissionType.REQUISICAO),

  CREATE_PARAMETERS("Criação de parâmetros", PermissionType.REQUISICAO),
  UPDATE_PARAMETERS("Atualização de parâmetros", PermissionType.REQUISICAO),
  READ_PARAMETERS("Listagem de parâmetros", PermissionType.REQUISICAO),
  READ_ALL_PARAMETERS("Listagem de parâmetros", PermissionType.REQUISICAO),
  DELETE_PARAMETERS("Remoção de parâmetros", PermissionType.REQUISICAO),

  CREATE_RENTS("Criação de aluguéis", PermissionType.REQUISICAO),
  UPDATE_RENTS("Atualização de aluguéis", PermissionType.REQUISICAO),
  READ_RENTS("Listagem de aluguéis", PermissionType.REQUISICAO),
  READ_ALL_RENTS("Listagem de aluguéis", PermissionType.REQUISICAO),
  DELETE_RENTS("Remoção de aluguéis", PermissionType.REQUISICAO),

  CREATE_USERS("Criação de usuários", PermissionType.REQUISICAO),
  UPDATE_USERS("Atualização de usuários", PermissionType.REQUISICAO),
  READ_USERS("Listagem de usuários", PermissionType.REQUISICAO),
  READ_ALL_USERS("Listagem de usuários", PermissionType.REQUISICAO),
  DELETE_USERS("Remoção de usuários", PermissionType.REQUISICAO),

  CREATE_USER_PROFILES("Criação de perfis de usuários", PermissionType.REQUISICAO),
  UPDATE_USER_PROFILES("Atualização de perfis de usuários", PermissionType.REQUISICAO),
  READ_USER_PROFILES("Listagem de perfis de usuários", PermissionType.REQUISICAO),
  READ_ALL_USER_PROFILES("Listagem de perfis de usuários", PermissionType.REQUISICAO),
  DELETE_USER_PROFILES("Remoção de perfis de usuários", PermissionType.REQUISICAO),

  HOME_MENU("Menu home", PermissionType.MENU),
  USERS_MENU("Menu de usuários", PermissionType.MENU),
  PROFILES_MENU("Menu de perfis", PermissionType.MENU),
  PARAMETERS_MENU("Menu de parâmetros", PermissionType.MENU),
  COMPANIES_MENU("Menu de empresas", PermissionType.MENU),
  ACCOUNTS_MENU("Menu de contas do livro caixa", PermissionType.MENU),
  ENTRIES_MENU("Menu de lançamentos do livro caixa", PermissionType.MENU),
  CLIENTS_MENU("Menu de clientes", PermissionType.MENU),
  ;
  private final String description;
  private final PermissionType type;

  @Override
  public String getAuthority() {
    return String.format("PERM_%s", name());
  }
}
