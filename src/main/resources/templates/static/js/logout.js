function logOut(){
    localStorage.removeItem('token')
    window.location = '/home'
}