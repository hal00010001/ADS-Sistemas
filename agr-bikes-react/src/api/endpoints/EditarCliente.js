import React, { useState } from 'react';
import axios from 'axios';

// import { Container } from './styles';

function EditarCliente( props ) {
  const [nome, setNome] = useState('')
  const [cpf, setCpf] = useState('')
  const [email, setEmail] = useState('')
  const [telefone, setTelefone] = useState('')

  const data = {
    'nome': nome,
    'cpf': cpf,
    'email': email,
    'telefone': telefone
  }

  const handleUpdate = () => {
    axios.put(`http://localhost:8080/clientes/${props}`)
      .then(data => console.log(data))
  }

  return (
    <div>
      <h2>Editando</h2>;
      <form onSubmit={handleUpdate}>
                <input 
                    type="text" 
                    placeholder="Nome" 
                    name="" value={nome} 
                    onChange={({ target }) => setNome(target.value)} 
                />
                <input 
                    type="text" 
                    placeholder="CPF" 
                    name="" value={cpf} 
                    onChange={({ target }) => setCpf(target.value)} 
                />
                <input 
                    type="email" 
                    placeholder="Email" 
                    name="" value={email} 
                    onChange={({ target }) => setEmail(target.value)} 
                />
                <input 
                    type="text" 
                    placeholder="Telefone" 
                    name="" value={telefone} 
                    onChange={({ target }) => setTelefone(target.value)} 
                />
                <button type="submit">Enviar</button>
            </form>
    </div>
  );
  
  
}

export default EditarCliente;