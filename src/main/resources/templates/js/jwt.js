app.post("/login", async (req, res) => {
    try {
        const user = await User.findByCredentials(
            req.body.email,
            req.body.password
        );
        const token = await user.generateAuthToken();

        res.send({ token: user.tasks });
    } catch (e) {
        res.status(400).send();
    }
});

localStorage.setItem('userInfo', JSON.stringify(userInfo));

document.getElementById("my-profile").addEventListener("click", getMe);

function getMe(e) {
    e.preventDefault();
    var token = JSON.parse(localStorage.getItem('token'));
    console.log(`Authorization=Bearer ${token}`)
    fetch('/users/me', {
        method: 'GET',
        headers: {
            'Authorization': 'Bearer ' + token
        }
    })
        .then(res => res.json())
        .then(data => {
            console.log(data)
            // window.location.href = 'http://localhost:3000/dashboard';
        })
        .catch(err => { console.log(err) })
}