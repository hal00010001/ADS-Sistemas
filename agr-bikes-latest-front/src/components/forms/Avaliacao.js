import React from 'react';

// import { Container } from './styles';

function Avaliacao() {
  return(
	<div className="container-fluid">
		<div className="row">
			<div className="col-xl-12 col-lg-7">
				<div className="card shadow mb-4">
					<div className="card-header py-3">
						<h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-comment-dots"></i> Adicionar Avaliação</h6>
					</div>
					<div className="card-body">
						<form className="user">
							<div className="form-group">
								<div className="row">
									<div className="col-sm-4 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="ID Cliente" value="" />
									</div>
									<div className="col-sm-4 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="Nota" value="" />
									</div>
								</div>
								<div className="row">
									<div className="col-sm-12 mb-3 mb-sm-4">
										<input type="text" className="form-control form-control-user" id="" placeholder="Digite seu comentário de avaliação" value="" />
									</div>
								</div>
								<button type="submit" className="btn btn-primary btn-user col-sm-4 mb-3 mb-sm-4"> Enviar Comentário </button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
  );
}

export default Avaliacao;