var coffeeRoastUrl = "/catalogs/roastings";

const xhrCoffeeRoast = new XMLHttpRequest();

xhrCoffeeRoast.open('GET', coffeeRoastUrl)

xhrCoffeeRoast.onload = () => {

    var datasss = JSON.parse(xhrCoffeeRoast.response)

    for (let i = 0; i < datasss.length; i++) {

        var teaType = document.createElement('option')
        teaType.value = datasss[i].id
        teaType.id = datasss[i].id
        teaType.textContent = datasss[i].name

        var super_select = document.getElementById('roast')

        super_select.appendChild(teaType)
    }
}
xhrCoffeeRoast.send()