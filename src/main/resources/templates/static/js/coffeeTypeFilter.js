var coffeeTypeUrl = "/catalogs/coffee-types";

const xhrCoffeeType = new XMLHttpRequest();

xhrCoffeeType.open('GET', coffeeTypeUrl)

xhrCoffeeType.onload = () => {

    var datasss = JSON.parse(xhrCoffeeType.response)

    for (let i = 0; i < datasss.length; i++) {

        var teaType = document.createElement('option')
        teaType.value = datasss[i].id
        teaType.id = datasss[i].id
        teaType.textContent = datasss[i].name

        var super_select = document.getElementById('coffeeType')

        super_select.appendChild(teaType)
    }
}
xhrCoffeeType.send()