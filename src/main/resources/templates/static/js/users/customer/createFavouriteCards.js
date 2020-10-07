const requestURL = '/api/drinks/favourites'

const xhr = new XMLHttpRequest();

xhr.open('GET', requestURL)

xhr.setRequestHeader('Authorization', localStorage.getItem('token'))

xhr.onload = () => {

    var datas = JSON.parse(xhr.response)

    for (let i = 0; i <= datas.length; i++) {

        var card = document.createElement("div");
        card.style.boxShadow = '0 4px 8px 0 rgba(0, 0, 0, 0.2)';
        card.style.textAlign = 'center';
        card.style.fontFamily = 'arial, serif';
        card.style.width = '15%';
        card.style.background = 'white';
        card.style.margin = '5px';

        var favourite = document.createElement('button');
        favourite.id = datas[i].id + 3000;
        favourite.style.color = 'white'
        favourite.style.backgroundColor = 'red'
        favourite.style.border = 'none';
        favourite.style.outline = '0';
        favourite.style.padding = '11px';
        favourite.style.textAlign = 'center';
        favourite.style.cursor = 'pointer';
        favourite.style.width = '100%';
        favourite.style.fontSize = '18px';
        favourite.textContent = 'Удалить из избранного'

        favourite.onclick = function () {

            let id = this.id - 3000

            fetch("/api/drinks/" + id + "/favourites", {

                method: 'DELETE',

                headers: {
                    'Content-Type': 'application/json;charset=utf-8',

                    'Authorization': localStorage.getItem('token')
                },
            })
                .then((res) => {
                    if (res.status === 200) {
                        alert('Напиток успешно удален из избранного!')
                        location.reload()
                    }
                })
        }

        var image = document.createElement("img")
        image.id = datas[i].id + 1100
        image.style.width = "225px";
        image.style.height = "129px";

        let drinkId = image.id - 1100

        fetch("/api/drinks/" + drinkId + "/image", {

            method: 'GET',

            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            }
        })

        image.src = 'http://localhost:8080/api/drinks/' + drinkId + '/image'

        var name = document.createElement("h1");
        name.textContent = datas[i].name;

        var price = document.createElement("p");
        price.textContent = 'Цена: ' + datas[i].price + '₽';
        price.style.color = 'grey';
        price.style.background = 'white';
        price.style.fontSize = '22px';

        var weight = document.createElement("p");
        weight.textContent = 'Вес: ' + datas[i].weight + 'гр.';

        var country = document.createElement("p");
        country.textContent = 'Страна: ' + datas[i].country.name;

        var button = document.createElement("button")
        button.textContent = "Добавить в корзину";
        button.id = datas[i].id;
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

            fetch("/api/cart-item/" + this.id, {

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

        var super_di = document.getElementById('cards')

        super_di.appendChild(card);
    }
}
xhr.send()