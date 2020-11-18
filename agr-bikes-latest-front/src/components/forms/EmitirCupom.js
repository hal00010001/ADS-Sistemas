import React from 'react';

const EmitirCupom = () => {
	const [numeroPedido, setNumeroPedido] = React.useState('')
	const [idCliente, setIdCliente] = React.useState('')
	
    function handleSubmit(event){        
        fetch('http://localhost:8080/nota-fiscal', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
            },
            body: JSON.stringify({
				'numeroPedido' : numeroPedido,
				'idCliente' : idCliente
			})
			,
        }).then(response => {
            console.log(response)
            return response.json()
        }).then(json => {
            console.log(json)
            return json
        })
        .catch(err => console.log(err))
        event.preventDefault();
    }

    return (
		<div className="container-fluid">
		<div className="row">
			<div className="col-xl-12 col-lg-7">
				<div className="card shadow mb-4">
					<div className="card-header py-3">
						<h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-shopping-cart"></i> Emitir Cupom Fiscal </h6>
					</div>
					<div className="card-body">
						<form onSubmit={handleSubmit} className="user">
							<div className="form-group">
								<div className="row">
									<div className="col-sm-3 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="Número do Pedido" value={numeroPedido} onChange={({ target }) => setNumeroPedido(target.value)} />
									</div>
									<div className="col-sm-3 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="Id do Cliente" value={idCliente} onChange={({ target }) => setIdCliente(target.value)} />
									</div>
								</div>
								<button type="submit" className="btn btn-primary btn-user col-sm-4 mb-3 mb-sm-4"> Emitir cupom fiscal </button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
    );
};

export default EmitirCupom;