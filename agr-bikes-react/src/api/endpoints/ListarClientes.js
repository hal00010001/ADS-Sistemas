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
      <div className="row">
		<div className="col-xl-12 col-lg-7">
          <div className="card shadow mb-4">
		    <div className="card-header py-3">
              <h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-user-edit"></i> Listar Clientes</h6>
			</div>
			  <div className="card-body">
				<div className="table-responsive">
				  		
				  <DataTable 
				  data={ clientes }/>
				  {clientes.id}
			
				</div>
			  </div>
		  </div>
		</div>
      </div>
    )
}

export default ListarClientes
