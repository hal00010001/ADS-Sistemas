import React from 'react';

// import { Container } from './styles';

function AdicionarCliente() {
  return(
    <div className="row">
        <div className="col-xl-12 col-lg-7">
            <div className="card shadow mb-4">
                <div className="card-header py-3">
                    <h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-user-edit"></i> Adicionar Clientes</h6>
                </div>
                <div className="card-body">
                    <form className="user">
                        <div className="form-group">
                            <div className="row">
                                <div className="col-sm-6 mb-3 mb-sm-4">
                                    <input type="text" className="form-control form-control-user" id="" placeholder="Nome" value="" />
                                </div>
                                <div className="col-sm-6 mb-3 mb-sm-4">
                                    <input type="text" className="form-control form-control-user" id="" placeholder="CPF" value="" />
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-sm-6 mb-3 mb-sm-4">
                                    <input type="email" className="form-control form-control-user" id="" placeholder="E-mail" value="" />
                                </div>
                                <div className="col-sm-6 mb-3 mb-sm-4">
                                    <input type="text" className="form-control form-control-user" id="" placeholder="Telefone" value="" />
                                </div>
                            </div>
                            <div className="row">
                                <div className="col-sm-3 mb-3 mb-sm-4">
                                    <input type="email" className="form-control form-control-user" id="" placeholder="Rua" value="" />
                                </div>
                                <div className="col-sm-3 mb-3 mb-sm-4">
                                    <input type="text" className="form-control form-control-user" id="" placeholder="Número" value="" />
                                </div>
                                <div className="col-sm-3 mb-3 mb-sm-4">
                                    <input type="text" className="form-control form-control-user" id="" placeholder="Bairro" value="" />
                                </div>
                                <div className="col-sm-3 mb-3 mb-sm-4">
                                    <input type="text" className="form-control form-control-user" id="" placeholder="CEP" value="" />
                                </div>						
                            </div>

                            <button type="submit" className="btn btn-primary btn-user col-sm-4 mb-3 mb-sm-4"> Cadastrar Cliente </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
  );
}

export default AdicionarCliente;