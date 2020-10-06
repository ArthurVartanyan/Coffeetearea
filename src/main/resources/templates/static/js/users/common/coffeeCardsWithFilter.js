function createCoffeeCardsFilter(number = '0', sortingParams = 'NAME_INCREASE',
                                 roastingId = '', typeId = '', countryId = '',
                                 min = '', max = '', drinkname = '') {

    var urlFilter = new URL("http://localhost:8080/coffee/filter?" + "page_size=" + 4 + '&page=' + number + "&sortingParams=" + sortingParams + '&countryId=' + countryId + '&roastingId=' +
        roastingId + '&typeId=' + typeId + '&min=' + min + '&max=' + max + '&drinkName=' + drinkname);

    const xhrFilt = new XMLHttpRequest();

    xhrFilt.open('GET', urlFilter)

    xhrFilt.onload = () => {

        var datas = JSON.parse(xhrFilt.response)

        document.getElementById('cards').innerHTML = "";

        for (let i = 0; i < datas.content.length; i++) {

            var card = document.createElement("div");
            card.style.boxShadow = '0 4px 8px 0 rgba(0, 0, 0, 0.2)';
            card.style.textAlign = 'center';
            card.style.fontFamily = 'arial, serif';
            card.style.width = '15%';
            card.style.background = 'white';
            card.style.margin = '5px';

            var image = document.createElement("img")
            image.id = datas.content[i].id + 500
            image.style.width = "229px";
            image.style.height = "129px";

            let drinkId = image.id - 500

            fetch("/drinks/" + drinkId + "/image", {

                method: 'GET',

                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                }
            })

            image.src = 'http://localhost:8080/drinks/' + drinkId + '/image'

            var favourite = document.createElement('button');
            favourite.id = datas.content[i].id + 3000;
            favourite.style.color = 'white'
            favourite.style.backgroundColor = 'green'
            favourite.style.border = 'none';
            favourite.style.outline = '0';
            favourite.style.padding = '11px';
            favourite.style.textAlign = 'center';
            favourite.style.cursor = 'pointer';
            favourite.style.width = '100%';
            favourite.style.fontSize = '18px';
            favourite.textContent = 'Добавить в избранное'

            favourite.onclick = function () {

                let id = this.id - 3000

                fetch("/drinks/" + id + "/favourites", {

                    method: 'POST',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')
                    },
                })
                    .then((res) => {
                        if (res.status === 200) {
                            alert('Напиток успешно добавлен в избранное!')
                        }
                    })
            }

            var name = document.createElement("h1");
            name.textContent = datas.content[i].name;
            name.id = datas.content[i].id + 1000;

            name.onclick = function () {

                document.getElementById('sort').remove()
                document.getElementById('roast').remove()
                document.getElementById('cofType').remove()
                document.getElementById('coffeeCountry').remove()
                document.getElementById('min-price').remove()
                document.getElementById('max-price').remove()
                document.getElementById('coffee-filter').remove()
                document.getElementById('cards').remove()
                document.getElementById('pagination').remove()

                let newId = this.id - 1000

                const coffeeUrl = '/coffee/' + newId;

                const coffee = new XMLHttpRequest();

                coffee.open('GET', coffeeUrl)

                coffee.setRequestHeader('Authorization', localStorage.getItem('token'))

                coffee.onload = () => {

                    var dannie = JSON.parse(coffee.response)

                    var name = document.createElement('h1')
                    name.textContent = dannie.name
                    name.style.position = 'fixed'
                    name.style.left = '750px'
                    name.style.top = '120px'
                    name.style.fontSize = '70px'
                    name.style.color = '#1D8348'

                    var image = document.createElement('img')
                    image.src = "static/images/drinkBack.jpg";
                    image.style.width = '1920px'
                    image.style.height = '1060px'
                    image.style.position = 'fixed'
                    image.style.left = '0px'
                    image.style.top = '88px'

                    var image2 = document.createElement('img')
                    image2.src = 'http://localhost:8080/drinks/' + newId + '/image'
                    image2.style.width = '600px'
                    image2.style.height = '750px'
                    image2.style.position = 'fixed'
                    image2.style.left = '100px'
                    image2.style.top = '120px'

                    var weight = document.createElement('pr')
                    weight.textContent = 'Вес: ' + dannie.weight + ' грамм'
                    weight.style.position = 'fixed'
                    weight.style.left = '750px'
                    weight.style.top = '270px'
                    weight.style.fontSize = '25px'
                    weight.style.color = '#8B4513'

                    var price = document.createElement('pr')
                    price.textContent = 'Цена: ' + dannie.price + '₽'
                    price.style.position = 'fixed'
                    price.style.left = '750px'
                    price.style.top = '230px'
                    price.style.fontSize = '25px'
                    price.style.color = '#8B4513'

                    var about = document.createElement('pr')
                    about.textContent = 'О товаре: ' + dannie.about
                    about.style.position = 'fixed'
                    about.style.left = '750px'
                    about.style.top = '510px'
                    about.style.fontSize = '25px'
                    about.style.color = '#8B4513'

                    var country = document.createElement('pr')
                    country.textContent = 'Страна: ' + dannie.country.name
                    country.style.position = 'fixed'
                    country.style.left = '750px'
                    country.style.top = '350px'
                    country.style.fontSize = '25px'
                    country.style.color = '#8B4513'

                    var manufacturer = document.createElement('pr')
                    manufacturer.textContent = 'Производитель: ' + dannie.manufacturer.name
                    manufacturer.style.position = 'fixed'
                    manufacturer.style.left = '750px'
                    manufacturer.style.top = '390px'
                    manufacturer.style.fontSize = '25px'
                    manufacturer.style.color = '#8B4513'

                    var packaging = document.createElement('pr')
                    packaging.textContent = 'Упаковка: ' + dannie.packaging.name
                    packaging.style.position = 'fixed'
                    packaging.style.left = '750px'
                    packaging.style.top = '430px'
                    packaging.style.fontSize = '25px'
                    packaging.style.color = '#8B4513'

                    var roass = document.createElement('pr')
                    roass.textContent = 'Степень прожарки: ' + dannie.roasting.name
                    roass.style.position = 'fixed'
                    roass.style.left = '750px'
                    roass.style.top = '470px'
                    roass.style.fontSize = '25px'
                    roass.style.color = '#8B4513'

                    var coffeeType = document.createElement('pr')
                    coffeeType.textContent = 'Тип: ' + dannie.coffeeType.name
                    coffeeType.style.position = 'fixed'
                    coffeeType.style.left = '750px'
                    coffeeType.style.top = '310px'
                    coffeeType.style.fontSize = '25px'
                    coffeeType.style.color = '#8B4513'

                    var br0 = document.createElement('br')
                    var br1 = document.createElement('br')
                    var br2 = document.createElement('br')
                    var br3 = document.createElement('br')
                    var br4 = document.createElement('br')
                    var br5 = document.createElement('br')
                    var br6 = document.createElement('br')
                    var br7 = document.createElement('br')
                    var br8 = document.createElement('br')
                    var br9 = document.createElement('br')
                    var br10 = document.createElement('br')
                    var br11 = document.createElement('br')
                    var br12 = document.createElement('br')
                    var br13 = document.createElement('br')
                    var br14 = document.createElement('br')
                    var br15 = document.createElement('br')
                    var br16 = document.createElement('br')
                    var br17 = document.createElement('br')
                    var br18 = document.createElement('br')
                    var br19 = document.createElement('br')
                    var br20 = document.createElement('br')


                    var button = document.createElement('button')
                    button.textContent = 'Добавить в корзину';
                    button.style.height = '60px';
                    button.style.width = '200px';
                    button.style.position = 'fixed';
                    button.style.left = '750px';
                    button.style.top = '780px';
                    button.style.color = 'white';
                    button.style.backgroundColor = '#1D8348';
                    button.onclick = function () {

                        fetch("/cart-item/" + newId, {

                            method: 'POST',

                            headers: {
                                'Content-Type': 'application/json;charset=utf-8',

                                'Authorization': localStorage.getItem('token')
                            },
                        })
                            .then((res) => {
                                if (res.status === 200) {
                                    alert('Напиток успешно добавлен в корзину!')
                                }
                            })
                    }

                    var drink_div = document.getElementById('drinkCoffee')
                    drink_div.appendChild(image)
                    drink_div.appendChild(image2)
                    drink_div.appendChild(name)
                    drink_div.appendChild(br8)
                    drink_div.appendChild(br9)
                    drink_div.appendChild(br10)
                    drink_div.appendChild(br11)
                    drink_div.appendChild(br12)
                    drink_div.appendChild(br0)
                    drink_div.appendChild(weight)
                    drink_div.appendChild(br1)
                    drink_div.appendChild(br13)
                    drink_div.appendChild(price)
                    drink_div.appendChild(br2)
                    drink_div.appendChild(br14)
                    drink_div.appendChild(country)
                    drink_div.appendChild(br3)
                    drink_div.appendChild(br15)
                    drink_div.appendChild(roass)
                    drink_div.appendChild(br4)
                    drink_div.appendChild(br16)
                    drink_div.appendChild(coffeeType)
                    drink_div.appendChild(br5)
                    drink_div.appendChild(br17)
                    drink_div.appendChild(packaging)
                    drink_div.appendChild(br6)
                    drink_div.appendChild(br18)
                    drink_div.appendChild(manufacturer)
                    drink_div.appendChild(br7)
                    drink_div.appendChild(br19)
                    drink_div.appendChild(about)
                    drink_div.appendChild(br20)
                    drink_div.appendChild(button)
                }
                coffee.send()
            }

            var price = document.createElement("p");
            price.textContent = 'Цена: ' + datas.content[i].price + '₽';
            price.style.color = 'grey';
            price.style.background = 'white';
            price.style.fontSize = '22px';

            var weight = document.createElement("p");
            weight.textContent = 'Вес: ' + datas.content[i].weight + 'гр.';

            var country = document.createElement("p");
            country.textContent = 'Страна: ' + datas.content[i].country.name;

            var button = document.createElement("button")
            button.textContent = "Добавить в корзину";
            button.id = datas.content[i].id;
            button.style.border = 'none';
            button.style.outline = '0';
            button.style.padding = '12px';
            button.style.color = 'white';
            button.style.backgroundColor = '#000';
            button.style.textAlign = 'center';
            button.style.cursor = 'pointer';
            button.style.width = '100%';
            button.style.fontSize = '18px';

            button.onclick = function () {

                fetch("/cart-item/" + this.id, {

                    method: 'POST',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')
                    },
                })
                    .then((res) => {
                        if (res.status === 200) {
                            alert('Напиток успешно добавлен в корзину!')
                        }
                    })
            }

            card.appendChild(image);
            card.appendChild(name);
            card.appendChild(price);
            card.appendChild(weight);
            card.appendChild(country);
            card.appendChild(favourite);
            card.appendChild(button);

            var supe_div = document.getElementById('cards')

            supe_div.appendChild(card);
        }

        for (let i = 0; i < datas.totalPages; i++) {
            document.getElementById(i + 10000).style.backgroundColor = 'chocolate';
            document.getElementById(i + 10000).style.color = 'black';
            document.getElementById(i + 10000).style.border = '1px solid chocolate';
        }

        document.getElementById(datas.number + 10000).style.backgroundColor = '#4CAF50';
        document.getElementById(datas.number + 10000).style.color = 'white';
        document.getElementById(datas.number + 10000).style.border = '1px solid #4CAF50';
    }
    xhrFilt.send()
}