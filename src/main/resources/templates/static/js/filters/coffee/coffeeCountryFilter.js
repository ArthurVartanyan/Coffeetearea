var coffeeCountryUrl = "/api/catalogs/countries";

const xhrCoffeeCountry = new XMLHttpRequest();

xhrCoffeeCountry.open('GET', coffeeCountryUrl)

xhrCoffeeCountry.onload = () => {

    var datassss = JSON.parse(xhrCoffeeCountry.response)

    for (let i = 0; i < datassss.length; i++) {

        var teaCountry = document.createElement('option')
        teaCountry.value = datassss[i].id
        teaCountry.id = datassss[i].id
        teaCountry.textContent = datassss[i].name

        var super_select = document.getElementById('coffeeCountry')

        super_select.appendChild(teaCountry)
    }
}
xhrCoffeeCountry.send()