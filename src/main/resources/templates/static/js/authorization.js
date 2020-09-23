let _form = document.querySelector("form")

_form.addEventListener("submit", function (e) {
    e.preventDefault();

    fetch("/users/login", {

        method: 'POST',

        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(Object.fromEntries(new FormData(e.target)))
    })
        .then((res) => {
            if (res.status === 200) {
                window.location = '/home';
                return res.json();
            }
            if (res.status === 403) {
                window.location = '/errorLogin';
            }
        })
        .then((data) => {
            if (data && data.token) {
                localStorage.setItem('token', 'Bearer ' + data.token);
            }
        })
})