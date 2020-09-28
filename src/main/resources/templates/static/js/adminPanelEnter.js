const admUrl = '/users/info'

const xah = new XMLHttpRequest();

xah.open('GET', admUrl)

if (localStorage.getItem('token') !== null) {

    xah.responseType = 'json';

    xah.setRequestHeader('Authorization', localStorage.getItem('token'));

    xah.onload = () => {

        if (xah.response.role === 'ADMIN') {
            var aaaa = document.createElement('a')
            aaaa.textContent = 'Режим модератора'
            aaaa.style.color = 'white'
            aaaa.style.position = 'absolute'
            aaaa.style.top = '30px'
            aaaa.style.left = '900px'
            aaaa.href = '/admin'

            document.body.appendChild(aaaa);
        }
    }
    xah.send()
}