import React, { useState } from 'react';
import editarCliente from '../api/endpoints/EditarCliente';
import excluirCliente from '../api/endpoints/ExcluirCliente';

// import { Container } from './styles';

function DataTable( props ) {
  const clientes = props.data;
  const [editando, setEditando] = useState(false);

  
  function mudarEstadoEditando() {
    setEditando(!editando);
    return editando;
  }
  
  const renderClientes = (cliente, index) => {
    return (
      <tr key={cliente.id}>
        <td> {cliente.id} </td>
        <td> {cliente.nome} </td>
        <td> {cliente.cpf} </td>
        <td> {cliente.email} </td>
        <td> {cliente.telefone} </td>
        <td> <button 
          onClick={() => editarCliente(cliente.id)}
          onClick={mudarEstadoEditando}
          >Alterar</button> </td>
        <td> <button onClick={() => excluirCliente(cliente.id)}>Excluir</button> </td>
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