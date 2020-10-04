if (localStorage.getItem('token') !== null) {

    const requestURL = '/tea/all?page_size=100000'

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

                const requestURL = '/catalogs/tea-types'

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
                addCountry.style.top = '600px';
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


                var addTeaColor = document.createElement('select')
                addTeaColor.id = 'addTeaColor';
                addTeaColor.style.position = 'fixed';
                addTeaColor.style.left = '1000px';
                addTeaColor.style.top = '550px';
                addTeaColor.style.width = '200px';
                addTeaColor.style.height = '40px';

                const roastURL = '/catalogs/tea-colors'

                const roastXhr = new XMLHttpRequest();

                roastXhr.open('GET', roastURL)

                roastXhr.setRequestHeader('Authorization', localStorage.getItem('token'))

                roastXhr.onload = () => {

                    var dannie = JSON.parse(roastXhr.response)

                    for (let i = 0; i < dannie.length; i++) {

                        var option = document.createElement('option')
                        option.value = dannie[i].id
                        option.textContent = dannie[i].name;
                        addTeaColor.appendChild(option);
                    }
                }
                roastXhr.send()

                var addAboutTxt = document.createElement('pr')
                addAboutTxt.id = 'addAboutTxt';
                addAboutTxt.style.position = 'fixed';
                addAboutTxt.style.left = '1050px';
                addAboutTxt.style.top = '650px';
                addAboutTxt.textContent = "О напитке:"

                var addAbout = document.createElement('input')
                addAbout.id = 'addAbout';
                addAbout.style.position = 'fixed';
                addAbout.style.left = '750px';
                addAbout.style.top = '700px';
                addAbout.style.width = '700px';
                addAbout.style.height = '80px';

                var inpName = document.createElement('pr')
                inpName.style.position = 'fixed'
                inpName.style.left = '905px';
                inpName.style.top = '255px';
                inpName.textContent = 'Название:'

                var inpPrice = document.createElement('pr')
                inpPrice.style.position = 'fixed'
                inpPrice.style.left = '920px';
                inpPrice.style.top = '300px';
                inpPrice.textContent = 'Цена:'

                var inpWeight = document.createElement('pr')
                inpWeight.style.position = 'fixed'
                inpWeight.style.left = '925px';
                inpWeight.style.top = '355px';
                inpWeight.textContent = 'Вес:'

                var inpType = document.createElement('pr')
                inpType.style.position = 'fixed'
                inpType.style.left = '925px';
                inpType.style.top = '410px';
                inpType.textContent = 'Тип:'

                var inpCountry = document.createElement('pr')
                inpCountry.style.position = 'fixed'
                inpCountry.style.left = '915px';
                inpCountry.style.top = '608px';
                inpCountry.textContent = 'Страна:'

                var inpRoast = document.createElement('pr')
                inpRoast.style.position = 'fixed'
                inpRoast.style.left = '910px';
                inpRoast.style.top = '555px';
                inpRoast.textContent = 'Цвет:'

                var inpPackage = document.createElement('pr')
                inpPackage.style.position = 'fixed'
                inpPackage.style.left = '915px';
                inpPackage.style.top = '510px';
                inpPackage.textContent = 'Упаковка:'

                var inpManufactuerer = document.createElement('pr')
                inpManufactuerer.style.position = 'fixed'
                inpManufactuerer.style.left = '868px';
                inpManufactuerer.style.top = '455px';
                inpManufactuerer.textContent = 'Производитель:'

                var coffeeBut = document.getElementById('addCoffee')
                coffeeBut.textContent = 'Изменить'
                coffeeBut.style.left = '1000px'
                coffeeBut.style.top = '800px'

                document.body.appendChild(addName);
                document.body.appendChild(addPrice);
                document.body.appendChild(addWeight);
                document.body.appendChild(addType);
                document.body.appendChild(addCountry);
                document.body.appendChild(addTeaColor);
                document.body.appendChild(addPackage);
                document.body.appendChild(addManufacturer);
                document.body.appendChild(addAbout);
                document.body.appendChild(addAboutTxt);
                document.body.appendChild(inpName);
                document.body.appendChild(inpPrice);
                document.body.appendChild(inpType);
                document.body.appendChild(inpCountry);
                document.body.appendChild(inpRoast);
                document.body.appendChild(inpPackage);
                document.body.appendChild(inpManufactuerer);
                document.body.appendChild(inpWeight);


                var redactButton = document.getElementById('addCoffee')

                redactButton.onclick = function () {

                    axios({
                        method: 'put',
                        url: "/tea/" + ids,
                        headers: {
                            'Content-Type': 'application/json;charset=utf-8',

                            'Authorization': localStorage.getItem('token')
                        },
                        data: {
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
                            teaType: {
                                id: document.getElementById('addType').value
                            },
                            teaColor: {
                                id: document.getElementById('addTeaColor').value
                            }
                        }
                    }).catch((error) => {

                        console.log(error.response)


                        Array.prototype.slice.call(document.getElementsByClassName('prEx')).forEach(
                            function (item) {
                                item.remove();
                            });

                        var priceEx;
                        var weightEx;
                        var aboutEx;
                        var nameEx;

                        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
                            if (error.response.data.fieldErrors[i].field === "price") {
                                priceEx = error.response.data.fieldErrors[i].message;
                            }
                        }

                        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
                            if (error.response.data.fieldErrors[i].field === "weight") {
                                weightEx = error.response.data.fieldErrors[i].message;
                            }
                        }

                        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
                            if (error.response.data.fieldErrors[i].field === "about") {
                                aboutEx = error.response.data.fieldErrors[i].message;
                            }
                        }

                        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
                            if (error.response.data.fieldErrors[i].field === "name") {
                                nameEx = error.response.data.fieldErrors[i].message;
                            }
                        }

                        var nameC = document.createElement('pr');
                        nameC.className = 'prEx'
                        nameC.style.color = 'red';
                        nameC.style.position = 'fixed';
                        nameC.style.top = '255px';
                        nameC.style.left = '1220px';
                        nameC.style.fontFamily = '"Brush Script MT", cursive';
                        nameC.textContent = nameEx;
                        document.body.appendChild(nameC)

                        var priceC = document.createElement('pr');
                        priceC.className = 'prEx'
                        priceC.style.color = 'red';
                        priceC.style.position = 'fixed';
                        priceC.style.top = '305px';
                        priceC.style.left = '1220px';
                        priceC.style.fontFamily = '"Brush Script MT", cursive';
                        priceC.textContent = priceEx;
                        document.body.appendChild(priceC)

                        var weightC = document.createElement('pr');
                        weightC.className = 'prEx'
                        weightC.style.color = 'red';
                        weightC.style.position = 'fixed';
                        weightC.style.top = '355px';
                        weightC.style.left = '1220px';
                        weightC.style.fontFamily = '"Brush Script MT", cursive';
                        weightC.textContent = weightEx;
                        document.body.appendChild(weightC)

                        var aboutC = document.createElement('pr');
                        aboutC.className = 'prEx'
                        aboutC.style.color = 'red';
                        aboutC.style.position = 'fixed';
                        aboutC.style.top = '730px';
                        aboutC.style.left = '1470px';
                        aboutC.style.fontFamily = '"Brush Script MT", cursive';
                        aboutC.textContent = aboutEx;
                        document.body.appendChild(aboutC)

                    }).then((res) => {
                        if (res.status === 200) {

                            alert("Напиток успешно изменен!")
                            location.reload()
                        }
                    })
                }
            }

            var removeButton = document.createElement("button")
            removeButton.style.width = '100px';
            removeButton.style.height = '30px';
            removeButton.style.marginLeft = '20px';
            removeButton.textContent = 'Удалить'

            removeButton.onclick = function () {

                fetch("/tea/" + ids, {

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

            const requestURL = '/catalogs/tea-types'

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
            addCountry.style.top = '600px';
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

            var addTeaColor = document.createElement('select')
            addTeaColor.id = 'addTeaColor';
            addTeaColor.style.position = 'fixed';
            addTeaColor.style.left = '1000px';
            addTeaColor.style.top = '550px';
            addTeaColor.style.width = '200px';
            addTeaColor.style.height = '40px';

            const roastURL = '/catalogs/tea-colors'

            const roastXhr = new XMLHttpRequest();

            roastXhr.open('GET', roastURL)

            roastXhr.setRequestHeader('Authorization', localStorage.getItem('token'))

            roastXhr.onload = () => {

                var dannie = JSON.parse(roastXhr.response)

                for (let i = 0; i < dannie.length; i++) {

                    var option = document.createElement('option')
                    option.value = dannie[i].id
                    option.textContent = dannie[i].name;
                    addTeaColor.appendChild(option);
                }
            }
            roastXhr.send()

            var addAboutTxt = document.createElement('pr')
            addAboutTxt.id = 'addAboutTxt';
            addAboutTxt.style.position = 'fixed';
            addAboutTxt.style.left = '1050px';
            addAboutTxt.style.top = '650px';
            addAboutTxt.textContent = "О напитке:"

            var addAbout = document.createElement('input')
            addAbout.id = 'addAbout';
            addAbout.style.position = 'fixed';
            addAbout.style.left = '750px';
            addAbout.style.top = '700px';
            addAbout.style.width = '700px';
            addAbout.style.height = '80px';

            var inpName = document.createElement('pr')
            inpName.style.position = 'fixed'
            inpName.style.left = '905px';
            inpName.style.top = '255px';
            inpName.textContent = 'Название:'

            var inpPrice = document.createElement('pr')
            inpPrice.style.position = 'fixed'
            inpPrice.style.left = '920px';
            inpPrice.style.top = '300px';
            inpPrice.textContent = 'Цена:'

            var inpWeight = document.createElement('pr')
            inpWeight.style.position = 'fixed'
            inpWeight.style.left = '925px';
            inpWeight.style.top = '355px';
            inpWeight.textContent = 'Вес:'

            var inpType = document.createElement('pr')
            inpType.style.position = 'fixed'
            inpType.style.left = '925px';
            inpType.style.top = '410px';
            inpType.textContent = 'Тип:'

            var inpCountry = document.createElement('pr')
            inpCountry.style.position = 'fixed'
            inpCountry.style.left = '915px';
            inpCountry.style.top = '608px';
            inpCountry.textContent = 'Страна:'

            var inpRoast = document.createElement('pr')
            inpRoast.style.position = 'fixed'
            inpRoast.style.left = '910px';
            inpRoast.style.top = '555px';
            inpRoast.textContent = 'Цвет:'

            var inpPackage = document.createElement('pr')
            inpPackage.style.position = 'fixed'
            inpPackage.style.left = '915px';
            inpPackage.style.top = '510px';
            inpPackage.textContent = 'Упаковка:'

            var inpManufactuerer = document.createElement('pr')
            inpManufactuerer.style.position = 'fixed'
            inpManufactuerer.style.left = '868px';
            inpManufactuerer.style.top = '455px';
            inpManufactuerer.textContent = 'Производитель:'

            document.body.appendChild(addName);
            document.body.appendChild(addPrice);
            document.body.appendChild(addWeight);
            document.body.appendChild(addType);
            document.body.appendChild(addCountry);
            document.body.appendChild(addTeaColor);
            document.body.appendChild(addPackage);
            document.body.appendChild(addManufacturer);
            document.body.appendChild(addAbout);
            document.body.appendChild(addAboutTxt);
            document.body.appendChild(inpName);
            document.body.appendChild(inpPrice);
            document.body.appendChild(inpType);
            document.body.appendChild(inpCountry);
            document.body.appendChild(inpRoast);
            document.body.appendChild(inpPackage);
            document.body.appendChild(inpManufactuerer);
            document.body.appendChild(inpWeight);

            var addButton = document.getElementById('addCoffee')

            var coffeeBut = document.getElementById('addCoffee')
            coffeeBut.textContent = 'Добавить'
            coffeeBut.style.left = '1000px'
            coffeeBut.style.top = '800px'

            addButton.onclick = function () {

                axios({
                    method: 'post',
                    url: "/tea",
                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')
                    },
                    data: {
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
                        teaType: {
                            id: document.getElementById('addType').value
                        },
                        teaColor: {
                            id: document.getElementById('addTeaColor').value
                        }
                    }
                }).catch((error) => {

                    Array.prototype.slice.call(document.getElementsByClassName('prEx')).forEach(
                        function (item) {
                            item.remove();
                        });

                    var priceEx;
                    var weightEx;
                    var aboutEx;
                    var nameEx;

                    for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
                        if (error.response.data.fieldErrors[i].field === "price") {
                            priceEx = error.response.data.fieldErrors[i].message;
                        }
                    }

                    for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
                        if (error.response.data.fieldErrors[i].field === "weight") {
                            weightEx = error.response.data.fieldErrors[i].message;
                        }
                    }

                    for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
                        if (error.response.data.fieldErrors[i].field === "about") {
                            aboutEx = error.response.data.fieldErrors[i].message;
                        }
                    }

                    for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
                        if (error.response.data.fieldErrors[i].field === "name") {
                            nameEx = error.response.data.fieldErrors[i].message;
                        }
                    }

                    var nameC = document.createElement('pr');
                    nameC.className = 'prEx'
                    nameC.style.color = 'red';
                    nameC.style.position = 'fixed';
                    nameC.style.top = '255px';
                    nameC.style.left = '1220px';
                    nameC.style.fontFamily = '"Brush Script MT", cursive';
                    nameC.textContent = nameEx;
                    document.body.appendChild(nameC)

                    var priceC = document.createElement('pr');
                    priceC.className = 'prEx'
                    priceC.style.color = 'red';
                    priceC.style.position = 'fixed';
                    priceC.style.top = '305px';
                    priceC.style.left = '1220px';
                    priceC.style.fontFamily = '"Brush Script MT", cursive';
                    priceC.textContent = priceEx;
                    document.body.appendChild(priceC)

                    var weightC = document.createElement('pr');
                    weightC.className = 'prEx'
                    weightC.style.color = 'red';
                    weightC.style.position = 'fixed';
                    weightC.style.top = '355px';
                    weightC.style.left = '1220px';
                    weightC.style.fontFamily = '"Brush Script MT", cursive';
                    weightC.textContent = weightEx;
                    document.body.appendChild(weightC)

                    var aboutC = document.createElement('pr');
                    aboutC.className = 'prEx'
                    aboutC.style.color = 'red';
                    aboutC.style.position = 'fixed';
                    aboutC.style.top = '730px';
                    aboutC.style.left = '1470px';
                    aboutC.style.fontFamily = '"Brush Script MT", cursive';
                    aboutC.textContent = aboutEx;
                    document.body.appendChild(aboutC)

                })
                    .then((res) => {
                        if (res.status === 200) {

                            alert("Напиток успешно добавлен!")
                            location.reload()
                        }
                    })
            }

        }
        document.body.appendChild(addCoffee);
    }
    xhr.send()
}