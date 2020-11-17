import React from 'react';
import Api from './API/endpoints/Api';
import AdicionarProduto from './forms/AdicionarProduto';

function ListarProdutos() {
  Api.getProdutos();
  return(
      <AdicionarProduto />
  );
}

export default ListarProdutos;