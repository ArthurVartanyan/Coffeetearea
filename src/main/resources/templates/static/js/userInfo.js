const request = '/users/info'

const xh = new XMLHttpRequest();

xh.open('GET', request)

if (localStorage.getItem('token') !== null) {

    xh.responseType = 'json';

    xh.setRequestHeader('Authorization', localStorage.getItem('token'));

    xh.onload = () => {

        var nameAndLastname = document.createElement('pr')
        nameAndLastname.textContent = xh.response.name + "_" + xh.response.lastName
        var br1 = document.createElement('br')
        var br2 = document.createElement('br')
        var login = document.createElement('pr')
        login.textContent = 'Логин:_' + xh.response.login
        var mail = document.createElement('pr')
        mail.textContent = xh.response.mail

        var super_div = document.getElementById('info')
        super_div.appendChild(nameAndLastname)
        super_div.appendChild(br1)
        super_div.appendChild(login)
        super_div.appendChild(br2)
        super_div.appendChild(mail)

    }

    xh.send(xh)
}

