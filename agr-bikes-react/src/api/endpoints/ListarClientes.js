import React, { useState, useEffect } from 'react';
import DataTable from '../../components/DataTable';

const ListarClientes = () => {
  const [clientes, setClientes] = useState([])
  

  useEffect(() => {
    fetch('http://localhost:8080/clientes', {
    method: 'GET',
    headers: {
      'Content-type': 'application/json',
    }
  }).then(response => response.json())
    .then(data => setClientes(data));
  }, [])

  return (
      <div>
        <DataTable 
        data={ clientes }/>
        {clientes.id}
      </div>
    )
}

export default ListarClientes