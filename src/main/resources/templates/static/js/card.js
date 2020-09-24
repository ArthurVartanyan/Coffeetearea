if (localStorage.getItem('token') !== null) {

    const requestURL = '/cart-item/list'

    const xhr = new XMLHttpRequest();

    xhr.open('GET', requestURL)

    xhr.setRequestHeader('Authorization', localStorage.getItem('token'))


    xhr.onload = () => {

        var datas = JSON.parse(xhr.response)

        var superio_div = document.getElementById('cardItems')

        for (let i = 0; i < datas.cartItemDTOS.length; i++) {

            var cardItem = document.createElement("pr");
            cardItem.style.fontFamily = 'Brush Script MT, cursive';
            cardItem.style.fontSize = '30px';
            cardItem.style.color = 'chocolate';

            var itemCount = document.createElement("input")
            itemCount.style.width = '30px';
            itemCount.value = datas.cartItemDTOS[i].count;

            var button = document.createElement("button")
            button.id = datas.cartItemDTOS[i].drink.id;
            button.style.width = '100px';
            button.style.height = '30px';
            button.style.marginLeft = '20px';
            button.textContent = 'Изменить'



            button.onclick = function () {

                const data = JSON.stringify({
                    count: 4
                });


                fetch("/cart-item/" + this.id + "/number", {

                    method: 'PUT',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')
                    },
                    body: data
                })
            }


            var cardItemCount = document.createElement("pr");
            cardItemCount.style.fontFamily = 'Brush Script MT, cursive';
            cardItemCount.style.fontSize = '30px';
            cardItemCount.style.color = 'chocolate';

            var weight = document.createElement("pr")
            weight.className = 'weightClassName'
            weight.style.fontFamily = 'Brush Script MT, cursive';
            weight.style.fontSize = '30px';
            weight.style.color = 'chocolate';
            weight.textContent = "Вес: " + datas.cartItemDTOS[i].drink.weight + "гр.";

            var br0 = document.createElement('br');
            var br1 = document.createElement('br');
            var br2 = document.createElement('br');
            var br3 = document.createElement('br');
            var br4 = document.createElement('br');

            cardItem.textContent = "Название: " + datas.cartItemDTOS[i].drink.name;

            cardItemCount.textContent = "Количество: ";


            var delButton = document.createElement('button');
            delButton.id = datas.cartItemDTOS[i].drink.id;
            delButton.textContent = "Удалить";
            delButton.style.marginLeft = "30px";

            delButton.onclick = function(){

                fetch("/cart-item/" + this.id, {

                    method: 'DELETE',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',
                        'Authorization': localStorage.getItem('token')
                    }
                }).then(() => {
                    location.reload()
                })
            }


            superio_div.appendChild(cardItem);
            superio_div.appendChild(br0);
            superio_div.appendChild(weight);
            superio_div.appendChild(br1);
            superio_div.appendChild(cardItemCount);
            superio_div.appendChild(itemCount);
            superio_div.appendChild(button);
            superio_div.appendChild(delButton);
            superio_div.appendChild(br2);
            superio_div.appendChild(br3);
            superio_div.appendChild(br4);

        }


        var removeAllButton = document.createElement("button")

        removeAllButton.style.width = '200px';
        removeAllButton.style.height = '40px';
        removeAllButton.style.position = 'fixed'
        removeAllButton.style.marginLeft = '700px';
        removeAllButton.style.top = '400px';
        removeAllButton.textContent = 'Очистить корзину'
        removeAllButton.onclick = function () {

                fetch("/cart-item/all", {

                    method: 'DELETE',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')

                    }
                })
                    .then(() => {
                        alert("Вы очистили корзину!")
                        location.reload()
                    })
            }



        var order = document.createElement("button")

        order.style.width = '200px';
        order.style.height = '40px';
        order.style.position = 'fixed'
        order.style.marginLeft = '950px';
        order.style.top = '400px';
        order.textContent = 'Оформить заказ'
        order.onclick = function () {

            if (document.getElementById('cardItems').childElementCount !== 1){
                RedirectOrder();
            } else (alert('Ошибка! Для оформления заказа Вам необходимо пополнить корзину!'))
        }

            var br5 = document.createElement('br');

            document.body.appendChild(removeAllButton);
            document.body.appendChild(order);
            superio_div.appendChild(br5);

            const url = '/cart-item/list'

            const request = new XMLHttpRequest();

            request.open('GET', url)

            request.setRequestHeader('Authorization', localStorage.getItem('token'))


            var totalPrice = document.createElement("pr")
            totalPrice.style.fontFamily = 'Brush Script MT, cursive';
            totalPrice.style.fontSize = '50px';
            totalPrice.style.position = 'fixed'
            totalPrice.style.left = '650px';
            totalPrice.style.top = '300px'
            totalPrice.style.color = '#228B22';
            totalPrice.textContent = "Стоимость заказа: " + datas.orderPrice + "₽";

            document.body.appendChild(totalPrice);
        }
        xhr.send()
    }