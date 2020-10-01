let _form = document.querySelector("form")

_form.addEventListener("submit", function (e) {
    e.preventDefault();

    fetch("/users/registration", {

        method: 'POST',

        headers: {
            'Content-Type': 'application/json',

            'accept': '*/*'
        },
        body: JSON.stringify(Object.fromEntries(new FormData(e.target)))

    }).then((res) => {

        if (res.status === 200) {
            alert('Вы успешно зарегистрированы!')
            window.location = '/login';
            return res.json();
        } else {
            var name = document.createElement('pr');
            name.style.color = 'red';
            name.style.position = 'fixed';
            name.style.top = '275px';
            name.style.left = '1080px';
            name.style.fontFamily = '"Brush Script MT", cursive';

            var sup_div = document.getElementById('formElem')
            sup_div.appendChild(name)
        }
    })
})