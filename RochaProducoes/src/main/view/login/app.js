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
        console.log('Sucesso: ', data);
    })
    .catch((error) => {
        console.error("Erro: ", error);
    });
});