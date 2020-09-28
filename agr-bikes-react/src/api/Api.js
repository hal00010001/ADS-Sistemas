import React from 'react';
import AdicionarCliente from './endpoints/AdicionarCliente';
import ListarClientes from './endpoints/ListarClientes';

const Api = () => {
    return (
        <div>
            <h1>AGR Bikes API</h1>
            <h2>Adicionar Cliente</h2>
            <AdicionarCliente />
            <ListarClientes />
        </div>
    );
};

export default Api;

