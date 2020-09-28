import React from 'react';



function DataTable( props ) {
  const clientes = props.data;
  

  
  const excluirCliente = () => {

  }
  const renderClientes = (cliente, index) => {
    return (
      <tr key={index}>
        <td> {cliente.id} </td>
        <td> {cliente.nome} </td>
        <td> {cliente.cpf} </td>
        <td> {cliente.email} </td>
        <td> {cliente.telefone} </td>
        <td> <a href="#">Alterar</a> </td>
        <td> <a href="#">Excluir</a> </td>
      </tr>
      
    )
  }

  return (
    
    <table>
      <thead>
        <tr>
          <td>ID</td>
          <td>NOME</td>
          <td>CPF</td>
          <td>E-MAIL</td>
          <td>FONE</td>
        </tr>
      </thead>
      <tbody>
        {clientes.map(renderClientes)}
      </tbody>
    </table>

  );
}

export default DataTable;