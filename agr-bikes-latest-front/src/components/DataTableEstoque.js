import React, { useState } from 'react';
import axios from 'axios';

function DataTableEstoque( props ) {
  
  const estoques = props.data;
  const excluirEstoque = (id) => {
    axios.delete(`http://localhost:8080/estoque/${id}`)
    .then(res => {
      console.log(res)
    })
    .catch(err => console.log(err))
  }
  const updateContent = (id) => {
    axios.get(`http://localhost:8080/estoque/${id}`)
      .then(response => {
        console.log(response)
      })
  }
  
  const renderEstoques = (estoque, index) => {
    return (    
      <tr key={estoque.id}>
	    <td> {estoque.id} </td>
        <td> {estoque.idProduto} </td>
        <td> {estoque.nomeProduto} </td>
		<td> {estoque.quantidade} </td>
      </tr>
    )
  }

  return (
  
    <table className="table table-bordered" id="" width="100%" cellSpacing="0">
      <thead>
        <tr>
          <td>Id</td>
          <td>Id Produto</td>
          <td>Nome do Produto</td>
		  <td>Quantidade</td>
        </tr>
      </thead>
      <tbody>
        {estoques.map(renderEstoques)}
      </tbody>
      </table>

  );
}

export default DataTableEstoque;