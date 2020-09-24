function makeOrder() {

    const data = JSON.stringify({
        phoneNumber: document.getElementById('inputNumber').value,
        address: document.getElementById('inputAddress').value
    });

    fetch("/orders", {

        method: 'POST',

        headers: {
            'Content-Type': 'application/json;charset=utf-8',

            'Authorization': localStorage.getItem('token')
        },
        body: data
    })
        .then((res) => {
            if (res.status === 200) {
                alert('Ваш заказ успешно оформлен!');
                window.location = '/home';
            }
})}