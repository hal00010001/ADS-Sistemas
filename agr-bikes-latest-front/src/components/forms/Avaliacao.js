import React from 'react';

const AdicionarAvaliacao = () => {
	const [comentario, setComentario] = React.useState('')
	const [nota, setNota] = React.useState('')
	const [idCliente, setIdCliente] = React.useState('')
	
    function handleSubmit(event){
        fetch('http://localhost:8080/avaliacao', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
            },
            body: JSON.stringify({
				'comentario': comentario,
				'nota' : nota,
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
						<h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-user-edit"></i> Adicionar Comentario</h6>
					</div>
					<div className="card-body">
						<form onSubmit={handleSubmit} className="user">
							<div className="form-group">
								<div className="row">
									<div className="col-sm-8 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="Comentário" value={comentario} onChange={({ target }) => setComentario(target.value)} />
									</div>
									<div className="col-sm-2 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="Nota" value={nota} onChange={({ target }) => setNota(target.value)} />
									</div>
								</div>
								<div className="row">
									<div className="col-sm-4 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="ID do Cliente" value={idCliente} onChange={({ target }) => setIdCliente(target.value)} />
									</div>
								</div>
								<button type="submit" className="btn btn-primary btn-user col-sm-4 mb-3 mb-sm-4"> Adicionar Comentário </button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
    );
};

export default AdicionarAvaliacao;