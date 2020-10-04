function makeOrder() {

    axios({
        method: 'post',
        url: '/orders',
        headers: {
            'Content-Type': 'application/json;charset=utf-8',

            'Authorization': localStorage.getItem('token')
        },
        data: {
            phoneNumber: document.getElementById('inputNumber').value,
            address: document.getElementById('inputAddress').value
        }
    })
        .catch((error) => {

        Array.prototype.slice.call(document.getElementsByClassName('prEx')).forEach(
            function (item) {
                item.remove();
            });

        var addressEx;
        var numberEx;

        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "address") {
                addressEx = error.response.data.fieldErrors[i].message;
            }
        }

        for (let i = 0; i < error.response.data.fieldErrors.length; i++) {
            if (error.response.data.fieldErrors[i].field === "phoneNumber") {
                numberEx = error.response.data.fieldErrors[i].message;
            }
        }

        var addressC = document.createElement('pr');
        addressC.className = 'prEx'
        addressC.style.color = 'red';
        addressC.style.position = 'fixed';
        addressC.style.top = '468px';
        addressC.style.left = '1035px';
        addressC.style.fontFamily = '"Brush Script MT", cursive';
        addressC.textContent = addressEx;
        document.body.appendChild(addressC)

        var numberC = document.createElement('pr');
        numberC.className = 'prEx'
        numberC.style.color = 'red';
        numberC.style.position = 'fixed';
        numberC.style.top = '380px';
        numberC.style.left = '1035px';
        numberC.style.fontFamily = '"Brush Script MT", cursive';
        numberC.textContent = numberEx;
        document.body.appendChild(numberC)
    })
        .then((res) => {
        if (res.status === 200) {
            alert('Ваш заказ успешно оформлен!');
            window.location = '/home';
        }
    })
}