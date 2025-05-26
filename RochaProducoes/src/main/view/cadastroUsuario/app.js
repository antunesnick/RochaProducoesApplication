const formSignUp = document.getElementById("formSignUp");

document.addEventListener("DOMContentLoaded", function() {


    formSignUp.addEventListener("submit", function(event) {
        const inputs = formSignUp.querySelectorAll("input[required]");
        let isValid = true;

        inputs.forEach(input => {
            const errorMessage = input.nextElementSibling

            if(input.id == "confirm-password")
            {
                const passwordInput = document.getElementById("password").value;
                if(passwordInput !== input.value)
                {
                    errorMessage.style.display = "block";
                    isValid = false;
                }
                else{ 
                    errorMessage.style.display = "none";    
                }
            }


            if(!input.checkValidity())
            {
                errorMessage.style.display = "block";
                isValid = false;

            }
            else {
                errorMessage.style.display = "none";
            }
        });
        
        if(!isValid) {
            event.preventDefault();
        }
        else {
            const name = document.getElementById("name").value;
            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            const user = {
                userName: name,
                userEmail: email,
                userPassword: password
            };

            fetch("http://localhost:8080/user", {
                method: "POST",
                headers: {
                    'Content-type': 'application/json'
                },
                body: JSON.stringify(user)
            }).then(response => response.json())
                .then(data => {
                    alert("Usuario cadastrado com sucesso.");
                    console.log("sucesso: " +data);
                }).catch(error => {
                    alert("Usuario não cadastrado, tente novamente mais tarde.")
                    console.error("Erro: " + error);
                    event.preventDefault();
            })

        }

        formSignUp.querySelectorAll("input[required]").forEach(input => {
            input.addEventListener("input", function () {
                this.nextElementSibling.style.display = "none";
            });
        });
    });
});

