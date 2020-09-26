var pagUrl = "/coffee/all";

const xhrPag = new XMLHttpRequest();

xhrPag.open('GET', pagUrl)

xhrPag.onload = () => {

    var data = JSON.parse(xhrPag.response)

    var formS = document.getElementById('sort')

    for (let i = 0; i < data.totalPages; i++) {

        var a = document.createElement('a');
        a.id = i
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

                createCards(i, 'NAME_INCREASE')
            }

            if (formS.value === 'Цена 🠗') {
                createCards(i,'PRICE_DECREASE')
            }

            if (formS.value === 'Цена 🠕') {
                createCards(i,'PRICE_INCREASE')
            }

            if (formS.value === 'По популярности 🠗') {
                createCards(i,'POP_DECREASE')

            }
        }

        formS.onchange = function () {

            if (formS.value === 'По алфавиту 🠗') {

                createCards(0, 'NAME_INCREASE')
            }

            if (formS.value === 'Цена 🠗') {
                createCards(0,'PRICE_DECREASE')
            }

            if (formS.value === 'Цена 🠕') {
                createCards(0,'PRICE_INCREASE')
            }

            if (formS.value === 'По популярности 🠗') {
                createCards(0,'POP_DECREASE')

            }
        }

        var super_d = document.getElementById('pagination');

        super_d.appendChild(a);
    }
}
xhrPag.send()