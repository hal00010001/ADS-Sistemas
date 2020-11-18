import React, { useState, useEffect } from 'react';
import DataTableEstoque from './DataTableEstoque';
import Api from './API/endpoints/Api';

// import { Container } from './styles';

const ListarEstoque = (props) => {
	const [estoques, setEstoques] = useState([])
  
	useEffect(() => {
		fetch('http://localhost:8080/estoque', {
		method: 'GET',
		headers: {
		'Content-type': 'application/json',
		}
	}).then(response => response.json())
		.then(data => setEstoques(data));
		}, [])

	return (
	<div className="container-fluid">
		<div className="row">
			<div className="col-xl-12 col-lg-7">
				<div className="card shadow mb-4">
					<div className="card-header py-3">
						<h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-user-edit"></i> Listar Estoque</h6>
					</div>
					<div className="card-body">
						<div className="table-responsive">				  		
							<DataTableEstoque 
								data={ estoques }
							/>
							{estoques.id}
			
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    )
}


export default ListarEstoque


