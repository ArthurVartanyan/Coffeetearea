function searchOrder() {

    if (localStorage.getItem('token') !== null) {

        const requestURL = '/api/orders/' + document.getElementById('orderId').value

        const xhr = new XMLHttpRequest();

        xhr.open('GET', requestURL)

        xhr.setRequestHeader('Authorization', localStorage.getItem('token'))


        xhr.onload = () => {

            if (xhr.status === 404) {

                Array.prototype.slice.call(document.getElementsByClassName('forRemove')).forEach(
                    function (item) {
                        item.remove();
                    });

                var errorInf = document.createElement('pr')
                errorInf.className = 'forRemove'
                errorInf.textContent = xhr.response
                errorInf.style.position = 'absolute'
                errorInf.style.left = '290px'
                errorInf.style.top = '232px'
                errorInf.style.color = 'red'
                document.body.appendChild(errorInf)
            }

            if (xhr.status === 405 || xhr.status === 400) {

                Array.prototype.slice.call(document.getElementsByClassName('forRemove')).forEach(
                    function (item) {
                        item.remove();
                    });

                var errorsInf = document.createElement('pr')
                errorsInf.className = 'forRemove'
                errorsInf.textContent = "Ошибка! Введите корректный номер заказа!"
                errorsInf.style.position = 'absolute'
                errorsInf.style.left = '290px'
                errorsInf.style.top = '232px'
                errorsInf.style.color = 'red'
                document.body.appendChild(errorsInf)
            }

            var orderData = JSON.parse(xhr.response)

            Array.prototype.slice.call(document.getElementsByClassName('forRemove')).forEach(
                function (item) {
                    item.remove();
                });

            var h2 = document.createElement('h2')
            h2.className = 'forRemove'
            h2.textContent = 'Информация:'
            h2.style.position = 'absolute'
            h2.style.left = '850px'
            h2.style.top = '120px'

            var numberInf = document.createElement('pr')
            numberInf.className = 'forRemove'
            numberInf.textContent = 'Номер заказа:'
            numberInf.style.position = 'absolute'
            numberInf.style.left = '850px'
            numberInf.style.top = '200px'
            var number = document.createElement('pr')
            number.className = 'forRemove'
            number.textContent = orderData.id
            number.style.position = 'absolute'
            number.style.left = '1000px'
            number.style.top = '200px'

            var addressInf = document.createElement('pr')
            addressInf.className = 'forRemove'
            addressInf.textContent = 'Адрес доставки:'
            addressInf.style.position = 'absolute'
            addressInf.style.left = '850px'
            addressInf.style.top = '250px'
            var address = document.createElement('pr')
            address.className = 'forRemove'
            address.textContent = orderData.address
            address.style.position = 'absolute'
            address.style.left = '1000px'
            address.style.top = '250px'

            var phoneNumberInf = document.createElement('pr')
            phoneNumberInf.className = 'forRemove'
            phoneNumberInf.textContent = 'Конт. номер:'
            phoneNumberInf.style.position = 'absolute'
            phoneNumberInf.style.left = '850px'
            phoneNumberInf.style.top = '300px'
            var phoneNumber = document.createElement('pr')
            phoneNumber.className = 'forRemove'
            phoneNumber.textContent = orderData.phoneNumber
            phoneNumber.style.position = 'absolute'
            phoneNumber.style.left = '1000px'
            phoneNumber.style.top = '300px'

            var dateOrderInf = document.createElement('pr')
            dateOrderInf.className = 'forRemove'
            dateOrderInf.textContent = 'Дата заказа:'
            dateOrderInf.style.position = 'absolute'
            dateOrderInf.style.left = '850px'
            dateOrderInf.style.top = '350px'
            var dateOrder = document.createElement('pr')
            dateOrder.className = 'forRemove'
            dateOrder.textContent = orderData.dateOrder
            dateOrder.style.position = 'absolute'
            dateOrder.style.left = '1000px'
            dateOrder.style.top = '350px'

            var orderStatusInf = document.createElement('pr')
            orderStatusInf.className = 'forRemove'
            orderStatusInf.textContent = 'Статус заказа:'
            orderStatusInf.style.position = 'absolute'
            orderStatusInf.style.left = '850px'
            orderStatusInf.style.top = '400px'
            var orderStatus = document.createElement('pr')
            orderStatus.className = 'forRemove'
            orderStatus.textContent = orderData.orderStatus
            orderStatus.style.position = 'absolute'
            orderStatus.style.left = '1000px'
            orderStatus.style.top = '400px'

            var totalCostInf = document.createElement('pr')
            totalCostInf.className = 'forRemove'
            totalCostInf.textContent = 'Стоимость заказа:'
            totalCostInf.style.position = 'absolute'
            totalCostInf.style.left = '850px'
            totalCostInf.style.top = '450px'
            var totalCost = document.createElement('pr')
            totalCost.className = 'forRemove'
            totalCost.textContent = orderData.totalCost
            totalCost.style.position = 'absolute'
            totalCost.style.left = '1000px'
            totalCost.style.top = '450px'

            var userNameInf = document.createElement('pr')
            userNameInf.className = 'forRemove'
            userNameInf.textContent = 'Имя заказчика:'
            userNameInf.style.position = 'absolute'
            userNameInf.style.left = '850px'
            userNameInf.style.top = '500px'
            var userName = document.createElement('pr')
            userName.className = 'forRemove'
            userName.textContent = orderData.userDTO.name
            userName.style.position = 'absolute'
            userName.style.left = '1000px'
            userName.style.top = '500px'

            var lastNameInf = document.createElement('pr')
            lastNameInf.className = 'forRemove'
            lastNameInf.textContent = 'Фам. заказчика:'
            lastNameInf.style.position = 'absolute'
            lastNameInf.style.left = '850px'
            lastNameInf.style.top = '550px'
            var lastName = document.createElement('pr')
            lastName.className = 'forRemove'
            lastName.textContent = orderData.userDTO.lastName
            lastName.style.position = 'absolute'
            lastName.style.left = '1000px'
            lastName.style.top = '550px'

            var loginInf = document.createElement('pr')
            loginInf.className = 'forRemove'
            loginInf.textContent = 'Логин заказчика:'
            loginInf.style.position = 'absolute'
            loginInf.style.left = '850px'
            loginInf.style.top = '600px'
            var login = document.createElement('pr')
            login.className = 'forRemove'
            login.textContent = orderData.userDTO.login
            login.style.position = 'absolute'
            login.style.left = '1000px'
            login.style.top = '600px'

            var mailInf = document.createElement('pr')
            mailInf.className = 'forRemove'
            mailInf.textContent = 'Почта заказчика:'
            mailInf.style.position = 'absolute'
            mailInf.style.left = '850px'
            mailInf.style.top = '650px'
            var mail = document.createElement('pr')
            mail.className = 'forRemove'
            mail.textContent = orderData.userDTO.mail
            mail.style.position = 'absolute'
            mail.style.left = '1000px'
            mail.style.top = '650px'

            var cancelBut = document.createElement('button')
            cancelBut.className = 'forRemove'
            cancelBut.style.position = 'absolute'
            cancelBut.style.left = '850px'
            cancelBut.style.top = '700px'
            cancelBut.style.height = '35px'
            cancelBut.style.width = '100px'
            cancelBut.textContent = 'Отменить'

            cancelBut.onclick = function () {

                fetch("/api/orders/cancel/" + orderData.id, {

                    method: 'PUT',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')
                    }
                })
                    .then((res) => {
                        if (res.status === 200) {
                            alert("Заказ отменен!")
                            searchOrder();
                        }
                    })
            }

            var activeBut = document.createElement('button')
            activeBut.className = 'forRemove'
            activeBut.style.position = 'absolute'
            activeBut.style.left = '1000px'
            activeBut.style.top = '700px'
            activeBut.style.height = '35px'
            activeBut.style.width = '100px'
            activeBut.textContent = 'Завершить'
            activeBut.onclick = function () {

                fetch("/api/orders/complete/" + orderData.id, {

                    method: 'PUT',

                    headers: {
                        'Content-Type': 'application/json;charset=utf-8',

                        'Authorization': localStorage.getItem('token')
                    }
                })
                    .then((res) => {
                        if (res.status === 200) {
                            alert("Заказ завершен!")
                            searchOrder();
                        }
                    })
            }

            document.body.appendChild(number)
            document.body.appendChild(address)
            document.body.appendChild(phoneNumber)
            document.body.appendChild(dateOrder)
            document.body.appendChild(orderStatus)
            document.body.appendChild(totalCost)
            document.body.appendChild(userName)
            document.body.appendChild(lastName)
            document.body.appendChild(login)
            document.body.appendChild(mail)
            document.body.appendChild(numberInf)
            document.body.appendChild(addressInf)
            document.body.appendChild(phoneNumberInf)
            document.body.appendChild(dateOrderInf)
            document.body.appendChild(orderStatusInf)
            document.body.appendChild(totalCostInf)
            document.body.appendChild(userNameInf)
            document.body.appendChild(lastNameInf)
            document.body.appendChild(loginInf)
            document.body.appendChild(mailInf)
            document.body.appendChild(h2)
            document.body.appendChild(cancelBut)
            document.body.appendChild(activeBut)
        }
        xhr.send()
    }
}