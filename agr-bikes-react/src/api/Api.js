import React from 'react';
import AdicionarCliente from './endpoints/AdicionarCliente';

const Api = () => {
    return (
        <div>
            <h1>AGR Bikes API</h1>
            <h2>Adicionar Cliente</h2>
            <AdicionarCliente />
        </div>
    );
};

export default Api;

