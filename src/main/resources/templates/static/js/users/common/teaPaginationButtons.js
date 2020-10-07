var pagUrl = "/api/tea/filter";

const xhrPag = new XMLHttpRequest();

xhrPag.open('GET', pagUrl)

xhrPag.onload = () => {

    var data = JSON.parse(xhrPag.response)

    var formS = document.getElementById('sort')

    for (let i = 0; i < data.totalPages; i++) {

        var a = document.createElement('a');
        a.id = i + 100
        a.style.color = 'black'
        a.style.float = 'left'
        a.style.padding = '8px 16px'
        a.style.textDecoration = 'chocolate'
        a.style.backgroundColor = 'chocolate'
        a.style.border = '1px solid chocolate'
        a.textContent = i + 1;
        a.href = "#"

        a.onclick = function pages() {

            for (let i = 0; i < data.totalPages; i++) {
                document.getElementById(i + 100).style.backgroundColor = 'chocolate';
                document.getElementById(i + 100).style.color = 'black';
                document.getElementById(i + 100).style.border = '1px solid chocolate';
            }

            document.getElementById(this.id).style.backgroundColor = '#4CAF50';
            document.getElementById(this.id).style.color = 'white';
            document.getElementById(this.id).style.border = '1px solid #4CAF50';

            if (formS.value === 'По алфавиту 🠗') {

                createTeaCardsFilter(i, 'NAME_INCREASE', colorId = document.getElementById('color').value, typeId = document.getElementById('type').value, countryId = document.getElementById('country').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value)
            }

            if (formS.value === 'Цена 🠗') {
                createTeaCardsFilter(i, 'PRICE_DECREASE', colorId = document.getElementById('color').value, typeId = document.getElementById('type').value, countryId = document.getElementById('country').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value)
            }

            if (formS.value === 'Цена 🠕') {
                createTeaCardsFilter(i, 'PRICE_INCREASE', colorId = document.getElementById('color').value, typeId = document.getElementById('type').value, countryId = document.getElementById('country').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value)
            }

            if (formS.value === 'По популярности 🠗') {
                createTeaCardsFilter(i, 'POP_DECREASE', colorId = document.getElementById('color').value, typeId = document.getElementById('type').value, countryId = document.getElementById('country').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value)

            }
        }

        formS.onchange = function () {

            var urlForPagi = '/api/tea/filter'

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

            if (formS.value === 'По алфавиту 🠗') {

                createTeaCardsFilter(0, 'NAME_INCREASE', colorId = document.getElementById('color').value, typeId = document.getElementById('type').value, countryId = document.getElementById('country').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value)
            }

            if (formS.value === 'Цена 🠗') {
                createTeaCardsFilter(0, 'PRICE_DECREASE', colorId = document.getElementById('color').value, typeId = document.getElementById('type').value, countryId = document.getElementById('country').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value)
            }

            if (formS.value === 'Цена 🠕') {
                createTeaCardsFilter(0, 'PRICE_INCREASE', colorId = document.getElementById('color').value, typeId = document.getElementById('type').value, countryId = document.getElementById('country').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value)
            }

            if (formS.value === 'По популярности 🠗') {
                createTeaCardsFilter(0, 'POP_DECREASE', colorId = document.getElementById('color').value, typeId = document.getElementById('type').value, countryId = document.getElementById('country').value, min = document.getElementById('min-price').value, max = document.getElementById('max-price').value)

            }
        }
        var super_divio = document.getElementById('paginationTea');

        super_divio.appendChild(a);
    }
}
xhrPag.send()