var li = document.createElement('li');
li.style.class = "page-item";

var a = document.createElement('a');
a.style.class = "page-link"
a.textContent = '1';
a.href = "#"

li.appendChild(a);

var super_li = document.getElementById('page-item');

super_li.appendChild(li);