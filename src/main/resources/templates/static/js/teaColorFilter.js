var teaColorUrl = "/catalogs/tea-colors";

const xhrTeaColor = new XMLHttpRequest();

xhrTeaColor.open('GET', teaColorUrl)

xhrTeaColor.onload = () => {

    var datassss = JSON.parse(xhrTeaColor.response)


    for (let i = 0; i < datassss.length; i++) {

        var teaColor = document.createElement('option')
        teaColor.value = 'Цвет чая'
        teaColor.textContent = datassss[i].name

        var super_select = document.getElementById('color')

        super_select.appendChild(teaColor)
    }
}

xhrTeaColor.send()