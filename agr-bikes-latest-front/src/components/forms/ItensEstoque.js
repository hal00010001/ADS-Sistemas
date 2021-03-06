import React from 'react';

// import { Container } from './styles';

function ItensEstoque() {
  return(
  	<div className="container-fluid">
		<div className="row">
			<div className="col-xl-12 col-lg-7">
				<div className="card shadow mb-4">
					<div className="card-header py-3">
						<h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-file-invoice-dollar"></i> Relatório de Itens no Estoque</h6>
					</div>
					<div className="card-body">
						<form className="user">
							<div className="form-group">
								<div className="row">
									<div className="col-sm-3 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="ID do Produto" value="" />
									</div>
								</div>
								<button type="submit" className="btn btn-primary btn-user col-sm-4 mb-3 mb-sm-4"> Gerar Relatório </button>
							</div>
						</form>
						<table className="table table-bordered" id="" width="100%" cellSpacing="0">
							<thead>
								<tr>
									<td>Id Produto</td>
									<td>Quantidade em Estoque</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td> </td>
									<td> </td>
								</tr>	
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>  
    </div>
  );
}

export default ItensEstoque;