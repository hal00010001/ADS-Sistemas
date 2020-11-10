import axios from 'axios';

class Api {
    
    static getClientes() {
        // const http = new XMLHttpRequest();
        // http.open("GET", "http://localhost:8080/cliente");
        // http.send();

        // http.onreadystatechange = (e) => {
        // console.log(http.responseText);
        // }
        fetch("http://localhost:8080/cliente")
            .then(res => res.json())
            .then(data => console.log(data))
    }
    static getProdutos() {
        const http = new XMLHttpRequest();
        http.open("GET", "http://localhost:8080/produto");
        http.send();

        http.onreadystatechange = (e) => {
        console.log(http.responseText);
        }
    }
    
}

export default Api;