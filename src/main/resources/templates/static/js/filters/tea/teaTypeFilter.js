var teaTypeUrl = "/api/catalogs/tea-types";

const xhrTeaType = new XMLHttpRequest();

xhrTeaType.open('GET', teaTypeUrl)

xhrTeaType.onload = () => {

    var datasss = JSON.parse(xhrTeaType.response)

    for (let i = 0; i < datasss.length; i++) {

        var teaType = document.createElement('option')
        teaType.value = datasss[i].id
        teaType.id = datasss[i].id
        teaType.textContent = datasss[i].name

        var super_select = document.getElementById('type')

        super_select.appendChild(teaType)
    }
}
xhrTeaType.send()