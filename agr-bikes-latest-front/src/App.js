import React from 'react';
import SideBar from './components/SideBar';
import Home from './components/Home';
import ListarClientes from './components/ListarClientes';
import ListarProdutos from './components/ListarProdutos';
import ListarVendas from './components/ListarVendas';
import Avaliacao from './components/forms/Avaliacao';
import RelatorioDeVendas from './components/forms/RelatorioDeVendas';
import ItensEstoque from './components/forms/ItensEstoque';

import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';


function App() {
  return (
    <Router>
      <div id="wrapper">
        <SideBar />
        
        <Switch>
          <Route path="/" exact component={Home}/>
          <Route path="/avaliacao" component={Avaliacao}/>
          <Route path="/clientes"component={ListarClientes}/>
          <Route path="/produtos"component={ListarProdutos}/>
          <Route path="/vendas" component={ListarVendas} />
          <Route path="/add" component={Avaliacao} />
          <Route path="/relatorios" component={RelatorioDeVendas} />
          <Route path="/estoque" component={ItensEstoque} />
        </Switch>
        
      </div>
    </Router>
  );
}

export default App;
