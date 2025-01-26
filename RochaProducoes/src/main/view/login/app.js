document.getElementById("formCadastro").addEventListener('submit', function(event) {
    event.preventDefault();

    const name = document.getElementById("name");
    const email = document.getElementById("email");
    const phone = document.getElementById("tel");
    const gender = document.getElementsByName("gender");
    const birth = document.getElementById("birth_date");
    const zipcode = document.getElementById("cep");
    const city = document.getElementById("city");
    const state = document.getElementById("state");
    const address = document.getElementById("address");

    const costumer = {
        name: name,
        email: email,
        phone: phone,
        gender: gender,
        birth: birth,
        zipcode: zipcode,
        city: city,
        state: state,
        address: address
    }

    fetch('https://localhost:8080/costumer/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(costumer)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Sucesso: ', data);
    })
    .catch((error) => {
        console.error("Erro: ", error);
    });
});