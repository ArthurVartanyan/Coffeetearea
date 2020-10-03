let _form = document.querySelector("form")

_form.addEventListener("submit", function (e) {
    e.preventDefault();

    axios({
        method: 'post',
        url: '/users/registration',
        data: {
            name: document.getElementById('inputName').value,
            lastName: document.getElementById('inputSurName').value,
            mail: document.getElementById('inputMail').value,
            login: document.getElementById('inputLogin').value,
            password: document.getElementById('inputPassword').value,
            checkPassword: document.getElementById('inputChekPassword').value
        }


    }).catch((error) => {

        console.log(error.response)

        var nameEx;
        var lastNameEx;
        var loginEx;
        var mailEx;
        var passEx;
        var checkPassEx;

        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "login") {
                loginEx = error.response.data.fieldErrors[i].message;
            }
        }

        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "name") {
                nameEx = error.response.data.fieldErrors[i].message;
            }
        }

        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "lastName") {
                lastNameEx = error.response.data.fieldErrors[i].message;
            }
        }

        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "mail") {
                mailEx = error.response.data.fieldErrors[i].message;
            }
        }

        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "password") {
                passEx = error.response.data.fieldErrors[i].message;
            }
        }

        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "checkPassword") {
                checkPassEx = error.response.data.fieldErrors[i].message;
            }
        }

        var nameC = document.createElement('pr');
        nameC.style.color = 'darkred';
        nameC.style.position = 'fixed';
        nameC.style.top = '275px';
        nameC.style.left = '1080px';
        nameC.style.fontFamily = '"Brush Script MT", cursive';
        nameC.textContent = nameEx;
        document.body.appendChild(nameC)

        var loginC = document.createElement('pr');
        loginC.style.color = 'darkred';
        loginC.style.position = 'fixed';
        loginC.style.top = '480px';
        loginC.style.left = '1080px';
        loginC.style.fontFamily = '"Brush Script MT", cursive';
        loginC.textContent = loginEx;
        document.body.appendChild(nameC)

        var mailC = document.createElement('pr');
        mailC.style.color = 'darkred';
        mailC.style.position = 'fixed';
        mailC.style.top = '480px';
        mailC.style.left = '1080px';
        mailC.style.fontFamily = '"Brush Script MT", cursive';
        mailC.textContent = mailEx;
        document.body.appendChild(mailC)

        var lastNameC = document.createElement('pr');
        lastNameC.style.color = 'darkred';
        lastNameC.style.position = 'fixed';
        lastNameC.style.top = '480px';
        lastNameC.style.left = '1080px';
        lastNameC.style.fontFamily = '"Brush Script MT", cursive';
        lastNameC.textContent = lastNameEx;
        document.body.appendChild(lastNameC)

        var nameC = document.createElement('pr');
        nameC.style.color = 'darkred';
        nameC.style.position = 'fixed';
        nameC.style.top = '480px';
        nameC.style.left = '1080px';
        nameC.style.fontFamily = '"Brush Script MT", cursive';
        nameC.textContent = loginEx;
        document.body.appendChild(nameC)

        var nameC = document.createElement('pr');
        nameC.style.color = 'darkred';
        nameC.style.position = 'fixed';
        nameC.style.top = '480px';
        nameC.style.left = '1080px';
        nameC.style.fontFamily = '"Brush Script MT", cursive';
        nameC.textContent = loginEx;
        document.body.appendChild(nameC)

    })
    //     .then((res) => {
    //     // if (res.status === 200) {
    //     //     alert('Вы успешно зарегистрированы!')
    //     //     window.location = '/login';
    //     //     return res.json();
    //     if (res.status === 422) {
    //
    //         var nameC = document.createElement('pr');
    //         nameC.style.color = 'red';
    //         nameC.style.position = 'fixed';
    //         nameC.style.top = '275px';
    //         nameC.style.left = '1080px';
    //         nameC.style.fontFamily = '"Brush Script MT", cursive';
    //         nameC.textContent = 'eededede'
    //
    //         document.body.appendChild(nameC)
    //     }
    // })
})