var coffeeTypeUrl = "/catalogs/coffee-types";

const xhrCoffeeType = new XMLHttpRequest();

xhrCoffeeType.open('GET', coffeeTypeUrl)

xhrCoffeeType.onload = () => {

    var datasss = JSON.parse(xhrCoffeeType.response)

    for (let i = 0; i < datasss.length; i++) {

        var coffeeType = document.createElement('option')
        coffeeType.value = datasss[i].id
        coffeeType.id = datasss[i].id
        coffeeType.textContent = datasss[i].name

        var super_select = document.getElementById('cofType')

        super_select.appendChild(coffeeType)
    }
}
xhrCoffeeType.send()