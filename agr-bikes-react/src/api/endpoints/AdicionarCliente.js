import React from 'react';

const AdicionarCliente = () => {
    
    const [nome, setNome] = React.useState('')
    const [cpf, setCpf] = React.useState('')
    const [email, setEmail] = React.useState('')
    const [telefone, setTelefone] = React.useState('')

    function handleSubmit(event){
        
        
        fetch('http://localhost:8080/clientes', {
            method: 'POST',
            headers: {
                'Content-type': 'application/json',
            },
            body: JSON.stringify({
                nome,
                cpf,
                email,
                telefone,
            }),
        }).then(response => {
            console.log(response)
            return response.json()
        }).then(json => {
            console.log(json)
            return json
        })
        event.preventDefault();
    }

    return (
        
        <div>
            <h2>Adicionar Cliente</h2>
        <form onSubmit={handleSubmit}>
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
};

export default AdicionarCliente;