function RedirectContacts() {
    window.location = '/contacts';
}

function RedirectCoffees() {
    window.location = '/coffees';
}

function RedirectTeas() {
    window.location = '/teas';
}

function RedirectAbout() {
    window.location = '/about';
}

function RedirectHome() {
    window.location = '/home';
}

function RedirectRegistration() {
    window.location = '/registration';
}

function RedirectLogin() {
    if (localStorage.getItem('token') !== null) {
        alert("Уважаемый покупатель, Вы уже авторизовались!")
    } else (window.location = '/login');

}

function RedirectCard() {
    window.location = '/card';
}

function RedirectOrder() {
    window.location = '/order';
}

function RedirectTea() {
    window.location = '/drink';
}

function RedirectFavourites() {
    window.location = '/favourites';
}