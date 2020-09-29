import axios from 'axios';

const excluirCliente = (props) => {
  console.log(props.id)
  axios.delete(`http://localhost:8080/clientes/${props}`)
    .then(res => {
      console.log(res)
    })
    .catch(err => console.log(err))
    
}
export default excluirCliente;