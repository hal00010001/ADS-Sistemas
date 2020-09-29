import React from 'react';
import AdicionarCliente from './endpoints/AdicionarCliente';
import ListarClientes from './endpoints/ListarClientes';

const Api = () => {
    return (
        <div className="container-fluid">
            <AdicionarCliente />
            <ListarClientes />
        </div>
    );
};

export default Api;

