function RedirectLogin() {
    if (localStorage.getItem('token') !== null) {
        alert("Уважаемый покупатель, Вы уже авторизовались!")
    } else (window.location = '/login');
}

function RedirectFavourites() {
    if (localStorage.getItem('token') === null) {
        window.location = '/login'
    } else (window.location = '/favourites');
}

function logOut(){
    localStorage.removeItem('token')
    window.location = '/home'
}

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

function RedirectCard() {
    window.location = '/card';
}

function RedirectOrder() {
    window.location = '/order';
}

function RedirectCountries() {
    window.location = '/admin-countries'
}

function RedirectCoffeeTypes() {
    window.location = '/admin-coffee-type'
}

function RedirectManufacturers() {
    window.location = '/admin-manufacturers'
}

function RedirectRoastings() {
    window.location = '/admin-roastings'
}

function RedirectTeaTypes() {
    window.location = '/admin-tea-types'
}

function RedirectTeaColors() {
    window.location = '/admin-tea-colors'
}

function RedirectPackages() {
    window.location = '/admin-packages'
}

function RedirectCatalog() {
    window.location = '/admin-catalog'
}

function RedirectAdminTea() {
    window.location = '/admin-tea'
}


function RedirectAdminCoffee() {
    window.location = '/admin-coffee'
}

