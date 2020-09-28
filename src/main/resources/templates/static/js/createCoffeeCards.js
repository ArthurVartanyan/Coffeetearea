function createCards(number = '0', sortingParams = 'NAME_INCREASE') {

    var url = new URL("http://localhost:8080/coffee/all?" + 'page=' + number + "&sortingParams=" + sortingParams);

    const xhr = new XMLHttpRequest();


    xhr.open('GET', url)


    xhr.onload = () => {

        var datas = JSON.parse(xhr.response)

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
            image.id = datas.content[i].id + 700
            image.style.width = "229px";
            image.style.height = "129px";

            let drinkId = image.id - 700

            fetch("/drinks/" + drinkId + "/image", {

                method: 'GET',

                headers: {
                    'Content-Type': 'application/json;charset=utf-8'
                }
            })

            image.src = 'http://localhost:8080/drinks/' + drinkId + '/image'

            var name = document.createElement("h1");
            name.textContent = datas.content[i].name;
            name.onclick = function () {
                RedirectDrink();

            }


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
            favourite.onclick = function() {

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
            button.className = 'button'
            button.id = datas.content[i].id
            button.textContent = "Добавить в корзину"
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

            var s_div = document.getElementById('cards')

            s_div.appendChild(card);
        }

        for (let i = 0; i < datas.totalPages; i++) {
            document.getElementById(i).style.backgroundColor = 'chocolate';
            document.getElementById(i).style.color = 'black';
            document.getElementById(i).style.border = '1px solid chocolate';
        }

        document.getElementById(number).style.backgroundColor = '#4CAF50';
        document.getElementById(number).style.color = 'white';
        document.getElementById(number).style.border = '1px solid #4CAF50';
    }
    xhr.send();
}