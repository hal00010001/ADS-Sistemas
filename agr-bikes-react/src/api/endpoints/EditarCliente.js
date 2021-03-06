import React from 'react';
import axios from 'axios';

function EditarCliente(props) {
  const [nome, setNome] = React.useState('')
  const [cpf, setCpf] = React.useState('')
  const [email, setEmail] = React.useState('')
  const [telefone, setTelefone] = React.useState('')

  const data = {
    'nome': nome,
    'cpf': cpf,
    'email': email,
    'telefone': telefone
  }

  const handleupdate = (id) => {
    axios.put(`http://localhost:8080/clientes/${id}`)
      .then(data => console.log(data))
      .catch(err => console.log(err))
  }
 
  return (
    <div className="row">
      <div className="col-xl-12 col-lg-7">
        <div className="card shadow mb-4">
        <div className="card-header py-3">
          <h6 className="m-0 font-weight-bold text-primary"><i className="fas fa-fw fa-user-edit"></i> Editar Clientes</h6>
        </div>
        <div className="card-body">
          <form onSubmit={() => handleupdate({props.cliente.id})} className="user">
              <div className="form-group">
            <div className="row">
            <div className="col-sm-6 mb-3 mb-sm-4">
            <input type="text" className="form-control form-control-user" id="" placeholder="Nome" value={cliente.nome} onChange={({ target }) => setNome(target.value)}
            />
            </div>
            <div className="col-sm-6 mb-3 mb-sm-4">
            <input type="text" className="form-control form-control-user" id="" placeholder="CPF" value={props.cliente.cpf} onChange={({ target }) => setCpf(target.value)}
            />
            </div>
            </div>
            <div className="row">
            <div className="col-sm-6 mb-3 mb-sm-4">
            <input type="email" className="form-control form-control-user" id="" placeholder="E-mail" value={props.cliente.email} onChange={({ target }) => setEmail(target.value)}
            />
            </div>
            <div className="col-sm-6 mb-3 mb-sm-4">
            <input type="text" className="form-control form-control-user" id="" placeholder="Telefone" value={props.cliente.telefone} onChange={({ target }) => setTelefone(target.value)}
            />
            </div>
            </div>
                  <button type="submit" className="btn btn-primary btn-user col-sm-12 mb-3 mb-sm-4"> Cadastrar Cliente </button>
          </div>
          </form>
        </div>
        </div>
      </div>
	  </div>
  );
}

export default EditarCliente;