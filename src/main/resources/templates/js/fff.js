function createLocalstorageItem(txtJwtTokenValue) {
    sessionStorage.setItem("jwtToken", txtJwtTokenValue)
}

    function readValue() {
        const jwtToken = sessionStorage.getItem("jwtToken");
        console.log("jwtToken : " + jwtToken );
    return jwtToken;

}

    function getDataFromAPiByPassingJwtTokenInHeader(){
        const jwtToken = readValue();
        $.ajax({
    url: '/login',
    type: 'post',
    data: {},
    headers: { Bearer_Token : "Bearer " + jwtToken,   //key word **Bearer**  should pass before the token string
},
    dataType: 'json',
    success: function (data) {
    console.info(data);
}
});
}