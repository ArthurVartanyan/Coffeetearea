// function teaDrink(id = 1001) {

    // RedirectTea();

    let newId = 1001 - 1000

    const teaUrl = '/tea/' + newId;

    const tea = new XMLHttpRequest();

    tea.open('GET', teaUrl)

    tea.setRequestHeader('Authorization', localStorage.getItem('token'))

    tea.onload = () => {

        var data = JSON.parse(tea.response)

        var name = document.createElement('h1')
        name.textContent = data.name
        name.style.position = 'fixed'
        name.style.left = '750px'
        name.style.top = '120px'
        name.style.fontSize = '70px'
        name.style.color = '#1D8348'

        var image = document.createElement('img')
        image.src = "static/images/back.jpg";
        image.style.width = '600px'
        image.style.height = '750px'
        image.style.position = 'fixed'
        image.style.left = '100px'
        image.style.top = '120px'

        var weight = document.createElement('pr')
        weight.textContent = 'Вес: ' + data.weight + ' грамм'
        weight.style.position = 'fixed'
        weight.style.left = '750px'
        weight.style.fontSize = '25px'
        weight.style.color = '#8B4513'

        var price = document.createElement('pr')
        price.textContent = 'Цена: ' + data.price + '₽'
        price.style.position = 'fixed'
        price.style.left = '750px'
        price.style.fontSize = '25px'
        price.style.color = '#8B4513'

        var about = document.createElement('pr')
        about.textContent = 'О товаре: ' + data.about
        about.style.position = 'fixed'
        about.style.left = '750px'
        about.style.fontSize = '25px'
        about.style.color = '#8B4513'

        var country = document.createElement('pr')
        country.textContent = 'Страна: ' + data.country.name
        country.style.position = 'fixed'
        country.style.left = '750px'
        country.style.fontSize = '25px'
        country.style.color = '#8B4513'

        var manufacturer = document.createElement('pr')
        manufacturer.textContent = 'Производитель: ' + data.manufacturer.name
        manufacturer.style.position = 'fixed'
        manufacturer.style.left = '750px'
        manufacturer.style.fontSize = '25px'
        manufacturer.style.color = '#8B4513'

        var packaging = document.createElement('pr')
        packaging.textContent = 'Упаковка: ' + data.packaging.name
        packaging.style.position = 'fixed'
        packaging.style.left = '750px'
        packaging.style.fontSize = '25px'
        packaging.style.color = '#8B4513'

        var teaColor = document.createElement('pr')
        teaColor.textContent = 'Цвет: ' + data.teaColor.name
        teaColor.style.position = 'fixed'
        teaColor.style.left = '750px'
        teaColor.style.fontSize = '25px'
        teaColor.style.color = '#8B4513'

        var teaType = document.createElement('pr')
        teaType.textContent = 'Тип: ' + data.teaType.name
        teaType.style.position = 'fixed'
        teaType.style.left = '750px'
        teaType.style.fontSize = '25px'
        teaType.style.color = '#8B4513'

        var br0 = document.createElement('br')
        var br1 = document.createElement('br')
        var br2 = document.createElement('br')
        var br3 = document.createElement('br')
        var br4 = document.createElement('br')
        var br5 = document.createElement('br')
        var br6 = document.createElement('br')
        var br7 = document.createElement('br')
        var br8 = document.createElement('br')
        var br9 = document.createElement('br')
        var br10 = document.createElement('br')
        var br11 = document.createElement('br')
        var br12 = document.createElement('br')
        var br13 = document.createElement('br')
        var br14 = document.createElement('br')
        var br15 = document.createElement('br')
        var br16 = document.createElement('br')
        var br17 = document.createElement('br')
        var br18 = document.createElement('br')
        var br19 = document.createElement('br')
        var br20 = document.createElement('br')


        var button = document.createElement('button')
        button.textContent = 'Добавить в корзину';
        button.style.height = '60px';
        button.style.width = '200px';
        button.style.position = 'fixed';
        button.style.left = '750px';
        button.style.top = '780px';
        button.style.color = 'white';
        button.style.backgroundColor = '#1D8348';

        var drink_div = document.getElementById('drink')
        drink_div.appendChild(image)
        drink_div.appendChild(name)
        drink_div.appendChild(br8)
        drink_div.appendChild(br9)
        drink_div.appendChild(br10)
        drink_div.appendChild(br11)
        drink_div.appendChild(br12)
        drink_div.appendChild(br0)
        drink_div.appendChild(weight)
        drink_div.appendChild(br1)
        drink_div.appendChild(br13)
        drink_div.appendChild(price)
        drink_div.appendChild(br2)
        drink_div.appendChild(br14)
        drink_div.appendChild(country)
        drink_div.appendChild(br3)
        drink_div.appendChild(br15)
        drink_div.appendChild(teaColor)
        drink_div.appendChild(br4)
        drink_div.appendChild(br16)
        drink_div.appendChild(teaType)
        drink_div.appendChild(br5)
        drink_div.appendChild(br17)
        drink_div.appendChild(packaging)
        drink_div.appendChild(br6)
        drink_div.appendChild(br18)
        drink_div.appendChild(manufacturer)
        drink_div.appendChild(br7)
        drink_div.appendChild(br19)
        drink_div.appendChild(about)
        drink_div.appendChild(br20)
        drink_div.appendChild(button)
    }
    tea.send()
// }