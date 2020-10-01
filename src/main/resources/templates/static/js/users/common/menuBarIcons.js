if (localStorage.getItem('token') === null) {
    document.getElementById('logout').style.display = 'none'
}

if (localStorage.getItem('token') !== null) {
    document.getElementById('login').style.display = 'none'
}