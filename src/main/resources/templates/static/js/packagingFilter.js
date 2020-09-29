var teaPackUrl = "/catalogs/packages";

const xhrTeaPack = new XMLHttpRequest();

xhrTeaPack.open('GET', teaPackUrl)

xhrTeaPack.onload = () => {

    var datassss = JSON.parse(xhrTeaPack.response)

    for (let i = 0; i < datassss.length; i++) {

        var teaColor = document.createElement('option');
        teaColor.value = 'Упаковка';
        teaColor.textContent = datassss[i].name;

        var super_select = document.getElementById('packaging');

        super_select.appendChild(teaColor);
    }
}
xhrTeaPack.send()