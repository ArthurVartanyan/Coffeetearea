function teaFilter(){

    var urlForPagi = '/tea/filter'

    const xhrPagi = new XMLHttpRequest();

    xhrPagi.open('GET', urlForPagi)

    xhrPagi.onload = () => {

        var datas_ = JSON.parse(xhrPagi.response)

        for (let i = 0; i < datas_.totalPages; i++) {
            document.getElementById(i + 100).style.backgroundColor = 'chocolate';
            document.getElementById(i + 100).style.color = 'black';
            document.getElementById(i + 100).style.border = '1px solid chocolate';
        }

        document.getElementById(datas_.number + 100).style.backgroundColor = '#4CAF50';
        document.getElementById(datas_.number + 100).style.color = 'white';
        document.getElementById(datas_.number + 100).style.border = '1px solid #4CAF50';
    }
    xhrPagi.send()

    var colorId = document.getElementById('color').value
    var typeId = document.getElementById('type').value
    var countryId = document.getElementById('country').value
    var minPriceId = document.getElementById('min-price').value
    var maxPriceId = document.getElementById('max-price').value

    createTeaCardsFilter(number = 0, sortingParams = 'NAME_INCREASE', colorId, typeId, countryId, minPriceId, maxPriceId)
}