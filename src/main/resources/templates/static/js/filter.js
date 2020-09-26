var urlR = "/catalogs/roastings"

const xhrR = new XMLHttpRequest();

xhrR.open('GET', urlR)

xhrR.onload = () => {

    var datass = JSON.parse(xhrR.response)

    for (let i = 0; i < datass.length; i++) {

        var super_roast = document.getElementById('roast')

        var roast = document.createElement('pr')
        roast.textContent = datass[i].name
        roast.style.color = 'white'


        super_roast.appendChild(roast);
    }

    var urlC = "/catalogs/coffee-types"

    const xhrC = new XMLHttpRequest();

    xhrC.open('GET', urlC)

    xhrC.onload = () => {

        var dat = JSON.parse(xhrC.response)

        for (let i = 0; i < dat.length; i++) {

            var super_ctype = document.getElementById('ctype')

            var ctype = document.createElement('pr')
            ctype.textContent = dat[i].name
            ctype.style.color = 'white'


            super_ctype.appendChild(ctype);
        }

    }
    xhrC.send()
}
xhrR.send()


