if (localStorage.getItem('token') !== null) {

    const requestURL = '/catalogs/countries'

    const xhr = new XMLHttpRequest();

    xhr.open('GET', requestURL)

    xhr.setRequestHeader('Authorization', localStorage.getItem('token'))

    xhr.onload = () => {

        var datas = JSON.parse(xhr.response)

        var superio_div = document.getElementById('countries')

        for (let i = 0; i < datas[i].length; i++) {

            var countryName = document.createElement("pr");
            countryName.style.fontFamily = 'Brush Script MT, cursive';
            countryName.style.fontSize = '30px';
            countryName.style.color = 'chocolate';
            countryName.textContent = "Название: " + datas[i].name;

            var button = document.createElement("button")
            button.id = datas[i].id;
            button.style.width = '100px';
            button.style.height = '30px';
            button.style.marginLeft = '20px';
            button.textContent = 'Редактировать'

            button.onclick = function () {
            }

            var br0 = document.createElement('br');
            var br1 = document.createElement('br');
            var br2 = document.createElement('br');
            var br3 = document.createElement('br');
            var br4 = document.createElement('br');


            var delButton = document.createElement('button');
            delButton.id = datas[i].id;
            delButton.textContent = "Удалить";
            delButton.style.marginLeft = "30px";

            delButton.onclick = function () {

                fetch("/catalogs/" + this.id + "/country", {

                    method: 'DELETE',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',
                        'Authorization': localStorage.getItem('token')
                    }
                }).then(() => {
                    location.reload()
                })
            }

            superio_div.appendChild(countryName);
            superio_div.appendChild(br0);
            superio_div.appendChild(br1);
            superio_div.appendChild(button);
            superio_div.appendChild(delButton);
            superio_div.appendChild(br2);
            superio_div.appendChild(br3);
            superio_div.appendChild(br4);
        }

        var order = document.createElement("button")
        order.style.width = '200px';
        order.style.height = '40px';
        order.style.position = 'fixed'
        order.style.left = '400px';
        order.style.top = '250px';
        order.textContent = 'Добавить'
        order.onclick = function () {

        }

        var br5 = document.createElement('br');

        document.body.appendChild(order);
        superio_div.appendChild(br5);

       // Все остальное в BODY крепится
    }
    xhr.send()
}