document.addEventListener("DOMContentLoaded", function() {
    const formSignUp = document.getElementById("formSignUp");


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

        formSignUp.querySelectorAll("input[required]").forEach(input => {
            input.addEventListener("input", function () {
                this.nextElementSibling.style.display = "none";
            });
        });
    });
});