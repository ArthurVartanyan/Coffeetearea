// const requestURL = '/coffee/all'
// const xhr = new XMLHttpRequest();
// xhr.open('GET', requestURL)


document.body.onload = addElement;


function addElement() {

    // var super_div = document.querySelector("div");
    // // super_div.style.cssText = 'margin-left: 150px;' +
    // //     'display: flex;' +
    // //     'flex-flow: row nowrap;' +
    // //     'justify-content: space-evenly;' +
    // //     'width: 80%;';
    // super_div.id = 'cardis';
    //
    // super_div.style.marginLeft = '40px';
    // super_div.style.display = 'flex';
    // super_div.style.flexFlow = 'row nowrap';
    // super_div.style.justifyContent = 'space-evenly';
    // super_div.style.width = '150px';
    //

    var card = document.createElement("div");

    // card.style.cssText = 'box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);\n' +
    //     '    text-align: center;\n' +
    //     '    font-family: arial, serif;\n' +
    //     '    width: 15%;\n' +
    //     '    background: white;'

    card.style.boxShadow = '0 4px 8px 0 rgba(0, 0, 0, 0.2)';
    card.style.textAlign = 'center';
    card.style.fontFamily = 'arial, serif';
    card.style.width = '15%';
    card.style.background = 'white';

    var image = document.createElement("img")
    image.src = "static/images/coffees-background.jpg"
    image.style.width = "100%";


    var name = document.createElement("h1");
    name.textContent = "Привет";

    var price = document.createElement("p");
    price.textContent = "100$";
    // price.style.cssText = 'color: grey;\n' +
    //     'background: white;\n' +
    //     '    font-size: 22px;'

    price.style.color = 'grey';
    price.style.background = 'white';
    price.style.fontSize = '22px';

    var weight = document.createElement("p");
    weight.textContent = "100гр";

    var country = document.createElement("p");
    country.textContent = "Brasil";

    var button = document.createElement("button")
    button.textContent = "Добавить в корзину"
    // button.style.cssText = 'border: none;\n' +
    //     '    outline: 0;\n' +
    //     '    padding: 12px;\n' +
    //     '    color: white;\n' +
    //     '    background-color: #000;\n' +
    //     '    text-align: center;\n' +
    //     '    cursor: pointer;\n' +
    //     '    width: 100%;\n' +
    //     '    font-size: 18px;\n'

    button.style.border = 'none';
    button.style.outline = '0';
    button.style.padding = '12px';
    button.style.color = 'white';
    button.style.backgroundColor = '#000';
    button.style.textAlign = 'center';
    button.style.cursor = 'pointer';
    button.style.width = '100%';
    button.style.fontSize = '18px';

    card.appendChild(image);
    card.appendChild(name);
    card.appendChild(price);
    card.appendChild(weight);
    card.appendChild(country);
    card.appendChild(button);

    var super_div = document.getElementById('cards')

    super_div.appendChild(card);

    // document.body.appendChild(super_div)

}


//
// xhr.onload = () => {
//
//
//     var datas = JSON.parse(xhr.response)
//
//     document.getElementById('name1').innerHTML = datas.content[4].name
//     document.getElementById('price1').innerHTML = datas.content[4].price
//     document.getElementById('weight1').innerHTML = datas.content[4].weight
//     document.getElementById('country1').innerHTML = datas.content[4].country.name
//
//     document.getElementById('name2').innerHTML = datas.content[1].name
//     document.getElementById('price2').innerHTML = datas.content[1].price
//     document.getElementById('weight2').innerHTML = datas.content[1].weight
//     document.getElementById('country2').innerHTML = datas.content[1].country.name
//
//     document.getElementById('name3').innerHTML = datas.content[2].name
//     document.getElementById('price3').innerHTML = datas.content[2].price
//     document.getElementById('weight3').innerHTML = datas.content[2].weight
//     document.getElementById('country3').innerHTML = datas.content[2].country.name
// }

// xhr.send()