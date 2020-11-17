import React from 'react';
import Api from './API/endpoints/Api';
import AdicionarCliente from './forms/AdicionarCliente';
// import { Container } from './styles';

function ListarClientes() {
  Api.getClientes();
  return(
      <AdicionarCliente />
  );
}

export default ListarClientes;