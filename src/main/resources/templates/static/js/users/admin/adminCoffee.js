if (localStorage.getItem('token') !== null) {

    const requestURL = '/coffee/all?page_size=100000'

    const xhr = new XMLHttpRequest();

    xhr.open('GET', requestURL)

    xhr.setRequestHeader('Authorization', localStorage.getItem('token'))

    xhr.onload = () => {

        var datas = JSON.parse(xhr.response)

        var superio_div = document.getElementById('coffee')

        for (let i = 0; i < datas.content.length; i++) {

            let ids = datas.content[i].id

            var nameC = document.createElement("pr");
            nameC.style.fontFamily = 'Brush Script MT, cursive';
            nameC.style.fontSize = '30px';
            nameC.style.color = 'chocolate';
            nameC.textContent = datas.content[i].name

            var addImage = document.createElement('input')
            addImage.type = 'file'
            addImage.accept = 'image/jpeg, image/jpg, image/png'
            addImage.id = 'addImage'
            addImage.style.width = '140px';
            addImage.style.height = '30px';
            addImage.style.marginLeft = '20px';

            var editButton = document.createElement("button")
            editButton.style.width = '100px';
            editButton.style.height = '30px';
            editButton.style.marginLeft = '20px';
            editButton.textContent = 'Изменить'

            editButton.onclick = function () {

                var addName = document.createElement('input')
                addName.id = 'addName'
                addName.style.position = 'fixed';
                addName.style.left = '1000px';
                addName.style.top = '250px';
                addName.style.width = '200px';
                addName.style.height = '40px';

                var addPrice = document.createElement('input')
                addPrice.id = 'addPrice'
                addPrice.style.position = 'fixed';
                addPrice.style.left = '1000px';
                addPrice.style.top = '300px';
                addPrice.style.width = '200px';
                addPrice.style.height = '40px';

                var addWeight = document.createElement('input')
                addWeight.id = 'addWeight'
                addWeight.style.position = 'fixed';
                addWeight.style.left = '1000px';
                addWeight.style.top = '350px';
                addWeight.style.width = '200px';
                addWeight.style.height = '40px';

                var addType = document.createElement('select')
                addType.id = 'addType'
                addType.style.position = 'fixed';
                addType.style.left = '1000px';
                addType.style.top = '400px';
                addType.style.width = '200px';
                addType.style.height = '40px';

                const requestURL = '/catalogs/coffee-types'

                const xhr = new XMLHttpRequest();

                xhr.open('GET', requestURL)

                xhr.setRequestHeader('Authorization', localStorage.getItem('token'))

                xhr.onload = () => {

                    var dannie = JSON.parse(xhr.response)

                    for (let i = 0; i < dannie.length; i++) {

                        var option = document.createElement('option')
                        option.value = dannie[i].id
                        option.textContent = dannie[i].name;
                        addType.appendChild(option);
                    }
                }
                xhr.send()


                var addCountry = document.createElement('select')
                addCountry.id = 'addCountry'
                addCountry.style.position = 'fixed';
                addCountry.style.left = '1000px';
                addCountry.style.top = '450px';
                addCountry.style.width = '200px';
                addCountry.style.height = '40px';

                const countryURL = '/catalogs/countries'

                const countryX = new XMLHttpRequest();

                countryX.open('GET', countryURL)

                countryX.setRequestHeader('Authorization', localStorage.getItem('token'))

                countryX.onload = () => {

                    var dannie = JSON.parse(countryX.response)

                    for (let i = 0; i < dannie.length; i++) {

                        var option = document.createElement('option')
                        option.value = dannie[i].id
                        option.textContent = dannie[i].name;
                        addCountry.appendChild(option);
                    }
                }
                countryX.send()


                var addManufacturer = document.createElement('select')
                addManufacturer.id = 'addManufacturer';
                addManufacturer.style.position = 'fixed';
                addManufacturer.style.left = '1000px';
                addManufacturer.style.top = '450px';
                addManufacturer.style.width = '200px';
                addManufacturer.style.height = '40px';

                const manufURL = '/catalogs/manufacturers'

                const manufXhr = new XMLHttpRequest();

                manufXhr.open('GET', manufURL)

                manufXhr.setRequestHeader('Authorization', localStorage.getItem('token'))

                manufXhr.onload = () => {

                    var dannie = JSON.parse(manufXhr.response)

                    for (let i = 0; i < dannie.length; i++) {

                        var option = document.createElement('option')
                        option.value = dannie[i].id
                        option.textContent = dannie[i].name;
                        addManufacturer.appendChild(option);
                    }
                }
                manufXhr.send()


                var addPackage = document.createElement('select')
                addPackage.id = 'addPackage';
                addPackage.style.position = 'fixed';
                addPackage.style.left = '1000px';
                addPackage.style.top = '500px';
                addPackage.style.width = '200px';
                addPackage.style.height = '40px';

                const packURL = '/catalogs/packages'

                const packXhr = new XMLHttpRequest();

                packXhr.open('GET', packURL)

                packXhr.setRequestHeader('Authorization', localStorage.getItem('token'))

                packXhr.onload = () => {

                    var dannie = JSON.parse(packXhr.response)

                    for (let i = 0; i < dannie.length; i++) {

                        var option = document.createElement('option')
                        option.value = dannie[i].id
                        option.textContent = dannie[i].name;
                        addPackage.appendChild(option);
                    }
                }
                packXhr.send()


                var addRoast = document.createElement('select')
                addRoast.id = 'addRoast';
                addRoast.style.position = 'fixed';
                addRoast.style.left = '1000px';
                addRoast.style.top = '550px';
                addRoast.style.width = '200px';
                addRoast.style.height = '40px';

                const roastURL = '/catalogs/roastings'

                const roastXhr = new XMLHttpRequest();

                roastXhr.open('GET', roastURL)

                roastXhr.setRequestHeader('Authorization', localStorage.getItem('token'))

                roastXhr.onload = () => {

                    var dannie = JSON.parse(roastXhr.response)

                    for (let i = 0; i < dannie.length; i++) {

                        var option = document.createElement('option')
                        option.value = dannie[i].id
                        option.textContent = dannie[i].name;
                        addRoast.appendChild(option);
                    }
                }
                roastXhr.send()

                var addAboutTxt = document.createElement('pr')
                addAboutTxt.id = 'addAboutTxt';
                addAboutTxt.style.position = 'fixed';
                addAboutTxt.style.left = '1050px';
                addAboutTxt.style.top = '600px';
                addAboutTxt.textContent = "О напитке:"

                var addAbout = document.createElement('input')
                addAbout.id = 'addAbout';
                addAbout.style.position = 'fixed';
                addAbout.style.left = '750px';
                addAbout.style.top = '650px';
                addAbout.style.width = '700px';
                addAbout.style.height = '80px';

                var coffeeBut = document.getElementById('addCoffee')
                coffeeBut.textContent = 'Изменить'
                coffeeBut.style.left = '1000px'
                coffeeBut.style.top = '750px'

                document.body.appendChild(addName);
                document.body.appendChild(addPrice);
                document.body.appendChild(addWeight);
                document.body.appendChild(addType);
                document.body.appendChild(addCountry);
                document.body.appendChild(addRoast);
                document.body.appendChild(addPackage);
                document.body.appendChild(addManufacturer);
                document.body.appendChild(addAbout);
                document.body.appendChild(addAboutTxt);


                var redactButton = document.getElementById('addCoffee')

                redactButton.onclick = function () {

                    const data = JSON.stringify({
                        name: document.getElementById('addName').value,
                        price: document.getElementById('addPrice').value,
                        about: document.getElementById('addAbout').value,
                        weight: document.getElementById('addWeight').value,
                        packaging: {
                            id: document.getElementById('addPackage').value
                        },
                        manufacturer: {
                            id: document.getElementById('addManufacturer').value
                        },
                        country: {
                            id: document.getElementById('addCountry').value
                        },
                        coffeeType: {
                            id: document.getElementById('addType').value
                        },
                        roasting: {
                            id: document.getElementById('addRoast').value
                        }
                    });

                    fetch("/coffee/" + ids, {

                        method: 'PUT',

                        headers: {
                            'Content-Type': 'application/json;charset=utf-8',

                            'Authorization': localStorage.getItem('token')
                        },
                        body: data
                    }).then(() => {
                        alert("Напиток успешно отредактирован!")
                        location.reload()
                    })
                }
            }

            var removeButton = document.createElement("button")
            removeButton.style.width = '100px';
            removeButton.style.height = '30px';
            removeButton.style.marginLeft = '20px';
            removeButton.textContent = 'Удалить'

            removeButton.onclick = function () {

                fetch("/coffee/" + ids, {

                    method: 'DELETE',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')
                    }
                }).then(() => {
                    alert("Напиток из удален!")
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
            superio_div.appendChild(addImage)
            superio_div.appendChild(br0)
            superio_div.appendChild(br1)
        }

        var addCoffee = document.createElement("button")
        addCoffee.id = 'addCoffee'
        addCoffee.style.width = '200px';
        addCoffee.style.height = '40px';
        addCoffee.style.position = 'fixed'
        addCoffee.style.left = '400px';
        addCoffee.style.top = '250px';
        addCoffee.textContent = 'Добавить'

        addCoffee.onclick = function () {

            var addName = document.createElement('input')
            addName.id = 'addName'
            addName.style.position = 'fixed';
            addName.style.left = '1000px';
            addName.style.top = '250px';
            addName.style.width = '200px';
            addName.style.height = '40px';

            var addPrice = document.createElement('input')
            addPrice.id = 'addPrice'
            addPrice.style.position = 'fixed';
            addPrice.style.left = '1000px';
            addPrice.style.top = '300px';
            addPrice.style.width = '200px';
            addPrice.style.height = '40px';

            var addWeight = document.createElement('input')
            addWeight.id = 'addWeight'
            addWeight.style.position = 'fixed';
            addWeight.style.left = '1000px';
            addWeight.style.top = '350px';
            addWeight.style.width = '200px';
            addWeight.style.height = '40px';

            var addType = document.createElement('select')
            addType.id = 'addType'
            addType.style.position = 'fixed';
            addType.style.left = '1000px';
            addType.style.top = '400px';
            addType.style.width = '200px';
            addType.style.height = '40px';

            const requestURL = '/catalogs/coffee-types'

            const xhr = new XMLHttpRequest();

            xhr.open('GET', requestURL)

            xhr.setRequestHeader('Authorization', localStorage.getItem('token'))

            xhr.onload = () => {

                var dannie = JSON.parse(xhr.response)

                for (let i = 0; i < dannie.length; i++) {

                    var option = document.createElement('option')
                    option.value = dannie[i].id
                    option.textContent = dannie[i].name;
                    addType.appendChild(option);
                }
            }
            xhr.send()

            var addCountry = document.createElement('select')
            addCountry.id = 'addCountry'
            addCountry.style.position = 'fixed';
            addCountry.style.left = '1000px';
            addCountry.style.top = '450px';
            addCountry.style.width = '200px';
            addCountry.style.height = '40px';

            const countryURL = '/catalogs/countries'

            const countryX = new XMLHttpRequest();

            countryX.open('GET', countryURL)

            countryX.setRequestHeader('Authorization', localStorage.getItem('token'))

            countryX.onload = () => {

                var dannie = JSON.parse(countryX.response)

                for (let i = 0; i < dannie.length; i++) {

                    var option = document.createElement('option')
                    option.value = dannie[i].id
                    option.textContent = dannie[i].name;
                    addCountry.appendChild(option);
                }
            }
            countryX.send()

            var addManufacturer = document.createElement('select')
            addManufacturer.id = 'addManufacturer';
            addManufacturer.style.position = 'fixed';
            addManufacturer.style.left = '1000px';
            addManufacturer.style.top = '450px';
            addManufacturer.style.width = '200px';
            addManufacturer.style.height = '40px';

            const manufURL = '/catalogs/manufacturers'

            const manufXhr = new XMLHttpRequest();

            manufXhr.open('GET', manufURL)

            manufXhr.setRequestHeader('Authorization', localStorage.getItem('token'))

            manufXhr.onload = () => {

                var dannie = JSON.parse(manufXhr.response)

                for (let i = 0; i < dannie.length; i++) {

                    var option = document.createElement('option')
                    option.value = dannie[i].id
                    option.textContent = dannie[i].name;
                    addManufacturer.appendChild(option);
                }
            }
            manufXhr.send()

            var addPackage = document.createElement('select')
            addPackage.id = 'addPackage';
            addPackage.style.position = 'fixed';
            addPackage.style.left = '1000px';
            addPackage.style.top = '500px';
            addPackage.style.width = '200px';
            addPackage.style.height = '40px';

            const packURL = '/catalogs/packages'

            const packXhr = new XMLHttpRequest();

            packXhr.open('GET', packURL)

            packXhr.setRequestHeader('Authorization', localStorage.getItem('token'))

            packXhr.onload = () => {

                var dannie = JSON.parse(packXhr.response)

                for (let i = 0; i < dannie.length; i++) {

                    var option = document.createElement('option')
                    option.value = dannie[i].id
                    option.textContent = dannie[i].name;
                    addPackage.appendChild(option);
                }
            }
            packXhr.send()

            var addRoast = document.createElement('select')
            addRoast.id = 'addRoast';
            addRoast.style.position = 'fixed';
            addRoast.style.left = '1000px';
            addRoast.style.top = '550px';
            addRoast.style.width = '200px';
            addRoast.style.height = '40px';

            const roastURL = '/catalogs/roastings'

            const roastXhr = new XMLHttpRequest();

            roastXhr.open('GET', roastURL)

            roastXhr.setRequestHeader('Authorization', localStorage.getItem('token'))

            roastXhr.onload = () => {

                var dannie = JSON.parse(roastXhr.response)

                for (let i = 0; i < dannie.length; i++) {

                    var option = document.createElement('option')
                    option.value = dannie[i].id
                    option.textContent = dannie[i].name;
                    addRoast.appendChild(option);
                }
            }
            roastXhr.send()

            var addAboutTxt = document.createElement('pr')
            addAboutTxt.id = 'addAboutTxt';
            addAboutTxt.style.position = 'fixed';
            addAboutTxt.style.left = '1050px';
            addAboutTxt.style.top = '600px';
            addAboutTxt.textContent = "О напитке:"

            var addAbout = document.createElement('input')
            addAbout.id = 'addAbout';
            addAbout.style.position = 'fixed';
            addAbout.style.left = '750px';
            addAbout.style.top = '650px';
            addAbout.style.width = '700px';
            addAbout.style.height = '80px';

            document.body.appendChild(addName);
            document.body.appendChild(addPrice);
            document.body.appendChild(addWeight);
            document.body.appendChild(addType);
            document.body.appendChild(addCountry);
            document.body.appendChild(addRoast);
            document.body.appendChild(addPackage);
            document.body.appendChild(addManufacturer);
            document.body.appendChild(addAbout);
            document.body.appendChild(addAboutTxt);

            var addButton = document.getElementById('addCoffee')

            var coffeeBut = document.getElementById('addCoffee')
            coffeeBut.textContent = 'Добавить'
            coffeeBut.style.left = '1000px'
            coffeeBut.style.top = '750px'

            addButton.onclick = function () {

                const data = JSON.stringify({

                    name: document.getElementById('addName').value,
                    price: document.getElementById('addPrice').value,
                    about: document.getElementById('addAbout').value,
                    weight: document.getElementById('addWeight').value,
                    packaging: {
                        id: document.getElementById('addPackage').value
                    },
                    manufacturer: {
                        id: document.getElementById('addManufacturer').value
                    },
                    country: {
                        id: document.getElementById('addCountry').value
                    },
                    coffeeType: {
                        id: document.getElementById('addType').value
                    },
                    roasting: {
                        id: document.getElementById('addRoast').value
                    }
                });

                fetch("/coffee", {

                    method: 'POST',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')
                    },
                    body: data
                }).then(() => {
                    alert("Напиток успешно добавлен!")
                    location.reload()
                })
            }

        }
        document.body.appendChild(addCoffee);
    }
    xhr.send()
}