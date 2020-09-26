var pagUrl = "/tea/all";

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

            if (formS.value === 'По алфавиту 🠗') {

                createTeaCards(i, 'NAME_INCREASE')
            }

            if (formS.value === 'Цена 🠗') {
                createTeaCards(i,'PRICE_DECREASE')
            }

            if (formS.value === 'Цена 🠕') {
                createTeaCards(i,'PRICE_INCREASE')
            }

            if (formS.value === 'По популярности 🠗') {
                createTeaCards(i,'POP_DECREASE')

            }
        }

        formS.onchange = function () {

            if (formS.value === 'По алфавиту 🠗') {

                createTeaCards(0, 'NAME_INCREASE')
            }

            if (formS.value === 'Цена 🠗') {
                createTeaCards(0,'PRICE_DECREASE')
            }

            if (formS.value === 'Цена 🠕') {
                createTeaCards(0,'PRICE_INCREASE')
            }

            if (formS.value === 'По популярности 🠗') {
                createTeaCards(0,'POP_DECREASE')

            }
        }

        var super_divio = document.getElementById('paginationTea');

        super_divio.appendChild(a);
    }
}
xhrPag.send()