import React from 'react';
import { Link } from 'react-router-dom';

function SideBar() {
  return(
    <ul className="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
		<Link to="/"> 
			<a className="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
				<div className="sidebar-brand-icon">
					<i className="fas fa-bicycle"></i>
				</div>
				<div className="sidebar-brand-text mx-3">AGR Bikes</div>
			</a> 
		</Link>
		<hr className="sidebar-divider my-0" />
			<li className="nav-item active">
				<a className="nav-link" href="index.html">
					<i className="fas fa-fw fa-tachometer-alt"></i>
					<span>Módulo Gestor</span>
				</a>
			</li>
		<Link to="/avaliacao">
			<li className="nav-item active">
				<a className="nav-link" href="index.html">
					<i className="fas fa-fw fa-users"></i>
					<span>Módulo Feedback</span>
				</a>
			</li>
		</Link>
		<hr className="sidebar-divider" />
		<div className="sidebar-heading">
			Links Rápidos
		</div>
		<li className="nav-item">
			<Link to="/produtos"> 
				<a className="nav-link collapsed" href="/#">
					<i className="fas fa-fw fa-box-open"></i>
					<span>Produtos</span>
				</a>
			</Link>
			<Link to="/clientes">
				<a className="nav-link collapsed" href="/#">
					<i className="fas fa-fw fa-user-edit"></i>
					<span>Clientes</span>
				</a>
			</Link>
			<a className="nav-link collapsed" href="/#" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseTwo">
				<i className="fas fa-fw fa-dollar-sign"></i>
				<span>Vender</span>
			</a>
			<div id="collapseOne" className="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
				<div className="bg-white py-2 collapse-inner rounded">
					<h6 className="collapse-header">Vendas:</h6>
					<Link to="/vendas">
						<a className="collapse-item" href="/#">Fazer Pedido</a>
					</Link>
					<Link to="/cupomfiscal">
						<a className="collapse-item" href="/#">Emitir Cupom Fiscal</a>
					</Link>
				</div>
			</div>
			
			<a className="nav-link collapsed" href="/#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
				<i className="fas fa-fw fa-file-alt"></i>
				<span>Relatórios</span>
			</a>
			<div id="collapseTwo" className="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
				<div className="bg-white py-2 collapse-inner rounded">
					<h6 className="collapse-header">Relatórios:</h6>
					<Link to="/relatorios">
						<a className="collapse-item" href="/#">Vendas por período</a>
					</Link>
					<Link to="estoque">
						<a className="collapse-item" href="/#">Itens no estoque</a>
					</Link>
				</div>
			</div>
		</li>
    </ul>
  );
}

export default SideBar;