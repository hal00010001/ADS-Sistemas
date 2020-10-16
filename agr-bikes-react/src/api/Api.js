import React from 'react';
import ListarClientes from './endpoints/ListarClientes';
import AdicionarCliente from './endpoints/AdicionarCliente';


const Api = () => {    
    
    return (
        <div className="container-fluid">
            <AdicionarCliente 
            />
         
            <ListarClientes />
			
        </div>
    );
};

export default Api;

