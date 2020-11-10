import React from 'react';

// import { Container } from './styles';

function ItensEstoque() {
  return(
    <div className="row">

        <div className="card-header py-3">
            <h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-boxes"></i> Relatório de Estoque</h6>
        </div>
        <div className="card-body">
            <form className="user">
            <div className="form-group">
                <div className="row">
                <button type="submit" className="btn btn-primary btn-user col-sm-4 mb-3 mb-sm-4"> Gerar Relatório </button>
            </div>
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
    
  );
}

export default ItensEstoque;