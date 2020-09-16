const requestURL = '/coffee/all'

const xhr = new XMLHttpRequest();

xhr.open('GET', requestURL)

xhr.onload = () => {

    var datas = JSON.parse(xhr.response)

    document.getElementById('name1').innerHTML = datas.content[4].name
    document.getElementById('price1').innerHTML = datas.content[4].price
    document.getElementById('weight1').innerHTML = datas.content[4].weight
    document.getElementById('country1').innerHTML = datas.content[4].country.name

    document.getElementById('name2').innerHTML = datas.content[1].name
    document.getElementById('price2').innerHTML = datas.content[1].price
    document.getElementById('weight2').innerHTML = datas.content[1].weight
    document.getElementById('country2').innerHTML = datas.content[1].country.name

    document.getElementById('name3').innerHTML = datas.content[2].name
    document.getElementById('price3').innerHTML = datas.content[2].price
    document.getElementById('weight3').innerHTML = datas.content[2].weight
    document.getElementById('country3').innerHTML = datas.content[2].country.name
}

xhr.send()



