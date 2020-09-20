if (localStorage.getItem('token') !== null) {

    const requestURL = '/cart-item/list'

    const xhr = new XMLHttpRequest();

    xhr.open('GET', requestURL)

    xhr.setRequestHeader('Authorization', localStorage.getItem('token'))



    xhr.onload = () => {

        var datas = JSON.parse(xhr.response)

        console.log(datas)

        for (let i = 0; i <= datas.length; i++) {

            var cardItem = document.createElement("pr");
            cardItem.style.fontFamily = 'Brush Script MT, cursive';
            cardItem.style.fontSize = '30px';
            cardItem.style.color = 'chocolate';

            var cardItemCount = document.createElement("pr");
            cardItemCount.style.fontFamily = 'Brush Script MT, cursive';
            cardItemCount.style.fontSize = '30px';
            cardItemCount.style.color = 'chocolate';

            var br1 = document.createElement('br');
            var br2 = document.createElement('br');
            var br3 = document.createElement('br');

            cardItem.textContent = "Название: " + datas[i].drink.name;

            cardItemCount.textContent = "Количество: " + datas[i].count;

            var super_div = document.getElementById('cardItems')

            super_div.appendChild(cardItem);
            super_div.appendChild(br1);
            super_div.appendChild(cardItemCount);
            super_div.appendChild(br2);
            super_div.appendChild(br3);
        }
    }
    xhr.send()
}