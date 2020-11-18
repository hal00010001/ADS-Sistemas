import React from 'react';
import SideBar from './components/SideBar';
import Home from './components/Home';
import ListarClientes from './components/ListarClientes';
import ListarProdutos from './components/ListarProdutos';
import ListarVendas from './components/ListarVendas';
import Avaliacao from './components/forms/Avaliacao';
import EmitirCupom from './components/forms/EmitirCupom';
import RelatorioDeVendas from './components/forms/RelatorioDeVendas';
import ItensEstoque from './components/forms/ItensEstoque';
import Login from './components/forms/Login';
import FazerPedido from './components/forms/FazerPedido';
import AtualizarEstoque from './components/forms/AtualizarEstoque';
import ListarEstoque from './components/ListarEstoque';
import ListarAvaliacoes from './components/ListarAvaliacoes';


import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';

function App() {
  return (
    <Router>
		<div id="wrapper">
			<SideBar />
			<Switch>
				<Route path="/" exact component={Home}/>
				<Route path="/login" component={Login}/>
				<Route path="/avaliacao" component={Avaliacao}/>
				<Route path="/clientes"component={ListarClientes}/>
				<Route path="/produtos"component={ListarProdutos}/>
				<Route path="/vendas" component={ListarVendas} />
				<Route path="/pedido" component={FazerPedido} />
				<Route path="/add" component={Avaliacao} />
				<Route path="/cupom" component={EmitirCupom} />
				<Route path="/relatorios" component={RelatorioDeVendas} />
				<Route path="/estoque" component={AtualizarEstoque} />
				<Route path="/listarestoque" component={ListarEstoque} />
				<Route path="/listaravaliacoes" component={ListarAvaliacoes} />
				<Route path="/listarvendas" component={ListarVendas} />
			</Switch>	
		</div>
    </Router>
  );
}

export default App;
