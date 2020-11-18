import React from 'react';

const AdicionarProduto = () => {
	const [idCat, setIdCat] = React.useState('')
	const [nome, setNome] = React.useState('')
	const [preco, setPreco] = React.useState('')
	
    function handleSubmit(event){
        fetch('http://localhost:8080/produto/', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
            },
            body: JSON.stringify({
				'idCategoria' : idCat,
				'descricao' : nome,
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
						<h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-shopping-cart"></i> Fazer Pedido</h6>
					</div>
					<div className="card-body">
						<form onSubmit={handleSubmit} className="user">
							<div className="form-group">
								<div className="row">
									<div className="col-sm-3 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="ID da Categoria" value={idCat} onChange={({ target }) => setIdCat(target.value)} />
									</div>
									<div className="col-sm-3 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="Descrição" value={nome} onChange={({ target }) => setNome(target.value)} />
									</div>
									<div className="col-sm-3 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="Preço" value={preco} onChange={({ target }) => setPreco(target.value)} />
									</div>
								</div>
								<button type="submit" className="btn btn-primary btn-user col-sm-4 mb-3 mb-sm-4"> Adicionar Produto </button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
    );
};

export default AdicionarProduto;