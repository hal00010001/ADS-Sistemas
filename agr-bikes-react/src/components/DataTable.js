import React, { useState } from 'react';
import axios from 'axios';

function DataTable( props ) {
  
  const clientes = props.data;
  const excluirCliente = (id) => {
    axios.delete(`http://localhost:8080/clientes/${id}`)
    .then(res => {
      console.log(res)
    })
    .catch(err => console.log(err))
    
  }
  const updateContent = (id) => {
    

    axios.get(`http://localhost:8080/clientes/${id}`)
      .then(response => {
        console.log(response)
      })
  }
  
  const renderClientes = (cliente, index) => {
    return (    
      <tr key={cliente.id}>
        <td> {cliente.id} </td>
        <td> {cliente.nome} </td>
        <td> {cliente.cpf} </td>
        <td> {cliente.email} </td>
        <td> {cliente.telefone} </td>
        <td><button className="btn btn-warning btn-circle"
        onClick={() => updateContent(cliente.id)}><i className="fas fa-edit"></i></button></td>
        <td><a href="#" className="btn btn-danger btn-circle"
        onClick={() => excluirCliente(cliente.id)}><i className="fas fa-trash"></i></a> </td>
      </tr>
    )
  }

  return (
    <table className="table table-bordered" id="" width="100%" cellSpacing="0">
      <thead>
        <tr>
          <td>Id</td>
          <td>Nome</td>
          <td>CPF</td>
          <td>E-mail</td>
          <td>Telefone</td>
		  <td>Alterar</td>
		  <td>Excluir</td>
        </tr>
      </thead>
      <tbody>
        {clientes.map(renderClientes)}
      </tbody>
      </table>

  );
}

export default DataTable;