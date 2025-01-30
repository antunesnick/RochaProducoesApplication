function limpa_cep() {
    document.getElementById("address").value="";
    document.getElementById("city").value="";
    document.getElementById("state").value="";

}

function valida_cep(inputCep) {
    if(!/^\d{8}$/.test(inputCep)) {
        return false;
    }
    return true;
}


function preenche_cep() {
    
    limpa_cep();
    const inputCep = document.getElementById("cep").value.trim();
    if(!valida_cep(inputCep)){
        alert("CEP inválido! Digite um cep com 8 números apenas.");
        return;
    }

    const url = `https://viacep.com.br/ws/${inputCep}/json/`;
    fetch(url).then(response => {
        if(!response.ok){
            throw new Error("Erro ao buscar o cep,");
        }
        return response.json();
    }).then(data => {
        if(data.erro) {
            alert("Cep não encontrado.");
            return;
        }
        document.getElementById("address").value = data.logradouro || "";
        document.getElementById("city").value= data.localidade || "";
        document.getElementById("state").value= data.estado || "";
    }).catch(error => {
        console.error("Erro na requisição", error);
        alert("Erro ao buscar o CEP! tente novamente.");
    });
    
}

document.getElementById("formCadastro").addEventListener('submit', function(event) {
    event.preventDefault();

    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
    const phone = document.getElementById("tel").value;
    const gender = Array.from(document.getElementsByName("gender")).find(g => g.checked)?.value;
    const birth = document.getElementById("birth_date").value;
    const zipcode = document.getElementById("cep").value;
    const city = document.getElementById("city").value;
    const state = document.getElementById("state").value;
    const address = document.getElementById("address").value;

    const costumer = {
        costumerName: name,
        costumerEmail: email,
        costumerPhone: phone,
        costumerGender: gender,
        costumerBirth: birth,
        costumerZipcode: zipcode,
        costumerCity: city,
        costumerState: state,
        costumerAddress: address
    }

    fetch('http://localhost:8080/costumer/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(costumer)
    })
    .then(response => response.json())
    .then(data => {
        alert("Cadastro realizado com sucesso!");
        console.log('Sucesso: ', data);
    })
    .catch((error) => {
        alert("Erro ao realizar o cadastro tente novamente mais tarde.");
        console.error("Erro: ", error);
    });
});
 