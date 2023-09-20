// FORMULÁRIO DE CADASTRO - REQUISIÇÃO POST
const form = document.getElementById("formulario_cadastro");

form.addEventListener("submit", function(event){
    event.preventDefault();

    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    fetch("http://localhost:8080/api/produtos/", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    }).then(res => res.json()).then(data => {    
        console.log(data);
    })
    .catch(error => console.log(error));  
    

});

// FUNÇÃO DE RELOAD E ALERTA DE SUCESSO
function mensagemSucesso(){
    alert("Produto cadastrado com sucesso.");
    window.location.reload(true);
} 


// LISTA DE PRODUTOS - REQUISIÇÃO GET

fetch("http://localhost:8080/api/produtos").then((data) => {
    return data.json();
    }).then((listarTodos) => {
        let data1 = "";
        listarTodos.map((values) => {
            data1 += `
            <tbody> 
                <tr>
                    <th scope="row">${values.id} </td>
                    <td> ${values.nome} </td>
                    <td> ${values.valor} </td>
                    <td> ${values.descricao} </td>
                    <td> ${values.quantidade} </td>
                </tr>        
            </tbody>
            `
        })
        document.getElementById("lista_produtos").innerHTML = data1;
        console.log(listarTodos);
    
    })

// BUSCA DE PRODUTOS POR ID - REQUISIÇÃO GET

const busca = document.getElementById("formulario_busca");
