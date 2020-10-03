if (localStorage.getItem('token') !== null) {

    const requestURL = '/catalogs/manufacturers'

    const xhr = new XMLHttpRequest();

    xhr.open('GET', requestURL)

    xhr.setRequestHeader('Authorization', localStorage.getItem('token'))

    xhr.onload = () => {

        var datas = JSON.parse(xhr.response)

        var superio_div = document.getElementById('manufactur')

        for (let i = 0; i < datas.length; i++) {

            let ids = datas[i].id

            var nameC = document.createElement("pr");
            nameC.style.fontFamily = 'Brush Script MT, cursive';
            nameC.style.fontSize = '30px';
            nameC.style.color = 'chocolate';
            nameC.textContent = datas[i].name

            var editButton = document.createElement("button")
            editButton.style.width = '100px';
            editButton.style.height = '30px';
            editButton.style.marginLeft = '20px';
            editButton.textContent = 'Изменить'

            editButton.onclick = function () {

                var addInput = document.createElement('input')
                addInput.id = 'addInput'
                addInput.style.position = 'fixed';
                addInput.style.left = '1000px';
                addInput.style.top = '400px';
                addInput.style.width = '200px';
                addInput.style.height = '40px';
                var countryBut = document.getElementById('addCountry')
                countryBut.textContent = 'Изменить'
                countryBut.style.left = '1000px'
                countryBut.style.top = '450px'

                countryBut.onclick = function () {

                    const data = JSON.stringify({
                        name: document.getElementById('addInput').value
                    });

                    fetch("/catalogs/" + ids + "/manufacturers", {

                        method: 'PUT',

                        headers: {
                            'Content-Type': 'application/json;charset=utf-8',

                            'Authorization': localStorage.getItem('token')
                        },
                        body: data
                    }).then((res) => {
                        if (res.status === 200) {
                            alert("Тип успешно отредактирован!")
                            location.reload()
                        }
                    })
                }
                document.body.appendChild(addInput);
            }

            var removeButton = document.createElement("button")
            removeButton.style.width = '100px';
            removeButton.style.height = '30px';
            removeButton.style.marginLeft = '20px';
            removeButton.textContent = 'Удалить'

            removeButton.onclick = function () {

                fetch("/catalogs/" + ids + "/manufacturers", {

                    method: 'DELETE',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')
                    }
                }).then(() => {
                    alert("Производитель из справочника удален!")
                    location.reload()
                })

            }

            var br0 = document.createElement('br');
            var br1 = document.createElement('br');
            var br2 = document.createElement('br');
            var br3 = document.createElement('br');
            var br4 = document.createElement('br');

            superio_div.appendChild(nameC)
            superio_div.appendChild(editButton)
            superio_div.appendChild(removeButton)
            superio_div.appendChild(br0)
            superio_div.appendChild(br1)
        }

        var addCountry = document.createElement("button")
        addCountry.id = 'addCountry'
        addCountry.style.width = '200px';
        addCountry.style.height = '40px';
        addCountry.style.position = 'fixed'
        addCountry.style.left = '400px';
        addCountry.style.top = '250px';
        addCountry.textContent = 'Добавить'
        addCountry.onclick = function () {

            var addInput = document.createElement('input')
            addInput.id = 'addInput'
            addInput.style.position = 'fixed';
            addInput.style.left = '1000px';
            addInput.style.top = '400px';
            addInput.style.width = '200px';
            addInput.style.height = '40px';
            var countryBut = document.getElementById('addCountry')
            countryBut.style.left = '1000px'
            countryBut.style.top = '450px'

            countryBut.onclick = function () {

                const data = JSON.stringify({
                    name: document.getElementById('addInput').value
                });

                fetch("/catalogs/manufacturers", {

                    method: 'POST',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')
                    },
                    body: data
                }).then((res) => {
                    if (res.status === 200) {
                        alert("Производитель успешно добавлен!")
                        location.reload()
                    }
                })
            }
            document.body.appendChild(addInput);
        }
        document.body.appendChild(addCountry);
    }
    xhr.send()
}