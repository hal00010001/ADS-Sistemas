import React, { useState }from 'react';
import AdicionarCliente from './endpoints/AdicionarCliente';
import ListarClientes from './endpoints/ListarClientes';

const Api = () => {
    /* const [editando, setEditando] = useState(false) */
    
    return (
        <div>
            <h1>AGR Bikes API</h1>
            
            <AdicionarCliente />
            <ListarClientes />
        </div>
    );
};

export default Api;

