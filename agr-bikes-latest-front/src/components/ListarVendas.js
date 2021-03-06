// ListarVendas funcionando
import React, { useState, useEffect } from 'react';
import DataTableVenda from './DataTableVenda';
import Api from './API/endpoints/Api';
import AdicionarCliente from './forms/AdicionarCliente';


// import { Container } from './styles';

const ListarVenda = (props) => {
	const [vendas, setVendas] = useState([])
	useEffect(() => {
		var dtInicial = window.prompt("Inicial");
		var dtFinal = window.prompt("Final");
		fetch('http://localhost:8080/relatorio/'+dtInicial+dtFinal, {
		method: 'GET',
		headers: {
		'Content-type': 'application/json',
		}
	}).then(response => response.json())
		.then(data => setVendas(data));
		}, [])

	return (
	<div className="container-fluid">
		<div className="row">
			<div className="col-xl-12 col-lg-7">
				<div className="card shadow mb-4">
					<div className="card-header py-3">
						<h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-user-edit"></i> Listar Vendas</h6>
					</div>
					<div className="card-body">
						<div className="table-responsive">				  		
							<DataTableVenda 
								data={ vendas }
							/>
							{vendas.id}
			
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    )
}


export default ListarVenda


