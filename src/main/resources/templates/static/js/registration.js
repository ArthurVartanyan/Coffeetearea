let _form = document.querySelector("form")

_form.addEventListener("submit", function (e) {
    e.preventDefault();

    fetch("/users/registration", {

        method: 'POST',

        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(Object.fromEntries(new FormData(e.target)))

    }).then((res) => {

        if (res.status === 200) {
            alert('Вы успешно зарегистрированы!')
            window.location = '/login';
            return res.json();
        }
    })
})