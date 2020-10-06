var pagUrl = "/coffee/all";

const xhrPag = new XMLHttpRequest();

xhrPag.open('GET', pagUrl)

xhrPag.onload = () => {

    var data = JSON.parse(xhrPag.response)

    var formS = document.getElementById('sort')

    for (let i = 0; i < data.totalPages; i++) {

        var a = document.createElement('a');
        a.id = i + 10000
        a.style.color = 'black'
        a.style.float = 'left'
        a.style.padding = '8px 16px'
        a.style.textDecoration = 'chocolate'
        a.style.backgroundColor = 'chocolate'
        a.style.border = '1px solid chocolate'
        a.textContent = i + 1;
        a.href = "#"

        a.onclick = function pages() {

            for (let i = 0; i < data.totalPages; i++) {
                document.getElementById(i + 10000).style.backgroundColor = 'chocolate';
                document.getElementById(i + 10000).style.color = 'black';
                document.getElementById(i + 10000).style.border = '1px solid chocolate';
            }
            document.getElementById(this.id).style.backgroundColor = '#4CAF50';
            document.getElementById(this.id).style.color = 'white';
            document.getElementById(this.id).style.border = '1px solid #4CAF50';

            if (formS.value === 'По алфавиту 🠗') {
                createCoffeeCardsFilter(i, 'NAME_INCREASE', roastingId = document.getElementById('roast').value, typeId = document.getElementById('cofType').value, countryId = document.getElementById('coffeeCountry').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value, /*drinkName = document.getElementById('drinkName').value*/)
            }

            if (formS.value === 'Цена 🠗') {
                createCoffeeCardsFilter(i, 'PRICE_DECREASE', roastingId = document.getElementById('roast').value, typeId = document.getElementById('cofType').value, countryId = document.getElementById('coffeeCountry').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value, /*drinkName = document.getElementById('drinkName').value*/)
            }

            if (formS.value === 'Цена 🠕') {
                createCoffeeCardsFilter(i, 'PRICE_INCREASE', roastingId = document.getElementById('roast').value, typeId = document.getElementById('cofType').value, countryId = document.getElementById('coffeeCountry').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value, /*drinkName = document.getElementById('drinkName').value*/)
            }

            if (formS.value === 'По популярности 🠗') {
                createCoffeeCardsFilter(i, 'POP_DECREASE', roastingId = document.getElementById('roast').value, typeId = document.getElementById('cofType').value, countryId = document.getElementById('coffeeCountry').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value, /*drinkName = document.getElementById('drinkName').value*/)
            }
        }

        formS.onchange = function () {

            var urlForPaga = '/coffee/filter'

            const xhrPaga = new XMLHttpRequest();

            xhrPaga.open('GET', urlForPaga)

            xhrPaga.onload = () => {

                var datas_ = JSON.parse(xhrPaga.response)

                for (let i = 0; i < datas_.totalPages; i++) {
                    document.getElementById(i + 10000).style.backgroundColor = 'chocolate';
                    document.getElementById(i + 10000).style.color = 'black';
                    document.getElementById(i + 10000).style.border = '1px solid chocolate';
                }

                document.getElementById(datas_.number + 10000).style.backgroundColor = '#4CAF50';
                document.getElementById(datas_.number + 10000).style.color = 'white';
                document.getElementById(datas_.number + 10000).style.border = '1px solid #4CAF50';
            }
            xhrPaga.send()

            if (formS.value === 'По алфавиту 🠗') {

                createCoffeeCardsFilter(0, 'NAME_INCREASE', roastingId = document.getElementById('roast').value, typeId = document.getElementById('cofType').value, countryId = document.getElementById('coffeeCountry').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value, /*drinkName = document.getElementById('drinkName').value*/)
            }

            if (formS.value === 'Цена 🠗') {
                createCoffeeCardsFilter(0, 'PRICE_DECREASE', roastingId = document.getElementById('roast').value, typeId = document.getElementById('cofType').value, countryId = document.getElementById('coffeeCountry').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value, /*drinkName = document.getElementById('drinkName').value*/)
            }

            if (formS.value === 'Цена 🠕') {
                createCoffeeCardsFilter(0, 'PRICE_INCREASE', roastingId = document.getElementById('roast').value, typeId = document.getElementById('cofType').value, countryId = document.getElementById('coffeeCountry').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value, /*drinkName = document.getElementById('drinkName').value*/)
            }

            if (formS.value === 'По популярности 🠗') {
                createCoffeeCardsFilter(0, 'POP_DECREASE', roastingId = document.getElementById('roast').value, typeId = document.getElementById('cofType').value, countryId = document.getElementById('coffeeCountry').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value, /*drinkName = document.getElementById('drinkName').value*/)
            }
        }

        var super_d = document.getElementById('pagination');

        super_d.appendChild(a);
    }
}
xhrPag.send()