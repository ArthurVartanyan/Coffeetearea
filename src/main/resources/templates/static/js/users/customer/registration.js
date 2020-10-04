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

        Array.prototype.slice.call(document.getElementsByTagName('pr')).forEach(
            function(item) {
                item.remove();
            });

        var nameEx;
        var lastNameEx;
        var loginEx;
        var mailEx;
        var passEx;
        var checkPassEx;

        var notValidError;

        if (error.response.data.error !== null) {

            Array.prototype.slice.call(document.getElementsByTagName('h3')).forEach(
                function(item) {
                    item.remove();
                });

            notValidError = error.response.data.error;

            var notValidMessage = document.createElement('h3');
            notValidMessage.textContent = notValidError;
            notValidMessage.style.color = 'red'
            notValidMessage.style.position = 'absolute'
            notValidMessage.style.left = '750px'
            notValidMessage.style.top = '110px'
            notValidMessage.style.textAlign = 'center'
            document.body.appendChild(notValidMessage)

        }

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
        //
        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "lastName") {
                lastNameEx = error.response.data.fieldErrors[i].message;
            }
        }
        //
        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "mail") {
                mailEx = error.response.data.fieldErrors[i].message;
            }
        }
        //
        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "password") {
                passEx = error.response.data.fieldErrors[i].message;
            }
        }
        //
        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "checkPassword") {
                checkPassEx = error.response.data.fieldErrors[i].message;
            }
        }
        //
        var nameC = document.createElement('pr');
        nameC.style.color = 'red';
        nameC.style.position = 'fixed';
        nameC.style.top = '275px';
        nameC.style.left = '1080px';
        nameC.style.fontFamily = '"Brush Script MT", cursive';
        nameC.textContent = nameEx;
        document.body.appendChild(nameC)

        var loginC = document.createElement('pr');
        loginC.style.color = 'red';
        loginC.style.position = 'fixed';
        loginC.style.top = '480px';
        loginC.style.left = '1080px';
        loginC.style.fontFamily = '"Brush Script MT", cursive';
        loginC.textContent = loginEx;
        document.body.appendChild(loginC)

        var mailC = document.createElement('pr');
        mailC.style.color = 'red';
        mailC.style.position = 'fixed';
        mailC.style.top = '410px';
        mailC.style.left = '1080px';
        mailC.style.fontFamily = '"Brush Script MT", cursive';
        mailC.textContent = mailEx;
        document.body.appendChild(mailC)
    //
        var lastNameC = document.createElement('pr');
        lastNameC.style.color = 'red';
        lastNameC.style.position = 'fixed';
        lastNameC.style.top = '340px';
        lastNameC.style.left = '1080px';
        lastNameC.style.fontFamily = '"Brush Script MT", cursive';
        lastNameC.textContent = lastNameEx;
        document.body.appendChild(lastNameC)
    //
        var pass = document.createElement('pr');
        pass.style.color = 'red';
        pass.style.position = 'fixed';
        pass.style.top = '555px';
        pass.style.left = '1080px';
        pass.style.fontFamily = '"Brush Script MT", cursive';
        pass.textContent = passEx;
        document.body.appendChild(pass)
    //
        var checkPass = document.createElement('pr');
        checkPass.style.color = 'red';
        checkPass.style.position = 'fixed';
        checkPass.style.top = '625px';
        checkPass.style.left = '1080px';
        checkPass.style.fontFamily = '"Brush Script MT", cursive';
        checkPass.textContent = checkPassEx;
        document.body.appendChild(checkPass)
    //
    })
        .then((res) => {
        if (res.status === 200) {
            alert('Вы успешно зарегистрированы!')
            window.location = '/login';
            return res.json();
        }
    })
})