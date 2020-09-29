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
        <td><a href="#" className="btn btn-warning btn-circle"><i className="fas fa-edit"></i></a></td>
        <td><a href="#" className="btn btn-danger btn-circle"><i className="fas fa-trash"></i></a> </td>

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