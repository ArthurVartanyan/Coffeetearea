var teaCountryUrl = "/api/catalogs/countries";

const xhrTeaCountry = new XMLHttpRequest();

xhrTeaCountry.open('GET', teaCountryUrl)

xhrTeaCountry.onload = () => {

    var datassss = JSON.parse(xhrTeaCountry.response)

    console.log(datassss)

    for (let i = 0; i < datassss.length; i++) {

        var teaCountry = document.createElement('option')
        teaCountry.value = datassss[i].id
        teaCountry.id = datassss[i].id
        teaCountry.textContent = datassss[i].name

        var super_select = document.getElementById('country')

        super_select.appendChild(teaCountry)
    }
}
xhrTeaCountry.send()