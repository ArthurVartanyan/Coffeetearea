function coffeeFilter() {

    var urlForPagi = '/coffee/filter'

    const xhrPagi = new XMLHttpRequest();

    xhrPagi.open('GET', urlForPagi)

    xhrPagi.onload = () => {

        var datas_ = JSON.parse(xhrPagi.response)

        for (let i = 0; i < datas_.totalPages; i++) {
            document.getElementById(i + 10000).style.backgroundColor = 'chocolate';
            document.getElementById(i + 10000).style.color = 'black';
            document.getElementById(i + 10000).style.border = '1px solid chocolate';
        }

        document.getElementById(datas_.number + 10000).style.backgroundColor = '#4CAF50';
        document.getElementById(datas_.number + 10000).style.color = 'white';
        document.getElementById(datas_.number + 10000).style.border = '1px solid #4CAF50';
    }
    xhrPagi.send()

    var roastingId = document.getElementById('roast').value
    var typeId = document.getElementById('cofType').value
    var countryId = document.getElementById('coffeeCountry').value
    var minPriceId = document.getElementById('min-price').value
    var maxPriceId = document.getElementById('max-price').value

    var drinkName = document.getElementById('drinkName').value

    if (drinkName.length > 0) {

        createCoffeeCardsFilter(number = 0, sortingParams = 'NAME_INCREASE', roastingId, typeId, countryId, minPriceId, maxPriceId, drinkName)
    } else {

        createCoffeeCardsFilter(number = 0, sortingParams = 'NAME_INCREASE', roastingId, typeId, countryId, minPriceId, maxPriceId)
    }
}