import React, { useState } from 'react';
import axios from 'axios';

function DataTableAvaliacao( props ) {
  
  const estoques = props.data;
  const excluirEstoque = (id) => {
    axios.delete(`http://localhost:8080/es/${id}`)
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
  
  const renderAvaliacoes = (avaliacao, index) => {
    return (    
      <tr key={avaliacao.id}>
	    <td> {avaliacao.id} </td>
        <td> {avaliacao.nomeCliente} </td>
        <td> {avaliacao.nota} </td>
		<td> {avaliacao.comentario} </td>
		<td> {avaliacao.dataInclusao} </td>
      </tr>
    )
  }

  return (
  
    <table className="table table-bordered" id="" width="100%" cellSpacing="0">
      <thead>
        <tr>
          <td>Id</td>
		  <td>Cliente</td>
          <td>Nota</td>
          <td>Comentário</td>
		  <td>Data e hora</td>
        </tr>
      </thead>
      <tbody>
        {estoques.map(renderAvaliacoes)}
      </tbody>
      </table>

  );
}

export default DataTableAvaliacao;