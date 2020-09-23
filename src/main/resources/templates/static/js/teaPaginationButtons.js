var pagUrl = "/tea/all";

const xhrPag = new XMLHttpRequest();


xhrPag.open('GET', pagUrl)


xhrPag.onload = () => {

    var data = JSON.parse(xhrPag.response)

    console.log(data)

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
            createTeaCards(i);
        }

        var super_div = document.getElementById('paginationTea');

        super_div.appendChild(a);
    }
}
xhrPag.send()