import React, { useState } from 'react';
import axios from 'axios';

function DataTableVenda( props ) {
  
  const vendas = props.data;
  const excluirEstoque = (id) => {
    axios.delete(`http://localhost:8080/es/${id}`)
    .then(res => {
      console.log(res)
    })
    .catch(err => console.log(err))
  }
  const updateContent = (id) => {
    axios.get(`http://localhost:8080/venda/${id}`)
      .then(response => {
        console.log(response)
      })
  }
  
  const renderVendas = (venda, index) => {
    return (    
      <tr key={venda.id}>
	    <td> {venda.id} </td>
		<td> {venda.dataInclusao} </td>
        <td> {venda.nomeCliente} </td>
      </tr>
    )
  }

  return (
  
    <table className="table table-bordered" id="" width="100%" cellSpacing="0">
      <thead>
        <tr>
          <td>Id</td>
		  <td>Data</td>
		  <td>Cliente</td>
        </tr>
      </thead>
      <tbody>
        {vendas.map(renderVendas)}
      </tbody>
      </table>

  );
}

export default DataTableVenda;