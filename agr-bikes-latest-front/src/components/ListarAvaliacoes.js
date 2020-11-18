import React, { useState, useEffect } from 'react';
import DataTableAvaliacao from './DataTableAvaliacao';
import Api from './API/endpoints/Api';
import AdicionarCliente from './forms/AdicionarCliente';



// import { Container } from './styles';

const Listaravaliacao = (props) => {
	const [avaliacoes, setavaliacoes] = useState([])
  
	useEffect(() => {
		fetch('http://localhost:8080/avaliacao', {
		method: 'GET',
		headers: {
		'Content-type': 'application/json',
		}
	}).then(response => response.json())
		.then(data => setavaliacoes(data));
		}, [])

	return (
	<div className="container-fluid">
		<div className="row">
			<div className="col-xl-12 col-lg-7">
				<div className="card shadow mb-4">
					<div className="card-header py-3">
						<h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-user-edit"></i> Listar Avaliações</h6>
					</div>
					<div className="card-body">
						<div className="table-responsive">				  		
							<DataTableAvaliacao 
								data={ avaliacoes }
							/>
							{avaliacoes.id}
			
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    )
}


export default Listaravaliacao


