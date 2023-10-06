const registerForm = document.getElementById('register-form')
const registerUsername = document.getElementById('register-username')
const registerPassword = document.getElementById('register-password')

const loginForm = document.getElementById('login-form')
const loginUsername = document.getElementById('login-username')
const loginPassword = document.getElementById('login-password')

const headers = {
    'Content-Type':'application/json'
}
const baseUrl = 'http://localhost:8080/api/v1/users'

const handleSubmit = async (e) => {
    e.preventDefault()
    console.log('register')
    let bodyObj = {
        username: registerUsername.value,
        password: registerPassword.value
    }

    const response = await fetch(`${baseUrl}/register`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err.message))

    const responseArr = await response.json()

    if(response.status === 200){
        window.location.replace(responseArr[0])
    }
}
//user login
const handleLoginSubmit = async (e) =>{
        e.preventDefault()
        console.log('login')
        let bodyObj = {
            username: loginUsername.value,
            password: loginPassword.value
        }

        const response = await fetch(`${baseUrl}/login`, {
            method: "POST",
            body: JSON.stringify(bodyObj),
            headers: headers
        }).catch(err => console.error(err.message))

        const responseArr = await response.json()

        if (response.status === 200){
            document.cookie = `${responseArr[1]}`
            window.location.replace(responseArr[0])
        }

}

registerForm.addEventListener("submit", handleSubmit);
loginForm.addEventListener("submit", handleLoginSubmit);