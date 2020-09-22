const requestURL = '/drinks/populars'

const xhr = new XMLHttpRequest();

xhr.open('GET', requestURL)

xhr.onload = () => {

    var datas = JSON.parse(xhr.response)

    for (let i = 0; i <= 4; i++) {

        var card = document.createElement("div");
        card.style.boxShadow = '0 4px 8px 0 rgba(0, 0, 0, 0.2)';
        card.style.textAlign = 'center';
        card.style.fontFamily = 'arial, serif';
        card.style.width = '15%';
        card.style.background = 'white';
        card.style.margin = '5px';

        var image = document.createElement("img")
        image.src = "static/images/back.jpg"
        image.style.width = "100%";

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
        button.onclick = function() {

            fetch("/cart-item/" + this.id, {

                method: 'POST',

                headers: {
                    'Content-Type': 'application/json;charset=utf-8',

                    'Authorization': localStorage.getItem('token')
                },
            })
        }

        card.appendChild(image);
        card.appendChild(name);
        card.appendChild(price);
        card.appendChild(weight);
        card.appendChild(country);
        card.appendChild(button);

        var super_div = document.getElementById('cards')

        super_div.appendChild(card);
    }
}
xhr.send()